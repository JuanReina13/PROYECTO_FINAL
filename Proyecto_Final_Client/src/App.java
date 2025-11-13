import java.util.List;
import java.util.UUID;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import co.edu.uptc.controller.ControllerCashier;
import co.edu.uptc.controller.ControllerStation;
import co.edu.uptc.model.Order;
import co.edu.uptc.model.Product;
import co.edu.uptc.view.MainFrame;
import co.edu.uptc.view.stations.ViewStation;

public class App {
    public static void main(String[] args) throws Exception {
        //MainFrame.getInstance();

        ControllerStation controller = new ControllerStation("MainKitchen");
        controller.start();
        ControllerCashier controllerCashier = new ControllerCashier();

        MainFrame.getInstance();

        // Esperar a que el socket se conecte
        try {
            Thread.sleep(5000);
        } catch (Exception ignored) {
        }

        // 3️⃣ Crear orden de prueba
        Order order = new Order();
        order.setIdOrder(UUID.randomUUID().toString());
        order.setTable("Mesa 12");
        order.setTime(System.currentTimeMillis() + "");
        order.setReady(false);

        order.setProducts(List.of(
                new Product("1","Supreme Pizza", "PIZZA", 15.99, 1, "")));

        order.setCategoriesInvolved(List.of(
                "PIZZA"
                ));

        controllerCashier.sendNewOrder(order);

        System.out.println("📤 Orden de prueba enviada al servidor.");
    }
}