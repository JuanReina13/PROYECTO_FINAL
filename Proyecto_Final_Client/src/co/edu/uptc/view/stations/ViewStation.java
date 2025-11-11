package co.edu.uptc.view.stations;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

import co.edu.uptc.controller.ControllerStation;


public class ViewStation extends JPanel{

    private ControllerStation controllerStation;
    private String stationName;

    public ViewStation(String stationName, ControllerStation controllerStation) {
        this.stationName = stationName;
        this.controllerStation = controllerStation;
        controllerStation.start();
        setBackground(new Color(18, 18, 18));
        setSize(800, 600);
        initComponents();
        setVisible(true);
    }

    private void initComponents() {
        JLabel namelabel = new JLabel("Estación: " + stationName);
        namelabel.setForeground(new Color(224, 224, 224));

    }

}
