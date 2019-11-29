package GUI;

import Model.Interfaces.IMovable;
import Model.MotorizedVehicle;
import Model.Saab95;
import Model.Scania;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    public Timer timer = new Timer(delay, new TimerListener());
    // The frame that represents this instance View of the MVC pattern
    public CarView frame;
    // A list of cars, modify if needed
    public ArrayList<MotorizedVehicle> vehicles;

    public CarController(ArrayList<MotorizedVehicle> vehicles) {
        this.vehicles = vehicles;
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (MotorizedVehicle vehicle : vehicles) {
                VehicleGUI vehicleGUI = frame.drawPanel.vehicleGUIs.get(vehicles.indexOf(vehicle));

                vehicle.move();
                int x = (int) Math.round(vehicle.getX());
                int y = (int) Math.round(vehicle.getY());
                if(outOfPanel(vehicle, vehicleGUI.getImage(), frame.drawPanel)) {
                    vehicle.stopEngine();
                    invertDirection(vehicle);
                    vehicle.startEngine();
                }
                LockCoordinates(vehicle, frame.drawPanel.getWidth() - vehicleGUI.getImage().getWidth(),
                        frame.drawPanel.getHeight() - vehicleGUI.getImage().getHeight());
                vehicleGUI.moveIt(x, y);
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

    // Calls the startEngine method for each car once
    void startCars() {
        for (MotorizedVehicle vehicle : vehicles) {
            vehicle.startEngine();
        }
    }

    // Calls the stopEngine method for each car once
    void stopCars() {
        for (MotorizedVehicle vehicle : vehicles) {
            vehicle.stopEngine();
        }
    }
    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (MotorizedVehicle vehicle : vehicles) {
            vehicle.gas(gas);
        }
    }

    // Calls the brake method for each car once
    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (MotorizedVehicle vehicle : vehicles) {
            vehicle.brake(brake);
        }
    }

    // Calls the setTurboOn method if vehicle is a Saab95
    void turboOn() {
        for (MotorizedVehicle vehicle : vehicles) {
            if (vehicle.getClass() == Saab95.class) {
                ((Saab95) vehicle).setTurboOn();
            }
        }
    }

    // Calls the setTurboOn method if vehicle is a Saab95
    void turboOff() {
        for (MotorizedVehicle vehicle : vehicles) {
            if(vehicle.getClass() == Saab95.class) {
                ((Saab95) vehicle).setTurboOff();
            }
        }
    }

    // Calls the raiseFlatbed method if vehicle is a Scania
    void raiseBed() {
        for (MotorizedVehicle vehicle : vehicles) {
            if(vehicle.getClass() == Scania.class) {
                ((Scania) vehicle).raiseFlatbed();
            }
        }
    }

    // Calls the lowerFlatbed method if vehicle is a Scania
    void lowerBed() {
        for (MotorizedVehicle vehicle : vehicles) {
            if(vehicle.getClass() == Scania.class) {
                ((Scania) vehicle).lowerFlatbed();
            }
        }
    }
}
