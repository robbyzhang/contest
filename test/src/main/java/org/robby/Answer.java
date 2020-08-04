package org.robby;

public class Answer {
    int contestId;
    int questionId;
    String answer;

    public Answer(int contestId, int questionId, String answer) {
        this.contestId = contestId;
        this.questionId = questionId;
        this.answer = answer;
    }
}
