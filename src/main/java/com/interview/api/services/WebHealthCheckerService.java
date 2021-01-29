package com.interview.api.services;

import java.sql.Timestamp;
import com.interview.api.model.HealthResponse;
import org.jsoup.Connection;
import org.jsoup.Jsoup;

public class WebHealthCheckerService {
    public static HealthResponse urlHealthCheck(String url){
        try{
            Long start = System.nanoTime();
            Connection.Response webResponse = Jsoup.connect(url).execute();
            Long end = System.nanoTime();

            Long duration = end - start;
            HealthResponse response = new HealthResponse();
            response.setDate(new Timestamp(System.currentTimeMillis()));
            response.setDuration(duration);
            response.setUrl(url);
            response.setStatusCode(webResponse.statusCode());

            return response;
        }catch(Exception e){
            //need better error handling
            return null;
        }
    }
}
