package com.example.androidunittest;

public class PinUtil {

    // Fungsi untuk validasi PIN
    public static String validatePin(String pin) {
        // Rule 1: PIN hanya boleh berisi angka
        if (!pin.matches("\\d+")) {
            return "PIN tidak valid";
        }

        // Rule 2: Panjang PIN harus antara 4 hingga 6 digit
        int length = pin.length();
        if (length < 4 || length > 6) {
            return "PIN tidak valid";
        }

        // Rule 3: Tidak boleh ada angka yang berulang lebih dari 2 kali berturut-turut
        int count = 1;
        char prevChar = pin.charAt(0);

        for (int i = 1; i < length; i++) {
            if (pin.charAt(i) == prevChar) {
                count++;
                if (count > 2) {
                    return "PIN tidak valid";
                }
            } else {
                count = 1; // Reset jika angka berbeda
            }
            prevChar = pin.charAt(i);
        }

        return "PIN valid"; // Jika semua aturan lolos
    }
}