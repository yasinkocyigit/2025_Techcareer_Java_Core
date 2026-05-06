package com.yasin.tutorials.othercourse;

import com.yasin.tutorials.othercourse.controller.impl.CustomerControllerImpl;
import com.yasin.tutorials.othercourse.controller.impl.ProductControllerImpl;
import com.yasin.tutorials.othercourse.dto.CustomerDto;
import com.yasin.tutorials.othercourse.dto.ProductDto;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    // Injection
    private static CustomerControllerImpl customerControllerImpl = new CustomerControllerImpl();

    @SuppressWarnings({ "unused" })
    // Customer Add
    private static void customerAdd() {
        // Müşteri Oluştur
        CustomerDto customerDto1 = new CustomerDto("Yasin Koçyiğit", "yasnkcygt@gmail.com");
        CustomerDto customerDto2 = new CustomerDto("Yasin Koçyiğit2", "yasinkocyigit2@gmail.com");

        customerControllerImpl.customerControllerSave(customerDto1);
        customerControllerImpl.customerControllerSave(customerDto2);

        // Tüm Müşterileri Listele
        customerControllerImpl.customerControllerFindAll();
    }

    // Product- Customer (Composition)
    private static void customerOnProductAdd() {
        // Müşteri Oluştur
        CustomerDto customerDto1 = new CustomerDto("Yasin Koçyiğit", "yasnkcygt@gmail.com");
        customerControllerImpl.customerControllerSave(customerDto1);

        // Tüm Müşterileri Listele
        customerControllerImpl.customerControllerFindAll();
        System.out.println("\n=============================================");

        // Ürünleri oluştur
        ProductDto laptopProduct = new ProductDto("Laptop", 12.0);
        ProductDto klavyeProduct = new ProductDto("Klavye", 8.0);

        // Controller ÜZerinden ilişkilendir
        ProductControllerImpl productControllerImpl = new ProductControllerImpl();
        productControllerImpl.productControllerSave(laptopProduct, customerDto1);
        productControllerImpl.productControllerSave(klavyeProduct, customerDto1);

        // Müşteri bilgisyle birlikte ürünleri yazdır
        System.out.println(customerDto1);

        // Tüm Ürünleri Listele
        productControllerImpl.productControllerFindAll();

    }

    public static void main(String[] args) {
        // customerAdd();
        customerOnProductAdd();
    }
}