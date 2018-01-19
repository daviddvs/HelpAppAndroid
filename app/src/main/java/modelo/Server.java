package modelo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by David Franco on 1/19/18.
 */

public class Server {
    private String baseUrl = "http://u017633.ehu.eus:28080/HelpApp/rest/School"; //Siempre la misma
    private RestClient rest;

    public Server(){
        rest =  new RestClient(baseUrl);
    }

    public List<Question> getQuestions() throws JSONException, IOException {
        List<Question> questionList = new ArrayList<Question>();
        Question question;
        JSONObject json = rest.getJson("requestQuestions");
        JSONArray array = json.getJSONArray("questions");
        for( int i = 0; i < array.length(); i++ ) {
            JSONObject item = array.getJSONObject(i);
            question = new Question();
            question.setId(item.getInt("idQuestion"));
            question.setAnswer(item.getInt("answer"));
            question.setField(item.getString("appField"));
            question.setOpt1(item.getString("opt1"));
            question.setOpt2(item.getString("opt2"));
            question.setOpt3(item.getString("opt3"));
            question.setOpt4(item.getString("opt4"));
            question.setWight1(item.getInt("weight1"));
            question.setWight2(item.getInt("weight2"));
            question.setWight3(item.getInt("weight3"));
            question.setWight4(item.getInt("weight4"));
            question.setWording(item.getString("wording"));
            questionList.add(question);
        }
        return questionList;
    }

    public int uploadChoice(int questionId, int choiceWeight, String timeStamp) throws JSONException, IOException {
        JSONObject json = new JSONObject();
        json.put("question",questionId);
        json.put("score", choiceWeight);
        json.put("date", timeStamp);
        return rest.postJson(json,"uploadSolution");
    }
}
