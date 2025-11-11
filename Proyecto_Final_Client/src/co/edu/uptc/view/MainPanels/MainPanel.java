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

import co.edu.uptc.controller.ControllerCashier;
import co.edu.uptc.controller.ControllerStation;
import co.edu.uptc.view.MainFrame;
import co.edu.uptc.view.cashier.ViewCashier;
import co.edu.uptc.view.stations.ViewStation;

public class MainPanel extends JPanel {

    private MainFrame mainFrame;
    private JButton btnCashier;
    private JButton btnPizza;
    private JButton btnKitchen;
    private JButton btnExpeditor;

    public MainPanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        setLayout(new BorderLayout());
        setBackground(new Color(245, 247, 250));

        JPanel panelBotones = new JPanel(new GridLayout(1, 4, 20, 10));
        panelBotones.setBackground(new Color(245, 247, 250));
        panelBotones.setBorder(BorderFactory.createEmptyBorder(40, 40, 10, 40));

        btnCashier = crearBotonConImagen("resources/Main_Frame_Images/cash_register.png", "Caja");
        btnPizza = crearBotonConImagen("resources/Main_Frame_Images/pizza.png", "Pizzas");
        btnKitchen = crearBotonConImagen("resources/Main_Frame_Images/fast_food.png", "Cocina Principal");
        btnExpeditor = crearBotonConImagen("resources/Main_Frame_Images/waiter.png", "Expedidor");

        panelBotones.add(btnCashier);
        panelBotones.add(btnPizza);
        panelBotones.add(btnKitchen);
        panelBotones.add(btnExpeditor);
        addActionListenersToButtons();

        JLabel textoInferior = new JLabel("Seleccione la estación a la que desea ingresar", SwingConstants.CENTER);
        textoInferior.setFont(new Font("Segoe UI", Font.BOLD, 20));
        textoInferior.setForeground(new Color(80, 80, 80));
        textoInferior.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
        add(panelBotones, BorderLayout.CENTER);
        add(textoInferior, BorderLayout.SOUTH);
    }

    private void addActionListenersToButtons() {
        btnCashier.addActionListener(e -> openCashier());
        btnPizza.addActionListener(e -> openStation("Pizza"));
        btnKitchen.addActionListener(e -> openStation("MainKitchen"));
        btnExpeditor.addActionListener(e -> openStation("Expeditor"));
    }

    private void openCashier() {
        ViewCashier viewCashier = new ViewCashier(new ControllerCashier());
        viewCashier.setVisible(true);
        mainFrame.showPanel(viewCashier);
    }

    private void openStation(String name) {
        ControllerStation controller = new ControllerStation(name);
        controller.start();
        ViewStation viewStation = new ViewStation(name, controller);
        viewStation.setVisible(true);
        mainFrame.showPanel(viewStation);
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

        JButton button = new JButton(texto, new ImageIcon(imgEscalada));
        button.setHorizontalTextPosition(SwingConstants.CENTER);
        button.setVerticalTextPosition(SwingConstants.BOTTOM);
        button.setFont(new Font("Segoe UI", Font.BOLD, 18));
        button.setForeground(new Color(60, 60, 60));
        button.setFocusPainted(false);
        button.setContentAreaFilled(true);
        button.setBorderPainted(false);
        button.setBackground(new Color(245, 247, 250));
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(new Color(225, 235, 255)); // tono más azul
                button.setBorder(BorderFactory.createLineBorder(new Color(100, 150, 255), 2, true));
                button.setOpaque(true);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(new Color(245, 247, 250));
                button.setBorder(null);
                button.setOpaque(true);
            }
        });

        return button;
    }

}
