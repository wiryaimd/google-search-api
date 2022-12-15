package com.wiryaimd.searchapi.services;

import com.google.cloud.firestore.Firestore;
import com.wiryaimd.searchapi.dto.req.QueryReqDto;
import com.wiryaimd.searchapi.dto.res.QueryResDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class QueryServices {

    @Autowired
    private Firestore firestore;

    public QueryResDto query(String query){
        String uid = UUID.randomUUID().toString().substring(0, 8);
        firestore.collection("query").document(uid).set(new QueryReqDto(
                uid, query, false
        ));

        return new QueryResDto(uid, query, 404, null);
    }


}
