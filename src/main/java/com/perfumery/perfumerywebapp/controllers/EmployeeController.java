package com.perfumery.perfumerywebapp.controllers;

import com.perfumery.perfumerywebapp.payload.request.UpdateOrderStatusRequest;
import com.perfumery.perfumerywebapp.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PreAuthorize(" hasRole('EMPLOYEE')")
    @PutMapping("/employee/orders/updateStatus")
    public void updateOrderStatus(@RequestBody UpdateOrderStatusRequest request) {
        employeeService.updateOrderStatus(request.getOrderId(), request.getNewStatus());
    }

    @PreAuthorize(" hasRole('EMPLOYEE')")
    @PostMapping("/employee/markPerfume/{perfumeId}")
    public ResponseEntity<String> changePerfumeAvailability(@PathVariable Long perfumeId) {
        employeeService.changePerfumeAvailability(perfumeId);
        return ResponseEntity.ok("Perfume availability changed successfully");
    }
}
