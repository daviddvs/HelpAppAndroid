package modelo;

import java.util.List;

/**
 * Created by tta on 1/19/18.
 */

public class Data {
    private static Data instance = null;
    private List<Question> questionList = null;
    private User user = null;

    private Data() {
    }

    public static synchronized Data getInstance() {
        if(instance == null)
            instance = new Data();
        return instance;
    }

    public List<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
