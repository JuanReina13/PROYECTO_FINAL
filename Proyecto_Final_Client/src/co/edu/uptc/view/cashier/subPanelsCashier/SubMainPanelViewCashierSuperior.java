package co.edu.uptc.view.cashier.subPanelsCashier;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import co.edu.uptc.view.styleConstans.UIStyle;

public class SubMainPanelViewCashierSuperior extends JPanel{

    public SubMainPanelViewCashierSuperior() {
        setBackground(UIStyle.BACKGROUND);
        setLayout(new BorderLayout());
        initComponents();
        setVisible(true);
    }

    private void initComponents() {
        SubPanelCenter subPanelCenter = new SubPanelCenter();
        SubPanelRight subPanelRight = new SubPanelRight();
        add(subPanelCenter, BorderLayout.CENTER);
        add(subPanelRight, BorderLayout.EAST);
    }

}
