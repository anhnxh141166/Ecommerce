package prj1.repositories;

//import org.springframework.data.jpa.repository.JpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import prj1.domains.Product;

@Repository

public interface ProductRepository extends MongoRepository<Product, Long> {

}
