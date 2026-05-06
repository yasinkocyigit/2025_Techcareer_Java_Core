package com.yasin.tutorials.othercourse.services;


import com.yasin.tutorials.othercourse.dao.impl.ProductDao;
import com.yasin.tutorials.othercourse.dto.CustomerDto;
import com.yasin.tutorials.othercourse.dto.ProductDto;

import java.util.List;

// Asıl iş Yükünü yapan yer
public class ProductService {

    // Field
    private final ProductDao productDao = new ProductDao();

    // SAVE
    public void productServiceSave(ProductDto productDto, CustomerDto customerDto) {
        customerDto.addProduct(productDto);  // Composition Bağlantısı
        productDao.save(productDto);         // Disk'e yaz
    }

    // FIND ALL
    public List<ProductDto> productServiceFindAll() {
        return productDao.findAll();
    }

}
