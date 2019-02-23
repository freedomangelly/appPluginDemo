package com.android.androidplugindemo;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * @author Created by freed
 * Created by freed on 2019/2/18.
 * Date:2019/2/18
 * @description
 */
public class TestActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_activity);

    }
}
