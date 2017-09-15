package yongbeom.utils.airquickutilssample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import yongbeom.utils.airquickutils.AirQuickUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        AirQuickUtils.prefs.save("AAA" , "test");
        AirQuickUtils.prefs.getString("AAA" , null);

    }
}
