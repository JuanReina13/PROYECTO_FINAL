package co.edu.uptc.view.cashier.subPanelsCashier;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;

import co.edu.uptc.view.cashier.subPanelsCashier.OrderPanels.ActionButtonsPanel;
import co.edu.uptc.view.cashier.subPanelsCashier.OrderPanels.ShoppingCart;
import co.edu.uptc.view.styleConstans.UIStyle;

public class SubPanelRight extends JPanel{
    public SubPanelRight() {
        setBackground(UIStyle.BACKGROUND);
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(350,800));
        setVisible(true);
        initComponents();
    }

    private void initComponents() {
        ShoppingCart shoppingCart = new ShoppingCart();
        add(shoppingCart, BorderLayout.CENTER);
        ActionButtonsPanel actionButtonsPanel = new ActionButtonsPanel();
        add(actionButtonsPanel, BorderLayout.SOUTH);
    }
}
