package com.wiryaimd.searchapi.services;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.wiryaimd.searchapi.dto.req.QueryReqDto;
import com.wiryaimd.searchapi.dto.res.QueryResDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

@Service
public class QueryServices {

    private Logger logger = LoggerFactory.getLogger(QueryServices.class);

    @Autowired
    private Firestore firestore;

    public QueryResDto query(String query){
        String uid = UUID.randomUUID().toString().substring(0, 8);
        firestore.collection("query").document(uid).set(new QueryReqDto(
                uid, query, false
        ));

        try {
            Thread.sleep(500);

            int interval = 0;
            return fetchQuery(uid, query, interval);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return new QueryResDto(uid, query, 404, null);
    }

    private QueryResDto fetchQuery(String uid, String query, int interval) throws InterruptedException, ExecutionException {
        if (interval >= 10){
            return new QueryResDto(uid, query, 408, null); // timeout
        }
        interval += 1;
        
        logger.info("Query call: " + query + " - " + interval);

        ApiFuture<DocumentSnapshot> callback = firestore.collection("queryResult").document(uid).get();
        DocumentSnapshot documentSnapshot = callback.get();
        if (documentSnapshot == null){
            return new QueryResDto(uid, query, 404, null);
        }

        QueryResDto queryResDto = documentSnapshot.toObject(QueryResDto.class);
        if (queryResDto == null){
            Thread.sleep(500);
            return fetchQuery(uid, query, interval);
        }

        return queryResDto;
    }


}
