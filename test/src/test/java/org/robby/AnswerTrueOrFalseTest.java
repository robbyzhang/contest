package org.robby;

import org.junit.Assert;
import org.junit.Test;

public class AnswerTrueOrFalseTest extends BaseTest {
    private int questionId = 133;
    @Test
    public void test_success()  {
        AnswerResponse resp = (AnswerResponse) httpPost(baseUrl + "/api/questionAnswer/test",
                new Answer(0, questionId, "true"),
                AnswerResponse.class);

        Assert.assertEquals(resp.getScore(), 20);
        Assert.assertEquals(resp.getQuestionId(), questionId);
        Assert.assertTrue(resp.isCorrect());

        resp = (AnswerResponse) httpPost(baseUrl + "/api/questionAnswer/test",
                new Answer(0, questionId, "True"),
                AnswerResponse.class);

        Assert.assertEquals(resp.getScore(), 20);
        Assert.assertEquals(resp.getQuestionId(), questionId);
        Assert.assertTrue(resp.isCorrect());
    }

    @Test
    public void test_wrong()  {
        AnswerResponse resp = (AnswerResponse) httpPost(baseUrl + "/api/questionAnswer/test",
                new Answer(0, questionId, "false"),
                AnswerResponse.class);

        Assert.assertEquals(resp.getScore(), 0);
        Assert.assertEquals(resp.getQuestionId(), questionId);
        Assert.assertFalse(resp.isCorrect());
    }
}