package com.igor.gerenciadordecomandas;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class MainActivity extends Activity {
    private String TAG = "|MainActivity|";
    public static WebView webview = null;

    @Override
    public void onCreate(Bundle appBundle) {
        super.onCreate(appBundle);

        setContentView(R.layout.activity_web_view);
        webview = (WebView) findViewById(R.id.web_view);

        webview.setWebContentsDebuggingEnabled(true);
        setUpSettings();
        webview.loadUrl("file:///android_asset/www/index.html");

        webview.addJavascriptInterface(new GerenciadorComanda(), "GerenciadorComanda");
    }

    private void setUpSettings() {
        WebSettings settings = webview.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setAllowContentAccess(true);
        settings.setAppCacheEnabled(true);
        settings.setAllowFileAccess(true);
        settings.setDatabaseEnabled(true);
    }

    public static void loadUrl(String url, boolean bridgeMode) {
        if (bridgeMode) {
            loadUrlInBridgeMode(url);
        } else {
            webview.loadUrl(url);
        }
    }

    private static void loadUrlInBridgeMode(String url) {
        final String urlInBridge = url;
        final Runnable runnable = new Runnable() {
            public void run() {
                if (urlInBridge != null) {
                    loadUrl(urlInBridge, false);
                }
            }
        };
        webview.post(runnable);
    }
}
