package co.edu.uptc.view.cashier.subPanelsCashier.OrderPanels;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import co.edu.uptc.view.components.RoundedButton;
import co.edu.uptc.view.styleConstans.UIStyle;

public class ActionButtonsPanel extends JPanel{

    private JButton btnLeft;
    private JButton btnRight;

    public ActionButtonsPanel() {
        setPreferredSize(new Dimension(WIDTH,150));
        setLayout(new FlowLayout(FlowLayout.CENTER, 20, 30));

        btnLeft = new RoundedButton("BORRAR ORDEN", UIStyle.ACTION_CANCEL);
        btnRight = new RoundedButton("ENVIAR ORDEN", UIStyle.ACTION_PAY);

        add(btnLeft);
        add(btnRight);
    }


}
