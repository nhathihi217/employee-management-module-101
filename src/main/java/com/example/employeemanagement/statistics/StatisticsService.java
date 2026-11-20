package com.example.employeemanagement.statistics;

import com.example.employeemanagement.employee.DepartmentStatistics;
import com.example.employeemanagement.employee.EmployeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class StatisticsService {
    private final EmployeeRepository employeeRepository;

    public StatisticsService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public long getTotalEmployees() {
        return employeeRepository.countAllEmployees();
    }

    public List<DepartmentStatistics> getDepartmentStatistics() {
        return employeeRepository.countEmployeesByDepartment();
    }
}
