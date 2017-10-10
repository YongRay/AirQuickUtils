package yongbeom.utils.airquickutils.core;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import yongbeom.utils.airquickutils.AirQuickUtils;

/**
 * AirImage
 *
 * Created by leeyongbeom on 2017. 9. 15..
 */
public class AirImage {

    public static Bitmap resizeImage(Context context, File file, int width, int height) throws IOException {
        String filePath = file.getCanonicalPath();

        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        options.inSampleSize = 1;

        // Get original image size.
        BitmapFactory.decodeFile(filePath, options);

        int adjustWidth = options.outWidth >> 1;
        int adjustHeight = options.outHeight >> 1;

        while ((adjustWidth > width) && (adjustHeight > height)) {
            options.inSampleSize <<= 1;

            adjustWidth >>= 1;
            adjustHeight >>= 1;
        }
        AirQuickUtils.log.d("Sampling size: " + options.inSampleSize);

        options.inJustDecodeBounds = false;
//        options.inDither = true;
//        options.inPurgeable = true;

        Bitmap tmp = BitmapFactory.decodeFile(filePath, options);

        if (tmp == null) {
            throw new IOException("Can't decode file");
        }

        AirQuickUtils.log.d("Request(Width: "+ width+ ", Height: " + height+ "), Response(Width: " + tmp.getWidth()+ ", Height: "+ tmp.getHeight()+ ")");

        return tmp;
    }

    public static File saveBitmap(Bitmap bitmap, String filename, String path, boolean recycle) {
        FileOutputStream out = null;
        try {
            File f = new File(path, filename);
            if (!f.exists()) {
                f.createNewFile();
            }
            out = new FileOutputStream(f);
            if (bitmap.compress(Bitmap.CompressFormat.PNG, 90, out)) {
                return f;
            }
        } catch (Exception e) {
            AirQuickUtils.log.e("Could not save bitmap", e);
        } finally {
            try {
                out.close();
            } catch (Throwable ignore) {
            }
            if (recycle) {
                bitmap.recycle();
            }
        }
        return null;
    }

}
