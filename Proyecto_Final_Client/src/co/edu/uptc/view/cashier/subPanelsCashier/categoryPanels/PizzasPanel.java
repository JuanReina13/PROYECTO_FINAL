package co.edu.uptc.view.cashier.subPanelsCashier.categoryPanels;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import co.edu.uptc.view.cashier.subPanelsCashier.SubPanelCenter;
import co.edu.uptc.view.components.RoundedButton;
import co.edu.uptc.view.components.RoundedButtonCardLayout;
import co.edu.uptc.view.styleConstans.UIStyle;

public class PizzasPanel extends JPanel {

    private RoundedButtonCardLayout btnBack;
    private RoundedButton btnPepperoni;
    private RoundedButton btnSupreme;
    private RoundedButton btnHawaiian;
    private RoundedButton btnRanch;
    private RoundedButton btnBbq;
    private RoundedButton btnMeatLovers;
    private RoundedButton btnBlt;
    private RoundedButton btnJalapenoPopper;
    private RoundedButton btnHaysticks;
    private RoundedButton btnHaysticksWithCheese;

    public PizzasPanel(SubPanelCenter subPanelCenter) {
        setLayout(new GridBagLayout());
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        initComponents(subPanelCenter);
        setVisible(true);
    }

    private void initComponents(SubPanelCenter subPanelCenter) {

        btnBack = new RoundedButtonCardLayout("VOLVER", UIStyle.ACTION_CANCEL, "buttonCategoryPanel", subPanelCenter);
        btnPepperoni = new RoundedButton("Pizza de Pepperoni", UIStyle.P2);
        btnBbq = new RoundedButton("Pizza pollo, gouda BBQ", UIStyle.P8);
        btnSupreme = new RoundedButton("Pizza Suprema", UIStyle.P3);
        btnRanch = new RoundedButton("Pizza Tocineta, pollo, ranch", UIStyle.P9);
        btnRanch.setForeground(UIStyle.TEXT_DARK);
        btnHawaiian = new RoundedButton("Pizza Hawaiana", UIStyle.P4);
        btnMeatLovers = new RoundedButton("Pizza Amantes de la carne", UIStyle.P9);
        btnJalapenoPopper = new RoundedButton("Pizza Jalapeño Popper", UIStyle.P7);
        btnBlt = new RoundedButton("Pizza Tocineta, lechuga, tomate", UIStyle.P5);
        btnHaysticks = new RoundedButton("Haysticks", UIStyle.P6);
        btnHaysticksWithCheese = new RoundedButton("Haysticks con queso", UIStyle.P4);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(btnBack, gbc);

        JLabel label = new JLabel("");
        gbc.gridx = 1;
        add(label, gbc);

        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.gridx = 1;
        gbc.gridy = 1;
        add(btnPepperoni, gbc);

        gbc.gridy = 2;
        add(btnSupreme, gbc);

        gbc.gridy = 3;
        add(btnHawaiian, gbc);

        gbc.gridy = 4;
        add(btnJalapenoPopper, gbc);

        gbc.gridy = 5;
        add(btnHaysticks, gbc);

        gbc.gridx = 2;
        gbc.gridy = 1;
        add(btnBbq, gbc);

        gbc.gridy = 2;
        add(btnRanch, gbc);

        gbc.gridy = 3;
        add(btnMeatLovers, gbc);

        gbc.gridy = 4;
        add(btnBlt, gbc);

        gbc.gridy = 5;
        add(btnHaysticksWithCheese, gbc);
    }
}
