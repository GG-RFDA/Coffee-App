package com.example.coffeeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        // Определяем элемент интерфейса Web View
        WebView webView;
        webView = (WebView) findViewById(R.id.webView);
        // Передаём ссылку, которую необходимо загрузить в Web View, и создаём нового веб-клиента
        webView.loadUrl("https://shoko.ru/contacts/");
        webView.setWebViewClient(new WebViewClient());
        // Задаём набор веб-настроек и включаем распознавание JavaScript для последующего взаимодействия с заданной веб-страницей
        WebSettings myWebSettings = webView.getSettings();
        myWebSettings.setJavaScriptEnabled(true);
    }

    @Override
    // Создаём метод для перехода к предыдущей веб-странице внутри WebView, чтобы не совершать переход к первому экрану
    public void onBackPressed() {
        WebView webView;
        webView = (WebView) findViewById(R.id.webView);
        // Если переход назад между страницами возможен, то реализуем его
        if (webView.canGoBack()){
            webView.goBack();
        }
        // В обратном случае выполняем стандартный переход назад, предусмотренный приложением (к MainActivity)
        else{
            super.onBackPressed();
        }
    }

}