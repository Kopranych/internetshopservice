package db.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
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

    public AvailableItemsDTO(String article, int count){
        this.article = article;
        this.count = count;
    }
}
