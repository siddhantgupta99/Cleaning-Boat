package edu.neu.csye6200.absim;

public class ABRule extends Boat {
    /**
     * This constructor will create a location for Boat
     *
     * @param x - X coordinate of the Boat
     * @param y - y coordinate of the Boat
     */
    public ABRule(int x, int y) {
        super(x, y);
    }

    public void moveTo() {
        while (boat_status = true) {
            if (distance > 25) {
                if (load_capacity  == load_usage) {
                    boat_status = false;    // boat has stopped moving
                }
                if (battery_capacity - 10 == battery_usage) {
                    boat_status = false;
                }
                distance = distance - 25;
                load_usage = load_usage + 10;
                battery_usage = battery_usage + 20;
                break;
            }

        }
    }
    public Object moveLeft() {
        // if the boat is at the left edge, don't move it
        if (getLocation().getX() < 0)

        accelerate();
        return new Boat(this.getLocation().getX()-getSpeed(),getLocation().getY());

    }

    /**
     * if possible, moves the boat to the right
     */
    public Object moveRight() {
        // if the boat is at the right edge, don't move it
        if (getLocation().getX() > Simulation.getWidth() - Simulation.getBoat_size())
        accelerate();
        return new Boat(this.getLocation().getX()+getSpeed(),getLocation().getY());

    }

    /**
     * if the left or right key is pressed and not passing the maximum speed, increase the speed by 3
     */
    private void accelerate() {
        if (getSpeed() < maxspeed)
            setSpeed(getSpeed() + 3);
    }
}
