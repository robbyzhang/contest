package org.robby;

import org.junit.Assert;
import org.junit.Test;

public class AnswerMultiChoiceTest extends BaseTest {
    private int questionId = 132;
    @Test
    public void test_success()  {
        AnswerResponse resp = (AnswerResponse) httpPost(baseUrl + "/api/questionAnswer/test",
                new Answer(0, questionId, "yes"),
                AnswerResponse.class);

        System.out.println(resp.getResult());
        Assert.assertEquals(20, resp.getScore());
        Assert.assertEquals(resp.getQuestionId(), questionId);
        Assert.assertTrue(resp.isCorrect());
    }

    @Test
    public void test_wrong()  {
        AnswerResponse resp = (AnswerResponse) httpPost(baseUrl + "/api/questionAnswer/test",
                new Answer(0, questionId, "B"),
                AnswerResponse.class);

        Assert.assertEquals(resp.getScore(), 0);
        Assert.assertEquals(resp.getQuestionId(), questionId);
        Assert.assertFalse(resp.isCorrect());
    }
}