package org.robby;

import com.google.gson.Gson;
import junit.framework.TestCase;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

public class BaseTest extends TestCase {
    public String baseUrl = "http://39.105.115.164:8080";
    RequestConfig config;
    Gson gson = new Gson();
    public BaseTest(){
        HttpHost proxy = new HttpHost("10.144.1.10", 8080);
        config = RequestConfig.custom()
                .setProxy(proxy)
                .build();
    }

    public String httpGet(String url){
        HttpGet httpget = new HttpGet( url );
        if(config != null) {
            httpget.setConfig(config);
        }

        HttpResponse response = null;
        try {
            response = HttpClientBuilder.create().build().execute(httpget);
            return EntityUtils.toString(response.getEntity());
        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    public Object httpPost(String url, Object obj, Class responseType){
        String ret = httpPost(url, obj);
        return gson.fromJson(ret, responseType);
    }

    public String httpPost(String url, Object obj){
        try {
            HttpPost httpPost = new HttpPost( url );
            httpPost.setHeader("Content-Type", "application/json");
            if(config != null) {
                httpPost.setConfig(config);
            }

            HttpResponse response = null;
            httpPost.setEntity(new StringEntity(gson.toJson(obj)));
            response = HttpClientBuilder.create().build().execute(httpPost);
            return EntityUtils.toString(response.getEntity());
        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }
}
