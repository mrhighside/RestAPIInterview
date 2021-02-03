package com.interview.api.services;

import java.sql.Timestamp;
import com.interview.api.model.HealthResponse;
import org.jsoup.Connection;
import org.jsoup.Jsoup;

public class WebHealthCheckerService 
{
    //Do the heath check of the pased in URL
    public static HealthResponse urlHealthCheck(String url)
    {
        try
        {
            //Fetch the URL and get the timing
            Long start = System.currentTimeMillis();
            Connection.Response webResponse = Jsoup.connect(url).execute();
            Long end = System.currentTimeMillis();

            Long duration = end - start;

            //create response object and populate
            HealthResponse response = new HealthResponse();
            response.setDate(new Timestamp(System.currentTimeMillis()));
            response.setDuration(duration);
            response.setUrl(url);
            response.setStatusCode(webResponse.statusCode());

            return response;
        }catch(Exception e){
            //need better error handling
            HealthResponse errorResponse = new HealthResponse();
            errorResponse.setDate(new Timestamp(System.currentTimeMillis()));
            errorResponse.setStatusCode(418);
            errorResponse.setUrl(url + " - Error: " + e.toString() );
            return errorResponse;
        }
    }
}
