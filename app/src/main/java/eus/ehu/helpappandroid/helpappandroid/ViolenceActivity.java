package eus.ehu.helpappandroid.helpappandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ViolenceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_violence);
    }

    public void rape(View view) {
        Intent intent = new Intent(this, ContentActivity.class);
        intent.putExtra(Content.ACTIVITY,Content.RAPE);
        intent.putExtra(ContentActivity.CALLING_ACTIVITY, ContentActivity.ACTIVITY_VIOLENCE);
        startActivity(intent);
    }

    public void brawl(View view) {
        Intent intent = new Intent(this, ContentActivity.class);
        intent.putExtra(Content.ACTIVITY,Content.BRAWL);
        intent.putExtra(ContentActivity.CALLING_ACTIVITY, ContentActivity.ACTIVITY_VIOLENCE);
        startActivity(intent);
    }

    public void back(View view) {
        Intent intent = new Intent(this, BilbaoActivity.class);
        startActivity(intent);
    }
}
