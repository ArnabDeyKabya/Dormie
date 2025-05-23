package com.HMS.hms.Repo;

import com.HMS.hms.Tables.HallFee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HallFeeRepo extends JpaRepository<HallFee, Long> {
    List<HallFee> findByStudent_StudentId(int studentId);
}

