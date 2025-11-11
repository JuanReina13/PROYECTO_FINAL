package co.edu.uptc.view.stations;

import javax.swing.JPanel;

import co.edu.uptc.controller.ControllerStation;


public class ViewStation extends JPanel{

    private ControllerStation controllerStation;
    private String stationName;

    public ViewStation(String stationName, ControllerStation controllerStation) {
        this.stationName = stationName;
        this.controllerStation = controllerStation;
        setSize(800, 600);
        initComponents();
        setVisible(true);
    }

    private void initComponents() {
        
    }
}
