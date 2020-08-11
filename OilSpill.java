package edu.neu.csye6200.absim;

/**
 * @author siddhantgupta
 * OillSpill class defines the behaviour of the spill in the ocean grid.
 */
public class OilSpill extends BasicElements{

    /**
     * The amount of time after which the oil will start to spread.
     * After this time the oil will spread at a continuous rate.
     */
    private static int Oilspreadthreshold;   // The Oil spread time is the number of time units after which the oil will start to spread.
    /**
     * The variable defined below depicts the thickness of oil on the surface of the ocean.
     * It ranges form 0-100, with 100 being the most dense oil, so the boat has to take more time to clean it
     * 0 means that the oil has been cleaned by the boat.
      */
    private static int Oillevel = 100;
    /**
     * Constructor will create a new location for oilspill
     *
     * @param x - X coordinate of oil spill
     * @param y - y coordinate of oil spill
     */
    public OilSpill(int x, int y, int Oilspreadthreshold, int Oillevel) {

        super(x, y);
        this.Oillevel = Oillevel;

    }

    /**
     * This method provides the time after which the oil starts to spread
     * @return
     */
    public static int getOilspreadthreshold() {
        return Oilspreadthreshold;
    }

    public static int getOillevel() {
        return Oillevel;
    }

   public static int OilSpreading(){
        while (Oillevel>20){
               Oillevel-=5;
        }
       return Oillevel;
    }
    @Override
    public BasicElements update(Ocean_Grid currentTimeUnit) {
        int Boat_as_neighbour = 0;
        int Islands_as_neighbour = 0;

        Boat_as_neighbour = Functionality.countBoats(this, currentTimeUnit);
        Islands_as_neighbour = Functionality.countIslands(this, currentTimeUnit);

        /**
         * If there is no boat or Island in the neighbouring cells then return Oilspill
         */
        if (Boat_as_neighbour == 0 && Islands_as_neighbour == 0) {
            return this;
        }


        /**
         * Is there is a boat in the neighbouring cell and there is no island then the boat will clean the Oilspill\
         * In the current time unit, the cell will become empty
         */
        else if (Boat_as_neighbour >=1 && Islands_as_neighbour == 0){
            return new Empty(this.getLocation().getX(), this.getLocation().getY());
        }
        /**
         * Else return an empty cell
         */
        else {
            return new Empty(this.getLocation().getX(), this.getLocation().getY());
        }
        }

}
