package eus.ehu.helpappandroid.helpappandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class FireActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fire);
    }

    public void building(View view) {
        Intent intent = new Intent(this, ContentActivity.class);
        intent.putExtra(Content.ACTIVITY,Content.BUILDING);
        intent.putExtra(ContentActivity.CALLING_ACTIVITY, ContentActivity.ACTIVITY_FIRE);
        startActivity(intent);
    }

    public void back(View view) {
        Intent intent = new Intent(this, BilbaoActivity.class);
        startActivity(intent);
    }
}
