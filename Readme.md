# Techcareer Java Core Eğitimi - 2025

> **Not:** Bu proje ve eğitim içerikleri **Techcareer** eğitimlerinden alınmış ve geliştirilmiştir. 🎓
>
> *Bu depo; 2025 yılında tamamlanan eğitim çalışmalarının 2026 yılında modernize edilerek, detaylı dökümante edilmiş ve kod kalitesi artırılmış (refactored) güncel sürümüdür.*

Bu depo (repository), Techcareer 2025 Java Core eğitimi boyunca işlenen konuları, örnek kodları, pratik çalışmaları ve geliştirilen kütüphane projesini içermektedir. Proje, temel Java syntax'ından başlayarak İleri Seviye Nesne Yönelimli Programlama (OOP), Koleksiyonlar (Collections), Generics ve Dosya İşlemleri (I/O) gibi modern Java yeteneklerini pratik uygulamalarla barındırır.

## Proje Ağaç Yapısı

```text
 2025_Techcareer_Java_Core
├── src
│   └── main
│       └── java
│           └── com
│               └── yasin
│                   ├── project
│                   │   └── library        # Dijital Kütüphane Sistemi Projesi
│                   └── tutorials          # Eğitim Modülleri
│                       ├── javacore       # Core Java Konuları
│                       └── othercourse    # Haftalık Eğitimler
│                           ├── _01_week
│                           ├── _02_week
│                           ├── _03_week
│                           └── _04_week
├── pom.xml
└── Readme.md
```

## İçerik ve Konular

Eğitim klasörlerinde aşağıdaki temel başlıklar işlenmiştir:

1. **Temel Java (Java Core):** Değişkenler, Veri Tipleri (Primitive & Wrapper), Tip Dönüşümleri (Casting).
2. **Kontrol Yapıları:** İf-Else, Switch-Case, Döngüler (For, While, Do-While).
3. **Metotlar:** Parametreli metotlar, Recursive (Özyinelemeli) metotlar.
4. **Nesne Yönelimli Programlama (OOP):** Sınıflar (Classes), Kalıtım (Inheritance), Çok Biçimlilik (Polymorphism), Kapsülleme (Encapsulation), Soyutlama (Abstract & Interface).
5. **Hata Yönetimi (Exception Handling):** Try-Catch blokları, Custom Exception oluşturma (Örn: `LibraryException`).
6. **Tarih ve Zaman API:** `java.util.Date`, `Calendar`, modern `LocalDateTime`.
7. **Koleksiyonlar (Collections Framework):** List (ArrayList, Vector, LinkedList), Set, Map (HashMap), Queue.
8. **Jenerikler (Generics):** Type safety, Bounded Generics, Wildcards yapıları.
9. **Dosya İşlemleri (File I/O):** Dosya okuma/yazma işlemleri (BufferedReader, BufferedWriter vb.).

## Projeler ve Uygulamalar

Eğitimin en önemli çıktısı olarak teorik bilgilerin pratiğe döküldüğü mini projeler geliştirilmiştir:

- [**Dijital Kütüphane Sistemi (CLI)**](./src/main/java/com/yasin/project/library/README.md): OOP ve Koleksiyonlar kullanılarak katmanlı mimari ile yazılmış terminal tabanlı bir kütüphane yönetim uygulamasıdır. Proje detayları ve çalıştırma rehberi için ilgili README dosyasına bakabilirsiniz.

## Nasıl Kullanılır?

Bu depodaki kodları kendi bilgisayarınızda derleyip çalıştırmak için:

1. Bu projeyi yerel ortamınıza klonlayın:
   ```bash
   git clone <sizin-repo-linkiniz>
   ```
2. Çalışmak istediğiniz konunun Java dosyasını (örneğin `_14_1_Date.java` veya `MainCLI.java`) kullandığınız IDE'de (VS Code, IntelliJ IDEA vb.) açın.
3. IDE içerisindeki **Run (Çalıştır / Play)** butonunu kullanarak sınıfları anında test edebilir ve çalıştırabilirsiniz.
4. VS Code kullanıyorsanız, "Extension Pack for Java" eklentisinin kurulu olduğundan emin olun.

## Gereksinimler
- Java Development Kit (JDK) 21 veya üzeri (Örnekler JDK 25/26 uyumlu olacak şekilde test edilmiştir).
- VS Code veya benzeri bir IDE.
- (İsteğe bağlı) Projenin kök dizininde `pom.xml` bulunmaktadır, projeyi Maven projesi olarak da içe aktarabilirsiniz.
