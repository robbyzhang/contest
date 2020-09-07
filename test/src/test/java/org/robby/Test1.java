package org.robby;

import org.junit.Assert;
import org.junit.Test;

public class Test1 extends BaseTest{
    public final int questionId = 180;
    public final int expectedPoints = 15;

    @Test
    public void test_correct()  {
        AnswerResponse resp = (AnswerResponse) httpPost(baseUrl + "/api/questionAnswer/test",
                new Answer(0, questionId, Util.readFileToBase64("180.correct.txt")),
                AnswerResponse.class);

        System.out.println(resp.getResult());
        Assert.assertEquals(expectedPoints, resp.getScore());
        Assert.assertTrue(resp.isCorrect());
        Assert.assertEquals(resp.getQuestionId(), questionId);
    }
}
