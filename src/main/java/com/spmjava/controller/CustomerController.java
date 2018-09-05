package com.spmjava.controller;

import com.spmjava.dao.model.Customer;
import com.spmjava.service.CustomerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.soap.Addressing;
import java.io.IOException;
import java.util.List;

/**
 * @author 齐伟超
 * @date 2018-09-04 15:17
 * @since 1.0.0
 **/
@WebServlet("/customer")
public class CustomerController extends HttpServlet {

    @Addressing
    private CustomerService customerService;

    @Override
    public void init() throws ServletException {
        customerService = new CustomerService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Customer> customers = customerService.listCustomer("");
        System.out.println(customers);
    }
}
