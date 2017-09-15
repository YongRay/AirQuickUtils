package yongbeom.utils.airquickutilssample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import yongbeom.utils.airquickutils.AirQuickUtils;
import yongbeom.utils.airquickutils.activity.AirCommonWebViewIntent;
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
                webViewOption.setUrl("http://www.mowa.kr");
                webViewOption.setTitle("TEST WEB VIEW");
                webViewOption.setShowActionbar(false);
                webViewOption.setShowUrl(false);
                AirQuickUtils.webview.startAirCommonWebView(webViewOption);
            }
        });
    }
}
