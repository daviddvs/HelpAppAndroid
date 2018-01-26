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
import android.view.View;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class RecordsActivity extends AppCompatActivity {

    public static final int AUDIO_REQUEST_CODE = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_records);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode != Activity.RESULT_OK)
            return;
        if(requestCode == AUDIO_REQUEST_CODE) {
            // data.getData(): Esto devuelve uri en fromato content://
            // Lo que hay que hacer es coger el archivo, leerlo con un input stream y escribirlo con output stream en otro dir que yo elija
            String filePath = "eus.ehu.helpappandroid/records";//modificar esto
            File dir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC);
            //File dir = Environment.getDataDirectory();
            moveFile(data.getData(),dir.getPath(),"prueba1"+".amr");
        }
    }

    public void recordAudio(View view) {
        if (!getPackageManager().hasSystemFeature(PackageManager.FEATURE_MICROPHONE)) {
            Toast.makeText(this, R.string.no_micro, Toast.LENGTH_SHORT).show();
        }
        else {
            Intent intent = new Intent(MediaStore.Audio.Media.RECORD_SOUND_ACTION);
            if (intent.resolveActivity(getPackageManager()) != null)
                startActivityForResult(intent, AUDIO_REQUEST_CODE);
            else
                Toast.makeText(this,R.string.no_app, Toast.LENGTH_SHORT).show();
        }

    }

    public void openRecords(View view) {

    }

    public void back(View view) {
        Intent intent = new Intent(this, BilbaoActivity.class);
        startActivity(intent);
    }

    private void moveFile(Uri inputUri, String outputPath, String outputName) {

        File dir = new File(outputPath);
        if(!dir.exists())
            dir.mkdirs();

        try {
            //InputStream is = getContentResolver().openInputStream(inputUri);
            InputStream is = new FileInputStream(inputUri.getPath());
            OutputStream os = new FileOutputStream(outputPath+"/"+outputName);

            byte[] buffer = new byte[1024];
            int read;
            while((read = is.read(buffer)) != -1) {
                os.write(buffer, 0, read);
            }
            is.close();
            is=null;
            os.flush();
            os.close();
            os=null;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
