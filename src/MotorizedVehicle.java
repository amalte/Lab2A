import java.awt.*;

/**
 * @author SM
 * Abstract superclass to all MotorVehicle subobjects
 */
public abstract class MotorizedVehicle implements IMovable {
    private final int nrDoors; // Number of doors on the vehicle
    private final double enginePower; // Engine power of the vehicle
    private double currentSpeed; // The current speed of the vehicle
    private Color color; // Color of the vehicle
    private final String modelName; // The vehicle model name
    private Direction currentDirection = Direction.NORTH; // Direction the vehicle is facing
    private double x; // X position of vehicle
    private double y; // Y position of vehicle
    private double widthMeter; // Width of vehicle in meters
    private double heightMeter; // Height of vehicle in meters
    private double lengthMeter; // Length of vehicle meters

    /**
     * Constructor for MotorizedVehicle class
     * @param nrDoors Number of doors on a Car
     * @param enginePower Engine power of a Car
     * @param color Color of a Car
     * @param modelName Model name of a Car
     */
    public MotorizedVehicle(int nrDoors, double enginePower, Color color, String modelName, double width, double height, double length) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
        widthMeter = width;
        heightMeter = height;
        lengthMeter = length;
        stopEngine();
    }

    /**
     * Moves the MotorizedVehicle depending on the direction it's facing. Inherits from IMovable interface
     */
    @Override
    public void move() {
        switch (currentDirection){
            case NORTH:
                y += currentSpeed;
                break;
            case EAST:
                x += currentSpeed;
                break;
            case SOUTH:
                y -= currentSpeed;
                break;
            case WEST:
                x -= currentSpeed;
                break;
        }
    }

    /**
     * Turns the car to the left depending on it's current direction. Inherits from Movable interface
     */
    @Override
    public void turnLeft() {
        switch (currentDirection) {
            case NORTH:
                currentDirection = Direction.WEST;
                break;
            case EAST:
                currentDirection = Direction.NORTH;
                break;
            case SOUTH:
                currentDirection = Direction.EAST;
                break;
            case WEST:
                currentDirection = Direction.SOUTH;
                break;
        }
    }

    /**
     * Turns the car to the right depending on it's current direction. Inherits from Movable interface
     */
    @Override
    public void turnRight() {
        switch (getCurrentDirection()) {
            case NORTH:
                currentDirection = Direction.EAST;
                break;
            case EAST:
                currentDirection = Direction.SOUTH;
                break;
            case SOUTH:
                currentDirection = Direction.WEST;
                break;
            case WEST:
                currentDirection = Direction.NORTH;
                break;
        }
    }

    /**
     * Increases speed of car depending on amount by calling on incrementSpeed
     * @param amount Amount the speed should be increased with
     */
    public void gas(double amount) {
        amount = Math.max(amount, 0);
        incrementSpeed(Math.min(amount, 1));
    }

    /**
     * Decreases speed of car depending on amount by calling on decrementSpeed
     * @param amount Amount the speed should be decreased with
     */
    public void brake(double amount){
        amount = Math.max(amount, 0);
        decrementSpeed(Math.min(amount, 1));
    }

    /**
     * Returns speed factor of car
     * @return Returns speed factor (is overridden in subclasses)
     */
    protected double speedFactor() { return 1; }

    /**
     * Increments speed of car depending on amount
     * @param amount Amount the speed should increment with
     */
    private void incrementSpeed(double amount) { setCurrentSpeed(getCurrentSpeed() + speedFactor() * amount); }

    /**
     * Decrements speed of car depending on amount
     * @param amount Amount the speed should decrement with
     */
    private void decrementSpeed(double amount){ setCurrentSpeed(getCurrentSpeed() - speedFactor() * amount); }

    /**
     * Returns number of doors on car
     * @return number of doors on car
     */
    public int getNrDoors(){
        return nrDoors;
    }

    /**
     * Returns engine power of car
     * @return Engine power of car
     */
    public double getEnginePower(){
        return enginePower;
    }

    /**
     * Gets current speed of car
     * @return Current speed of car
     */
    public double getCurrentSpeed() { return currentSpeed; }

    /**
     * Sets current speed of car to a valid value in the interval [0, enginePower]
     * @param speed Sets current speed of car
     */
    public void setCurrentSpeed(double speed) {
        speed = Math.min(speed, enginePower);
        currentSpeed = Math.max(speed, 0);
    }

    /**
     * Gets color of car
     * @return Color of car
     */
    public Color getColor(){
        return color;
    }

    /**
     * Sets color of car to valid color
     * @param clr Sets the color of car
     */
    public void setColor(Color clr){
        color = clr;
    }

    /**
     * Starts engine by setting currentSpeed to 0.1
     */
    public void startEngine(){
        currentSpeed = 0.1;
    }

    /**
     * Stops engine by setting currentSpeed to 0
     */
    public void stopEngine(){
        currentSpeed = 0;
    }

    /**
     * Returns current direction of car
     * @return Current direction (the direction the car is currently facing)
     */
    public Direction getCurrentDirection() { return currentDirection; }

    /**
     * Sets current direction of car to a valid direction
     * @param currentDirection Current direction of car to set
     */
    public void setCurrentDirection(Direction currentDirection) { this.currentDirection = currentDirection; }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getWidth() {
        return widthMeter;
    }

    public void setWidth(double width) {
        this.widthMeter = width;
    }

    public double getHeight() {
        return heightMeter;
    }

    public void setHeight(double height) {
        this.heightMeter = height;
    }

    public double getLength() {
        return lengthMeter;
    }

    public void setLength(double length) {
        this.lengthMeter = length;
    }

    /**
     * Returns if a Car object is moving or not
     * @return Returns true or false depending on if a Car object is moving or not
     */
    public boolean isMoving() {
        return getCurrentSpeed() != 0;
    }
}