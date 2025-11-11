package co.edu.uptc.view.stations;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import co.edu.uptc.view.components.ShapedButtonUI;
import co.edu.uptc.view.styleConstans.UIStyle;

public class InfoPanel extends JPanel {

    private String stationName;
    private JButton openButton;
    private JButton recordButton;

    public InfoPanel(String stationName) {
        this.stationName = stationName;
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        setBackground(UIStyle.BACKGROUND_COLOR);
        setPreferredSize(new Dimension(Integer.MAX_VALUE, 120));
        setMaximumSize(new Dimension(Integer.MAX_VALUE, 120));
        initComponents();
        setVisible(true);
    }

    private void initComponents() {
        add(Box.createHorizontalStrut(40));
        addJLabel(stationName);


        add(Box.createHorizontalGlue());
        // add(Box.createHorizontalStrut(500));
        openButton = createButton(getOrdersCount() + "   Ordenes", new Dimension(150, 50));
        openButtonAction();
        add(openButton);

        add(Box.createHorizontalStrut(50));
        recordButton = createButton("Historial", new Dimension(150, 50));
        recordButtonAction();
        add(recordButton);

        add(Box.createHorizontalGlue());
        add(Box.createHorizontalStrut(50));
    }

    private void addJLabel(String text) {
        String title;

        if(text.equals("MainKitchen")){
            title = "Cocina";
        } else if (text.equals("Expeditor")){
            title = "Expedidor";
        } else {
            title = text;
        }
        JLabel namelabel = new JLabel("Estación: " + title);
        UIStyle.styleLabel(namelabel, true);
        add(namelabel);
    }

    private JButton createButton(String text, Dimension size) {
        JButton button = new JButton(text);
        button.setPreferredSize(size);
        button.setMaximumSize(size);
        button.setBackground(UIStyle.PRIMARY_COLOR);
        button.setForeground(UIStyle.BACKGROUND_COLOR);
        button.setFont(new Font("SansSerif", Font.PLAIN, 18));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setAlignmentX(CENTER_ALIGNMENT);
        button.setContentAreaFilled(false);
        button.setUI(new ShapedButtonUI());
        return button;
    }

    private void openButtonAction() {
        openButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setActiveButton(openButton, recordButton);
                //mainPanel.setRightComponent(new PositionsPanel(presenter));
            }
        });
    }

    private void recordButtonAction() {
        recordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setActiveButton(recordButton, openButton);
                //mainPanel.setRightComponent(new PositionsPanel(presenter));
            }
        });
    }

    private void setActiveButton(JButton b1, JButton b2) {
        b1.setBackground(UIStyle.SECONDARY_COLOR);
        b2.setBackground(UIStyle.PRIMARY_COLOR);
    }

    private int getOrdersCount() {
        // Lógica para obtener el número de órdenes pendientes
        return 0; // Valor de ejemplo
    }
}
