package com.wiryaimd.searchapi.config.filter;

import com.wiryaimd.searchapi.helper.JwtHelper;
import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Component
public class JwtFilter extends OncePerRequestFilter {

    @Autowired
    private JwtHelper jwtHelper;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String token = Optional.ofNullable(request.getHeader(HttpHeaders.AUTHORIZATION))
                .filter(new Predicate<String>() {
                    @Override
                    public boolean test(String s) {
                        return s.startsWith("Bearer ");
                    }
                }).map(new Function<String, String>() {
                    @Override
                    public String apply(String s) {
                        return s.replace("Bearer ", "");
                    }
                }).orElseThrow(() -> new BadCredentialsException("Invalid token"));

        Map<String, Object> jwt = jwtHelper.validateToken(token);

        List<SimpleGrantedAuthority> roles = Arrays.stream(jwt.get("roles").toString().split(",")).map(new Function<String, SimpleGrantedAuthority>() {
            @Override
            public SimpleGrantedAuthority apply(String s) {
                return new SimpleGrantedAuthority(s);
            }
        }).toList();

        SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(jwt.get(Claims.SUBJECT), null, roles));

        filterChain.doFilter(request, response);
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        return !request.getRequestURI().startsWith("/api/login/") && HttpMethod.POST.matches(request.getMethod());
    }
}
