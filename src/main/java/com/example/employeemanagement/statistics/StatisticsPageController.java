package com.example.employeemanagement.statistics;

import com.example.employeemanagement.employee.DepartmentStatistics;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class StatisticsPageController {
    private final StatisticsService statisticsService;

    public StatisticsPageController(StatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }

    @GetMapping("/statistics")
    public String showStatistics(Model model) {
        List<DepartmentStatistics> departmentStatistics = statisticsService.getDepartmentStatistics();
        model.addAttribute("totalEmployees", statisticsService.getTotalEmployees());
        model.addAttribute("departmentStatistics", departmentStatistics);
        return "employees/statistics";
    }
}
