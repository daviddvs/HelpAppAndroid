package eus.ehu.helpappandroid.helpappandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class BilbaoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bilbao);
    }

    public void accident(View view) {
        Intent intent = new Intent(this, AccidentActivity.class);
        startActivity(intent);
    }

    public void goods(View view) {
        Intent intent = new Intent(this, GoodsActivity.class);
        startActivity(intent);
    }

    public void health(View view) {
        Intent intent = new Intent(this, HealthActivity.class);
        startActivity(intent);
    }

    public void violence(View view) {
        Intent intent = new Intent(this, ViolenceActivity.class);
        startActivity(intent);
    }

    public void fire(View view) {
        Intent intent = new Intent(this, FireActivity.class);
        startActivity(intent);
    }

    public void map(View view) {

    }

    public void profile(View view) {

    }

    public void records(View view) {

    }

    public void back(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
