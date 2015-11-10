import java.util.*;
class quodigious
{
   public static void main (String [] args) throws Exception
   {
      Scanner sc = new Scanner (System.in);
      String [] test = (sc.nextLine()).split(" ");
      System.out.println();
      int [] in = new int [test.length];
      for ( int i = 0; i< test.length; i++) in[i] = Integer.parseInt(test[i]);
      quodigious (in);
   }
   public static int quodigious (int [] in) throws Exception
   {
      int sum =0;
      int pow = 0;
      int product = 1;
      boolean flag = true;

      for (int i = 0; i < in.length; i++)
      {
         if(in[i]==1) pow = 0;
         else pow = (int)Math.pow(10,in[i]-1);
         int x = 2+ pow;
         String test = x+"";

         while(test.length()<=in[i])
         {
            test = x+"";
            sum =0; product=1; flag = true;

            for ( int j = 0; j<test.length(); j++)
            {
               if(test.charAt(j)=='0' || test.charAt(j)=='1')
               {
                  flag = false;
                  break;
               }
            }

            if (flag)
            {
               for ( int j = 0; j<test.length(); j++)
               {
                  sum += Integer.parseInt(test.charAt(j)+"");
                  product *= Integer.parseInt(test.charAt(j)+"");
               }
               if((x%sum==0) && (x%product==0)) System.out.println(x);
            }
            x++;
         }
         System.out.println();
      }
      return 0;
   }
}