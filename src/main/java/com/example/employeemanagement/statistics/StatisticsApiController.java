package com.example.employeemanagement.statistics;

import com.example.employeemanagement.employee.DepartmentStatistics;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/statistics")
public class StatisticsApiController {
    private final StatisticsService statisticsService;

    public StatisticsApiController(StatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }

    @GetMapping("/employee-count")
    public EmployeeCountResponse getEmployeeCount() {
        return new EmployeeCountResponse(statisticsService.getTotalEmployees());
    }

    @GetMapping("/employees-by-department")
    public List<DepartmentCountResponse> getDepartmentStatistics() {
        return statisticsService.getDepartmentStatistics().stream()
                .map(item -> new DepartmentCountResponse(item.getDepartment(), item.getEmployeeCount()))
                .toList();
    }

    public record EmployeeCountResponse(long totalEmployees) {}
    public record DepartmentCountResponse(String department, long employeeCount) {}
}
