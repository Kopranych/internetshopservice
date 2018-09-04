package db.dto;

import lombok.Data;

import javax.persistence.*;

@Data
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
    @Column(name = "article")
    private String article;
}
