package com.example.androidunittest;

import org.junit.Test;
import static org.junit.Assert.*;

public class PinUtilTest {

    /**
     * Menguji berbagai PIN yang memenuhi aturan validasi.
     *
     * Test case ini memastikan bahwa:
     * 1. PIN terdiri dari **4 hingga 6 digit angka**.
     * 2. Tidak mengandung karakter selain angka.
     * 3. Tidak memiliki angka yang berulang lebih dari **2 kali berturut-turut**.
     *
     * Data uji yang digunakan:
     * - "1234", 4 digit, angka semua, valid.
     * - "567890", 6 digit, angka semua, valid.
     * - "998877", 6 digit, angka tidak berulang lebih dari 2 kali berturut-turut, valid.
     * - "0011", 4 digit angka yang sama, tapi masih valid karena tidak lebih dari 2 kali berturut-turut.
     * - "135792", 6 digit, kombinasi angka unik, valid.
     * - "2468", 4 digit, semua angka berbeda, valid.
     * - "99123", 6 digit, '99' muncul 2 kali, valid.
     * - "808080", 6 digit, pola berulang tetapi tidak lebih dari 2 kali berturut-turut, valid.
     * - "121314", 6 digit, angka unik, valid.
     * - "4321", 4 digit angka dalam pola menurun, valid.
     */
    @Test
    public void testValidPin() {
        assertEquals("PIN valid", PinUtil.validatePin("1234")); // PIN 4 digit, valid
        assertEquals("PIN valid", PinUtil.validatePin("567890")); // PIN 6 digit, valid
        assertEquals("PIN valid", PinUtil.validatePin("998877")); // Tidak ada angka yang berulang >2 kali
        assertEquals("PIN valid", PinUtil.validatePin("1100")); // Semua angka sama tapi tidak lebih dari 2 kali berturut-turut
        assertEquals("PIN valid", PinUtil.validatePin("135792")); // Tidak ada angka yang berulang berturut-turut
        assertEquals("PIN valid", PinUtil.validatePin("2468")); // PIN dengan 4 digit acak, valid
        assertEquals("PIN valid", PinUtil.validatePin("99123")); // 99 diulang 2x ,valid
        assertEquals("PIN valid", PinUtil.validatePin("808080")); // Tidak ada angka yang berulang lebih dari 2 kali berturut-turut
        assertEquals("PIN valid", PinUtil.validatePin("121314")); // Kombinasi angka yang valid
        assertEquals("PIN valid", PinUtil.validatePin("4321")); // PIN menurun tanpa pengulangan berlebihan
    }

    /**
     * Menguji berbagai PIN yang **tidak memenuhi aturan validasi**.
     *
     * Test case ini memastikan bahwa:
     * 1. PIN yang **mengandung huruf atau karakter spesial** tidak valid.
     * 2. PIN yang **kurang dari 4 digit atau lebih dari 6 digit** tidak valid.
     * 3. PIN dengan **angka yang berulang lebih dari 2 kali berturut-turut** tidak valid.
     * 4. PIN kosong tidak valid.
     *
     * Data uji yang digunakan:
     * - "abcd", Mengandung huruf, tidak valid.
     * - "1112", '1' muncul 3 kali berturut-turut, tidak valid.
     * - "123", Kurang dari 4 digit, tidak valid.
     * - "1234567", Lebih dari 6 digit, tidak valid.
     * - "12@34", Mengandung karakter spesial '@', tidak valid.
     * - "999999", Semua angka sama, lebih dari 2 kali berturut-turut, tidak valid.
     * - "122333", '3' muncul 3 kali berturut-turut, tidak valid.
     * - "a1b2c3", Mengandung huruf dan angka campuran, tidak valid.
     * - "888000", Dua angka berbeda ('888' dan '000') muncul 3 kali berturut-turut, tidak valid.
     * - "" (kosong), PIN kosong, tidak valid.
     */
    @Test
    public void testInvalidPin() {
        assertEquals("PIN tidak valid", PinUtil.validatePin("abcd")); // Mengandung huruf, tidak valid
        assertEquals("PIN tidak valid", PinUtil.validatePin("1112")); // '1' muncul 3 kali berturut-turut, tidak valid
        assertEquals("PIN tidak valid", PinUtil.validatePin("123")); // Kurang dari 4 digit, tidak valid
        assertEquals("PIN tidak valid", PinUtil.validatePin("1234567")); // Lebih dari 6 digit, tidak valid
        assertEquals("PIN tidak valid", PinUtil.validatePin("12@34")); // Mengandung karakter spesial, tidak valid
        assertEquals("PIN tidak valid", PinUtil.validatePin("999999")); // Semua angka sama dan berulang lebih dari 2 kali, tidak valid
        assertEquals("PIN tidak valid", PinUtil.validatePin("122333")); // '3' muncul 3 kali berturut-turut, tidak valid
        assertEquals("PIN tidak valid", PinUtil.validatePin("a1b2c3")); // Mengandung huruf dan angka campuran, tidak valid
        assertEquals("PIN tidak valid", PinUtil.validatePin("888000")); // '888' dan '000' muncul lebih dari 2 kali berturut-turut, tidak valid
        assertEquals("PIN tidak valid", PinUtil.validatePin("")); // String kosong, tidak valid
    }
}