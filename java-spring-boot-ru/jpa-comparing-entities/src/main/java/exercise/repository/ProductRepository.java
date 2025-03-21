package exercise.repository;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import exercise.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    boolean existsProductByTitleAndPrice(String title, Integer price);
}
