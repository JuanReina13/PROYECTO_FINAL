package co.edu.uptc.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Order {

    private String idOrden;
    private String table;
    private List<Product> products;
    private boolean isReady;
    private long time;
    private List<ProductCategory> categoriesInvolved;

    public Order(String table, List<Product> products) {
        this.idOrden = UUID.randomUUID().toString();
        this.table = table;
        this.products = products;
        this.isReady = false;
        this.time = System.currentTimeMillis();
        categoriesInvolved();
    }

    public boolean containsCategory(ProductCategory category) {
        for (Product product : products) {
            if (product.getCategory() == category) {
                return true;
            }
        }
        return false;
    }

    private void categoriesInvolved() {
        categoriesInvolved = new ArrayList<>();
        for (Product product : products) {
            if (!categoriesInvolved.contains(product.getCategory())) {
                categoriesInvolved.add(product.getCategory());
            }
        }
    }

    public String getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(String idOrden) {
        this.idOrden = idOrden;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Boolean getIsReady() {
        return isReady;
    }

    public void setIsReady(Boolean isReady) {
        this.isReady = isReady;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public List<ProductCategory> getCategoriesInvolved() {
        return categoriesInvolved;
    }

    public void setCategoriesInvolved(List<ProductCategory> categoriesInvolved) {
        this.categoriesInvolved = categoriesInvolved;
    }
}