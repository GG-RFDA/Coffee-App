package com.example.coffeeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.webkit.URLUtil;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Создаём обработчик события для кнопки "Меню"
    public void OnClickMenu(View view) {
        // Создаём объект класса Uri и указываем ссылку на файл
        Uri uri = Uri.parse("https://assets.allcafe.ru/pic/%D0%9D%D0%BE%D0%B2%D0%BE%D0%B5%20%D0%BC%D0%B5%D0%BD%D1%8E%20%D0%A8%D0%BE%D0%BA%D0%BE%D0%BB%D0%B0%D0%B4%D0%BD%D0%B8%D1%86%D0%B0%20(full).PDF");
        // Используем метод guessFileName для получения файла из ссылки
        String title = URLUtil.guessFileName(uri.toString(), null, null);
        // Используем класс DownloadManager
        DownloadManager.Request request = new DownloadManager.Request(uri);
        // Задаём заголовок
        request.setTitle(title);
        // Задаём отображаемый текст
        request.setDescription("Загрузка файла...");
        // Устанавливаем отображение уведомления
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE);
        // Указываем место сохранения
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, title);
        // Создаём и запускаем DownloadManager
        DownloadManager manager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
        manager.enqueue(request);
        // Отображаем для пользователя сообщение о начале загрузки файла
        Toast.makeText(this, "Загрузка файла", Toast.LENGTH_LONG).show();
    }
    // Создаём обработчик события для кнопки "О нас"
    public void OnClickUs(View view) {
        // Реализуем переход к стороннему приложению, способную обработать ссылку
        Intent siteIntent = new Intent(Intent.ACTION_VIEW,
        // Указываем ссылку
        Uri.parse("https://shoko.ru/about/"));
        startActivity(siteIntent);
    }
    // Создаём обработчик события для кнопки "Контакты"
    public void OnClickContacts(View  view) {
        // Реализуем переход между экранами
        Intent webIntent = new Intent(MainActivity.this, WebViewActivity.class);
        startActivity(webIntent);
    }
    // Создаём обработчик события для кнопки телефона
    public void OnClickPhone(View view) {
        // Реализуем переход к приложению, способному работать с телефонными номерами
        Intent phoneIntent = new Intent(Intent.ACTION_DIAL,
        // Распознаём номер телефона
        Uri.parse("tel:+7(926)991-09-08")); startActivity(phoneIntent);
    }
    // Создаём обработчик события для кнопки VK
    public void OnClickShop(View view) {
        // Реализуем переход к магазину приложений
        Intent vkIntent = new Intent(Intent.ACTION_VIEW,
        // Передаём ссылку
        Uri.parse("market://details?id=com.vkontakte.android"));
        startActivity(vkIntent);
    }
    // Создаём обработчик события для кнопки email
    public void OnClickEmail(View view) {
        // Реализуем переход к написанию электронного письма
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        // Указываем тип содержимого
        emailIntent.setType("text/*");
        // Указываем email получателя
        emailIntent.putExtra(Intent.EXTRA_EMAIL, "info@shoko.ru");
        // Указываем тему письма
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Мнение о кофейне");
        // Указываем шаблон письма
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Добрый день!...");
        startActivity(Intent.createChooser(emailIntent, "Написать в кофейню «Шоколадница»"));
    }
}