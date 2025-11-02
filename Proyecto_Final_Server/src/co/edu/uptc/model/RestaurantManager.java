package co.edu.uptc.model;

import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;

public class RestaurantManager {

    private List<Station> stations;
    private Queue<Order> orderQueue;
    private Deque<Order> recordStack;

    public RestaurantManager() {
        this.stations = new ArrayList<>();
        this.orderQueue = new java.util.LinkedList<>();
        this.recordStack = new java.util.ArrayDeque<>();
        configureStations();
    }

    private void configureStations() {

        Station mainKitchen = new Station(
                "Cocina Principal",
                List.of(ProductCategory.HAMBURGER, ProductCategory.SANDWICH, ProductCategory.HOT_DOG,
                        ProductCategory.NACHOS, ProductCategory.QUESADILLA, ProductCategory.SALAD));

        Station pizzas = new Station(
                "Zona de Pizzas",
                List.of(ProductCategory.PIZZA));

        Station expeditor = new Station("Zona de Meseros",
                List.of(ProductCategory.HAMBURGER, ProductCategory.SANDWICH, ProductCategory.HOT_DOG,
                        ProductCategory.NACHOS, ProductCategory.QUESADILLA, ProductCategory.SALAD,
                        ProductCategory.PIZZA));

        stations.add(mainKitchen);
        stations.add(pizzas);
        stations.add(expeditor);
    }

    public void addOrder(Order order) {
        orderQueue.add(order);
        shareOrder(order);
    }

    private void shareOrder(Order order) {
        for (Station station : stations) {
            for (ProductCategory category : station.getAssignedCategories()) {
                if (order.containsCategory(category)) {
                    station.addOrder(order);
                    break;
                }

            }
        }
    }

    public void finishOrder(Order order) {
        Iterator<Order> iterator = orderQueue.iterator();
        boolean condition = false;
        while (iterator.hasNext() && condition) {
            Order o = iterator.next();
            if (o.getIdOrden().equalsIgnoreCase(order.getIdOrden())) {
                iterator.remove();
                notifyStations(order, order.getCategoriesInvolved());
                recordStack.push(o);
                condition = true;
            }
        }
    }

    private void notifyStations(Order order, List<ProductCategory> categories) {
        for (Station station : stations) {
            for (ProductCategory category : categories) {
                if (station.getAssignedCategories().contains(category)) {
                    station.finishOrder(order);
                }
            }
        }
    }

}
