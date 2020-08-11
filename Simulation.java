package edu.neu.csye6200.absim;
import java.util.Observable;
import java.util.Random;
public final class Simulation extends Observable {
    private static int width = 55;  //Default width
    private static int height = 30; //Default height
    private static int Boat_size  = 110;    // Default Boat Size

    private static final int Multiplier = 8;

    private static int Oilspreadthreshold = 3;  //Default time till which oil will not spread
    private static int Oillevel = 100;  //Default oil level
    private static final int Magic_Prime = 78887; //Prime number that is used to select a random location in the ocean

    /**
     * Getters
     * @return
     */
    public static int getWidth() {
        return width;
    }

    public static int getHeight() {
        return height;
    }

    public static int getBoat_size() {
        return Boat_size;
    }


    /**
     * Private Constructor
     */
    private Simulation(){}

    public static void run(Ocean_Grid present_grid){
        if (present_grid != null){
            int width = present_grid.getWidth();
            int height = present_grid.getHeight();

            /**
             * DIsplay the ocean grid
             */
            for(int i = 0;i<width+2;i++){
                System.out.print("*");
            }
            System.out.println();
            for(int row = 0;row<height;row++){
                System.out.print("|");
                for(int column =0;column<width;column++) {
                    BasicElements add_element = present_grid.Cell_Contents(row, column);    // Cell whose contents we want
                    System.out.print(add_element.getClass().getName().substring(0,1));
                }
                System.out.println("|");
                }
            for(int i=0;i<width+2;i++){
                System.out.print("*");
            }
            System.out.println();
        }
    }


    /**
     * Main method
     *
     * @param args
     * @throws InterruptedException
     */


    public static void main (String args[]) throws InterruptedException {

        Ocean_Grid present_grid = new Ocean_Grid(width, height);    // Create the grid




        /**
         * Visit each cell and randomly place Boat, Island or Oil spill in the grid.
         */
        Random random = new Random(0);
        int x = 0;
        int y = 0;
        for (int row = 0; row < height; row++) {
            x = (x + Magic_Prime) % height;
            if ((x & Multiplier) == 0) {
                for (int column = 0; column < width; column++) {
                    y = (y + Magic_Prime) % width;
                    if ((y & Multiplier) == 0) {
                        int rand = random.nextInt();
                        if (rand < 0) {
                            present_grid.addElement(new Boat(x, y));
                        } else if (rand > 1500000000) {
                            present_grid.addElement(new OilSpill(x, y, Oilspreadthreshold, Oillevel));
                        }
                    }
                }
            } else {
                present_grid.addElement(new Empty(x, y));
            }
        }

            while (true) {
                run(present_grid);
                Thread.sleep(1000);
            }
        }
    }
