package com.example.myapp;

import android.os.Bundle;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;

public class MainActivity extends ComponentActivity {

    static {
        System.loadLibrary("native-lib");  // Load the C++ library
    }

    private native String getNativeVersion();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Enable edge-to-edge
        EdgeToEdge.enable(this);

        // Create the TextView programmatically
        TextView textView = new TextView(this);
        textView.setText("Native Version: " + getNativeVersion());
        textView.setTextSize(24); // Approximate equivalent to headlineMedium
        textView.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);

        // Handle edge-to-edge insets
        ViewCompat.setOnApplyWindowInsetsListener(textView, (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        setContentView(textView);

        // Hide the action bar if needed
        new WindowInsetsControllerCompat(getWindow(), getWindow().getDecorView())
                .setSystemBarsBehavior(WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE);
    }
}