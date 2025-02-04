package Services;

import Entities.Product;
import Repositories.CartRepo;
import Repositories.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

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

    public void addProduct(Product product) {
        productRepo.save(product);
    }

    public Product updateProduct(Long id, Product product) {
        if (product != null) {
            if (product.getProductName() != null) {productRepo.updateProductName(product.getProductName(), LocalDateTime.now(), id);}
            if (product.getDescription() != null) {productRepo.updateProductDescription(product.getDescription(), LocalDateTime.now(), id);}
            if (product.getPrice() != 0){productRepo.updateProductPrice(product.getPrice(), LocalDateTime.now(), id);}
            return productRepo.findById(id).orElse(null);
        }return productRepo.findById(id).orElse(null);

    }
    public void deleteProduct(Long productId) {
        productRepo.deleteById(productId);
    }
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }
}
