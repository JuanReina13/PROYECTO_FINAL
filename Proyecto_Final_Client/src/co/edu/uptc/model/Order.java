package co.edu.uptc.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Order {

    private String idOrder;
    private String table;
    private List<Product> products;
    private boolean isReady;
    private long time;
    private List<ProductCategory> categoriesInvolved;

    
    public Order(String table, List<Product> products) {
        this.idOrder = createIdOrder();
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

    public String toString() {
        return "Order{" +
                "id=" + idOrder + "\n" +
                ", table='" + table + "\n" +
                ", products=" + products + "\n" +
                ", isReady=" + isReady + "\n" +
                ", time=" + time +
                '}';
    }

    private String createIdOrder() {
        String prefix = new SimpleDateFormat("yyMMdd").format(new Date());
        int random = (int) (Math.random() * 10000);
        String finalId = prefix + "-" + random;
        return finalId;
    }

    public String getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(String idOrden) {
        this.idOrder = idOrden;
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
