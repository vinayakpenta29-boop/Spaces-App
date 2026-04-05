package com.example.floatingtool;

import android.accessibilityservice.AccessibilityService;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Toast;

public class MyAccessibilityService extends AccessibilityService {

    public static String selectedText = "";

    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {

        if (event == null) return;

        // Detect selection change
        if (event.getEventType() == AccessibilityEvent.TYPE_VIEW_TEXT_SELECTION_CHANGED ||
            event.getEventType() == AccessibilityEvent.TYPE_VIEW_TEXT_CHANGED) {

            AccessibilityNodeInfo source = event.getSource();
            if (source != null && source.getText() != null) {

                selectedText = source.getText().toString();

                // Show preview (optional)
                Toast.makeText(this, "Captured Text", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onInterrupt() {
        // Required method
    }
}
