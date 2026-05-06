package com.yasin.tutorials.othercourse._02_week;

import java.io.IOException;

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

@SuppressWarnings("unused")
public class _10_1_Exception {

    // try - catch - finally - throws - throw
    // throws : Sayın yazılımcı bu alanda xyz istisnaları gelebilir - throw
    public static void exceptionTutorials() throws NullPointerException, IOException {
        try {
            int number = 8 / 0;
        } catch (ArithmeticException arithmeticException) {
            arithmeticException.printStackTrace();
            // String message = arithmeticException.getMessage();
            // System.out.println(message);
        } catch (NullPointerException nullPointerException) { // catch (ArithmeticException | NullPointerException e)
            nullPointerException.printStackTrace();
        } finally {
            System.out.println("database.close");
        }

        System.out.println("Son satır");
    }

    public static void handleMethod() throws IOException {
        exceptionTutorials();
    }

    // PSVM
    public static void main(String[] args) {
        try {
            handleMethod();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
