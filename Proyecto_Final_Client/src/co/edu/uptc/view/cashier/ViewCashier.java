package co.edu.uptc.view.cashier;

import javax.swing.JPanel;

import co.edu.uptc.controller.ControllerCashier;

public class ViewCashier extends JPanel{

    private ControllerCashier controllerCashier;

    public ViewCashier(ControllerCashier controllerCashier) {
        this.controllerCashier = controllerCashier;
        setSize(800, 600);
        initComponents();
        setVisible(true);
    }

    private void initComponents() {
        
    }
}
