package org.robby;

import org.junit.Assert;
import org.junit.Test;

public class Test2 extends BaseTest{
    public final int questionId = 189;
    public final int expectedPoints = 30;

    @Test
    public void test_correct()  {
        AnswerResponse resp = (AnswerResponse) httpPost(baseUrl + "/api/questionAnswer/test",
                new Answer(0, questionId, Util.readFileToBase64(questionId + ".correct.txt")),
                AnswerResponse.class);

        Assert.assertEquals(expectedPoints, resp.getScore());
        Assert.assertTrue(resp.isCorrect());
        Assert.assertEquals(resp.getQuestionId(), questionId);
    }

    @Test
    public void test_compile()  {
        AnswerResponse resp = (AnswerResponse) httpPost(baseUrl + "/api/questionAnswer/test",
                new Answer(0, questionId, Util.readFileToBase64(questionId + ".wrong.compile.txt")),
                AnswerResponse.class);

        Assert.assertEquals(0L, resp.getScore());
        Assert.assertFalse(resp.isCorrect());
        Assert.assertEquals(resp.getQuestionId(), questionId);
    }

    @Test
    public void test_ut()  {
        AnswerResponse resp = (AnswerResponse) httpPost(baseUrl + "/api/questionAnswer/test",
                new Answer(0, questionId, Util.readFileToBase64(questionId + ".wrong.test.txt")),
                AnswerResponse.class);

        Assert.assertEquals(0L, resp.getScore());
        Assert.assertFalse(resp.isCorrect());
        Assert.assertEquals(resp.getQuestionId(), questionId);
    }
}
