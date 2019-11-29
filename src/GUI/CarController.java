package GUI;

import Model.Interfaces.IMovable;
import Model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Scanner;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    ArrayList<MotorizedVehicle> cars = new ArrayList<>();

    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        cc.cars.add(new Volvo240());
        cc.cars.add(new Saab95());
        cc.cars.get(1).setX(150);
        cc.cars.add(new Scania());
        cc.cars.get(2).setX(400);

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            BufferedImage image;

            for (MotorizedVehicle vehicle : cars) {

                if(vehicle.getClass() == Volvo240.class) {
                    image = frame.drawPanel.imageList.get(1);
                } else if(vehicle.getClass() == Saab95.class) {
                    image = frame.drawPanel.imageList.get(2);
                } else if(vehicle.getClass() == Scania.class) {
                    image = frame.drawPanel.imageList.get(3);
                } else {
                    image = frame.drawPanel.imageList.get(0);
                }

                frame.drawPanel.currentImage = image;
                vehicle.move();
                int x = (int) Math.round(vehicle.getX());
                int y = (int) Math.round(vehicle.getY());
                if(outOfPanel(vehicle, image, frame.drawPanel)) {
                    vehicle.stopEngine();
                    invertDirection(vehicle);
                    vehicle.startEngine();
                }
                LockCoordinates(vehicle, frame.drawPanel.getWidth() - image.getWidth(),
                        frame.drawPanel.getHeight() - image.getHeight());
                frame.drawPanel.moveit(x, y);
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
            }
        }
    }

    void invertDirection(MotorizedVehicle car) {
        switch (car.getCurrentDirection()) {
            case NORTH:
                car.setCurrentDirection(IMovable.Direction.SOUTH);
                break;
            case EAST:
                car.setCurrentDirection(IMovable.Direction.WEST);
                break;
            case SOUTH:
                car.setCurrentDirection(IMovable.Direction.NORTH);
                break;
            case WEST:
                car.setCurrentDirection(IMovable.Direction.EAST);
                break;
        }
    }

    boolean outOfPanel(MotorizedVehicle car, BufferedImage image, DrawPanel panel) {
        return (car.getY() < 0) ||
                (car.getY() + image.getHeight() > panel.getHeight()) ||
                (car.getX() < 0) ||
                (car.getX() + image.getWidth() > panel.getWidth());
    }

    void LockCoordinates(MotorizedVehicle car, double xMax, double yMax) {
        double y = Math.min(car.getY(), yMax);
        car.setY(Math.max(y, 0));

        double x = Math.min(car.getX(), xMax);
        car.setX(Math.max(x, 0));
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (MotorizedVehicle car : cars) {
            car.gas(gas);
        }
    }

    // Calls the brake method for each car once
    void  brake(int amount) {
        double brake = ((double) amount) / 100;
        for (MotorizedVehicle car : cars) {
            car.brake(brake);
        }
    }
}
