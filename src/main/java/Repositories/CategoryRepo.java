package Repositories;

import Entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CategoryRepo extends JpaRepository<Category, Long> {
    @Query(
            value = "SELECT * from Categories where parent_id =:parent_id",
            nativeQuery = true
    )
    @Transactional
    public List<Category> findByParentId(@Param("parent_id") Long parent);
}
