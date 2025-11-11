package co.edu.uptc.view.styleConstans;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import java.awt.*;

public class UIStyle {
    public static final Color PRIMARY_COLOR = new Color(25, 118, 210);
    public static final Color SECONDARY_COLOR = new Color(13, 71, 161);
    public static final Color BACKGROUND_COLOR = new Color(245, 245, 245);
    public static final Color TEXT_COLOR = Color.DARK_GRAY;

    public static final Color CATEGORY_BURGUERS = new Color(30, 136, 229); // #1E88E5
    public static final Color CATEGORY_PIZZA = new Color(251, 140, 0); // #FB8C00
    public static final Color CATEGORY_HOT_DOGS = new Color(236, 64, 122); // #EC407A
    public static final Color CATEGORY_SANDWICHES = new Color(67, 160, 71); // #43A047
    public static final Color CATEGORY_MEXICAN = new Color(41, 182, 246); // #29B6F6
    public static final Color CATEGORY_SALADS = new Color(0, 137, 123); // #00897B
    public static final Color CATEGORY_MISC = new Color(142, 36, 170); // #8E24AA
    public static final Color BACKGROUND = new Color(245, 245, 245); // #F5F5F5
    public static final Color PANEL_BG = new Color(255, 255, 255); // #FFFFFF
    public static final Color SPACING = new Color(224, 224, 224); // #E0E0E0
    public static final Color TEXT_PRIMARY = new Color(33, 33, 33); // #212121
    public static final Color TEXT_SECONDARY = new Color(97, 97, 97); // #616161
    public static final Color BORDER = new Color(189, 189, 189); // #BDBDBD
    public static final Color TOPBAR_BG = new Color(55, 71, 79); // #37474F
    public static final Color TOPBAR_TEXT = new Color(255, 255, 255); // #FFFFFF
    public static final Color ACTION_PAY = new Color(56, 142, 60); // #388E3C
    public static final Color ACTION_CANCEL = new Color(211, 47, 47); // #D32F2F
    public static final Color ACTION_MENU = new Color(69, 90, 100); // #455A64

    public static final Font TITLE_FONT = new Font("Segoe UI", Font.BOLD, 26);
    public static final Font SUBTITLE_FONT = new Font("Segoe UI", Font.BOLD, 20);
    public static final Font TEXT_FONT = new Font("Segoe UI", Font.PLAIN, 16);
    public static final Font BUTTON_FONT = new Font("Segoe UI", Font.BOLD, 14);

    public static final Border BUTTON_BORDER = BorderFactory.createLineBorder(PRIMARY_COLOR, 2, true);
    public static final Border PANEL_BORDER = BorderFactory.createLineBorder(SECONDARY_COLOR, 1, true);

    public static void styleButton(JButton button) {
        button.setBackground(PRIMARY_COLOR);
        button.setForeground(Color.WHITE);
        button.setFont(BUTTON_FONT);
        button.setBorder(BUTTON_BORDER);
        button.setFocusPainted(false);
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    public static void stylePanel(JPanel panel) {
        panel.setBackground(BACKGROUND_COLOR);
        panel.setBorder(PANEL_BORDER);
    }

    public static void styleLabel(JLabel label, boolean isTitle) {
        label.setFont(isTitle ? TITLE_FONT : TEXT_FONT);
        label.setForeground(TEXT_COLOR);
    }
}
