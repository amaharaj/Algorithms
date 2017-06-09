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
 //  private QuickUnionUF uf = new QuickUnionUF(); 

   public Percolation(int n)                // create n-by-n grid, with all sites blocked
   { 
      // create boolean grid and array for IDs
      grid = new boolean[n][n];
      id = new int[n*n];
      // fill id array with integers - these will be the objects we are connecting
      for (int i=0; i<n*n; i++) {
         id[i] = i+1; 
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
      // For now, create a variable which identifies the current index's ID label and the label
      // of the neighbour below it on the grid. 
      int middle = col + row*grid.length;
      int bottom = col + (row+1)*grid.length;
      int top = col + (row-1)*grid.length;
      int right = middle + 1; 
      int left = middle - 1; 
 
      // ATTENTION: figure out why the union call isn't working. 

      // Set top, bottom, left and right neighbours to be true
      boolean tn = true; 
      boolean bn = true;
      boolean ln = true; 
      boolean rn = true; 

      // Check if neighbours are out of bounds. If they are, set the neighbour
      // to be false. 
      System.out.println("Now printing id[middle]: " + id[middle]);
      System.out.println("Now printing id[middle]%grid.length: " + id[middle]%grid.length);
      if (id[middle]%grid.length == 1) {
         ln = false; 
      } else {
         System.out.println("Left neighbour exists");
      }
      if (id[middle]%grid.length == 0) {
         rn = false;
      } else {
         System.out.println("Right neighbour exists");
      }
      if (row == 0 ) {
         tn = false; 
      } else {
         System.out.println("Top neighbour exists");
      }
      if (row == (grid.length-1)) {
         bn = false; 
      } else {
         System.out.println("Bottom neighbour exists");
      }

      // Check each neighbour if it exists
      if (tn == true) {
         if (grid[row-1][col] == true) {
            System.out.println("Top neighbour is true!");
         } else {
            System.out.println("Top neighbour is false :(");
         }
      } else {
         System.out.println("No top neighbour");
      }
      if (bn == true) {
         if (grid[row+1][col] == true) {
            System.out.println("Bottom neighbour is true!");
         } else {
            System.out.println("Bottom neighbour is false :(");
         }
      } else {
         System.out.println("No bottom neighbour");
      }
      if (ln == true) { 
         if (grid[row][col-1] == true) {
            System.out.println("Left neighbour is true!");
         } else {
            System.out.println("Left neighbour is false :(");
         }
      } else {
         System.out.println("No left neighbour");
      } 
      if (rn == true) {
         if (grid[row][col+1] == true) {
            System.out.println("Right neighbour is true!");
         } else {
            System.out.println("Right neighbour is false :(");
         }
      } else {
         System.out.println("No right neighbour");
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
      //QuickUnionUF uf = new QuickUnion(n);
      System.out.println("inside the Main method!");
      // call method to open sites
      for (int i=0; i<n; i++) {
         pc.open(n-1,i);
         System.out.println("~~~~~~~ We are at the ith entry~~~~~~~~" + i); 
      }
   }
}
