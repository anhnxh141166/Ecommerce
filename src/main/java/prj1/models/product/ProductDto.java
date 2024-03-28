package prj1.models.product;

import lombok.Data;

@Data
public class ProductDto {

  private String id;

  private String name;

  private String description;


  private String branch;


  private String category;


  private Long price;

  private Integer quantity;

}
