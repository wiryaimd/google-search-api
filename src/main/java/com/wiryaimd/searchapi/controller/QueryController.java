package com.wiryaimd.searchapi.controller;

import com.wiryaimd.searchapi.dto.res.QueryResDto;
import com.wiryaimd.searchapi.services.QueryServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/search")
public class QueryController {

    private Logger logger = LoggerFactory.getLogger(QueryController.class);

    @Autowired
    private QueryServices queryServices;

    @GetMapping
    public ResponseEntity<QueryResDto> query(@RequestParam String query){
        logger.info("query: " + query);

        QueryResDto queryResDto = queryServices.query(query);
        return ResponseEntity.status(queryResDto.getStatusCode()).body(queryResDto);
    }

}
