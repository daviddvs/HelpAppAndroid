package eus.ehu.helpappandroid.helpappandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class AccidentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accident);
    }

    public void traffic(View view) {

    }

    public void domestic(View view) {

    }

    public void back(View view) {
        Intent intent = new Intent(this, BilbaoActivity.class);
        startActivity(intent);
    }
}
