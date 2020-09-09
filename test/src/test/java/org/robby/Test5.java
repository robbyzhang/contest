package org.robby;

import org.junit.Assert;
import org.junit.Test;

public class Test5 extends BaseTest{
    public final int questionId = 192;
    public final int expectedPoints = 80;

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
