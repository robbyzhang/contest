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
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.sun.javaws.JnlpxArgs.verify;
import static org.awaitility.Awaitility.await;
import static org.junit.Assert.assertTrue;

public class AnswerJavaTest extends BaseTest {
    private int questionId = 129;

    @Test
    public void test_wrong()  {
        AnswerResponse resp = (AnswerResponse) httpPost(baseUrl + "/api/questionAnswer/test",
                new Answer(0, questionId, ""),
                AnswerResponse.class);

        Assert.assertEquals(resp.getScore(), 0);
        Assert.assertFalse(resp.isCorrect());
        Assert.assertEquals(resp.getQuestionId(), questionId);
        System.out.println(resp.getResult());
    }

    @Test
    public void test_correct()  {
        AnswerResponse resp = (AnswerResponse) httpPost(baseUrl + "/api/questionAnswer/test",
                new Answer(0, questionId, "DQpjbGFzcyBTb2x1dGlvbiB7DQogICAgcHVibGljIExpc3ROb2RlIGFkZFR3b051bWJlcnMoTGlzdE5vZGUgbDEsIExpc3ROb2RlIGwyKSB7DQogICAgICAgIExpc3ROb2RlIGR1bW15SGVhZCA9IG5ldyBMaXN0Tm9kZSgwKTsNCiAgICAgICAgTGlzdE5vZGUgcCA9IGwxLCBxID0gbDIsIGN1cnIgPSBkdW1teUhlYWQ7DQogICAgICAgIGludCBjYXJyeSA9IDA7DQogICAgICAgIHdoaWxlIChwICE9IG51bGwgfHwgcSAhPSBudWxsKSB7DQogICAgICAgICAgICBpbnQgeCA9IChwICE9IG51bGwpID8gcC52YWwgOiAwOw0KICAgICAgICAgICAgaW50IHkgPSAocSAhPSBudWxsKSA/IHEudmFsIDogMDsNCiAgICAgICAgICAgIGludCBzdW0gPSBjYXJyeSArIHggKyB5Ow0KICAgICAgICAgICAgY2FycnkgPSBzdW0gLyAxMDsNCiAgICAgICAgICAgIGN1cnIubmV4dCA9IG5ldyBMaXN0Tm9kZShzdW0gJSAxMCk7DQogICAgICAgICAgICBjdXJyID0gY3Vyci5uZXh0Ow0KICAgICAgICAgICAgaWYgKHAgIT0gbnVsbCkgcCA9IHAubmV4dDsNCiAgICAgICAgICAgIGlmIChxICE9IG51bGwpIHEgPSBxLm5leHQ7DQogICAgICAgIH0NCiAgICAgICAgaWYgKGNhcnJ5ID4gMCkgew0KICAgICAgICAgICAgY3Vyci5uZXh0ID0gbmV3IExpc3ROb2RlKGNhcnJ5KTsNCiAgICAgICAgfQ0KICAgICAgICByZXR1cm4gZHVtbXlIZWFkLm5leHQ7DQogICAgfQ0KfQ=="),
                AnswerResponse.class);

        System.out.println(resp.getResult());
        Assert.assertEquals(20, resp.getScore());
        Assert.assertTrue(resp.isCorrect());
        Assert.assertEquals(resp.getQuestionId(), questionId);
    }

    @Test
    public void test_correct_performance()  {
        List<Integer> result = new ArrayList<>();
        int total = 2;
        for(int i = 0; i < total; i++) {
            int finalI = i;
            new Thread(){
                @Override
                public void run(){
                    AnswerResponse resp = (AnswerResponse) httpPost(baseUrl + "/api/questionAnswer/test",
                            new Answer(0, questionId, "DQpjbGFzcyBTb2x1dGlvbiB7DQogICAgcHVibGljIExpc3ROb2RlIGFkZFR3b051bWJlcnMoTGlzdE5vZGUgbDEsIExpc3ROb2RlIGwyKSB7DQogICAgICAgIExpc3ROb2RlIGR1bW15SGVhZCA9IG5ldyBMaXN0Tm9kZSgwKTsNCiAgICAgICAgTGlzdE5vZGUgcCA9IGwxLCBxID0gbDIsIGN1cnIgPSBkdW1teUhlYWQ7DQogICAgICAgIGludCBjYXJyeSA9IDA7DQogICAgICAgIHdoaWxlIChwICE9IG51bGwgfHwgcSAhPSBudWxsKSB7DQogICAgICAgICAgICBpbnQgeCA9IChwICE9IG51bGwpID8gcC52YWwgOiAwOw0KICAgICAgICAgICAgaW50IHkgPSAocSAhPSBudWxsKSA/IHEudmFsIDogMDsNCiAgICAgICAgICAgIGludCBzdW0gPSBjYXJyeSArIHggKyB5Ow0KICAgICAgICAgICAgY2FycnkgPSBzdW0gLyAxMDsNCiAgICAgICAgICAgIGN1cnIubmV4dCA9IG5ldyBMaXN0Tm9kZShzdW0gJSAxMCk7DQogICAgICAgICAgICBjdXJyID0gY3Vyci5uZXh0Ow0KICAgICAgICAgICAgaWYgKHAgIT0gbnVsbCkgcCA9IHAubmV4dDsNCiAgICAgICAgICAgIGlmIChxICE9IG51bGwpIHEgPSBxLm5leHQ7DQogICAgICAgIH0NCiAgICAgICAgaWYgKGNhcnJ5ID4gMCkgew0KICAgICAgICAgICAgY3Vyci5uZXh0ID0gbmV3IExpc3ROb2RlKGNhcnJ5KTsNCiAgICAgICAgfQ0KICAgICAgICByZXR1cm4gZHVtbXlIZWFkLm5leHQ7DQogICAgfQ0KfQ=="),
                            AnswerResponse.class);

                    System.out.println(resp.getResult());
                    Assert.assertEquals(20, resp.getScore());
                    Assert.assertTrue(resp.isCorrect());
                    Assert.assertEquals(resp.getQuestionId(), questionId);
                    System.out.println("#" + finalI + " is finished");
                    result.add(1);
                }
            }.start();
        }
        await().atMost(30, TimeUnit.SECONDS).untilAsserted(() -> assertTrue(result.size() == total));
    }

