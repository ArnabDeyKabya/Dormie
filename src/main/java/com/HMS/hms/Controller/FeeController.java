package com.HMS.hms.Controller;

import com.HMS.hms.Service.FeeService;
import com.HMS.hms.Tables.DiningFee;
import com.HMS.hms.Tables.HallFee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fees")
public class FeeController {

    @Autowired
    private FeeService feeService;

    @PostMapping("/dining")
    public ResponseEntity<DiningFee> addDiningFee(@RequestBody DiningFee fee) {
        return ResponseEntity.ok(feeService.saveDiningFee(fee));
    }

    @PostMapping("/hall")
    public ResponseEntity<HallFee> addHallFee(@RequestBody HallFee fee) {
        return ResponseEntity.ok(feeService.saveHallFee(fee));
    }

    @GetMapping("/dining/{studentId}")
    public ResponseEntity<List<DiningFee>> getDiningFees(@PathVariable int studentId) {
        return ResponseEntity.ok(feeService.getDiningFeesByStudent(studentId));
    }

    @GetMapping("/hall/{studentId}")
    public ResponseEntity<List<HallFee>> getHallFees(@PathVariable int studentId) {
        return ResponseEntity.ok(feeService.getHallFeesByStudent(studentId));
    }

    @PutMapping("/dining/{feeId}")
    public ResponseEntity<DiningFee> updateDiningFee(@PathVariable Long feeId, @RequestParam String status) {
        return ResponseEntity.ok(feeService.updateDiningStatus(feeId, status));
    }

    @PutMapping("/hall/{feeId}")
    public ResponseEntity<HallFee> updateHallFee(@PathVariable Long feeId, @RequestParam String status) {
        return ResponseEntity.ok(feeService.updateHallStatus(feeId, status));
    }
}

