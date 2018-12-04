package yongbeom.utils.airquickutilssample;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import yongbeom.utils.airquickutils.AirQuickUtils;
import yongbeom.utils.airquickutils.model.AirWebViewOption;

public class MainActivity extends AppCompatActivity {

    private Button btn_ari_webview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_ari_webview = findViewById(R.id.btn_ari_webview);
        btn_ari_webview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AirWebViewOption webViewOption = new AirWebViewOption();
                webViewOption.setUrl("https://www.google.com");
                webViewOption.setTitle("TEST WEB VIEW");
                webViewOption.setShowActionbar(false);
                webViewOption.setShowUrl(false);
                AirQuickUtils.webview.startAirCommonWebView(webViewOption);
            }
        });

        // set pref
        AirQuickUtils.prefs.save("KEY_NAME1" , "String Value");
        AirQuickUtils.prefs.save("KEY_NAME2" , true);
        AirQuickUtils.prefs.save("KEY_NAME3" , 10);
        AirQuickUtils.prefs.save("KEY_NAME4" , 10f);
        AirQuickUtils.prefs.save("KEY_NAME5" , 10L);

        // get pref or AirLog
        AirQuickUtils.log.d(AirQuickUtils.prefs.getString("KEY_NAME1" , null));
        AirQuickUtils.log.e("VALUE: " + AirQuickUtils.prefs.getBoolean("KEY_NAME2" , false));
        AirQuickUtils.log.i("VALUE: " + AirQuickUtils.prefs.getInt("KEY_NAME3" , 0));
        AirQuickUtils.log.w("VALUE: " + AirQuickUtils.prefs.getFloat("KEY_NAME4" , 0f));
        AirQuickUtils.log.v("VALUE: " + AirQuickUtils.prefs.getLong("KEY_NAME5" , 0L));
    }
}
