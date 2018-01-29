package modelo;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by tta on 1/29/18.
 */

public class FileTask {

    public static String moveFile(Uri inputUri, String outputPath, String outputName, Context context) {

        File dir = new File(outputPath);
        if(!dir.exists())
            dir.mkdirs();

        try {
            InputStream is = context.getContentResolver().openInputStream(inputUri);
            //InputStream is = new FileInputStream(inputUri);
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

            String inFilePath;
            Cursor cursor = context.getContentResolver().query(inputUri, null, null, null, null);
            if (cursor == null) { // Source is Dropbox or other similar local file path
                inFilePath = inputUri.getPath();
            } else {
                cursor.moveToFirst();
                int idx = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
                inFilePath = cursor.getString(idx);
                cursor.close();
            }
            new File(inFilePath).delete();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return outputPath+"/"+outputName;
    }

}
