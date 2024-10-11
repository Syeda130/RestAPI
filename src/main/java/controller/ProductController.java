package controller;

import model.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.ProductService;
import java.util.List;


@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Products> getAll(){
        return productService.getAll();
    }

    @PostMapping
    public Products createEntry(@RequestBody Products myEntry){
        productService.saveProducts(myEntry);
        return myEntry;
    }


@GetMapping("id/{myId}")
    public Products getProductsById(@PathVariable String myId){
     return productService.findById(myId).orElse(null);
}

@DeleteMapping("id/{myId}")
    public boolean deleteProductsById(@PathVariable String myId){
    productService.deleteById(myId);
    return true;
}

@PutMapping("/id/{id}")
    public Products updateProductsById(@PathVariable String id,@RequestBody Products newEntry) {
     Products old = productService.findById(id).orElse(null);
     if(old != null){
old.setProductName(newEntry.getProductName() != null && !newEntry.getProductName().equals("") ? newEntry.getProductName() : old.ProductName);
         old.setProductPrice(newEntry.getProductPrice() != null && !newEntry.getProductPrice().equals("") ? newEntry.getProductPrice() : old.ProductPrice);
     }
    productService.saveProducts(old);
    return old;
}

}
