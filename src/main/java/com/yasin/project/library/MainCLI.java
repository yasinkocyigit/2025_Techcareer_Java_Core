package com.yasin.project.library;

import com.yasin.project.library.model.*;
import com.yasin.project.library.service.LibraryService;
import com.yasin.project.library.exception.LibraryException;

import java.util.Scanner;
import java.util.UUID;

public class MainCLI {
    private static LibraryService service = LibraryService.getInstance();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- DİJİTAL KÜTÜPHANE SİSTEMİ ---");
            System.out.println("1. Kitap Ekle");
            System.out.println("2. Kitapları Listele");
            System.out.println("3. Üye Ekle");
            System.out.println("4. Üyeleri Listele");
            System.out.println("5. Kitap Ödünç Ver");
            System.out.println("6. Kitap İade Al");
            System.out.println("7. Gecikmiş İadeleri Listele");
            System.out.println("0. Çıkış");
            System.out.print("Seçiminiz: ");
            
            int choice = -1;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Lütfen geçerli bir sayı giriniz!");
                continue;
            }

            try {
                switch (choice) {
                    case 1 -> addBook();
                    case 2 -> listBooks();
                    case 3 -> addMember();
                    case 4 -> listMembers();
                    case 5 -> loanBook();
                    case 6 -> returnBook();
                    case 7 -> listOverdueLoans();
                    case 0 -> {
                        System.out.println("Çıkış yapılıyor...");
                        System.exit(0);
                    }
                    default -> System.out.println("Geçersiz seçim!");
                }
            } catch (LibraryException e) {
                System.out.println("HATA: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("BEKLENMEYEN HATA: " + e.getMessage());
            }
        }
    }

    private static void addBook() {
        System.out.print("Kitap Başlığı: ");
        String title = scanner.nextLine();
        System.out.print("Yazar: ");
        String author = scanner.nextLine();
        System.out.println("Kategoriler: 1-FICTION, 2-SCIENCE, 3-HISTORY, 4-ART, 5-TECHNOLOGY");
        System.out.print("Seçim: ");
        int catChoice = Integer.parseInt(scanner.nextLine());
        BookCategory category = BookCategory.values()[catChoice - 1];
        
        Book book = new Book(UUID.randomUUID().toString(), title, author, category, true);
        service.addBook(book);
        System.out.println("Kitap başarıyla eklendi! ID: " + book.getId());
    }

    private static void listBooks() {
        System.out.println("\n--- Kitaplar ---");
        for (Book b : service.getBooksSortedByTitle()) {
            System.out.println(b.getId() + " | " + b.getTitle() + " | " + b.getAuthor() + " | Uygun: " + b.isAvailable());
        }
    }

    private static void addMember() {
        System.out.print("Üye Adı: ");
        String name = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        
        Member member = new Member(UUID.randomUUID().toString(), name, email);
        service.addMember(member);
        System.out.println("Üye eklendi! ID: " + member.getId());
    }

    private static void listMembers() {
        System.out.println("\n--- Üyeler ---");
        for (Member m : service.getMembers()) {
            System.out.println(m.getId() + " | " + m.getName() + " | " + m.getEmail());
        }
    }

    private static void loanBook() {
        System.out.print("Kitap ID: ");
        String bookId = scanner.nextLine();
        System.out.print("Üye ID: ");
        String memberId = scanner.nextLine();
        service.loanBook(bookId, memberId);
        System.out.println("Kitap ödünç verildi!");
    }

    private static void returnBook() {
        System.out.print("İade Edilecek Kitap ID: ");
        String bookId = scanner.nextLine();
        service.returnBook(bookId);
        System.out.println("İade işlemi başarılı!");
    }

    private static void listOverdueLoans() {
        System.out.println("\n--- Gecikmiş İadeler ---");
        var overdues = service.getOverdueLoans();
        if (overdues.isEmpty()) {
            System.out.println("Gecikmiş kitap bulunmuyor.");
        } else {
            for (Loan l : overdues) {
                System.out.println("Kitap ID: " + l.getBookId() + " | Üye ID: " + l.getMemberId() + " | Ödünç Tarihi: " + l.getLoanDate());
            }
        }
    }
}
