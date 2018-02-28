package xyz.siavash.storygame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

import xyz.siavash.storygame.di.AppComponent;
import xyz.siavash.storygame.presentation.ComponentProvider;
import xyz.siavash.storygame.presentation.TelegramLoginWebView;

public class MainActivity extends AppCompatActivity implements ComponentProvider{

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    WebView webView = (WebView) findViewById(R.id.webView1);
    webView.getSettings().setJavaScriptEnabled(true);
    webView.loadUrl("http://www.google.com");
    webView.setWebViewClient(new TelegramLoginWebView());
  }

  @Override
  public AppComponent getComponent() {
    return ((StoryGameApp)getApplication()).getComponent();
  }
}