    @Test
    public void test_correct_with_cn_comment()  {
        AnswerResponse resp = (AnswerResponse) httpPost(baseUrl + "/api/questionAnswer/test",
                new Answer(0, questionId, "Ly/kvaDlpb0NCg0KY2xhc3MgU29sdXRpb24gew0KICAgIHB1YmxpYyBMaXN0Tm9kZSBhZGRUd29OdW1iZXJzKExpc3ROb2RlIGwxLCBMaXN0Tm9kZSBsMikgew0KICAgICAgICBMaXN0Tm9kZSBkdW1teUhlYWQgPSBuZXcgTGlzdE5vZGUoMCk7DQogICAgICAgIExpc3ROb2RlIHAgPSBsMSwgcSA9IGwyLCBjdXJyID0gZHVtbXlIZWFkOw0KICAgICAgICBpbnQgY2FycnkgPSAwOw0KICAgICAgICB3aGlsZSAocCAhPSBudWxsIHx8IHEgIT0gbnVsbCkgew0KICAgICAgICAgICAgaW50IHggPSAocCAhPSBudWxsKSA/IHAudmFsIDogMDsNCiAgICAgICAgICAgIGludCB5ID0gKHEgIT0gbnVsbCkgPyBxLnZhbCA6IDA7DQogICAgICAgICAgICBpbnQgc3VtID0gY2FycnkgKyB4ICsgeTsNCiAgICAgICAgICAgIGNhcnJ5ID0gc3VtIC8gMTA7DQogICAgICAgICAgICBjdXJyLm5leHQgPSBuZXcgTGlzdE5vZGUoc3VtICUgMTApOw0KICAgICAgICAgICAgY3VyciA9IGN1cnIubmV4dDsNCiAgICAgICAgICAgIGlmIChwICE9IG51bGwpIHAgPSBwLm5leHQ7DQogICAgICAgICAgICBpZiAocSAhPSBudWxsKSBxID0gcS5uZXh0Ow0KICAgICAgICB9DQogICAgICAgIGlmIChjYXJyeSA+IDApIHsNCiAgICAgICAgICAgIGN1cnIubmV4dCA9IG5ldyBMaXN0Tm9kZShjYXJyeSk7DQogICAgICAgIH0NCiAgICAgICAgcmV0dXJuIGR1bW15SGVhZC5uZXh0Ow0KICAgIH0NCn0="),
                AnswerResponse.class);

        System.out.println(resp.getResult());
        Assert.assertEquals(20, resp.getScore());
        Assert.assertTrue(resp.isCorrect());
        Assert.assertEquals(resp.getQuestionId(), questionId);
    }

    @Test
    public void test_wrong_compile()  {
        String content = "Ly/kvaDlpb0NCg0KY2xhc3MgU29sdXRpb24gew0KICAgIHB1YmxpYyBMaXN0Tm9kZSBhZGRUd29OdW1iZXJzKExpc3ROb2RlIGwxLCBMaXN0Tm9kZSBsMikgew0KICAgICAgICBMaXN0Tm9kZSBkdW1teUhlYWQgPSBuZXcgTGlzdE5vZGUoMCk7DQogICAgICAgIExpc3ROb2RlIHAgPSBsMSwgcSA9IGwyLCBjdXJyID0gZHVtbXlIZWFkOw0KICAgICAgICBpbnQgY2FycnkgPSAwOw0KICAgICAgICB3aGlsZSAocCAhPSBudWxsIHx8IHEgIT0gbnVsbCkgew0KICAgICAgICAgICAgaW50IHggPSAocCAhPSBudWxsKSA/IHAudmFsIDogMDsNCiAgICAgICAgICAgIGludCB5ID0gKHEgIT0gbnVsbCkgPyBxLnZhbCA6IDA7DQogICAgICAgICAgICBpbnQgc3VtID0gY2FycnkgKyB4ICsgeTsNCiAgICAgICAgICAgIGNhcnJ5ID0gc3VtIC8gMTA7DQogICAgICAgICAgICBjdXJyLm5leHQgPSBuZXcgTGlzdE5vZGUoc3VtICUgMTApOw0KICAgICAgICAgICAgY3VyciA9IGN1cnIubmUNCiAgICAgICAgICAgIGlmIChwICE9IG51bGwpIHAgPSBwLm5leHQ7DQogICAgICAgICAgICBpZiAocSAhPSBudWxsKSBxID0gcS5uZXh0Ow0KICAgICAgICB9DQogICAgICAgIGlmIChjYXJyeSA+IDApIHsNCiAgICAgICAgICAgIGN1cnIubmV4dCA9IG5ldyBMaXN0Tm9kZShjYXJyeSk7DQogICAgICAgIH0NCiAgICAgICAgcmV0dXJuIGR1bW15SGVhZC5uZXh0Ow0KICAgIH0NCn0=";
        AnswerResponse resp = (AnswerResponse) httpPost(baseUrl + "/api/questionAnswer/test",
                new Answer(0, questionId, content),
                AnswerResponse.class);

        System.out.println(resp.getResult());
        Assert.assertEquals(0, resp.getScore());
        Assert.assertFalse(resp.isCorrect());
        Assert.assertEquals(resp.getQuestionId(), questionId);
    }
}