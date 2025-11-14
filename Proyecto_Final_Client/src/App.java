<<<<<<< HEAD
<<<<<<< HEAD
import co.edu.uptc.view.MainFrame;
=======
=======
>>>>>>> parent of 52a5bc1 (Final ShoppingCart)
import java.util.Arrays;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import co.edu.uptc.controller.ControllerStation;
import co.edu.uptc.view.MainFrame;
import co.edu.uptc.view.stations.OrderCardPanel;
import co.edu.uptc.view.stations.OrdersPanel;
import co.edu.uptc.view.stations.ViewStation;
>>>>>>> parent of 3e3b762 (NEW_ORDER and ORDERS_PANEL_UPTADE)

public class App {
    public static void main(String[] args) throws Exception {
        MainFrame.getInstance();
<<<<<<< HEAD
<<<<<<< HEAD
=======
=======
>>>>>>> parent of 52a5bc1 (Final ShoppingCart)
        // SwingUtilities.invokeLater(() -> {
        //     JFrame frame = new JFrame("Test Orders Panel");
        //     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //     frame.setSize(1200, 700);
        //     frame.setLocationRelativeTo(null);

        //     OrdersPanel ordersPanel = new OrdersPanel(null);

        //     // 🧾 Añadimos tarjetas de prueba
        //     for (int i = 1; i <= 8; i++) {
        //         List<String> items = Arrays.asList(
        //                 "1 Pizza MargaritaPizza MargaritaPizza MargaritaPizza MargaritaPizza Margarita",
        //                 "2 Lasagnas|Añadir Pollo",
        //                 "1 Ensalada César|Añadir Pollo,1 Pizza Margarita"
        //         );
        //         OrderCardPanel card = new OrderCardPanel("yo",
        //                 "Cliente " + i,
        //                 "10:" + (20 + i),
        //                 items, true
        //         );
        //         ordersPanel.addOrderCard(card);
        //     }

        //     ViewStation station = new ViewStation("Estación de Cocina", new ControllerStation("yo"));
        //     station.setDownPanel(ordersPanel);

        //     frame.setContentPane(station);
        //     frame.setVisible(true);
        // });
<<<<<<< HEAD
>>>>>>> parent of 3e3b762 (NEW_ORDER and ORDERS_PANEL_UPTADE)
=======
>>>>>>> parent of 52a5bc1 (Final ShoppingCart)
    }
}