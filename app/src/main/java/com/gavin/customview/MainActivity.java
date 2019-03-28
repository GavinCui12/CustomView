package com.gavin.customview;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.tencent.mmkv.MMKV;

public class MainActivity extends AppCompatActivity {
    public InputMethodManager mInputMethodManager;
    View mBtnCloseSoft,mFreeView;
    EditText mSearch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String rootDir = MMKV.initialize(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mInputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        findId();
    }

    private void findId() {
        mBtnCloseSoft = findViewById(R.id.btn_close_soft);
        mFreeView = findViewById(R.id.free_view);
        mSearch = findViewById(R.id.et_search);

        mBtnCloseSoft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closeSoftInput(mSearch);
            }
        });
    }

    /**
     * 收起软键盘
     * @param editText
     */
    public void closeSoftInput(View editText) {
        if (mInputMethodManager != null && mInputMethodManager.isActive()) {
            mInputMethodManager.hideSoftInputFromWindow(editText.getWindowToken(), 0);
        }
    }
}
