package nz.webshop.models.ProductCategory;

import javax.persistence.Column;

import java.io.Serializable;


public class ProductCategoryID implements Serializable {


    private Integer productId;


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
