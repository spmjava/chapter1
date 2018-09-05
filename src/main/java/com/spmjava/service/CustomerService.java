package com.spmjava.service;

import com.spmjava.dao.DatabaseHelper;
import com.spmjava.dao.model.Customer;

import java.util.List;
import java.util.Map;

/**
 * @author 齐伟超
 * @date 2018-09-05 11:18
 * @since 1.0.0
 **/
public class CustomerService {
    public List<Customer> listCustomer(String keyword) {
        return DatabaseHelper.queryEntityList(Customer.class, "select * from customer");
    }

    public Customer getById(Long id) {
        return null;
    }

    public boolean createCustomer(Map<String, Object> fieldMap) {
        return false;
    }

    public boolean updateCustomer(Long id, Map<String, Object> fieldMap) {
        return false;
    }

    public boolean deleteCustomer(Long id) {
        return false;
    }
}
