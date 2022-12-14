package com.wiryaimd.searchapi.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;

import java.io.FileInputStream;
import java.io.IOException;

@Configuration
public class AppConfig {

    private Logger logger = LoggerFactory.getLogger(AppConfig.class);

    public static final String DB_CLIENT = "searchapi-firebase-adminsdk.json";

    @Bean
    public FirebaseApp firebaseApp(){
        try {
            FileInputStream inputStream = new FileInputStream(ResourceUtils.getFile(ResourceUtils.CLASSPATH_URL_PREFIX + DB_CLIENT));
            FirebaseOptions options = FirebaseOptions.builder()
                    .setCredentials(GoogleCredentials.fromStream(inputStream))
                    .build();

            logger.info("Firebase init success");
            return FirebaseApp.initializeApp(options);
        } catch (IOException e) {
            throw new RuntimeException("Check firebase private key file");
        }
    }

}
