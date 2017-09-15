package yongbeom.utils.airquickutilssample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import yongbeom.utils.airquickutils.AirQuickUtils;
import yongbeom.utils.airquickutils.activity.AirCommonWebViewIntent;
import yongbeom.utils.airquickutils.model.AirWebViewOption;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        AirWebViewOption webViewOption = new AirWebViewOption();
        webViewOption.setUrl("http://www.google.com");
        webViewOption.setTitle("테스트");
        webViewOption.setShowActionbar(false);
        AirQuickUtils.webview.startAirCommonWebView(webViewOption);

    }
}
