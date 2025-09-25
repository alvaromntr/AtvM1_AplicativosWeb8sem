package com.example.crud.service;

import com.example.crud.domain.product.Product;
import com.example.crud.domain.product.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.Normalizer;

@Service
public class DistributionCenterService {

    @Autowired
    private ProductRepository repository;

    @Autowired
    private AddressSearch addressSearch;

    public boolean isCepCompatibleWithProduct(String cep, String productId){
        Product product = repository.findById(productId).orElseThrow(() -> new EntityNotFoundException("Produto não encontrado"));
        String city = addressSearch.searchCityByCep(cep);
        if (city == null || product.getDistributionCenter() == null) return false;
        return normalize(city).equals(normalize(product.getDistributionCenter()));
    }

    private String normalize(String s){
        if (s == null) return "";
        String n = Normalizer.normalize(s, Normalizer.Form.NFD);
        return n.replaceAll("\\p{M}", "").trim().toLowerCase();
    }
}
