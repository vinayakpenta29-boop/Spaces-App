package com.example.floatingtool;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;

public class ClipboardHelper {

    public static void copyText(Context context, String text) {
        ClipboardManager cm = (ClipboardManager)
                context.getSystemService(Context.CLIPBOARD_SERVICE);
        cm.setPrimaryClip(ClipData.newPlainText("text", text));
    }

    public static String getText(Context context) {
        ClipboardManager cm = (ClipboardManager)
                context.getSystemService(Context.CLIPBOARD_SERVICE);

        if (cm.hasPrimaryClip()) {
            return cm.getPrimaryClip().getItemAt(0).getText().toString();
        }
        return "";
    }
}
