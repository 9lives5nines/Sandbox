//Quick Relax
/////////////////////////////////////////////////////////////////////
import java.io.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;
/////////////////////////////////////////////////////////////////////
class qrelax
{
//-------------------------------------------------------------------
   public static void main (String [] args) throws Exception
   {
      int [][] image = {{0,1,1,0,1,0,1,1,1,0},
                        {0,0,1,0,0,1,1,0,1,0},
                        {0,1,1,0,1,0,1,1,0,0},
                        {0,0,1,0,0,1,0,1,1,0},
                        {0,1,1,1,0,1,0,1,0,0},
                        {1,0,0,0,0,1,1,1,0,0},
                        {0,1,0,1,0,0,0,1,1,1}};
      print(relax(image));
   }
//-------------------------------------------------------------------
   public static double[][] relax (int [][] matrix)
   {
      int H = matrix[0].length;
      int W = matrix.length;

      int [][] oGrid = pad(matrix,3);
      double [][] mGrid = new double [W+1][H+1];
      double [][] outGrid = new double[W][H];
      double s1 = 0;
      double a = 0;
      double b = 0;
      double c = 0;
      double m = 0;
      double conf0 = 0;
      double conf1 = 0;
      double conf2 = 0;
      double conf3 = 0;
      double maxc = 0;
      double max = 0;
      
      //Loop through the image
      for ( int y = 1; y < H+1; y++)
      {
         for ( int x = 1; x < W+1; x++)
         {
         // Calculate each mask
         s1 = Math.pow(oGrid[x+1][y]-oGrid[x][y],2)
            + Math.pow(oGrid[x][y+1]-oGrid[x][y],2);

         s1 = s1/1.414;
               
         mGrid[x-1][y-1] = s1;
       }
      }      
      for ( int y = 1; y < H; y++)
      {
         for ( int x = 1; x < W; x++)
         {
            // Calculate each mask
            a = mGrid[x][y];
            b = mGrid[x-1][y+1];
            c = mGrid[x+1][y+1];
            m = Math.max(Math.max(a,b),c);

            conf0 = (m-a)*(m-b)*(m-c);
            maxc = conf0;
            max = 0;
            
            conf1 = a*(m-b)*(m-c);
            if ( maxc < conf1 )
            {
               maxc = conf1; max = 1;
            }
            conf2 = a*b*(m-c);
            if ( maxc < conf2 )
            {
               maxc = conf2; max = 2;
            }
            conf3 = a*b*c;
            if ( maxc < conf3 )
            {
               maxc = conf3; max = 3;
            }
               
            outGrid[x-1][y-1] = max;
         }
      }

      return outGrid;
   }
//-------------------------------------------------------------------
   public static int[][] pad (int [][] matrix, int mask)
   {
      int pad = (mask-1)/2;
      int W = matrix.length + (mask-1);
      int H = matrix[0].length + (mask-1);
      int [][] modM = new int [W][H];

      for (int x = pad; x < W-pad; x++)
      {
         for (int y = pad; y < H-pad; y++)
         {
            modM[x][y] = matrix[x-pad][y-pad];
         }
      }

      //Copy right/left nieghbors
      int x1 = pad-1;
      int x2 = W-pad;

      for ( int i = 0; i < pad; i++)
      {
         for ( int y = pad; y < H; y++)
         {
            modM[x1][y] = modM[x1+1][y];
            modM[x2][y] = modM[x2-1][y];
         }
         x1--;
         x2++;
      }

      //Copy Top/Bottom Neighbors
      int y1 = pad-1;
      int y2 = H-pad;

      for ( int i = 0; i < pad; i++)
      {
         for ( int x = 0; x < W; x++)
         {
            modM[x][y1] = modM[x][y1+1];
            modM[x][y2] = modM[x][y2-1];
         }
         y1--;
         y2++;
      }

      return modM;
   }
//-------------------------------------------------------------------
   public static int[][] depad (int [][] matrix, int mask)
   {
      int pad = (mask-1)/2;
      int W = matrix.length-(mask-1);
      int H = matrix[0].length-(mask-1);
      int [][] modM = new int [W][H];

      for (int x = 0; x < W; x++)
      {
         for (int y = 0; y < H; y++)
         {
            modM[x][y] = matrix[x+pad][y+pad];
         }
      }
      return modM;
   }
//-------------------------------------------------------------------
   public static void print (double [][] m)
   {
	  NumberFormat formatter = new DecimalFormat("#0.000");
      for ( int i = 0; i < m.length; i++)
      {
         for ( int j = 0; j < m[0].length; j++)
         {
			System.out.print(formatter.format(m[i][j]) + " ");
         }
         System.out.println();
      }
   }
//-------------------------------------------------------------------
}//end class relax
/////////////////////////////////////////////////////////////////////