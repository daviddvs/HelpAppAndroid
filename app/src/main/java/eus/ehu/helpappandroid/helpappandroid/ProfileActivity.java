package eus.ehu.helpappandroid.helpappandroid;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import modelo.Data;
import modelo.User;

public class ProfileActivity extends AppCompatActivity {

    private String userId;
    private String passwd;
    private Data data = Data.getInstance();
    //private final String PREF_LOGIN = "login";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
    }

    public void login(View v) {
        EditText userText = (EditText)findViewById(R.id.user_id);
        userId = userText.getText().toString();

        EditText passwdText = (EditText)findViewById(R.id.password);
        passwd = passwdText.getText().toString();

        loadUser();

        if (data.getUser().getPassword() == null) {
            Toast.makeText(this, "No such user", Toast.LENGTH_SHORT).show();
        }
        else{
            if(passwd.equals(data.getUser().getPassword())) {
                //Entra
                Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
                findViewById(R.id.login_layout).setVisibility(View.GONE);
                findViewById(R.id.profile_layout).setVisibility(View.VISIBLE);
                fillUser();
            }
            else {
                Toast.makeText(this, "Wrong password", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void signup(View v) {
        findViewById(R.id.user_layout).setVisibility(View.GONE);
        findViewById(R.id.password_layout).setVisibility(View.GONE);
        findViewById(R.id.signin_layout).setVisibility(View.VISIBLE);
        findViewById(R.id.button_layout).setVisibility(View.GONE);
    }

    public void sign(View v) {
        User user = new User();

        EditText userText = (EditText)findViewById(R.id.signin_user_id);
        userId = userText.getText().toString();
        user.setId(userId);

        EditText passwdText = (EditText)findViewById(R.id.signin_password);
        passwd = passwdText.getText().toString();
        user.setPassword(passwd);

        EditText nameText = (EditText)findViewById(R.id.signin_name);
        user.setName(nameText.getText().toString());

        EditText genderText = (EditText)findViewById(R.id.signin_gender);
        user.setGender(genderText.getText().toString());

        EditText countryText = (EditText)findViewById(R.id.signin_country);
        user.setCountry(countryText.getText().toString());

        data.setUser(user);

        saveUser();

        findViewById(R.id.user_layout).setVisibility(View.VISIBLE);
        findViewById(R.id.password_layout).setVisibility(View.VISIBLE);
        findViewById(R.id.signin_layout).setVisibility(View.GONE);
        findViewById(R.id.button_layout).setVisibility(View.VISIBLE);

        userText.setText("");
        passwdText.setText("");
        genderText.setText("");
        countryText.setText("");
    }

    public void close(View v) {
        findViewById(R.id.user_layout).setVisibility(View.VISIBLE);
        findViewById(R.id.password_layout).setVisibility(View.VISIBLE);
        findViewById(R.id.signin_layout).setVisibility(View.GONE);
        findViewById(R.id.button_layout).setVisibility(View.VISIBLE);
    }

    public void logout(View v){

        Toast.makeText(this, "Bye", Toast.LENGTH_SHORT).show();
        findViewById(R.id.login_layout).setVisibility(View.VISIBLE);
        findViewById(R.id.profile_layout).setVisibility(View.GONE);

    }

    public void back(View v) {
        Intent intent = new Intent(this, BilbaoActivity.class);
        startActivity(intent);
    }

    private void fillUser(){
        TextView textId = (TextView)findViewById(R.id.profile_id);
        textId.setText("Your id: "+data.getUser().getId());
        TextView textName = (TextView)findViewById(R.id.profile_name);
        textName.setText("Your name: "+data.getUser().getName());
        TextView textGender = (TextView)findViewById(R.id.profile_gender);
        textGender.setText("Your gender: "+data.getUser().getGender());
        TextView textCountry = (TextView)findViewById(R.id.profile_country);
        textCountry.setText("Your country: "+data.getUser().getCountry());



    }
    private void saveUser() {
        SharedPreferences prefs = getSharedPreferences(userId,MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("id", userId);
        editor.putString("name",data.getUser().getName());
        editor.putString("gender",data.getUser().getGender());
        editor.putString("country",data.getUser().getCountry());
        editor.putString("password",passwd);
        editor.commit();
        //Toast.makeText(this, "User id: "+data.getUser().getId(), Toast.LENGTH_SHORT).show();
        //Toast.makeText(this, "User pw: "+data.getUser().getPassword(), Toast.LENGTH_SHORT).show();
    }

    private void loadUser() {
        User user = new User();
        SharedPreferences prefs = getSharedPreferences(userId,MODE_PRIVATE);
        user.setId(prefs.getString("id",null));
        user.setName(prefs.getString("name",null));
        user.setGender(prefs.getString("gender",null));
        user.setCountry(prefs.getString("country",null));
        user.setPassword(prefs.getString("password",null));
        data.setUser(user);
        //Toast.makeText(this, "User id: "+data.getUser().getId(), Toast.LENGTH_SHORT).show();
        //Toast.makeText(this, "User pw: "+data.getUser().getPassword(), Toast.LENGTH_SHORT).show();
    }
}
