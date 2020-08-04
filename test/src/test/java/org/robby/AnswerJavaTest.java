package org.robby;

import junit.framework.TestCase;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class AnswerJavaTest extends BaseTest {
    @Test
    public void test_wrong()  {
        AnswerResponse resp = (AnswerResponse) httpPost(baseUrl + "/api/questionAnswer/test",
                new Answer(0, 129, ""),
                AnswerResponse.class);

        Assert.assertEquals(resp.getScore(), 0);
        Assert.assertFalse(resp.isCorrect());
        Assert.assertEquals(resp.getQuestionId(), 129);
        System.out.println(resp.getResult());
    }
}