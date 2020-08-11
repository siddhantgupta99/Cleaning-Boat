package edu.neu.csye6200.absim;



/**
 * @author siddhantgupta
 * This class defines rules used by other classes such as Empty class or Boat and Islands classes.
 */
public final class Functionality {

    /**
     * Private constructor
     */
    private Functionality(){}

    /**
     * This method performs modulo operation
     * @param n : numerator
     * @param d : denominator
     * @return  remainder
     */
    private static int mod(int n, int d) {
        if (n >= 0)
            return n % d;
        else
            return d + ~(~n % d);
    }

    /**
     * This method checks whether the oil is present in the grid?
     * @param add_element : oil
     * @param present_grid : current state of ocean grid
     * @return : if oil is present or absent around an empty cell
     */
    public static boolean checkforoil(BasicElements add_element, Ocean_Grid present_grid){
        Point P = add_element.getLocation();
        int x =  P.getX();
        int y =  P.getY();
        int row, column;

        for(int i = x-1;i<x+1;i++){
            for(int j=y-1;j<y+1;j++){

                row = mod(i, present_grid.getHeight());
                column = mod(j,present_grid.getWidth());
                if(present_grid.Cell_Contents(row,column) instanceof OilSpill)
                    return true;
            }
        }
    return false;
    }

    /**
     * This method counts the number of Boats in the ocean
     * @param add_element : add Boat
     * @param present_grid : Present state of Ocean grid
     * @return : Number of boats present around an empty cell
     */
    public static int countBoats(BasicElements add_element, Ocean_Grid present_grid){
        int Boatcount = 0;
        Point P = add_element.getLocation();
        int x =  P.getX();
        int y =  P.getY();
        int row, column;

        for(int i = x-1;i<x+1;i++){
            for(int j=y-1;j<y+1;j++){

                row = mod(i, present_grid.getHeight());
                column = mod(j,present_grid.getWidth());
                if(present_grid.Cell_Contents(row,column) instanceof Boat)
                    Boatcount++;

            }
        }
        return Boatcount;
    }

    /**
     * This method counts the number of Islands in the ocean
     * @param add_element : Island
     * @param present_grid : Instance of present Ocean grid
     * @return : Number of islands present arount an empty cell
     */
    public static int countIslands(BasicElements add_element, Ocean_Grid present_grid){
        int Islandcount = 0;
        Point P = add_element.getLocation();
        int x =  P.getX();
        int y =  P.getY();
        int row, column;

        for(int i = x-1;i<x+1;i++){
            for(int j=y-1;j<y+1;j++){

                row = mod(i, present_grid.getHeight());
                column = mod(j,present_grid.getWidth());
                if(present_grid.Cell_Contents(row,column) instanceof Island)
                    Islandcount++;

            }
        }
        return Islandcount;
    }
}