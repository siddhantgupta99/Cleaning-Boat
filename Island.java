package edu.neu.csye6200.absim;

public class Island extends BasicElements{
    /**
     * Constructor
     *
     * @param x - X coordinate of the Island
     * @param y - y coordinate of the Island
     */
    public Island(int x, int y) {
        super(x, y);
    }

    @Override
    public BasicElements update(Ocean_Grid currentTimeUnit) {
        int Boat_as_neighbour = 0;
        int Island_as_neighbour = 0;
        boolean oilspill;

        Boat_as_neighbour = Functionality.countBoats(this, currentTimeUnit);
        oilspill = Functionality.checkforoil(this, currentTimeUnit);

        if (oilspill == true && Island_as_neighbour == 0 && Boat_as_neighbour < 4 ){
        return this;
        }

        return new Empty(this.getLocation().getX(), this.getLocation().getY());
    }

}
