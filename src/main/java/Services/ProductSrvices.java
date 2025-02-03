package Services;

import Entities.Product;
import Repositories.CartRepo;
import Repositories.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductSrvices {

    @Autowired
    ProductRepo productRepo;
    @Autowired
    CartRepo cartRepo;
    @Autowired
    public ProductSrvices(ProductRepo productRepo, CartRepo cartRepo) {
        this.productRepo = productRepo;
        this.cartRepo = cartRepo;
    }

    public Product addProduct(Product product) {
        return productRepo.save(product);
    }

    public Product updateProduct(Product product) {

    }
}
