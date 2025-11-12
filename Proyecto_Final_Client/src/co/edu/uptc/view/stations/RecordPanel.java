package co.edu.uptc.view.stations;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import co.edu.uptc.controller.ControllerStation;
import co.edu.uptc.view.components.ScrollBarUI;
import co.edu.uptc.view.styleConstans.UIStyle;

public class RecordPanel extends JPanel {

    private ControllerStation controllerStation;
    private JPanel ordersContainer; 
    private JScrollPane scrollPane;

    public RecordPanel(ControllerStation controllerStation) {
        this.controllerStation = controllerStation;
        setLayout(new BorderLayout());
        setBackground(UIStyle.TEXT_COLOR); 
        initComponents();
    }

    private void initComponents() {
        ordersContainer = new JPanel();
        ordersContainer.setLayout(new BoxLayout(ordersContainer, BoxLayout.X_AXIS));
        ordersContainer.setBackground(UIStyle.TEXT_COLOR);
        addJScrollPane();
    }

    private void addJScrollPane() {
        scrollPane = new JScrollPane(ordersContainer);
        scrollPane.setBackground(UIStyle.TEXT_COLOR);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.getHorizontalScrollBar().setUnitIncrement(16);
        scrollPane.getHorizontalScrollBar().setUI(new ScrollBarUI());
        scrollPane.getVerticalScrollBar().setUI(new ScrollBarUI());
        add(scrollPane, BorderLayout.CENTER);
    }

}
