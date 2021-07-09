package com.yummy.restful.serveces.impl;

import com.yummy.restful.dto.general.ProductDTO;
import com.yummy.restful.model.Product;
import com.yummy.restful.repository.ProductRepository;
import com.yummy.restful.serveces.ProductService;

import com.yummy.restful.util.mappers.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public boolean createProduct(ProductDTO productDTO) {
        productRepository.save(ProductMapper.INSTANCE.toProduct(productDTO));
        return true;
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).orElse(null);
    }
}