package co.edu.uptc.model;

import java.util.List;
import java.util.UUID;

public class Order {

    private String idOrder;
    private String table;
    private List<Product> products;
<<<<<<< HEAD
    private String time;
    private boolean isReady;
    private List<String> categoriesInvolved;
=======
    private long time;
>>>>>>> parent of 3e3b762 (NEW_ORDER and ORDERS_PANEL_UPTADE)

    public Order(String table, List<Product> products, long time) {
        this.idOrder = UUID.randomUUID().toString();;
        this.table = table;
        this.products = products;
        this.time = time;
    }

    public String getIdOrder() {
        return idOrder;
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

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
<<<<<<< HEAD

    public boolean isReady() {
        return isReady;
    }

    public void setReady(boolean isReady) {
        this.isReady = isReady;
    }

    public List<String> getCategoriesInvolved() {
        return categoriesInvolved;
    }

    public void setCategoriesInvolved(List<String> categoriesInvolved) {
        this.categoriesInvolved = categoriesInvolved;
    }
=======
>>>>>>> parent of 3e3b762 (NEW_ORDER and ORDERS_PANEL_UPTADE)
}
