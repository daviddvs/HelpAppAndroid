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
        Intent intent = new Intent(this, ContentActivity.class);
        intent.putExtra(Content.ACTIVITY,Content.TRAFFIC);
        intent.putExtra(ContentActivity.CALLING_ACTIVITY, ContentActivity.ACTIVITY_ACCIDENT);
        startActivity(intent);
    }

    public void domestic(View view) {
        Intent intent = new Intent(this, ContentActivity.class);
        intent.putExtra(Content.ACTIVITY,Content.DOMESTIC);
        intent.putExtra(ContentActivity.CALLING_ACTIVITY, ContentActivity.ACTIVITY_ACCIDENT);
        startActivity(intent);
    }

    public void back(View view) {
        Intent intent = new Intent(this, BilbaoActivity.class);
        startActivity(intent);
    }
}
