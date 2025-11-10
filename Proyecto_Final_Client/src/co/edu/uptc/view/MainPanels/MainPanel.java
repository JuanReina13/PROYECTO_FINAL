package co.edu.uptc.view.MainPanels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class MainPanel extends JPanel {
    

    public MainPanel() {
        setLayout(new BorderLayout());
        setBackground(new Color(245, 247, 250)); // Fondo claro moderno

        // ===== PANEL SUPERIOR CON BOTONES =====
        JPanel panelBotones = new JPanel(new GridLayout(1, 4, 20, 10));
        panelBotones.setBackground(new Color(245, 247, 250));
        panelBotones.setBorder(BorderFactory.createEmptyBorder(40, 40, 10, 40));

        
        JButton btn1 = crearBotonConImagen("resources/Main_Frame_Images/cash_register.png", "Caja");
        JButton btn2 = crearBotonConImagen("resources/Main_Frame_Images/pizza.png", "Pizzas");
        JButton btn3 = crearBotonConImagen("resources/Main_Frame_Images/fast_food.png", "Cocina Principal");
        JButton btn4 = crearBotonConImagen("resources/Main_Frame_Images/waiter.png", "Expedidor");

        panelBotones.add(btn1);
        panelBotones.add(btn2);
        panelBotones.add(btn3);
        panelBotones.add(btn4);
        JLabel textoInferior = new JLabel("Seleccione la estación a la que desea ingresar", SwingConstants.CENTER);
        textoInferior.setFont(new Font("Segoe UI", Font.BOLD, 20));
        textoInferior.setForeground(new Color(80, 80, 80));
        textoInferior.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
        add(panelBotones, BorderLayout.CENTER);
        add(textoInferior, BorderLayout.SOUTH);
    }

    private JButton crearBotonConImagen(String rutaImagen, String texto) {
        Image img;
        try {
            img = ImageIO.read(new File(rutaImagen));
        } catch (Exception e) {
            img = new BufferedImage(80, 80, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g = ((BufferedImage) img).createGraphics();
            g.setColor(Color.LIGHT_GRAY);
            g.fillRect(0, 0, 80, 80);
            g.dispose();
        }
        Image imgEscalada = img.getScaledInstance(70, 70, Image.SCALE_SMOOTH);
        JButton button = new JButton(new ImageIcon(imgEscalada));

        button.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        button.setForeground(new Color(60, 60, 60));
        button.setFocusPainted(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setOpaque(false);
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                button.setBorder(BorderFactory.createLineBorder(new Color(100, 150, 255), 2, true));
                button.setOpaque(true);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setBorder(null);
                button.setOpaque(false);
            }
        });

        // Panel envolvente para texto debajo del botón
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(245, 247, 250));
        panel.add(button, BorderLayout.CENTER);

        JLabel etiqueta = new JLabel(texto, SwingConstants.CENTER);
        etiqueta.setFont(new Font("Arial", Font.PLAIN, 18));
        etiqueta.setForeground(new Color(60, 60, 60));
        panel.add(etiqueta, BorderLayout.SOUTH);

        // Devuelve el panel como botón “visual”
        JButton envoltorio = new JButton();
        envoltorio.setLayout(new BorderLayout());
        envoltorio.setBorderPainted(false);
        envoltorio.setContentAreaFilled(false);
        envoltorio.setFocusPainted(false);
        envoltorio.add(panel);

        return envoltorio;
    }

}
