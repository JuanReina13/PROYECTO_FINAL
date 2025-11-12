package co.edu.uptc.view.stations;

import javax.swing.*;
import javax.swing.border.*;

import co.edu.uptc.view.components.RoundedPanelUI;
import co.edu.uptc.view.components.ScrollBarUI;
import co.edu.uptc.view.styleConstans.UIStyle;

import java.awt.*;
import java.util.List;

public class OrderCardPanel extends RoundedPanelUI {

    public OrderCardPanel(String table, String time, List<String> products) {
        super(UIStyle.BACKGROUND, 20);
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(300, 400));
        setMaximumSize(new Dimension(260, Integer.MAX_VALUE));

        initComponents(table, time, products);
    }

    private void initComponents(String table, String time, List<String> products) {
        add(Box.createHorizontalStrut(20));
        addHeaderPanel(table, time);
        addItemsPanel(products);
    }

    private void addHeaderPanel(String table, String time) {
        Color color = UIStyle.getRandomHeaderColor();
        RoundedPanelUI headerPanel = new RoundedPanelUI(color, 15);
        headerPanel.setBackground(color);
        headerPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        JLabel lblCustomer = new JLabel(table);
        lblCustomer.setFont(new Font("Segoe UI", Font.BOLD, 18));
        lblCustomer.setForeground(Color.WHITE);

        JPanel rightHeader = new JPanel(new GridLayout(2, 1));
        rightHeader.setBackground(color);
        JLabel lblTime = new JLabel(time, SwingConstants.RIGHT);
        lblTime.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        lblTime.setForeground(Color.WHITE);

        rightHeader.add(lblTime);

        headerPanel.add(lblCustomer, BorderLayout.WEST);
        headerPanel.add(rightHeader, BorderLayout.EAST);
        add(headerPanel, BorderLayout.NORTH);
    }

    private void addItemsPanel(List<String> products) {
        JPanel itemsPanel = new JPanel();
        itemsPanel.setLayout(new BoxLayout(itemsPanel, BoxLayout.Y_AXIS));
        itemsPanel.setBackground(Color.WHITE);
        itemsPanel.setBorder(new EmptyBorder(10, 15, 10, 15));

        for (String item : products) {
            String[] parts = item.split("\\|");
            String main = parts[0].trim();
            String extra = parts.length > 1 ? parts[1].trim() : null;

            // ✅ Texto principal con salto de línea
            JTextArea txtMain = new JTextArea(main);
            txtMain.setFont(new Font("Segoe UI", Font.BOLD, 16));
            txtMain.setForeground(new Color(30, 30, 30));
            txtMain.setOpaque(false);
            txtMain.setEditable(false);
            txtMain.setFocusable(false);
            txtMain.setLineWrap(true);
            txtMain.setWrapStyleWord(true);
            txtMain.setAlignmentX(Component.LEFT_ALIGNMENT);
            txtMain.setBorder(new EmptyBorder(3, 0, 0, 0));
            txtMain.setMaximumSize(new Dimension(230, Integer.MAX_VALUE));
            itemsPanel.add(txtMain);

            // Subtexto (extras)
            if (extra != null && !extra.isEmpty()) {
                JLabel lblExtra = new JLabel(extra);
                lblExtra.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                lblExtra.setForeground(new Color(120, 120, 120));
                lblExtra.setBorder(new EmptyBorder(0, 15, 5, 0));
                lblExtra.setAlignmentX(Component.LEFT_ALIGNMENT);
                itemsPanel.add(lblExtra);
            }

            itemsPanel.add(Box.createVerticalStrut(10));
        }

        // 🔹 Solo el panel de productos tiene scroll si se excede la altura
        int estimatedHeight = products.size() * 40 + 40;
        int maxHeight = 250;

        JScrollPane scrollPane = new JScrollPane(
                itemsPanel,
                estimatedHeight > maxHeight
                        ? JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
                        : JScrollPane.VERTICAL_SCROLLBAR_NEVER,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        scrollPane.setPreferredSize(new Dimension(260, Math.min(estimatedHeight, maxHeight)));
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.setBackground(Color.WHITE);
        scrollPane.getViewport().setBackground(Color.WHITE);
        scrollPane.getVerticalScrollBar().setUnitIncrement(14);
        scrollPane.getVerticalScrollBar().setUI(new ScrollBarUI());

        add(scrollPane, BorderLayout.CENTER);
    }
}