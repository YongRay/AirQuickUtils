package yongbeom.utils.airquickutils.activity;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.net.URISyntaxException;

import yongbeom.utils.airquickutils.R;
import yongbeom.utils.airquickutils.collections.AirQuickUtilWebChromeClient;
import yongbeom.utils.airquickutils.core.AirSystem;
import yongbeom.utils.airquickutils.exceptions.MissingRequiredValueException;

/**
 * AirCommonWebViewActivity
 *
 * Created by leeyongbeom on 2017. 9. 15..
 */

public class AirCommonWebViewActivity extends AppCompatActivity {
    public static String KEY_URL = "url";
    public static String KEY_TITLE = "title";
    public static String KEY_IS_URL = "is_show_url";
    public static String KEY_IS_SHARE = "is_share_btn";
    public static String KEY_IS_ACTIONBAR = "is_actionbar";
    public static String KEY_IS_CONTROLLER = "is_controller";
    public static boolean SHOW_URL = false;
    public static boolean SHOW_SHARE = false;
    public static boolean SHOW_ACTIONBAR = true;
    public static boolean SHOW_CONTROLLER = false;

    private String mURL = null;
    private String mOrgUrl = null;
    private String mTitle = "";

    private float m_downX;
    private WebView mWebview;
    private ProgressBar progressBar;
    private RelativeLayout rl_airquickutil_url_layout;
    private EditText et_airquickutil_input_url;
    private Button btn_airquickutil_go;
    private RelativeLayout rl_airquickutil_controller;

    private ActionBar mActionbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.airquickutil_common_webview);

        mWebview = findViewById(R.id.airquickutil_id_webView);
        progressBar = findViewById(R.id.airquickutil_id_progressBar);
        rl_airquickutil_url_layout = findViewById(R.id.rl_airquickutil_url_layout);
        et_airquickutil_input_url = findViewById(R.id.et_airquickutil_input_url);
        btn_airquickutil_go = findViewById(R.id.btn_airquickutil_go);
        rl_airquickutil_controller = findViewById(R.id.rl_airquickutil_controller);

        SHOW_URL = getIntent().getBooleanExtra(KEY_IS_URL, false);
        SHOW_SHARE = getIntent().getBooleanExtra(KEY_IS_SHARE, false);
        SHOW_ACTIONBAR = getIntent().getBooleanExtra(KEY_IS_ACTIONBAR, true);
        SHOW_CONTROLLER = getIntent().getBooleanExtra(KEY_IS_CONTROLLER , false);

        if(getIntent().getStringExtra(KEY_URL) == null){
            // missing url error
            throw new MissingRequiredValueException();
        }else{
            mURL = getIntent().getStringExtra(KEY_URL);
            mOrgUrl = mURL;
        }

        // SET ACTIONBAR
        if(getSupportActionBar() != null){
            mActionbar = getSupportActionBar();
            if(SHOW_ACTIONBAR){
                mActionbar.show();
                mActionbar.setDisplayHomeAsUpEnabled(true);
                if(getIntent().getStringExtra(KEY_TITLE) != null){
                    mTitle = getIntent().getStringExtra(KEY_TITLE);
                }
                mActionbar.setTitle(mTitle);
            }else{
                mActionbar.hide();
            }
        }

        initWebView();

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void initWebView() {
        mWebview.setWebChromeClient(new AirQuickUtilWebChromeClient(this));
        mWebview.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                progressBar.setVisibility(View.VISIBLE);
                invalidateOptionsMenu();
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                mURL = url;
                return setScheme(url);
            }

            @TargetApi(Build.VERSION_CODES.N)
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                String url = request.getUrl().toString();
                mURL = url;
                return setScheme(url);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                super.onReceivedError(view, request, error);
                progressBar.setVisibility(View.GONE);
            }
        });

        mWebview.clearCache(true);
        mWebview.clearHistory();
        mWebview.getSettings().setUseWideViewPort(true);
        mWebview.getSettings().setJavaScriptEnabled(true);
        mWebview.setHorizontalScrollBarEnabled(true);
        mWebview.getSettings().setSupportZoom(true);
        mWebview.getSettings().setBuiltInZoomControls(false);
        mWebview.getSettings().setDisplayZoomControls(false);
        mWebview.getSettings().setDefaultTextEncodingName("UTF-8");
        mWebview.getSettings().setLoadWithOverviewMode(true);
        mWebview.getSettings().setDatabaseEnabled(true);
        mWebview.getSettings().setDomStorageEnabled(true);

        mWebview.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {

                if (event.getPointerCount() > 1) {
                    //Multi touch detected
                    return true;
                }

                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        // save the x
                        m_downX = event.getX();
                    }
                    break;

                    case MotionEvent.ACTION_MOVE:
                    case MotionEvent.ACTION_CANCEL:
                    case MotionEvent.ACTION_UP: {
                        // set x so that it doesn't move
                        event.setLocation(m_downX, event.getY());
                    }
                    break;
                }

                return false;
            }
        });


        if(SHOW_URL){
            setUrlLayout();
        }

        if(SHOW_SHARE){
            // TODO
        }

        if(SHOW_CONTROLLER){
            // TODO
//            setWebController();
        }

        mWebview.loadUrl(mURL);
    }

    private void setUrlLayout(){
        rl_airquickutil_url_layout.setVisibility(View.VISIBLE);
        et_airquickutil_input_url.setText(mURL);
        btn_airquickutil_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputUrl = et_airquickutil_input_url.getText().toString().trim();
                if(!inputUrl.startsWith("http")){
                    inputUrl = "http://"+inputUrl;
                }
                AirSystem.requestHideKeyboard(et_airquickutil_input_url);
                et_airquickutil_input_url.setText(inputUrl);
                mWebview.loadUrl(inputUrl);
            }
        });
        et_airquickutil_input_url.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                String inputUrl = et_airquickutil_input_url.getText().toString().trim();
                if(!inputUrl.startsWith("http")){
                    inputUrl = "http://"+inputUrl;
                }
                AirSystem.requestHideKeyboard(et_airquickutil_input_url);
                et_airquickutil_input_url.setText(inputUrl);
                mWebview.loadUrl(inputUrl);
                return true;
            }
        });
    }

    private void setWebController(){
        rl_airquickutil_controller.setVisibility(View.VISIBLE);

    }

    private boolean setScheme(String url) {
        if (url != null && !url.equals("")) {
            try {
                if (url.startsWith("intent:")) {
                    try {
                        Intent intent = Intent.parseUri(url, Intent.URI_INTENT_SCHEME);
                        Intent existPackage = getPackageManager().getLaunchIntentForPackage(intent.getPackage());
                        if (existPackage != null) {
                            startActivity(intent);
                        } else {
                            Intent marketIntent = new Intent(Intent.ACTION_VIEW);
                            marketIntent.setData(Uri.parse("market://details?id=" + intent.getPackage()));
                            startActivity(marketIntent);
                        }
                        mWebview.loadUrl(mURL);
                        return true;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else if (url.startsWith("market://")) {
                    try {
                        Intent intent = Intent.parseUri(url, Intent.URI_INTENT_SCHEME);
                        if (intent != null) {
                            startActivity(intent);
                        }
                        mWebview.loadUrl(mURL);
                        return true;
                    } catch (URISyntaxException e) {
                        e.printStackTrace();
                    }
                }

                return false;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }else{
            return false;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_BACK:
                if(mWebview != null){
                    if(!mURL.equals(mOrgUrl)){
                        mWebview.goBack();
                        return true;
                    }else{
                        finish();
                    }
                }
        }
        return super.onKeyDown(keyCode, event);
    }
}
