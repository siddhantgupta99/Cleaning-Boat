package edu.neu.csye6200.absim;

/**
 * @author siddhantgupta
 * This class will create an empty cell
 */
public class Empty extends BasicElements {

    /**
     * Constructor creates a new location based on the current state of the ocean
     * @param x : x coordinate of new location
     * @param y : y coordinate of new location
     */
    public Empty(int x, int y) {
        super(x, y);
    }

    /**
     * This method updates a cell based on the current ocean state
     * @param currentTimeUnit : Current Ocean Grid
     * @return :
     */
    @Override
    public BasicElements update(Ocean_Grid currentTimeUnit) {
        int Boatcount = 0;
        int Islandcount = 0;
        boolean oilspill;

        //  Check whether the nearby cells have either boats or Islands or Oil spills.
       Boatcount = Functionality.countBoats(this, currentTimeUnit);
       Islandcount = Functionality.countIslands(this,currentTimeUnit);
       oilspill = Functionality.checkforoil(this, currentTimeUnit);

       //Update the current cell

        /**
         *If oilspill is true and there is no boat around then we need a new boat to clean this oilspill.
          */

        if (oilspill == true && Boatcount ==0 && Islandcount < 3){
            return  new Boat(this.getLocation().getX(), this.getLocation().getY());
        }
        /**
         * If Oil spill is false and there is no island and the boat count is less than 2 then a oil spill is generated.
         */

        else if (oilspill == false && Islandcount == 0 && Boatcount <2){
            return new OilSpill(this.getLocation().getX(), this.getLocation().getY() ,OilSpill.getOilspreadthreshold() ,100);
        }

        /**
         * If oil spill is there and the level of oil is 100 then it starts to spread in the neighbouring cells
         */
        if (oilspill == true && OilSpill.OilSpreading() > 30){
            return new OilSpill(this.getLocation().getX(), this.getLocation().getY(), OilSpill.getOilspreadthreshold(), 50);

        }

        /**
         * Else return an empty cell
         */
        else {
        return this;}
    }
}
