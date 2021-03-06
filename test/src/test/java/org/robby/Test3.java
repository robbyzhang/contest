package org.robby;

import org.junit.Assert;
import org.junit.Test;

public class Test3 extends BaseTest{
    public final int questionId = 190;
    public final int expectedPoints = 40;

    @Test
    public void test_correct()  {
        AnswerResponse resp = (AnswerResponse) httpPost(baseUrl + "/api/questionAnswer/test",
                new Answer(0, questionId, Util.readFileToBase64(questionId + ".correct.txt")),
                AnswerResponse.class);

        Assert.assertEquals(expectedPoints, resp.getScore());
        Assert.assertTrue(resp.isCorrect());
        Assert.assertEquals(resp.getQuestionId(), questionId);
    }
}
