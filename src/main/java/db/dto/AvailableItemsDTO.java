package db.dto;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "availableetems")
public class AvailableItemsDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    @Column(name = "article")
    private String article;
    @Column(name = "count")
    private int count;
}
