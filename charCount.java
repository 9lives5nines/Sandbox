import java.io.*;
import java.util.*;
/////////////////////////////////////////////////////////////////////
class charCount
{
//-------------------------------------------------------------------
   public static void main (String args[]) throws Exception
   {
      int [] count = new int [256];
      for (int j = 0; j < count.length; j++)
      {
         count[j] = 0;
      }
      
      int i = 0;
      FileInputStream fi = new FileInputStream(new File(args[0]));
      
      for (int c; (c = fi.read()) != -1; i++)
      {
         count[c]++;
      }
      
      for ( int j = 0; j < count.length; j++)
      {
         System.out.println(j + ":" + count[j]);
      }
      System.out.println("Total: " + i );

   }
//-------------------------------------------------------------------

}//end class charCount
/////////////////////////////////////////////////////////////////////
