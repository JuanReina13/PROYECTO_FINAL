package co.edu.uptc.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Order {

    private String idOrder;
    private String table;
    private List<Product> products;

    public Order(String table, List<Product> products) {
        this.idOrder = createIdOrder();
        this.table = table;
        this.products = products;
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

}
