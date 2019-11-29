package GUI;

import Model.MotorizedVehicle;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel {

    // TODO: Make this genereal for all cars
    // List for image paths, the images and their points
    ArrayList<String> picPath = new ArrayList<>();
    ArrayList<BufferedImage> imageList = new ArrayList<>();
    Point point;
    BufferedImage currentImage;

    // Initializes the panel and reads the images. Add paths to images here
    public DrawPanel(int x, int y) {
        picPath.add("pics/Default.jpg");
        picPath.add("pics/Volvo240.jpg");
        picPath.add("pics/Saab95.jpg");
        picPath.add("pics/Scania.jpg");

        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);

        // Print an error message in case file is not found with a try/catch block
        try {
            for (String s : picPath) {
                BufferedImage image = ImageIO.read(DrawPanel.class.getResourceAsStream(s));
                imageList.add(image);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    // TODO: Make this genereal for all cars
    void moveit(int x, int y) {
        point.x = x;
        point.y = y;

    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(currentImage, point.x, point.y, null); // see javadoc for more info on the parameters

    }
}
