package co.edu.uptc.view.components;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;

import javax.swing.JButton;

import org.w3c.dom.events.MouseEvent;

import co.edu.uptc.view.cashier.subPanelsCashier.SubPanelCenter;
import co.edu.uptc.view.styleConstans.UIStyle;

public class RoundedButton extends JButton{
    private Color backgroundColor;

    public RoundedButton(String text, Color backgroundColor, String cardLayoutName, SubPanelCenter subPanelCenter) {
        super(text);
        this.backgroundColor = backgroundColor;
        setFocusPainted(false);
        setContentAreaFilled(false);
        setBorderPainted(false);
        setForeground(Color.WHITE);
        setFont(UIStyle.SUBTITLE_FONT);
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                System.out.println("Button clicked: " + getText());
                subPanelCenter.showPanel(cardLayoutName);
                System.out.println("Button clicked222: " + getText());
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(backgroundColor);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30);
        FontMetrics fm = g2.getFontMetrics();
        int x = (getWidth() - fm.stringWidth(getText())) / 2;
        int y = (getHeight() + fm.getAscent()) / 2 - 4;
        g2.setColor(getForeground());
        g2.drawString(getText(), x, y);
        g2.dispose();
    }

    public void setBackgroundColor(Color color) {
        this.backgroundColor = color;
        repaint();
    }

   
        
}
