package com.yummy.restful.serveces;

import com.yummy.restful.dto.general.ProductDTO;

import java.util.List;

public interface ProductService {
    boolean createProduct(ProductDTO productDTO);
    List<ProductDTO> getAll();
    ProductDTO findById(Long id);
}