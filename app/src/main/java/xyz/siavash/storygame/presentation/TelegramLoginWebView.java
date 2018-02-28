package xyz.siavash.storygame.presentation;

import android.graphics.Bitmap;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class TelegramLoginWebView extends WebViewClient {

  @Override
  public void onPageStarted(WebView view, String url, Bitmap favicon) {
    super.onPageStarted(view, url, favicon);
    Log.i("Listener", "Start");

  }

  @Override
  public void onPageFinished(WebView view, String url) {
    super.onPageFinished(view, url);
    Log.i("Listener", "Finish");
  }

}