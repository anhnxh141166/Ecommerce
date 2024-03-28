package prj1.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import prj1.domains.Product;
import prj1.models.product.ProductDto;

public interface ProductService {

  Page<Product> search(Pageable pageable);

  void createOrUpdate(ProductDto product);
}
