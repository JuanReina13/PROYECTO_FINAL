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

public class SandwichesPanel extends JPanel{

    private RoundedButtonCardLayout btnBack;
    private RoundedButtonProduct btnBlt;
    private RoundedButtonProduct btnGrilledCheese;
    private RoundedButtonProduct btnGrilledCheeseDeluxe;
    private RoundedButtonProduct btnGrilledChicken;
    private RoundedButtonProduct btnHaystack;

    public SandwichesPanel(SubPanelCenter subPanelCenter) {
        setLayout(new GridBagLayout());
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        initComponents(subPanelCenter);
        setVisible(true);
    }

    private void initComponents(SubPanelCenter subPanelCenter) {
        btnBack = new RoundedButtonCardLayout("VOLVER", UIStyle.ACTION_CANCEL, "buttonCategoryPanel", subPanelCenter);
        btnBlt = new RoundedButtonProduct("sw-blt", UIStyle.CATEGORY_SANDWICHES);
        btnGrilledCheese = new RoundedButtonProduct("sw-grilled-cheese", UIStyle.P3);
        btnGrilledCheeseDeluxe = new RoundedButtonProduct("sw-grilled-cheese-deluxe", UIStyle.P5);
        btnGrilledChicken = new RoundedButtonProduct("sw-grilled-chicken", UIStyle.P8);
        btnHaystack = new RoundedButtonProduct("sw-haystack", UIStyle.P1);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0; gbc.gridy = 0;
        add(btnBack, gbc);

        JLabel label = new JLabel("");
        gbc.gridx = 1;
        add(label, gbc);

        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.gridy = 1; add(btnBlt, gbc);
        gbc.gridy = 2; add(btnGrilledCheese, gbc);
        gbc.gridy = 3; add(btnGrilledCheeseDeluxe, gbc);
        gbc.gridy = 4; add(btnGrilledChicken, gbc);
        gbc.gridy = 5; add(btnHaystack, gbc);
    }

}
