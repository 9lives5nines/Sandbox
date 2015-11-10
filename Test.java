import java.io.*;
/////////////////////////////////////////////////////////////////////
class Test
{        
//-------------------------------------------------------------------
   public static void main (String [] args) throws Exception
   {
      System.out.println("Crunching...");
      ProcessBuilder p = new ProcessBuilder("crunch.exe", "-file", "lena.tga" );
      p.redirectOutput(new File("output.txt"));
      final Process process = p.start();
      
      final int processStatus = process.waitFor();
      System.out.println("Done Crunching.");
   }
//-------------------------------------------------------------------
}//end class Test
/////////////////////////////////////////////////////////////////////