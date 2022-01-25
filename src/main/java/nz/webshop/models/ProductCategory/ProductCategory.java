package nz.webshop.models.ProductCategory;

import javax.persistence.*;

@Entity
@Table(name ="productcategory")
@IdClass(ProductCategoryID.class)
public class ProductCategory {

    @Id
    @Column(name = "product_id")
    private Integer productId;

    @Id //here id is a recent change
    @Column(name = "category_id")
    private Integer categoryId;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }
}
