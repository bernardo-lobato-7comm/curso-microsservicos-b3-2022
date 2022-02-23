package com.example.hexagonalarchitecture.adapters.web;

import com.example.hexagonalarchitecture.application.domain.Product;
import com.example.hexagonalarchitecture.application.port.incoming.UpdateProduct;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final UpdateProduct updateProduct;

    public ProductController(UpdateProduct updateProduct) {
        this.updateProduct = updateProduct;
    }


    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Product obj){
         updateProduct.update(id, obj.getPrice());
         return ResponseEntity.ok().build();
    }
}
