package com.hoyup.rnkeyboard;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

public class RNKeyboardModule extends ReactContextBaseJavaModule {

    ReactApplicationContext reactContext;

    public RNKeyboardModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
    }

    @Override
    public String getName() {
        return "RNKeyboardModule";
    }

    @ReactMethod
    public void dismiss() {
        InputMethodManager inputManager = (InputMethodManager) getCurrentActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        View v = getCurrentActivity().getCurrentFocus();

        if (v != null) {
            inputManager.hideSoftInputFromWindow(v.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }

    @ReactMethod
    public void show(Promise promise) {
        ((InputMethodManager) getCurrentActivity().getSystemService(Context.INPUT_METHOD_SERVICE)).toggleSoftInput(0, InputMethodManager.HIDE_IMPLICIT_ONLY);
    }
}

