package com.matsta25.controller;

import com.matsta25.dao.CustomerDAO;
import com.matsta25.entity.Customer;
import com.matsta25.service.CustomerService;
import com.matsta25.service.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/list")
    public String listCustomers(Model model) {

        List<Customer> theCustomers = customerService.getCustomers();

        model.addAttribute("customers", theCustomers);

        return "list-customers";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {
        Customer customer = new Customer();

        model.addAttribute("customer", customer);

        return "customer-form";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer customer) {

        customerService.saveCustomer(customer);

        return "redirect:/customer/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@ModelAttribute("customerId") int customerId, Model model) {

        Customer customer = customerService.getCustomer(customerId);

        model.addAttribute("customer", customer);

        return "customer-form";
    }

    @GetMapping("/showFormForDelete")
    public String showFormForDelete(@ModelAttribute("customerId") int customerId, Model model) {
        customerService.deleteCustomer(customerId);

        return "redirect:/customer/list";
    }


}
