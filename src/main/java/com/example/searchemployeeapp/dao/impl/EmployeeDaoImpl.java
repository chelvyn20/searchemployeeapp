package com.example.searchemployeeapp.dao.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import com.example.searchemployeeapp.dao.EmployeeDao;
import com.example.searchemployeeapp.model.Employee;
import com.example.searchemployeeapp.model.EmployeeMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDaoImpl extends JdbcDaoSupport implements EmployeeDao {
    @Autowired
    DataSource dataSource;

    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
    }

    @Override
    public Employee insertEmployee(Employee employee) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
        String today = formatter.format(new Date());

        employee.setCreatedDate(today);
        employee.setUpdatedDate(today);

        String sql = "INSERT INTO employeetb(name, joined_date, call_number, limit_reimburs, created_date, updated_date)"
                + "VALUES (?, ?, ?, ?, ?, ?)";
        getJdbcTemplate().update(sql, new Object[] {
                employee.getName(), employee.getJoinedDate(), employee.getCallNumber(), employee.getLimitReimburs(),
                employee.getCreatedDate(), employee.getUpdatedDate()
        });
        System.out.println("Inserted to employeetb");
        return employee;
    }

    @Override
    public List<Employee> selectAllEmployees() {
        String sql = "SELECT * FROM employeetb";

        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
        List<Employee> result = new ArrayList<Employee>();

        for (Map<String, Object> row : rows) {
            Employee emp = new Employee();
            emp.setId((String) row.get("id"));
            emp.setName((String) row.get("name"));
            emp.setJoinedDate((String) row.get("joined_date"));
            emp.setCallNumber((String) row.get("call_number"));
            emp.setLimitReimburs((BigDecimal) row.get("limit_reimburs"));
            emp.setCreatedDate((String) row.get("created_date"));
            emp.setUpdatedDate((String) row.get("updated_date"));
            result.add(emp);
        }
        return result;
    }

    @Override
    public Employee selectEmployeeById(String id) {
        String sql = "SELECT * FROM employeetb WHERE id = ?";
        return getJdbcTemplate().queryForObject(sql, new EmployeeMapper(), id);
    }

    @Override
    public List<Employee> selectEmployeesByInfo(String name, String joinedDate, String callNumber) {
        // SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
        // String joinedDateStr = formatter.format(joinedDate);

        String sql = "SELECT * FROM employeetb WHERE name LIKE ? AND joined_date LIKE ? AND call_number LIKE ?";

        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql,
                new Object[] { '%' + name + '%', '&' + joinedDate + '%', '&' + callNumber + '%' });
        List<Employee> result = new ArrayList<Employee>();

        for (Map<String, Object> row : rows) {
            Employee emp = new Employee();
            emp.setId((String) row.get("id"));
            emp.setName((String) row.get("name"));
            emp.setJoinedDate((String) row.get("joined_date"));
            emp.setCallNumber((String) row.get("call_number"));
            emp.setLimitReimburs((BigDecimal) row.get("limit_reimburs"));
            emp.setCreatedDate((String) row.get("created_date"));
            emp.setUpdatedDate((String) row.get("updated_date"));
            result.add(emp);
        }
        return result;
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
        String today = formatter.format(new Date());
        employee.setUpdatedDate(today);

        String sql = "UPDATE employeetb SET name = ?, call_number = ?, limit_reimburs = ?, updated_date = ? WHERE id = ?";
        getJdbcTemplate().update(sql, new Object[] {
                employee.getName(), employee.getCallNumber(), employee.getLimitReimburs(), employee.getUpdatedDate(),
                employee.getId()
        });
        System.out.println("Updated successfully");
        return employee;
    }

    @Override
    public void deleteEmployeeById(String id) {
        String sql = "DELETE FROM employeetb WHERE id = ?";
        getJdbcTemplate().update(sql, id);
        System.out.println("Deleted successfully");
    }

}
