package com.p2p.service;

import com.p2p.domain.*;
import java.math.BigDecimal;

public class LoanService {
    public Loan createLoan(Borrower borrower, BigDecimal amount) {

        validateBorrower(borrower);
        validateAmount(amount);

        Loan loan = new Loan();
        if (validateCreditScore(borrower)) {
            loan.approve();
        } else {
            loan.reject();
        }

        return loan;
    }

    private void validateBorrower(Borrower borrower) {
        if (!borrower.isVerified()) {
            throw new IllegalArgumentException("Borrower not verified");
        }
    }

    private void validateAmount(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Invalid loan amount");
        }
    }

    private boolean validateCreditScore(Borrower borrower) {
        if (borrower.getCreditScore() < 600) {
            throw new IllegalArgumentException("Credit score is lower than threshold");
        }
        return true;
    }
}
