package com.example.androidunittest;

import android.content.Context;

public class ResourceComparer {

    // Method untuk membandingkan string dari resource dengan string yang diberikan
    public static boolean isEqual(Context context, int resId, String input) {
        return context.getString(resId).equals(input);
    }

    // Method tambahan untuk membandingkan string secara case-insensitive (tidak peduli huruf besar/kecil)
    public static boolean isEqualIgnoreCase(Context context, int resId, String input) {
        return context.getString(resId).equalsIgnoreCase(input);
    }
}