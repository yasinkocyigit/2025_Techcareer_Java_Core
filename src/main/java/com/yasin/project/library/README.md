# Dijital Kütüphane Yönetim Sistemi (CLI)

Bu proje, Java Core bilgileri (OOP, Collections, Exceptions, vb.) kullanılarak geliştirilmiş, terminal tabanlı bir Dijital Kütüphane Yönetim Sistemidir.

## Özellikler
- **Kitap Yönetimi:** Kütüphaneye yeni kitap ekleme ve tüm kitapları listeleme.
- **Üye Yönetimi:** Yeni üye kaydı oluşturma ve üyeleri listeleme.
- **Ödünç Alma & İade İşlemleri:** Üyelere kitap ödünç verme ve alınan kitapların iadesini sağlama.
- **Gecikme Takibi:** Gecikmiş iadeleri listeleyerek kütüphane düzenini sağlama.

## Kullanılan Teknolojiler
- **Dil:** Java (JDK 21 ve üzeri uyumlu)
- **Mimari:** Katmanlı Mimari (Model, Service, Exception vb.)
- **Veri Yapıları:** Collections (List, Map vb.)
- **Arayüz:** Command Line Interface (CLI - Terminal)

## Nasıl Çalıştırılır?

Projeyi çalıştırmak için terminal (veya komut satırı) üzerinden projenin ana dizininde (Örn: `~/Desktop/2025_Techcareer_Java_Core`) aşağıdaki komutları sırasıyla uygulayabilirsiniz:

### 1. Derleme (Compile)
Terminalden derlemek için aşağıdaki komutu kullanın:
```bash
javac --release 25 -d target/classes -sourcepath src/main/java src/main/java/com/yasin/project/library/MainCLI.java
```
*(Not: `javac` sürümünüze göre `--release 25` kısmını sisteminizdeki sürüme ayarlamanız gerekebilir. VS Code üzerinden "Run" tuşuna basarak doğrudan çalıştırmak her zaman en pratik yöntemdir.)*

### 2. Çalıştırma (Run)
Derleme işlemi başarılı olduktan sonra programı başlatmak için:
```bash
java -cp target/classes com.yasin.project.library.MainCLI
```

## Proje Yapısı

```text
 library
├── exception
│   └── LibraryException.java
├── model
│   ├── Book.java
│   └── Member.java
├── service
│   └── LibraryService.java
├── MainCLI.java
└── README.md
```
- `model/`: Kitap, Üye gibi temel iş nesnelerini (POJO) içerir.
- `service/`: İş kurallarının uygulandığı, verilerin (kitap, üye vb.) yönetildiği kısımdır.
- `exception/`: Projeye özgü hata yakalama ve istisna yönetimi (`LibraryException`).
- `MainCLI.java`: Kullanıcının terminal üzerinden etkileşime geçtiği ve menülerin bulunduğu giriş (entry) sınıfıdır.
