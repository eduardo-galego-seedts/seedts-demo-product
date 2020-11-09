package seedts.demo.product.resources;

import org.springframework.stereotype.Service;
import seedts.demo.product.models.ProductModel;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductResource {

    private static final List<ProductModel> REPO = new ArrayList<>();

    public List<ProductModel> getAll() {
        return REPO;
    }

    public ProductModel getById(final String id) {
        return REPO.stream()
                .filter(p -> id.equals(p.getId()))
                .findFirst()
                .orElse(null);
    }

    public void save(ProductModel newProduct) {
        REPO.add(newProduct);
    }
}
