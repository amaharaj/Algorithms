import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
   private int[] id; 
   private int site;
   private int nsites;
   private boolean isOpen;
   private boolean isFull;  
   private boolean percolates;

   public Percolation(int n)                // create n-by-n grid, with all sites blocked
   {
      site = n; 
      id = new int[n];
      for (int i = 0; i < n; i++)
         id[i] = i; 
   }
   // when an object's return type is void, nothing is returned 
   public    void open(int row, int col)    // open site (row, col) if it is not open already
   {
      System.out.println("Hello, World!");
   }
   public boolean isOpen(int row, int col)  // is site (row, col) open?
   {
      if (1 == 1) 
         isOpen = true; 
      
      else 
         isOpen = false; 
      
      return isOpen; 
   }
   public boolean isFull(int row, int col)  // is site (row, col) full?
   {
      if (1 == 1)   
         isFull = false;

      else 
         isFull = true;

      return isFull;
   }
   public     int numberOfOpenSites()       // number of open sites
   {
      nsites = 40; 
      return nsites; 
   }
   public boolean percolates()              // does the system percolate?
   {
      if (isFull == true) 
         percolates = false; 
      else 
         percolates = true; 
      return percolates;      
   }


   public static void main(String[] args)   // test client (optional)
   {
      System.out.println("Hello, World!");
   }
}
