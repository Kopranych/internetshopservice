package db.dto;

import com.sun.istack.internal.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "items")
public class ItemDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "urlphoto")
    private String urlPhoto;
    @NotNull
    @Column(name = "article", unique = true)
    private String article;
    @Column
    private float price;

    public ItemDTO(String name, String description, String urlPhoto, String article, float price){
        this.name = name;
        this.description = description;
        this.urlPhoto = urlPhoto;
        this.article = article;
        this.price = price;
    }
}
