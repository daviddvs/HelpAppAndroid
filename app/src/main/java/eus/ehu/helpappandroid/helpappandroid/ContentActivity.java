package eus.ehu.helpappandroid.helpappandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ContentActivity extends AppCompatActivity {

    public static final String CALLING_ACTIVITY = "calling_activity";
    public static final int ACTIVITY_ACCIDENT = 0;
    public static final int ACTIVITY_GOODS = 1;
    public static final int ACTIVITY_HEALTH = 2;
    public static final int ACTIVITY_VIOLENCE = 3;
    public static final int ACTIVITY_FIRE = 4;

    public int calling_activity;
    private TextView textWhat;
    private TextView textWhere;
    private TextView textTelephone;
    private String activity_to_create;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);

        Intent intent = getIntent();
        calling_activity = intent.getIntExtra(CALLING_ACTIVITY,-1);
        Content contentActivity = new Content();
        activity_to_create = intent.getStringExtra(Content.ACTIVITY);
        contentActivity.getContent(activity_to_create);

        //Fill programatically the content of the activity
        textWhat = (TextView)findViewById(R.id.content_whatToDo);
        textWhat.setText(contentActivity.whatToDo);
        textWhere = (TextView)findViewById(R.id.content_whereToGo);
        textWhere.setText(contentActivity.whereToGo);
        textTelephone = (TextView)findViewById(R.id.content_telephone);
        textTelephone.setText(contentActivity.telephone);

        //Make content collapsible: hide until its title is clicked
        textWhat.setVisibility(View.GONE);
        textWhere.setVisibility(View.GONE);
        textTelephone.setVisibility(View.GONE);

        //Set title
        setTitle(activity_to_create);
    }

    public void toggleContentsWhat(View v){
        textWhat.setVisibility( textWhat.isShown()
                ? View.GONE
                : View.VISIBLE );
    }

    public void toggleContentsWhere(View v){

        textWhere.setVisibility( textWhere.isShown()
                ? View.GONE
                : View.VISIBLE );
    }
    public void toggleContentsTelephone(View v){
        textTelephone.setVisibility( textTelephone.isShown()
                ? View.GONE
                : View.VISIBLE );
    }

    public void route(View view) {
        //Google Maps functionallity

    }

    public void back(View view) {

        //Back to the correspondent activity depending on the calling activity
        Intent intent;
        switch (calling_activity) {
            case 0:
                intent = new Intent(this, AccidentActivity.class);
                break;
            case 1:
                intent = new Intent(this, GoodsActivity.class);
                break;
            case 2:
                intent = new Intent(this, HealthActivity.class);
                break;
            case 3:
                intent = new Intent(this, ViolenceActivity.class);
                break;
            case 4:
                intent = new Intent(this, FireActivity.class);
                break;
            default:
                intent = new Intent(this, BilbaoActivity.class);
                break;
        }

        startActivity(intent);
    }


}
