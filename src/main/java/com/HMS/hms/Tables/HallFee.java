package com.HMS.hms.Tables;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "hall_fees", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"student_id", "fee_year"})
})
public class HallFee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long feeId;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Students student;

    @Column(nullable = false)
    private BigDecimal hallFee;

    @Column(nullable = false)
    private String status; // 'paid' or 'unpaid'

    @Column(nullable = false)
    private int feeYear;

    // Getters & Setters

    public int getFeeYear() {
        return feeYear;
    }

    public void setFeeYear(int feeYear) {
        this.feeYear = feeYear;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getHallFee() {
        return hallFee;
    }

    public void setHallFee(BigDecimal hallFee) {
        this.hallFee = hallFee;
    }

    public Students getStudent() {
        return student;
    }

    public void setStudent(Students student) {
        this.student = student;
    }

    public Long getFeeId() {
        return feeId;
    }

    public void setFeeId(Long feeId) {
        this.feeId = feeId;
    }
}

