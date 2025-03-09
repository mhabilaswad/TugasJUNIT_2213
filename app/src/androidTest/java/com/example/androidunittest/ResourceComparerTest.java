package com.example.androidunittest;

import android.content.Context;
import androidx.test.core.app.ApplicationProvider;
import org.junit.Test;
import static org.junit.Assert.*;

public class ResourceComparerTest {

    private final Context context = ApplicationProvider.getApplicationContext();

    /**
     * Menguji apakah teks yang diambil dari resources sesuai dengan teks yang diharapkan.
     *
     * Test case ini memastikan bahwa:
     * 1. `R.string.hello_world` diambil dengan benar dari `strings.xml`.
     * 2. Teks yang ada di resources cocok dengan expectedText yang diberikan.
     * 3. Jika teks cocok, maka `assertTrue()` harus lolos.
     *
     * Data uji:
     * - `expectedText = "Hello World"`, Harus cocok dengan string di `strings.xml`.
     */
    @Test
    public void testResourceMatchesCorrectString() {
        String expectedText = "Hello World"; // Teks yang seharusnya ada di strings.xml
        assertTrue(ResourceComparer.isEqual(context, R.string.hello_world, expectedText));
    }

    /**
     * Menguji apakah teks dari resources tidak cocok dengan teks yang salah.
     *
     * Test case ini memastikan bahwa:
     * 1. `R.string.hello_world` tetap diambil dari `strings.xml`.
     * 2. Teks yang diberikan (`wrongText`) **tidak sama** dengan teks di resources.
     * 3. Jika teks tidak cocok, maka `assertFalse()` harus lolos.
     *
     * Data uji:
     * - `wrongText = "Hello"`, Tidak sesuai dengan string di `strings.xml`.
     */
    @Test
    public void testResourceDoesNotMatchIncorrectString() {
        String wrongText = "Hello"; // Teks yang berbeda dari `strings.xml`
        assertFalse(ResourceComparer.isEqual(context, R.string.hello_world, wrongText));
    }

    /**
     * Menguji apakah teks dari resources cocok dengan input yang berbeda kapitalisasi.
     *
     * Test case ini memastikan bahwa:
     * 1. `R.string.hello_world` diambil dari `strings.xml`.
     * 2. Input memiliki perbedaan dalam huruf besar/kecil, tetapi tetap harus cocok.
     * 3. Jika cocok, maka `assertTrue()` harus lolos.
     *
     * Data uji:
     * - `differentCaseText = "hello world"`, Seharusnya masih cocok dengan "Hello World".
     */
    @Test
    public void testResourceMatchesIgnoreCase() {
        String differentCaseText = "hello world"; // Huruf kecil, tetapi seharusnya masih cocok
        assertTrue(ResourceComparer.isEqualIgnoreCase(context, R.string.hello_world, differentCaseText));
    }

    /**
     * Menguji apakah teks dari resources tidak cocok dengan input yang benar-benar berbeda.
     *
     * Test case ini memastikan bahwa:
     * 1. `R.string.hello_world` tetap diambil dari `strings.xml`.
     * 2. Input memiliki teks yang sangat berbeda sehingga harus dianggap **tidak cocok**.
     * 3. Jika teks tidak cocok, maka `assertFalse()` harus lolos.
     *
     * Data uji:
     * - `completelyDifferentText = "Hi Universe"`, Berbeda dari "Hello World", sehingga harus return false.
     */
    @Test
    public void testResourceDoesNotMatchEvenIgnoreCase() {
        String completelyDifferentText = "Hi Universe"; // Berbeda secara keseluruhan
        assertFalse(ResourceComparer.isEqualIgnoreCase(context, R.string.hello_world, completelyDifferentText));
    }
}