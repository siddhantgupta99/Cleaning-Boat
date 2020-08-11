package edu.neu.csye6200.absim;

/**
 * @author siddhantgupta
 * Boat class defines the behaviour of the boat in the ocean-grid.
 */
public class Boat extends BasicElements {

    private int max = 100;   // Maximum load and battery capacity
    private int min = 30;   // Minimum load and battery capacity
    double load_capacity = (Math.random() * (max-min+1) + min);
    double battery_capacity = (Math.random() * (max-min+1) + min);
    protected boolean boat_status = true;                    // Boat is moving or not

    protected double load_usage;       // Load capacity and the load it is currently carrying(in kg)
    protected double battery_usage; // Battery capacity and usage (in milliamps)
    private int Boat_id;
    private static int idcounter = 0;



    private double heading;                         // Direction of Boat with respect to north
    protected int speed;                           // Speed of the boat in Km/h



    protected double maxspeed = 100;                         // Maximum speed of the boat
    protected double time;                            // Total time in hours during which boat is collecting debris
    protected double distance;
    /**
     * This constructor will create a location for Boat
     *
     * @param x - X coordinate of the Boat
     * @param y - y coordinate of the Boat
     */
    public Boat(int x,int y) {

        super(x, y);
        Boat_id = idcounter++;
    }


   public double distance(){
        distance = speed * time;

        return distance;
    }


    /**
     * Get Speed
     * @return  Speed
     */
    public int getSpeed() {
        return speed;
    }

    /**
     * Set speed
     * @param speed
     */
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    @Override
    public BasicElements update(Ocean_Grid currentTimeUnit) {
        return null;
    }
}