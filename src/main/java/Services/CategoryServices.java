package Services;

import Entities.Category;
import Repositories.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServices {

    @Autowired
    private CategoryRepo categoryRepo;
    @Autowired
    public void setCategoryRepo(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    public List<Category> findAll() {
        return categoryRepo.findAll();
    }
    public Optional<Category> findById(Long id) {
        return categoryRepo.findById(id);
    }
    public Category save(Category category) {
        return categoryRepo.save(category);
    }
    public void delete(Long id) {
        categoryRepo.deleteById(id);
    }
    public List<Category> findByParentId(Long parent) {
        return categoryRepo.findByParentId(parent);
    }
}
