import co.edu.uptc.controller.ControllerCashier;
import co.edu.uptc.controller.ControllerStation;
import co.edu.uptc.view.MainFrame;

public class App {
    public static void main(String[] args) throws Exception {
        
        ControllerStation pizza = new ControllerStation("Pizza");
        pizza.start();
        
    }
}
