package com.p2p.domain;

public class Borrower {

    // Status verifikasi KYC
    private boolean isVerified;

    // Nilai credit score borrower
    private int creditScore;

    // Constructor untuk inisialisasi data borrower
    public Borrower(boolean isVerified, int creditScore) {
        this.isVerified = isVerified;
        this.creditScore = creditScore;
    }

    // Getter untuk mengecek apakah borrower sudah isVerified
    public boolean isVerified() {
        return isVerified;
    }

    // Getter untuk mengambil credit score
    public int getCreditScore() {
        return creditScore;
    }

    public boolean canApplyLoan() {
        return isVerified;
    }
}
