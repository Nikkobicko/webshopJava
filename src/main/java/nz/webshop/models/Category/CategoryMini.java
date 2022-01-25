package nz.webshop.models.Category;


import javax.persistence.*;

@Entity
@Table(name ="category")
public class CategoryMini {

    @Id
    @GeneratedValue
    @Column(name = "category_id")
    private Integer id;

    @Column(name = "category_name")
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
