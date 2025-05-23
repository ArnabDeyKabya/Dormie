package com.HMS.hms.Tables;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "dining_fees")
public class DiningFee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long feeId;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Students student;

    @Column(nullable = false)
    private BigDecimal diningFee;

    @Column(nullable = false)
    private String status; // 'paid' or 'unpaid'

    public int getDiningYear() {
        return diningYear;
    }

    public void setDiningYear(int diningYear) {
        this.diningYear = diningYear;
    }

    public int getDiningMonth() {
        return diningMonth;
    }

    public void setDiningMonth(int diningMonth) {
        this.diningMonth = diningMonth;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getDiningFee() {
        return diningFee;
    }

    public void setDiningFee(BigDecimal diningFee) {
        this.diningFee = diningFee;
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

    @Column(nullable = false)
    private int diningMonth;

    @Column(nullable = false)
    private int diningYear;

    // Getters & Setters
}

