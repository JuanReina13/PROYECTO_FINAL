import java.util.Arrays;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import co.edu.uptc.controller.ControllerStation;
import co.edu.uptc.view.MainFrame;
import co.edu.uptc.view.stations.OrderCardPanel;
import co.edu.uptc.view.stations.OrdersPanel;
import co.edu.uptc.view.stations.ViewStation;

public class App {
    public static void main(String[] args) throws Exception {
        //MainFrame.getInstance();
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Test Orders Panel");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(1200, 700);
            frame.setLocationRelativeTo(null);

            OrdersPanel ordersPanel = new OrdersPanel(null);

            // 🧾 Añadimos tarjetas de prueba
            for (int i = 1; i <= 8; i++) {
                List<String> items = Arrays.asList(
                        "1 Pizza MargaritaPizza MargaritaPizza MargaritaPizza MargaritaPizza Margarita",
                        "2 Lasagnas|Añadir Pollo",
                        "1 Ensalada César|Añadir Pollo,1 Pizza Margarita",
                        "2 Lasagnas|Añadir Pollo",
                        "1 Ensalada César|Añadir Pollo,1 Pizza Margarita",
                        "2 Lasagnas|Añadir Pollo",
                        "1 Ensalada César|Añadir Pollo,1 Pizza Margarita",
                        "2 Lasagnas|Añadir Pollo",
                        "1 Ensalada César|Añadir Pollo,1 Pizza Margarita",
                        "2 Lasagnas|Añadir Pollo",
                        "1 Ensalada César|Añadir Pollo,1 Pizza Margarita",
                        "2 Lasagnas|Añadir Pollo",
                        "1 Ensalada César|Añadir Pollo,1 Pizza Margarita",
                        "2 Lasagnas|Añadir Pollo",
                        "1 Ensalada César|Añadir Pollo1 Pizza Margarita",
                        "2 Lasagnas|Añadir Pollo",
                        "1 Ensalada César|Añadir Pollo,1 Pizza Margarita",
                        "2 Lasagnas|Añadir Pollo",
                        "1 Ensalada César|Añadir Pollo,1 Pizza Margarita",
                        "2 Lasagnas|Añadir Pollo",
                        "1 Ensalada César|Añadir Pollo,1 Pizza Margarita",
                        "2 Lasagnas|Añadir Pollo",
                        "1 Ensalada César|Añadir Pollo"
                );
                OrderCardPanel card = new OrderCardPanel(
                        "Cliente " + i,
                        "10:" + (20 + i),
                        items
                );
                ordersPanel.addOrderCard(card);
            }

            ViewStation station = new ViewStation("Estación de Cocina", new ControllerStation("yo"));
            station.setDownPanel(ordersPanel);

            frame.setContentPane(station);
            frame.setVisible(true);
        });
    }
}