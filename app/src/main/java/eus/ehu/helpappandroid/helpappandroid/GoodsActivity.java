package eus.ehu.helpappandroid.helpappandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class GoodsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods);
    }

    public void papers(View view) {
        Intent intent = new Intent(this, ContentActivity.class);
        intent.putExtra(Content.ACTIVITY,Content.PAPERS);
        intent.putExtra(ContentActivity.CALLING_ACTIVITY, ContentActivity.ACTIVITY_GOODS);
        startActivity(intent);
    }

    public void theft(View view) {
        Intent intent = new Intent(this, ContentActivity.class);
        intent.putExtra(Content.ACTIVITY,Content.THEFT);
        intent.putExtra(ContentActivity.CALLING_ACTIVITY, ContentActivity.ACTIVITY_GOODS);
        startActivity(intent);
    }

    public void relative(View view) {
        Intent intent = new Intent(this, ContentActivity.class);
        intent.putExtra(Content.ACTIVITY,Content.RELATIVE);
        intent.putExtra(ContentActivity.CALLING_ACTIVITY, ContentActivity.ACTIVITY_GOODS);
        startActivity(intent);
    }

    public void luggage(View view) {
        Intent intent = new Intent(this, ContentActivity.class);
        intent.putExtra(Content.ACTIVITY,Content.LUGGAGE);
        intent.putExtra(ContentActivity.CALLING_ACTIVITY, ContentActivity.ACTIVITY_GOODS);
        startActivity(intent);
    }

    public void back(View view) {
        Intent intent = new Intent(this, BilbaoActivity.class);
        startActivity(intent);
    }
}
