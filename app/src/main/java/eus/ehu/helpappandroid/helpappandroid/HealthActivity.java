package eus.ehu.helpappandroid.helpappandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class HealthActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health);
    }

    public void emergency(View view) {
        Intent intent = new Intent(this, ContentActivity.class);
        intent.putExtra(Content.ACTIVITY,Content.EMERGENCY);
        intent.putExtra(ContentActivity.CALLING_ACTIVITY, ContentActivity.ACTIVITY_HEALTH);
        startActivity(intent);
    }

    public void consultation(View view) {
        Intent intent = new Intent(this, ContentActivity.class);
        intent.putExtra(Content.ACTIVITY,Content.CONSULTATION);
        intent.putExtra(ContentActivity.CALLING_ACTIVITY, ContentActivity.ACTIVITY_HEALTH);
        startActivity(intent);
    }
    public void pharmacy(View view) {
        Intent intent = new Intent(this, ContentActivity.class);
        intent.putExtra(Content.ACTIVITY,Content.PHARMACY);
        intent.putExtra(ContentActivity.CALLING_ACTIVITY, ContentActivity.ACTIVITY_HEALTH);
        startActivity(intent);
    }

    public void back(View view) {
        Intent intent = new Intent(this, BilbaoActivity.class);
        startActivity(intent);
    }
}
