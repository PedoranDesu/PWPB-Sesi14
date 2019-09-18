package com.pedoran.pwpbsesi14;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebViewClient;
import android.widget.Button;

import com.pedoran.pwpbsesi14.FirebaseExample.FireBaseExample;
import com.pedoran.pwpbsesi14.LatihanWebView.WebViewExample;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnLat1 = findViewById(R.id.btn_lat1);
        btnLat1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pindah = new Intent(MainActivity.this, WebViewExample.class);
                startActivity(pindah);
            }
        });

        Button btnLat2 = findViewById(R.id.btn_lat2);
        btnLat2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pindah = new Intent(MainActivity.this, FireBaseExample.class);
                startActivity(pindah);
            }
        });
    }
}
