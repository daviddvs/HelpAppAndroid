package eus.ehu.helpappandroid.helpappandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.List;

import modelo.Data;
import modelo.ProgressTask;
import modelo.Question;
import modelo.Server;

public class MainActivity extends AppCompatActivity {

    private Server server = new Server();
    private Data data = Data.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void bilbao(View view) {
        Intent intent = new Intent(this, BilbaoActivity.class);
        startActivity(intent);
    }

    public void getReady(View view) {

        new ProgressTask<List<Question>>(this){
            @Override
            protected List<Question> work() throws Exception{
                return server.getQuestions();
            }
            @Override
            protected void onFinish(List<Question> result){
                data.setQuestionList(result);
                Intent intent = new Intent(context, TestActivity.class);
                startActivity(intent);
            }
        }.execute();
        
    }

    public void profile(View view) {
        Intent intent = new Intent(this, ProfileActivity.class);
        startActivity(intent);
    }


}
