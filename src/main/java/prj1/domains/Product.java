package prj1.domains;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import prj1.models.product.ProductDto;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Document("Product")
public class Product {

    @Id
    private String id;

    private String name;

    private String description;

    private String branch;

    private String category;

    private Long price;

    private Integer quantity;

    public Product(ProductDto product) {
        this.id = product.getId();
        this.name = product.getName();
        this.description = product.getDescription();
        this.branch = product.getBranch();
        this.category = product.getCategory();
        this.price = product.getPrice();
        this.quantity = product.getQuantity();
    }
}
