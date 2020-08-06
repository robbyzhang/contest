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

    @Test
    public void test_correct()  {
        AnswerResponse resp = (AnswerResponse) httpPost(baseUrl + "/api/questionAnswer/test",
                new Answer(0, 129, "Y2xhc3MgU29sdXRpb24gew0KICAgIHB1YmxpYyBMaXN0Tm9kZSBhZGRUd29OdW1iZXJzKExpc3ROb2RlIGwxLCBMaXN0Tm9kZSBsMikgew0KICAgICAgICBMaXN0Tm9kZSBkdW1teUhlYWQgPSBuZXcgTGlzdE5vZGUoMCk7DQogICAgICAgIExpc3ROb2RlIHAgPSBsMSwgcSA9IGwyLCBjdXJyID0gZHVtbXlIZWFkOw0KICAgICAgICBpbnQgY2FycnkgPSAwOw0KICAgICAgICB3aGlsZSAocCAhPSBudWxsIHx8IHEgIT0gbnVsbCkgew0KICAgICAgICAgICAgaW50IHggPSAocCAhPSBudWxsKSA/IHAudmFsIDogMDsNCiAgICAgICAgICAgIGludCB5ID0gKHEgIT0gbnVsbCkgPyBxLnZhbCA6IDA7DQogICAgICAgICAgICBpbnQgc3VtID0gY2FycnkgKyB4ICsgeTsNCiAgICAgICAgICAgIGNhcnJ5ID0gc3VtIC8gMTA7DQogICAgICAgICAgICBjdXJyLm5leHQgPSBuZXcgTGlzdE5vZGUoc3VtICUgMTApOw0KICAgICAgICAgICAgY3VyciA9IGN1cnIubmV4dDsNCiAgICAgICAgICAgIGlmIChwICE9IG51bGwpIHAgPSBwLm5leHQ7DQogICAgICAgICAgICBpZiAocSAhPSBudWxsKSBxID0gcS5uZXh0Ow0KICAgICAgICB9DQogICAgICAgIGlmIChjYXJyeSA+IDApIHsNCiAgICAgICAgICAgIGN1cnIubmV4dCA9IG5ldyBMaXN0Tm9kZShjYXJyeSk7DQogICAgICAgIH0NCiAgICAgICAgcmV0dXJuIGR1bW15SGVhZC5uZXh0Ow0KICAgIH0NCn0="),
                AnswerResponse.class);

        System.out.println(resp.getResult());
        System.out.println(decodeBase64(resp.getResult()));
        Assert.assertEquals(20, resp.getScore());
        Assert.assertTrue(resp.isCorrect());
        Assert.assertEquals(resp.getQuestionId(), 129);

    }
}