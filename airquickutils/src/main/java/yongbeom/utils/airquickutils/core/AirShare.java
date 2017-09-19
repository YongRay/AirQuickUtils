package yongbeom.utils.airquickutils.core;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.widget.Toast;

import java.io.File;

import yongbeom.utils.airquickutils.AirQuickUtils;

/**
 * AirShare
 *
 * Created by leeyongbeom on 2017. 9. 15..
 */
public class AirShare {

    /**
     * Facebook sharing.
     * TODO: Requires AirQuickUtils-CommonSNS plug-in
     *
     * add dependencies compile 'com.github.yongbeam:AirQuickUtils-CommonSNS:x.x.x'
     */
    public static void postFacebookFeed(Bitmap shareImage){
    }

    /**
     * Band sharing
     *
     * @param content Type the character that you want to include in the share.
     * @param uri Enter the image path to share.
     */
    public static void postBendFeed(String content , String uri){
        
        if(AirSystem.isInstalledApp("com.nhn.android.band")){
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("image/jpg");
            if(uri != null && !uri.equals("")){
                intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(new File(uri)));
            }
            intent.putExtra(Intent.EXTRA_TEXT, content);
            intent.setPackage("com.nhn.android.band");
            AirQuickUtils.getContext().startActivity(intent);
        }else{
            Toast.makeText(AirQuickUtils.getContext(), "Install the band, please.", Toast.LENGTH_SHORT).show();
        }
       
    }


    /**
     * Kakao sharing
     *
     * @param uri Enter the image path to share.
     */
    public static void postKakaoImage( String uri){
        if(AirSystem.isInstalledApp("com.kakao.talk")){
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("image/jpg");
            if(uri != null && !uri.equals("")){
                intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(new File(uri)));
            }
            intent.setPackage("com.kakao.talk");
            AirQuickUtils.getContext().startActivity(intent);
        }else{
            Toast.makeText(AirQuickUtils.getContext(), "Install the KakaoTalk, please.", Toast.LENGTH_SHORT).show();
        }

    }


    /**
     * etc sharing
     *
     * @param content Type the character that you want to include in the share.
     * @param uri Enter the image path to share.
     */
    public static void postCommonShare( String content , String uri){
        if(AirSystem.isInstalledApp("com.kakao.talk")){
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("image/jpg");
            if(uri != null && !uri.equals("")){
                intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(new File(uri)));
            }
            intent.putExtra(Intent.EXTRA_TEXT, content);
            AirQuickUtils.getContext().startActivity(intent);
        }else{
            Toast.makeText(AirQuickUtils.getContext(), "Install the KakaoTalk, please.", Toast.LENGTH_SHORT).show();
        }
    }

}
