package GUI;

import Model.MotorizedVehicle;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel {

    ArrayList<VehicleGUI> vehicleGUIs = new ArrayList<>();

    // Initializes the panel and reads the images. Add paths to images here
    public DrawPanel(ArrayList<MotorizedVehicle> vehicles, int x, int y) {
        for (MotorizedVehicle vehicle : vehicles) {
            vehicleGUIs.add(new VehicleGUI(vehicle));
        }
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(VehicleGUI vehicle : vehicleGUIs) {
            g.drawImage(vehicle.getImage(), vehicle.getPoint().x,vehicle.getPoint().y, null); // see javadoc for more info on the parameters
        }
    }
}
