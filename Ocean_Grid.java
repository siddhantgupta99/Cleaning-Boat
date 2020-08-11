package edu.neu.csye6200.absim;


/**
 *
 * @author siddhantgupta
 * This class defines an ocean grid full of basic elements such as boats, oil spills and land.
 */

public class Ocean_Grid {

    private int width;  //Width of the grid
    private int height; // Height of the grid
    private BasicElements[][] oceangrid;

    /**
     *
     * Constructor creates an empty ocean grid
     * @param width : Width of the ocean
     * @param height : Height of the ocean
     *
     */
    public Ocean_Grid(int width, int height){
        this.oceangrid = new BasicElements[height][width];
        this.width = width;
        this.height = height;
        for(int row=0;row<height;row++){
            System.out.println();
            for (int column=0;column<width;column++){
                oceangrid[row][column] = new Empty(row, column);
                System.out.print(oceangrid[row][column]);
            }
        }

    }

    /**
     * This method adds the BasicElements like a boat or oil spill or islands.
     * @param add_object : Object to be added to the oceangrid
     *
     */
    public void addElement(BasicElements add_object){
        Point P = add_object.getLocation();
        int x = P.getX();
        int y = P.getY();
        oceangrid[x][y] = add_object;
    }

    /**
     *
     * @param x : X coordinate of the cell whose contents we want to know
     * @param y : Y coordinate of the cell whose contents we want to know
     * @return  : oceangrid
     */
    public BasicElements Cell_Contents(int x, int y){
        return oceangrid[x][y];
    }

    /**
     * to get the width of the ocean
     * @return : width of the ocean
     */
    public int getWidth() {
        return width;
    }

    /**
     * to get the height of the ocean
     * @return  : height of the ocean
     */
    public int getHeight() {
        return height;
    }

    /**
     * TimeUnit() does a simulation of nest state of the ocean
     * @return : Ocean after one time unit.
     */
    public Ocean_Grid TimeUnit() {
        Ocean_Grid nextTimeUnit = new Ocean_Grid(width, height);

        for(int row=0; row<this.height;row++){
            System.out.println();
            for(int column=0; column<this.width;column++){
                BasicElements add_element = this.Cell_Contents(row, column);
                nextTimeUnit.addElement(add_element.update(this));

            }
        }
        return nextTimeUnit;
    }
}
