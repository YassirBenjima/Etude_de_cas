package ma.variante.varianteB.repository;

import ma.variante.varianteB.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
