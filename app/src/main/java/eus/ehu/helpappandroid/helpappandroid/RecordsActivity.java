package eus.ehu.helpappandroid.helpappandroid;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.provider.OpenableColumns;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import modelo.AudioPlayer;
import modelo.FileTask;
import modelo.ProgressTask;

public class RecordsActivity extends AppCompatActivity {

    public static final int AUDIO_REQUEST_CODE = 2;
    private String audioName;
    private String audioPath;
    private File[] files = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_records);

        File dirMusic = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC);
        audioPath = dirMusic+"/HelpAppAudio";
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, final Intent data) {
        if(resultCode != Activity.RESULT_OK)
            return;
        if(requestCode == AUDIO_REQUEST_CODE) {
            new ProgressTask<String>(this){
                @Override
                protected String work() throws Exception{
                    //return moveFile(data.getData(),audioPath,audioName+".mp3");
                    return FileTask.moveFile(data.getData(),audioPath,audioName+".mp3", context);
                }
                @Override
                protected void onFinish(String result){
                    Toast.makeText(context, "Moved file: "+result, Toast.LENGTH_SHORT).show();
                }
            }.execute();
        }
    }

    public void recordAudio(View view) {
        if (!getPackageManager().hasSystemFeature(PackageManager.FEATURE_MICROPHONE)) {
            Toast.makeText(this, R.string.no_micro, Toast.LENGTH_SHORT).show();
        }
        else {
            Intent intent = new Intent(MediaStore.Audio.Media.RECORD_SOUND_ACTION);
            if (intent.resolveActivity(getPackageManager()) != null) {
                EditText audioNameText = (EditText)findViewById(R.id.audio_name);
                audioName =  audioNameText.getText().toString();
                startActivityForResult(intent, AUDIO_REQUEST_CODE);
            }
            else
                Toast.makeText(this,R.string.no_app, Toast.LENGTH_SHORT).show();
        }

    }

    public void openRecords(View view) {
        final ViewGroup layout = (ViewGroup) view.getParent();

        if (files != null)
            for(int i=0; i<files.length; i++) {
                Button button = (Button)findViewById(i);
                layout.removeView(button);
            }

        new ProgressTask<File[]>(this){
            @Override
            protected File[] work() throws Exception{
                File directory = new File(audioPath);
                files = directory.listFiles();
                return files;
            }
            @Override
            protected void onFinish(File[] files){
                Toast.makeText(context, "Read files", Toast.LENGTH_SHORT).show();
                for(int i = 0; i < files.length; i++){
                    Button button = new Button(context);
                    button.setText(files[i].getName());
                    button.setId(i);
                    button.setCompoundDrawablesWithIntrinsicBounds(R.drawable.play,0,0,0);
                    button.setOnClickListener(new Button.OnClickListener(){
                        public void onClick(View v) {
                           playAudioRecord(v);
                        }
                    });
                    layout.addView(button);
                }
            }
        }.execute();
    }

    private void playAudioRecord(View v) {
        int id = v.getId();
        //Toast.makeText(this, "file://"+files[id].getPath(), Toast.LENGTH_SHORT).show();
        playAudio("file://"+files[id].getPath(), (View)v.getParent().getParent() ); // /storage/emulated/0/Music/HelpAppAudio/Prueba.mp3", );
    }

    public void back(View view) {
        Intent intent = new Intent(this, BilbaoActivity.class);
        startActivity(intent);
    }


    private void playAudio(String advise, View view) {

        Runnable run = new Runnable() {
            @Override
            public void run() {
                finish();
            }
        };
        AudioPlayer audioPlayer = new AudioPlayer(view, run);
        try {
            audioPlayer.setAudioUri(Uri.parse(advise));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
