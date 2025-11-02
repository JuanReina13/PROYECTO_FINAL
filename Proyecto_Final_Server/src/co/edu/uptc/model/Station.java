package co.edu.uptc.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Station {

    private String name;
    private List<ProductCategory> assignedCategories;
    private List<Order> orders;


    public Station(String name, List<ProductCategory> assignedCategories) {
        this.name = name;
        this.assignedCategories = assignedCategories;
        orders = new ArrayList<>();
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public void finishOrder(Order order) {
        Iterator<Order> iterator = orders.iterator();
        boolean condition = true;
        Order currentOrder;
        while (iterator.hasNext() && condition){
            currentOrder = iterator.next();
            if (currentOrder.getIdOrden().equalsIgnoreCase(order.getIdOrden())){
                iterator.remove();
                condition = false;
            }
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ProductCategory> getAssignedCategories() {
        return assignedCategories;
    }

    public void setAssignedCategories(List<ProductCategory> assignedCategories) {
        this.assignedCategories = assignedCategories;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

}
