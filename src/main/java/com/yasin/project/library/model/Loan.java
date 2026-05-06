package com.yasin.project.library.model;
import java.io.Serializable;
import java.time.LocalDate;
public class Loan implements Serializable {
    private String loanId;
    private String bookId;
    private String memberId;
    private LocalDate loanDate;
    private LocalDate returnDate;

    public Loan(String loanId, String bookId, String memberId, LocalDate loanDate, LocalDate returnDate) {
        this.loanId = loanId; this.bookId = bookId; this.memberId = memberId; this.loanDate = loanDate; this.returnDate = returnDate;
    }
    public String getLoanId() { return loanId; }
    public String getBookId() { return bookId; }
    public String getMemberId() { return memberId; }
    public LocalDate getLoanDate() { return loanDate; }
    public LocalDate getReturnDate() { return returnDate; }
    public void setReturnDate(LocalDate returnDate) { this.returnDate = returnDate; }
}
