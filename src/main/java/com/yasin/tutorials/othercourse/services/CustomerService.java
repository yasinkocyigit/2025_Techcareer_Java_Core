package com.yasin.tutorials.othercourse.services;


import com.yasin.tutorials.othercourse.dao.impl.CustomerDao;
import com.yasin.tutorials.othercourse.dto.CustomerDto;

import java.util.List;

// Asıl iş Yükünü yapan yer
public class CustomerService {

    // Field
    private final CustomerDao customerDao = new CustomerDao();

    // SAVE
    public void customerServiceSave(CustomerDto customerDto) {
        customerDao.save(customerDto);
    }

    // FIND ALL
    public List<CustomerDto> customerServiceFindAll() {
        return customerDao.findAll();
    }

}
