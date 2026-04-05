package com.example.floatingtool;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnOverlay, btnAccessibility, btnStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // ✅ Set UI (VERY IMPORTANT)
        setContentView(R.layout.activity_main);

        // Initialize buttons
        btnOverlay = findViewById(R.id.btn_overlay);
        btnAccessibility = findViewById(R.id.btn_accessibility);
        btnStart = findViewById(R.id.btn_start);

        // 🔵 Overlay Permission Button
        btnOverlay.setOnClickListener(v -> {
            if (!Settings.canDrawOverlays(this)) {
                Intent intent = new Intent(
                        Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
                        Uri.parse("package:" + getPackageName()));
                startActivity(intent);
            } else {
                Toast.makeText(this, "Overlay permission already granted", Toast.LENGTH_SHORT).show();
            }
        });

        // 🔐 Accessibility Permission Button
        btnAccessibility.setOnClickListener(v -> {
            startActivity(new Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS));
        });

        // 🚀 Start Floating Tool
        btnStart.setOnClickListener(v -> {
            if (Settings.canDrawOverlays(this)) {
                startService(new Intent(this, FloatingService.class));
                Toast.makeText(this, "Floating tool started", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Please enable overlay permission first", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
