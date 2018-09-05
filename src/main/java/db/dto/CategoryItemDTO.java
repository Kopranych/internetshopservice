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
    @ManyToOne
    @JoinColumn(name = "parent_category")
    private CategoryItemDTO parentCategoryItem;
}

