package eus.ehu.helpappandroid.helpappandroid;

import android.content.Intent;
import android.graphics.Color;
import android.support.constraint.solver.LinearSystem;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;

import java.io.IOException;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import modelo.Data;
import modelo.ProgressTask;
import modelo.Question;
import modelo.Server;

public class TestActivity extends AppCompatActivity implements View.OnClickListener {

    private Data data = Data.getInstance();
    private int nextQuestion = 0;
    private List<Question> questionList = data.getQuestionList();
    private RadioGroup group;
    private Server server = new Server();
    private int selectedWeight;
    private Timestamp timeStamp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        questionList = shuffleQuestions();
        try {
            fillTest();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void fillTest() throws IOException, JSONException {

        TextView textWording = (TextView) findViewById(R.id.test_wording);

        if(nextQuestion < questionList.size()){
            // Fill wording
            textWording.setText(questionList.get(nextQuestion).getWording());

            // Fill choices (always 4)
            group = (RadioGroup)findViewById(R.id.test_choices);
            RadioButton radio1 = new RadioButton(this);
            radio1.setText(questionList.get(nextQuestion).getOpt1());
            radio1.setOnClickListener(this);

            RadioButton radio2 = new RadioButton(this);
            radio2.setText(questionList.get(nextQuestion).getOpt2());
            radio2.setOnClickListener(this);

            RadioButton radio3 = new RadioButton(this);
            radio3.setText(questionList.get(nextQuestion).getOpt3());
            radio3.setOnClickListener(this);

            RadioButton radio4 = new RadioButton(this);
            radio4.setText(questionList.get(nextQuestion).getOpt4());
            radio4.setOnClickListener(this);

            group.addView(radio1);
            group.addView(radio2);
            group.addView(radio3);
            group.addView(radio4);
            nextQuestion++;
        }
        else {
            Toast.makeText(this, "Last Question", Toast.LENGTH_SHORT).show();
            textWording.setText("");
            findViewById(R.id.button_finish_test).setVisibility(View.VISIBLE);
            findViewById(R.id.button_send_test).setVisibility(View.GONE);
        }
    }

    public void next(View v) {
        findViewById(R.id.button_next_test).setVisibility(View.GONE);
        group.removeAllViews();
        try {
            fillTest();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void send(View v) {
        int radioButtonId = group.getCheckedRadioButtonId();//Este id no es la posicion del radioButton
        View radioButton = group.findViewById(radioButtonId);
        int selected = group.indexOfChild(radioButton);
        int choices = group.getChildCount();
        int correct = questionList.get(nextQuestion-1).getAnswer();
        // Deshabilitar para que no se pueda volver a seleccionar
        for (int i=0; i<choices; i++)
            group.getChildAt(i).setEnabled(false);

        group.getChildAt(correct-1).setBackgroundColor(Color.GREEN);// El -1 es por la implementacion de mi REST
        if(selected != correct-1){
            group.getChildAt(selected).setBackgroundColor(Color.RED);
            Toast.makeText(getApplicationContext(), "¡Has fallado!", Toast.LENGTH_SHORT).show();
        } else
            Toast.makeText(getApplicationContext(), "¡Correcto!", Toast.LENGTH_SHORT).show();

        findViewById(R.id.button_send_test).setVisibility(View.GONE);
        findViewById(R.id.button_next_test).setVisibility(View.VISIBLE);

        selectedWeight = 0;
        if( selected == 0 )
            selectedWeight = questionList.get(nextQuestion-1).getWight1();
        if( selected == 1 )
            selectedWeight = questionList.get(nextQuestion-1).getWight2();
        if( selected == 2 )
            selectedWeight = questionList.get(nextQuestion-1).getWight3();
        if( selected == 3 )
            selectedWeight = questionList.get(nextQuestion-1).getWight4();

        // Fecha en formato "yyyy mm dd hh:mm:ss"
        Date date = new Date();
        timeStamp = new Timestamp(date.getTime());

        new ProgressTask<Integer>(this){
            @Override
            protected Integer work() throws Exception{

                return server.uploadChoice(questionList.get(nextQuestion-1).getId(), selectedWeight, timeStamp.toString());
            }
            @Override
            protected void onFinish(Integer result){
                Toast.makeText(context, "Status code: "+result.toString(), Toast.LENGTH_SHORT).show();
            }
        }.execute();
    }

    public void finishTest(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        findViewById(R.id.button_send_test).setVisibility(View.VISIBLE);
    }

    private List<Question> shuffleQuestions() {
        List<Question> list = new ArrayList<Question>();
        int arrayLength = questionList.size();

        for (int i = 0; i<arrayLength; i++){
            long j = Math.round(Math.random()*(questionList.size()-1));
            list.add(questionList.get((int)j));
            questionList.remove((int)j);
        }
        return list;
    }
}
