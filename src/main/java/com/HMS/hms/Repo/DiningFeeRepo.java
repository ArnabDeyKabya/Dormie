package com.HMS.hms.Repo;

import com.HMS.hms.Tables.DiningFee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DiningFeeRepo extends JpaRepository<DiningFee, Long> {
    List<DiningFee> findByStudent_StudentId(int studentId);
}
