package com.yasin.tutorials.javacore;

/*
✅ Checked Exception Nedir?
Java tarafından zorunlu tutulur. Derleyici sizi uyarır.

📌 Örnekler:
IOException → dosya erişimi
SQLException → veritabanı hataları
ParseException → tarih dönüşüm hatası
 */

/*
✅ Unchecked Exception Nedir?
Derleyici sizi zorlamaz, ama çalışma zamanında program çökerse hatayı gösterir.

📌 Örnekler:
ArithmeticException → 10 / 0
NullPointerException
ArrayIndexOutOfBoundsException
NumberFormatException
 */

public class _15_2_CustomException extends Exception {

    // Constructor
    public _15_2_CustomException(String message) {
        super(message);
    }
}

@SuppressWarnings("unused")
class MainTestException {
    public static void main(String[] args) throws _15_2_CustomException {

        try {
            int a = 5 / 0;
        } catch (Exception e) {
            throw new _15_2_CustomException("Burada istisna var");
        }
    }

}
