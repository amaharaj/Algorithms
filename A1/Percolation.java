import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;
import edu.princeton.cs.algs4.QuickUnionUF;

public class Percolation {
   private int[] id;
   private int nsites;
   private boolean[][] grid;
   private boolean isOpen;
   private boolean isFull;  
   private boolean percolates;

   public Percolation(int n)                // create n-by-n grid, with all sites blocked
   { 
      System.out.println("inside the Percolation method!");
      // create boolean grid and array for IDs
      grid = new boolean[n][n];
      id = new int[n*n];
      // fill id array with integers - these will be the objects we are connecting
      for (int i=0; i<n*n; i++) {
         id[i] = i; 
      }

      System.out.println("The length of the id array is: " + id.length);
   }

   // when an object's return type is void, nothing is returned 
   public    void open(int row, int col)    // open site (row, col) if it is not open already
   { 
      // ATTENTION: need to put a statement here to check to see if the indices are out of bounds
      System.out.println("Row: " + row + " Column: " + col);
      // if the index is false, change that value to true. Otherwise don't do anything.
      // call isOpen to check to make connections to neighbours and check if the current
      // index is connected to the top row. 
      if (grid[row][col] == false) {
         grid[row][col] = true;
         System.out.println("Opening a new site.");
         System.out.println(grid[row][col]);
         isOpen(row,col); 
      }
      else { 
         System.out.println("This site is already open.");
      }
   }

   public boolean isOpen(int row, int col)  // is site (row, col) open?
   {
      // ATTENTION: use modular arithmetic here?
      // for now, create a variable which identifies the current index's ID label and the label
      // of the neighbour below it on the grid. 
      int value1 = col + row*grid.length;
      int value2 = col + (row+1)*grid.length;

 
      System.out.println("---------- printing value1 : " + value1 + " and value2 : " + value2);

      // ATTENTION: add checks to see if the neighbouring values are out of bounds
      // ATTENTION: figure out why the union call isn't working. 
      // check to see if the neighbour below the current index is also true. If it 
      // is, we will call the union function to change the id value. 
      if (grid[row+1][col] = true ) {
      // union(id[value1], id[value2]);
         System.out.println("id[" + value1 + "] is now connected to id[" + value2 + "]");
         System.out.println("Changing id to: " + id[value1] + " and " +  id[value2] );
         isOpen = true; 
         System.out.println("isOpen: " + isOpen);
      }
      else {
         isOpen = false; 
      }
      return isOpen; 
   }


   public boolean isFull(int row, int col)  // is site (row, col) full?
   {
      // some placeholder stuff
      if (grid[row][col] == false) {  
         isFull = true;
      }
      else { 
         isFull = false;
      }
      return isFull;
   }
   public     int numberOfOpenSites()       // number of open sites
   {
      // some placeholder stuff
      for (int i = 0; i < id.length; i++) {
         
         nsites += 1; 
      } 
      return nsites; 
   }
   public boolean percolates()              // does the system percolate?
   {
      // some placeholder stuff
      if (isFull == true) 
         percolates = false; 
      else 
         percolates = true; 
      return percolates;      
   }


   public static void main(String[] args)   // test client (optional)
   {
      // Attention: modify main function to read in variables at command line 

      //StdOut.readInt(args[0]);  
      StdOut.println("Running Percolation Alg...");
      int n = 5; 
      // create and initialize object
      Percolation pc = new Percolation(n); 
      System.out.println("inside the Main method!");
      // call method to open sites
      for (int i=0; i<n; i++) {
         pc.open(i,2);
         System.out.println("~~~~~~~ We are at the ith entry~~~~~~~~" + i); 
      }
   }
}
