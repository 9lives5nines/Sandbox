import java.math.*;
import java.util.*;
class Fibrary
{
   public static void main (String [] args) throws Exception
   {
      long [] f = new Fib().f;
      Scanner in = new Scanner (System.in);
      String read;
      long s;
      
      while (true)
      {
         try
         {  
            read = in.nextLine();
            s = Long.parseLong(read);
         }
         catch (Exception e)
         {
            break;
         }
         
         int pos = 45;
         String out = "";
         
         if (s == 0){ System.out.println("0"); continue;}
         
         while (s < f[pos]) pos--;
         
         while (pos > -1)
         {
            if      (s >= f[pos])         {s-=f[pos]; out = out + "1"; pos--;}
            else if (s <  f[pos])         {           out = out + "0"; pos--;}
         }
         System.out.println(out);
      }
   }
}
class Fib
{
   int n = 46;
   long [] f = new long [n];
   
   public Fib()
   {
      fibG();
   }
   public long [] fibG()
   {
      f[0] = 1;
      f[1] = 2;
      for (int i = 2; i < n; i++)
      {
         f[i] = f[i-1] + f[i-2];
      } 
      return f;

   }
   public String toString()
   {
      String s = "";
      for (int i = 0; i < f.length; i++)
         s += f[i] + " ";
      return s;
   }
}
