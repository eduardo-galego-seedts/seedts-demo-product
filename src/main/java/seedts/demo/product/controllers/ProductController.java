package seedts.demo.product.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import seedts.demo.product.models.ProductModel;
import seedts.demo.product.resources.ProductResource;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductResource productResource;

    @GetMapping
    public List<ProductModel> getAll() {
        return productResource.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductModel> getById(@PathVariable final String id) {
        ProductModel productModel = productResource.getById(id);
        if (productModel == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(productModel);
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody ProductModel newProduct) throws Exception {
        productResource.save(newProduct);
        return ResponseEntity.created(new URI("/products/" + newProduct.getId())).build();
    }
}
