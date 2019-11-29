package GUI;

import Model.MotorizedVehicle;
import Model.Saab95;
import Model.Scania;
import Model.Volvo240;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class VehicleGUI {

    private final MotorizedVehicle vehicle;
    private BufferedImage image;
    private final Point point;

    public VehicleGUI(MotorizedVehicle vehicle) {
        this.vehicle = vehicle;
        selectPicPath();
        point = new Point(0, 0);
    }

    void selectPicPath() {
        try {
            if(vehicle.getClass() == Volvo240.class) {
                image = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg"));
            } else if(vehicle.getClass() == Saab95.class) {
                image = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg"));
            } else if(vehicle.getClass() == Scania.class) {
                image = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania.jpg"));
            }
            // Add more statements when new pictures are added....maybe make this process automatic?
            else {
                image = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Default.jpg"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void moveIt(int x, int y) {
        point.x = x;
        point.y = y;
    }

    public MotorizedVehicle getVehicle() {
        return vehicle;
    }

    public BufferedImage getImage() {
        return image;
    }

    public Point getPoint() {
        return point;
    }
}
