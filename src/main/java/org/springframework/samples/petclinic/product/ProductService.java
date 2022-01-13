package org.springframework.samples.petclinic.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;


    public List<Product> getAllProducts(){
        List<Product> p = productRepository.findAll();
        return p;
    }

    public List<Product> getProductsCheaperThan(double price) {
        List<Product> p = this.productRepository.findByPriceLessThan(price);
        return p;
    }

    public ProductType getProductType(String typeName) {
        ProductType tipoProducto = productRepository.findProductType(typeName);
        return tipoProducto;
    }

    public List<ProductType> findAllProductTypes(){
        List<ProductType> pt = productRepository.findAllProductTypes();
        return pt;
    }

    public Product save(Product p){
        return productRepository.save(p);     
    }

    
}
