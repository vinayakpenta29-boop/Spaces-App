package com.example.floatingtool;

public class TextProcessor {

    public static String addSpaces(String text) {
        if (text == null) return "";

        String[] lines = text.split("\n");
        StringBuilder result = new StringBuilder();

        for (String line : lines) {
            result.append("   ").append(line).append("\n");
        }

        return result.toString();
    }
}
