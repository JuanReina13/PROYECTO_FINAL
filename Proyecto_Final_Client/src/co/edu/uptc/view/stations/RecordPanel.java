package co.edu.uptc.view.stations;

import java.awt.BorderLayout;
import java.awt.Component;
import java.time.Instant;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import co.edu.uptc.controller.ControllerStation;
import co.edu.uptc.model.Order;
import co.edu.uptc.view.components.ScrollBarUI;
import co.edu.uptc.view.styleConstans.UIStyle;

public class RecordPanel extends JPanel {

    private ControllerStation controllerStation;
    private JPanel ordersContainer;
    private JScrollPane scrollPane;
    private List<OrderCardPanel> orderCards;

    public RecordPanel(ControllerStation controllerStation) {
        orderCards = new ArrayList<>();
        this.controllerStation = controllerStation;
        setLayout(new BorderLayout());
        setBackground(UIStyle.TEXT_COLOR);
        initComponents();
    }

    private void initComponents() {
        ordersContainer = new JPanel();
        ordersContainer.setLayout(new BoxLayout(ordersContainer, BoxLayout.X_AXIS));
        ordersContainer.setBackground(UIStyle.TEXT_COLOR);
        ordersContainer.setBorder(new EmptyBorder(15, 15, 15, 15));
        orderCards = convertToOrderCards();
        addJScrollPane();
        showOrders();
    }

    private void addJScrollPane() {
        scrollPane = new JScrollPane(ordersContainer);
        scrollPane.setBackground(UIStyle.TEXT_COLOR);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.getHorizontalScrollBar().setUnitIncrement(16);
        scrollPane.getHorizontalScrollBar().setUI(new ScrollBarUI());
        scrollPane.getVerticalScrollBar().setUI(new ScrollBarUI());
        add(scrollPane, BorderLayout.CENTER);
    }

    public void addOrderCard(OrderCardPanel orderCard) {
        orderCards.add(orderCard);
        orderCard.setAlignmentY(Component.TOP_ALIGNMENT);
        ordersContainer.add(orderCard);
        ordersContainer.add(Box.createHorizontalStrut(20));
        ordersContainer.revalidate();
        ordersContainer.repaint();
    }

    public void showOrders() {
        ordersContainer.removeAll();
        for (OrderCardPanel orderCard : orderCards) {
            orderCard.setAlignmentY(Component.TOP_ALIGNMENT);
            ordersContainer.add(orderCard);
            ordersContainer.add(Box.createHorizontalStrut(20));
        }
        ordersContainer.revalidate();
        ordersContainer.repaint();
    }

    private List<OrderCardPanel> convertToOrderCards() {
        List<OrderCardPanel> orderCards = new ArrayList<>();
<<<<<<< HEAD
<<<<<<< HEAD
        List<OrderViewData> orders = controllerStation.getOrderHistoryViewData();

        for (OrderViewData data : orders) {
            OrderCardPanel card = new OrderCardPanel(
                    data.idOrder(),
                    data.table(),
                    formatTime(data.time()),
                    data.products(),
                    false,
                    controllerStation);
            orderCards.add(card);
        }

        return orderCards;
    }

    private String formatTime(String timestamp) {
        Instant instant = Instant.ofEpochMilli(Long.parseLong(timestamp));
=======
        List<Order> orders = controllerStation.getOrderHistory();
        for (Order order : orders) {
            List<String> productStrings = order.getProducts().stream()
                    .map(p -> p.getQuantity() + "x " + p.getName())
                    .collect(Collectors.toList());

            OrderCardPanel card = new OrderCardPanel(order.getIdOrder(),
                    order.getTable(),
                    formatTime(order.getTime()),
                    productStrings, false);

            orderCards.add(card);
        }
        return orderCards;
    }

    private String formatTime(long timestamp) {
        Instant instant = Instant.ofEpochMilli(timestamp);
>>>>>>> parent of 3e3b762 (NEW_ORDER and ORDERS_PANEL_UPTADE)
=======
        List<Order> orders = controllerStation.getOrderHistory();
        for (Order order : orders) {
            List<String> productStrings = order.getProducts().stream()
                    .map(p -> p.getQuantity() + "x " + p.getName())
                    .collect(Collectors.toList());

            OrderCardPanel card = new OrderCardPanel(order.getIdOrder(),
                    order.getTable(),
                    formatTime(order.getTime()),
                    productStrings, false);

            orderCards.add(card);
        }
        return orderCards;
    }

    private String formatTime(long timestamp) {
        Instant instant = Instant.ofEpochMilli(timestamp);
>>>>>>> parent of 52a5bc1 (Final ShoppingCart)
        LocalTime time = instant.atZone(ZoneId.systemDefault()).toLocalTime();
        return String.format("%02d:%02d", time.getHour(), time.getMinute());
    }
}
