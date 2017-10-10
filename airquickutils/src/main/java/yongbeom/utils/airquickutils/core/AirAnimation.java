package yongbeom.utils.airquickutils.core;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.util.DisplayMetrics;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import yongbeom.utils.airquickutils.AirQuickUtils;

/**
 * AirAnimation
 *
 * Created by leeyongbeom on 2017. 9. 15..
 */

public class AirAnimation {

    private static final String TAG = AirAnimation.class.getSimpleName();

    private static final int DEFAULT_FRAME_DURATION = 500;

    private static final String TOKENIZER = "_";
    private static final int INDEX_OF_DURATION = 2;

    public static AnimationDrawable createAnimationDrawable(Context context, File directory, FilenameFilter filter, int width, int height) throws IllegalArgumentException {
        List<AnimationFrame> animationFrameList = createAnimationDrawableList(context, directory, filter, width, height);

        AnimationDrawable animation = new AnimationDrawable();

        for (AnimationFrame frame : animationFrameList) {
            animation.addFrame(frame.getDrawable(), frame.getDuration());
        }

        animationFrameList.clear();
        animationFrameList = null;

        animation.selectDrawable(0);
        animation.setOneShot(false);

        return animation;
    }

    public static List<AnimationFrame> createAnimationDrawableList(Context context, File directory, FilenameFilter filter, int width, int height) throws IllegalArgumentException {
        if (directory == null || directory.isDirectory() == false) {
            throw new IllegalArgumentException("Argument isn't directory. "+directory);
        }

        File[] files = null;

        if (filter == null) {
            files = directory.listFiles();
        } else {
            files = directory.listFiles(filter);
        }

        if (files.length == 0) {
            throw new IllegalArgumentException("The directory is empty. " + directory);
        }

        Arrays.sort(files, new Comparator<File>() {
            @Override
            public int compare(File lhs, File rhs) {
                return lhs.compareTo(rhs);
            }
        });

        List<AnimationFrame> drawables = new ArrayList<AnimationFrame>(files.length);

        for (File file : files) {
            AnimationFrame frame = new AnimationFrame();

            // Extract duration from file name.
            frame.setDuration(getDurationFromFileName(file.getName()));

            // Create BitmapDrawlable.
            Bitmap bitmap = null;

            try {
                bitmap = AirQuickUtils.image.resizeImage(context, file, width, height);
            }
            catch(IOException e) {
                AirQuickUtils.log.e("Can't resize bimtap.");
                continue;
            }

            bitmap.setDensity(DisplayMetrics.DENSITY_MEDIUM);

            BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
            bitmapDrawable.setAntiAlias(true);

            frame.setDrawable(bitmapDrawable);

            drawables.add(frame);
            AirQuickUtils.log.e(" Frame >> Path: " + file.getAbsoluteFile() + ", Duration: " + frame.getDuration());
        }

        return drawables;
    }

    private static int getDurationFromFileName(String fileName) {
        try {
            fileName = fileName.substring(0, fileName.indexOf("."));

            return Integer.parseInt(fileName.split(TOKENIZER)[INDEX_OF_DURATION]);
        } catch (ArrayIndexOutOfBoundsException e) {
            AirQuickUtils.log.e("ERROR" , e);
            return DEFAULT_FRAME_DURATION;
        }
    }

    public static class AnimationFrame {
        private int duration;
        private BitmapDrawable drawable;

        public int getDuration() {
            return duration;
        }

        public void setDuration(int duration) {
            this.duration = duration;
        }

        public BitmapDrawable getDrawable() {
            return drawable;
        }

        public void setDrawable(BitmapDrawable drawable) {
            this.drawable = drawable;
        }
    }

}
