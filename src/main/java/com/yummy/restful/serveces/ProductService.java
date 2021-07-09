package com.yummy.restful.serveces;

import com.yummy.restful.dto.general.ProductDTO;
import com.yummy.restful.model.Product;

import java.util.List;

public interface ProductService {
    boolean createProduct(ProductDTO productDTO);
    List<Product> getAll();
    Product findById(Long id);
}