package org.robby;

public class AnswerResponse {
    int id;
    String result;
    boolean isCorrect;
    int executionPeriod;
    int score;
    int questionId;
    int contestId;

    public AnswerResponse() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }

    public int getExecutionPeriod() {
        return executionPeriod;
    }

    public void setExecutionPeriod(int executionPeriod) {
        this.executionPeriod = executionPeriod;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public int getContestId() {
        return contestId;
    }

    public void setContestId(int contestId) {
        this.contestId = contestId;
    }
}
