package net.xdclass.product_service.service;


import net.xdclass.product_service.domain.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    List<Product> listProduct();

    Product findById(int id);





}
