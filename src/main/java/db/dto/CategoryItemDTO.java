package db.dto;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "categoryitem")
public class CategoryItemDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "category")
    private CategoryItemDTO categoryItem;
    @Column(name = "parentcategory")
    private CategoryItemDTO parentCategoryItem;
}

