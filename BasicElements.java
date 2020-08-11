package edu.neu.csye6200.absim;

import javax.xml.stream.Location;
import java.awt.*;

/**
 * This class defines anything that can be added to a specific location in the ocean.
 * Elements can be Boat, Islands, Oil ..etc which are added to the ocean_grid
 * @author siddhantgupta
 */
public abstract class BasicElements {

    Point location; // Location of an element in the ocean

    /**
     * Constructor
     * @param x - X coordinate of the element
     * @param y - y coordinate of the element
     */
    public BasicElements(int x, int y){
        location = new Point(x,y);
    }

    public Point getLocation() {
        return location;
    }
    public Point setLocation()  {return location;
    }

    /**
     * This method calculates the new value of location
     * Does not perform any action
     */

    public abstract BasicElements update(Ocean_Grid currentTimeUnit);

}
