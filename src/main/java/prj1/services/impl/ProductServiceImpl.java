package prj1.services.impl;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import prj1.domains.Product;
import prj1.models.product.ProductDto;
import prj1.repositories.ProductRepository;
import prj1.services.ProductService;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
  private final ProductRepository productRepository;
  private final MongoTemplate mongoTemplate;

  @Override
  public Page<Product> search(Pageable pageable) {
    return productRepository.findAll(pageable);
  }

  @Override
  public void createOrUpdate(ProductDto product) {
    productRepository.save(new Product(product));
  }
}
