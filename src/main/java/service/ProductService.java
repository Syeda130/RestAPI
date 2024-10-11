package service;

import model.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import repository.ProductRepository;
import java.util.List;
import java.util.Optional;

@Component
@Service
public class ProductService {

   @Autowired
    private ProductRepository productRepository;

        public void saveProducts(Products products){
             productRepository.save(products);
        }

        public List<Products> getAll(){
            return productRepository.findAll();
        }
        public Optional<Products> findById(String id){
            return  productRepository.findById(id);
        }

        public void deleteById(String id){
            productRepository.deleteById(id);
        }
    }


