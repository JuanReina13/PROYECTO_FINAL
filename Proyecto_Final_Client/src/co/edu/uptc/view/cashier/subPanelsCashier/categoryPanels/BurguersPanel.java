package co.edu.uptc.view.cashier.subPanelsCashier.categoryPanels;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import co.edu.uptc.view.cashier.subPanelsCashier.SubPanelCenter;
import co.edu.uptc.view.components.RoundedButtonProduct;
import co.edu.uptc.view.components.RoundedButtonCardLayout;
import co.edu.uptc.view.styleConstans.UIStyle;

public class BurguersPanel extends JPanel {
    private RoundedButtonCardLayout btnBack;
    private RoundedButtonProduct btnHayloftBurger;
    private RoundedButtonProduct btnHayloftBurgerWithCheese;
    private RoundedButtonProduct btnBltBurguer;
    private RoundedButtonProduct btnRanchBurger;
    private RoundedButtonProduct btnSwissMushroomsBurger;
    private RoundedButtonProduct btnSpicyPepperJackBurger;
    private RoundedButtonProduct btnDoubleBurguer;

    public BurguersPanel(SubPanelCenter subPanelCenter) {
        setLayout(new GridBagLayout());
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        initComponents(subPanelCenter);
        setVisible(true);
    }

    private void initComponents(SubPanelCenter subPanelCenter) {
        btnBack = new RoundedButtonCardLayout("VOLVER", UIStyle.ACTION_CANCEL, "buttonCategoryPanel", subPanelCenter);
        btnHayloftBurger = new RoundedButtonProduct("bg-hayloft-classic", UIStyle.P1);
        btnHayloftBurgerWithCheese = new RoundedButtonProduct("bg-hayloft-cheese", UIStyle.P4);
        btnBltBurguer = new RoundedButtonProduct("bg-blt", UIStyle.P5);
        btnRanchBurger = new RoundedButtonProduct("bg-ranch", UIStyle.P3);
        btnSwissMushroomsBurger = new RoundedButtonProduct("bg-swiss-mushrooms", UIStyle.P7);
        btnSpicyPepperJackBurger = new RoundedButtonProduct("bg-spicy-pepperjack", UIStyle.P6);
        btnDoubleBurguer = new RoundedButtonProduct("bg-double", UIStyle.P1);

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
        gbc.gridy = 1; add(btnHayloftBurger, gbc);
        gbc.gridy = 2; add(btnHayloftBurgerWithCheese, gbc);
        gbc.gridy = 3; add(btnBltBurguer, gbc);
        gbc.gridy = 4; add(btnRanchBurger, gbc);
        gbc.gridy = 5; add(btnSwissMushroomsBurger, gbc);
        gbc.gridy = 6; add(btnSpicyPepperJackBurger, gbc);
        gbc.gridy = 7; add(btnDoubleBurguer, gbc);

    }

}
