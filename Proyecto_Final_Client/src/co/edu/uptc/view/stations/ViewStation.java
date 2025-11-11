package co.edu.uptc.view.stations;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import co.edu.uptc.controller.ControllerStation;
import co.edu.uptc.view.styleConstans.UIStyle;


public class ViewStation extends JPanel{

    private ControllerStation controllerStation;
    private String stationName;

    public ViewStation(String stationName, ControllerStation controllerStation) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.stationName = stationName;
        this.controllerStation = controllerStation;
        controllerStation.start();
        setBackground(UIStyle.BACKGROUND);
        setSize(800, 600);
        initComponents();
        setVisible(true);
    }

    private void initComponents() {
        InfoPanel infoPanel = new InfoPanel(stationName);
        add(infoPanel);

    }
}
