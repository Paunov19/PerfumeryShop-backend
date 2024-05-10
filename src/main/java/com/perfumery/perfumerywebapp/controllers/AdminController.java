package com.perfumery.perfumerywebapp.controllers;

import com.perfumery.perfumerywebapp.dtos.UserDTO;
import com.perfumery.perfumerywebapp.models.User;
import com.perfumery.perfumerywebapp.payload.request.ChangeUserRoleRequest;
import com.perfumery.perfumerywebapp.services.AdminService;
import com.perfumery.perfumerywebapp.utils.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1")
public class AdminController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AdminService adminService;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/admin/addEmployee")
    public ResponseEntity<?> addEmployee(@RequestBody User user) {
        User newEmployee = adminService.addEmployee(user);

        return new ResponseEntity<>(UserMapper.userToDTO(newEmployee), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin/getAllEmployees")
    public ResponseEntity<List<UserDTO>> getAllEmployees() {
        List<User> employees = adminService.getAllEmployees();
        List<UserDTO> employeeDTOs = employees.stream()
                .map(UserMapper::userToDTO)
                .collect(Collectors.toList());

        return new ResponseEntity<>(employeeDTOs, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/admin/deleteEmployee/{employeeId}")
    public ResponseEntity<?> deleteEmployee(@PathVariable Long employeeId) {
        adminService.deleteEmployee(employeeId);
        return new ResponseEntity<>("Employee deleted successfully", HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/admin/changeUserRole")
    public ResponseEntity<?> changeUserRole(@RequestBody ChangeUserRoleRequest request) {
        User updatedUser = adminService.changeEmployeeRole(request.getUserId(), request.getNewRole());
        return new ResponseEntity<>(UserMapper.userToDTO(updatedUser), HttpStatus.OK);
    }
}
