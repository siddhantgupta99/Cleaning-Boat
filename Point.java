package edu.neu.csye6200.absim;

/**
 * This class will define a location(x,y) on the Ocean_Grid
 * elements are things that are added to the ocean grid like Boat, Islands, Oil..etc
 * @author siddhantgupta
 */
public class Point {
    /**
     * The top left is considered to be origin
     * x is an x-coordinate of the location on the grid
     * y is the y coordinate of the location on the grid
     */
    private int x;
    private int y;

    /**
     *
     * @param x: x coordinate of an element in the grid.
     * @param y  y coordinate of an element in the grid.
     */
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    /**
     *
     * @return : x coordinate of an element in the grid.
     */
    public int getX() {
        return x;
    }

    /**
     *
     * @return: y coordinate of an element in the grid.
     */
    public int getY() {
        return y;
    }
}
