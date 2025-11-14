package co.edu.uptc.view.cashier.subPanelsCashier.OrderPanels;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.List;

import javax.swing.JPanel;

import co.edu.uptc.view.styleConstans.UIStyle;

public class ShoppingCart extends JPanel {

    public ShoppingCart() {
        setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        setBackground(UIStyle.BACKGROUND_INFERIOR_COLOR);
        setVisible(true);
        initComponents();
    }

    private void initComponents() {
        FieldProductPanel fieldProductPanel = new FieldProductPanel("1", "Pepperoni Pizza");
        add(fieldProductPanel);
        FieldProductPanel fieldProductPanel2 = new FieldProductPanel("1", "Supreme Pizza");
        add(fieldProductPanel2);
        FieldProductPanel fieldProductPanel3 = new FieldProductPanel("1", "Hawaiian Pizza");
        add(fieldProductPanel3);
        FieldProductPanel fieldProductPanel4 = new FieldProductPanel("1", "Hawaiian Pizza");
        add(fieldProductPanel4);
        FieldProductPanel fieldProductPanel5 = new FieldProductPanel("1", "Hawaiian Pizza");
        add(fieldProductPanel5);
        FieldProductPanel fieldProductPanel6 = new FieldProductPanel("1", "Hawaiian Pizza");
        add(fieldProductPanel6);
        FieldProductPanel fieldProductPanel7 = new FieldProductPanel("1", "Hawaiian Pizza");
        add(fieldProductPanel7);
        FieldProductPanel fieldProductPanel8 = new FieldProductPanel("1", "Hawaiian Pizza");
        add(fieldProductPanel8);
        FieldProductPanel fieldProductPanel9 = new FieldProductPanel("1", "Hawaiian Pizza");
        add(fieldProductPanel9);
        FieldProductPanel fieldProductPanel10 = new FieldProductPanel("1", "Hawaiian Pizza");
        add(fieldProductPanel10);
    }

    public void addfieldProductPanel(String number, String name) {
        FieldProductPanel panel = new FieldProductPanel(number, name);
        this.add(panel);
        revalidate();
        repaint();
    }

    @Override
    public Dimension getPreferredSize() {
        int height = getComponentCount() * 130;
        return new Dimension(330, height);
    }
}
