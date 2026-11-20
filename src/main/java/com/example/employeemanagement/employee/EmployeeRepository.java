package com.example.employeemanagement.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Query("select e.department as department, count(e) as employeeCount " +
           "from Employee e group by e.department order by e.department")
    List<DepartmentStatistics> countEmployeesByDepartment();

    @Query("select count(e) from Employee e")
    long countAllEmployees();

    @Query("select e from Employee e where lower(e.department) = lower(:department) order by e.name")
    List<Employee> findByDepartmentIgnoreCase(@Param("department") String department);
}
