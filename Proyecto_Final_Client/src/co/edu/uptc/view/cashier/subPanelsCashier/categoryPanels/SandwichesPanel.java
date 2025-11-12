package co.edu.uptc.view.cashier.subPanelsCashier.categoryPanels;

import java.awt.Color;
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

public class SandwichesPanel extends JPanel{

    private RoundedButtonCardLayout btnBack;
    private RoundedButton btnBlt;
    private RoundedButton btnGrilledCheese;
    private RoundedButton btnGrilledCheeseDeluxe;
    private RoundedButton btnGrilledChicken;
    private RoundedButton btnHaystack;

    public SandwichesPanel(SubPanelCenter subPanelCenter) {
        setLayout(new GridBagLayout());
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        initComponents(subPanelCenter);
        setVisible(true);
    }

    private void initComponents(SubPanelCenter subPanelCenter) {
        btnBack = new RoundedButtonCardLayout("VOLVER", UIStyle.ACTION_CANCEL, "buttonCategoryPanel", subPanelCenter);
        btnBlt = new RoundedButton("BLT Sandwich - USD 8.99", UIStyle.CATEGORY_SANDWICHES);
        btnGrilledCheese = new RoundedButton("Grilled Cheese Sandwich - USD 7.99", UIStyle.P3);
        btnGrilledCheeseDeluxe = new RoundedButton("Grilled Cheese Deluxe - USD 8.99", UIStyle.P5);
        btnGrilledChicken = new RoundedButton("Grilled Chicken Sandwich - USD 10.99", UIStyle.P8);
        btnHaystack = new RoundedButton("Haystack Sandwich - USD 10.99", UIStyle.P1);

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
