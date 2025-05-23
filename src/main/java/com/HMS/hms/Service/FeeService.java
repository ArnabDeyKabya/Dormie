package com.HMS.hms.Service;

import com.HMS.hms.Repo.DiningFeeRepo;
import com.HMS.hms.Repo.HallFeeRepo;
import com.HMS.hms.Tables.DiningFee;
import com.HMS.hms.Tables.HallFee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeeService {

    @Autowired private DiningFeeRepo diningRepo;
    @Autowired private HallFeeRepo hallRepo;

    public DiningFee saveDiningFee(DiningFee fee) {
        return diningRepo.save(fee);
    }

    public HallFee saveHallFee(HallFee fee) {
        return hallRepo.save(fee);
    }

    public List<DiningFee> getDiningFeesByStudent(int studentId) {
        return diningRepo.findByStudent_StudentId(studentId);
    }

    public List<HallFee> getHallFeesByStudent(int studentId) {
        return hallRepo.findByStudent_StudentId(studentId);
    }

    public DiningFee updateDiningStatus(Long id, String status) {
        DiningFee fee = diningRepo.findById(id).orElseThrow();
        fee.setStatus(status);
        return diningRepo.save(fee);
    }

    public HallFee updateHallStatus(Long id, String status) {
        HallFee fee = hallRepo.findById(id).orElseThrow();
        fee.setStatus(status);
        return hallRepo.save(fee);
    }
}
