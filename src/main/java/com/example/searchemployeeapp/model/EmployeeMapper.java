package com.example.searchemployeeapp.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class EmployeeMapper implements RowMapper<Employee> {

    @Override
    public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Employee(rs.getString("id"), rs.getString("name"), rs.getString("joined_date"),
                rs.getString("call_number"), rs.getBigDecimal("limit_reimburs"), rs.getString("created_date"),
                rs.getString("updated_date"));
    }

}
