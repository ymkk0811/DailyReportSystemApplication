package com.techacademy.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.techacademy.entity.Employee;
import com.techacademy.repository.EmployeeRepository;
import com.techacademy.repository.ReportRepository;

/*@Service
public class UserDetailService implements UserDetailsService {
    private final EmployeeRepository employeeRepository;
    private final ReportRepository reportRepository;

    @Autowired
    public UserDetailService(EmployeeRepository repository,ReportRepository reportRepository) {
        this.employeeRepository = repository;
        this.reportRepository reportRepository
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Employee> employee = employeeRepository.findById(username);

        if (employee.isEmpty()) {
            throw new UsernameNotFoundException("Exception:Username Not Found");
        }
        return new UserDetail(employee.get());
    }
}

/*package com.techacademy.service;

import java.util.Optional;*/

@Service
public class UserDetailService implements UserDetailsService {
    private final EmployeeRepository employeeRepository;


    @Autowired
    public UserDetailService(EmployeeRepository repository) {
        this.employeeRepository = repository;

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Employee> employee = employeeRepository.findById(username);

        if (employee.isEmpty()) {
            throw new UsernameNotFoundException("Exception:Username Not Found");
        }
        return new UserDetail(employee.get());
    }
}