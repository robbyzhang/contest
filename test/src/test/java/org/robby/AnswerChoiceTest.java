package org.robby;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class AnswerChoiceTest extends BaseTest {
    @Test
    public void test_success()  {
        AnswerResponse resp = (AnswerResponse) httpPost(baseUrl + "/api/questionAnswer/test",
                new Answer(0, 130, "b"),
                AnswerResponse.class);

        Assert.assertEquals(resp.getScore(), 20);
        Assert.assertEquals(resp.getQuestionId(), 130);
        Assert.assertTrue(resp.isCorrect());
    }

    @Test
    public void test_success2()  {
        AnswerResponse resp = (AnswerResponse) httpPost(baseUrl + "/api/questionAnswer/test",
                new Answer(0, 130, "B"),
                AnswerResponse.class);

        Assert.assertEquals(resp.getScore(), 20);
        Assert.assertEquals(resp.getQuestionId(), 130);
        Assert.assertTrue(resp.isCorrect());
    }

    @Test
    public void test_wrong()  {
        AnswerResponse resp = (AnswerResponse) httpPost(baseUrl + "/api/questionAnswer/test",
                new Answer(0, 130, "afbefae"),
                AnswerResponse.class);

        Assert.assertEquals(resp.getScore(), 0);
        Assert.assertEquals(resp.getQuestionId(), 130);
        Assert.assertFalse(resp.isCorrect());
    }
}