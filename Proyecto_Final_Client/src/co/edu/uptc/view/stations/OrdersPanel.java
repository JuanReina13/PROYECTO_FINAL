package co.edu.uptc.view.stations;

import java.awt.BorderLayout;
import java.awt.Component;
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

public class OrdersPanel extends JPanel {

    private ControllerStation controllerStation;
    private JPanel ordersContainer;
    private JScrollPane scrollPane;
    private List<OrderCardPanel> orderCards;

    public OrdersPanel(ControllerStation controllerStation) {
        orderCards = new ArrayList<>();
        this.controllerStation = controllerStation;
        controllerStation.requestOrders();
        setLayout(new BorderLayout());
        setBackground(UIStyle.TEXT_COLOR);
        initComponents();
    }

    private void initComponents() {
        ordersContainer = new JPanel();
        ordersContainer.setLayout(new BoxLayout(ordersContainer, BoxLayout.X_AXIS));
        ordersContainer.setBackground(UIStyle.TEXT_COLOR);
        ordersContainer.setBorder(new EmptyBorder(15, 15, 15, 15));
        addJScrollPane();
        showOrders();
    }

    private void addJScrollPane() {
        scrollPane = new JScrollPane(ordersContainer);
        scrollPane.setBackground(UIStyle.TEXT_COLOR);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.getHorizontalScrollBar().setUnitIncrement(16);
        scrollPane.getHorizontalScrollBar().setUI(new ScrollBarUI());
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

    public void removeOrderCard(OrderCardPanel orderCard) {
        orderCards.remove(orderCard);
        ordersContainer.remove(orderCard);
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

    public void loadOrders(List<Order> orders) {
        orderCards.clear();
        for (Order o : orders) {
            List<String> items = o.getProducts().stream()
                    .map(p -> p.getQuantity() + "x " + p.getName())
                    .collect(Collectors.toList());

            OrderCardPanel card = new OrderCardPanel(
                    o.getIdOrder(),
                    o.getTable(),
                    o.getTime(),
                    items,
                    true,
                    controllerStation);
            orderCards.add(card);
        }
        showOrders();
    }
}
