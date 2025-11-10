import co.edu.uptc.controller.Controller;
import co.edu.uptc.view.MainFrame;

public class App {
    public static void main(String[] args) throws Exception {
        Controller controller = new Controller();  
        MainFrame main = new MainFrame();
        main.setVisible(true); 
    }
}
