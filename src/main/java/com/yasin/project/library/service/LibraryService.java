package com.yasin.project.library.service;

import com.yasin.project.library.model.*;
import com.yasin.project.library.repository.DataRepository;
import com.yasin.project.library.exception.LibraryException;
import com.yasin.project.library.util.LoggerUtil;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class LibraryService {
    private static LibraryService instance;
    private List<Book> books;
    private List<Member> members;
    private List<Loan> loans;
    
    private DataRepository<Book> bookRepo;
    private DataRepository<Member> memberRepo;
    private DataRepository<Loan> loanRepo;

    private LibraryService() {
        bookRepo = new DataRepository<>("books.dat");
        memberRepo = new DataRepository<>("members.dat");
        loanRepo = new DataRepository<>("loans.dat");
        
        books = bookRepo.loadAll();
        members = memberRepo.loadAll();
        loans = loanRepo.loadAll();
    }

    public static LibraryService getInstance() {
        if (instance == null) {
            instance = new LibraryService();
        }
        return instance;
    }

    public void addBook(Book book) {
        books.add(book);
        saveData();
        LoggerUtil.log("Kitap eklendi: " + book.getTitle());
    }

    public List<Book> getBooksSortedByTitle() {
        return books.stream()
                .sorted(Comparator.comparing(Book::getTitle))
                .collect(Collectors.toList());
    }

    public void addMember(Member member) {
        if (!member.getEmail().matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            throw new LibraryException("Geçersiz email formatı!");
        }
        members.add(member);
        saveData();
        LoggerUtil.log("Üye eklendi: " + member.getName());
    }

    public void loanBook(String bookId, String memberId) {
        Book book = books.stream().filter(b -> b.getId().equals(bookId)).findFirst()
                .orElseThrow(() -> new LibraryException("Kitap bulunamadı!"));
        Member member = members.stream().filter(m -> m.getId().equals(memberId)).findFirst()
                .orElseThrow(() -> new LibraryException("Üye bulunamadı!"));
                
        if (!book.isAvailable()) {
            throw new LibraryException("Kitap şu anda başkasında!");
        }
        
        Loan loan = new Loan(UUID.randomUUID().toString(), bookId, memberId, LocalDate.now(), null);
        loans.add(loan);
        book.setAvailable(false);
        saveData();
        LoggerUtil.log("Kitap (" + book.getTitle() + ") " + member.getName() + " isimli üyeye ödünç verildi.");
    }
    
    public void returnBook(String bookId) {
        Loan loan = loans.stream()
                .filter(l -> l.getBookId().equals(bookId) && l.getReturnDate() == null)
                .findFirst()
                .orElseThrow(() -> new LibraryException("Bu kitap için aktif bir ödünç kaydı bulunamadı!"));
                
        loan.setReturnDate(LocalDate.now());
        Book book = books.stream().filter(b -> b.getId().equals(bookId)).findFirst().get();
        book.setAvailable(true);
        saveData();
        LoggerUtil.log("Kitap iade edildi: " + book.getTitle());
    }
    
    public List<Loan> getOverdueLoans() {
        return loans.stream()
                .filter(l -> l.getReturnDate() == null && l.getLoanDate().plusDays(30).isBefore(LocalDate.now()))
                .collect(Collectors.toList());
    }

    private void saveData() {
        bookRepo.saveAll(books);
        memberRepo.saveAll(members);
        loanRepo.saveAll(loans);
    }
    
    public List<Book> getBooks() { return books; }
    public List<Member> getMembers() { return members; }
    public List<Loan> getLoans() { return loans; }
}
