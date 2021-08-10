package com.yummy.restful.serveces.impl;

import com.yummy.restful.dto.general.ProductDTO;
import com.yummy.restful.model.Product;
import com.yummy.restful.repository.ProductRepository;
import com.yummy.restful.serveces.ProductService;
import com.yummy.restful.util.mappers.ProductMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public List<ProductDTO> getAll() {
        List<Product> products = productRepository.findAll();
        List<ProductDTO> productsDTO = new ArrayList<>();
        for(Product product : products) {
            ProductDTO productDTO = ProductMapper.INSTANCE.toProductDTO(product);
            productsDTO.add(productDTO);
        }
        return productsDTO;
    }

    @Override
    public ProductDTO findById(Long id) {
        final Product product = productRepository.findById(id).orElse(null);
        return ProductMapper.INSTANCE.toProductDTO(product);
    }
}