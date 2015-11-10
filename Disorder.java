import java.util.Scanner;
import java.util.ArrayList;
class Disorder
{
   public static void main (String [] args) throws Exception
   {
      Scanner in = new Scanner (System.in);
      String read = "";
      ArrayList<String> dict = new ArrayList<String>();
      ArrayList<String> lex  = new ArrayList<String>();
      
      while (true)
      {
         try
         {  
            if(!in.hasNext()) System.exit(0);
         }
         catch (Exception e)
         {
            break;
         }
         
         while (in.hasNext())
         {
            read = in.nextLine();
            if (read.equals("")) break;
            addD(read, dict);
            addL(read, lex);
         }

         diff(dict, lex);

         dict.clear(); lex.clear();
      }
   }
   public static void addD(String s, ArrayList<String> dict)
   {
      if (dict.size() == 0) {dict.add(s); return;}
      if (dict.size() == 1)
      { 
         if ( s.compareTo(dict.get(0)) > 0) dict.add(s);
         else dict.add(0, s);
         return;
      }
      
      if ( s.compareTo(dict.get(0)) < 0 ){ dict.add(0,s); return; }
      
      for ( int i = 0; i < dict.size()-1; i++)
      {
         if (s.compareTo(dict.get(i)) >= 0 && s.compareTo(dict.get(i+1)) < 0)
         {
            dict.add(i+1, s); return;
         }
      }
      
      dict.add(s);
      
   }
   
   public static void addL(String s, ArrayList<String> lex)
   {
      if (lex.size() == 0) {lex.add(s); return;}
      if (lex.size() == 1)
      {
         if ( s.length() > lex.get(0).length() ) {lex.add(s); return;}
         else if ( s.length() < lex.get(0).length() ) {lex.add(0, s); return;}
         else if ( s.compareTo(lex.get(0)) < 0) {lex.add(0,s); return;}
         else {lex.add(s); return;}
      }
      
      for ( int i = 0; i < lex.size(); i++)
      {
         if ( s.length() < lex.get(i).length()) {lex.add(i, s); return;}
         if ( s.length() == lex.get(i).length())
         {
            if ( s.compareTo(lex.get(i)) < 0 )
            {
               lex.add(i, s); return;
            }
         }
      }
      lex.add(s);
      
   }
   public static void diff (ArrayList<String> dict, ArrayList<String> lex)
   {
      int total = 0;
      for ( int i = 0; i < dict.size(); i++)
      {
         for ( int j = 0; j < lex.size(); j++)
         {
            if ( dict.get(i).equals(lex.get(j)))
            {
               total += Math.abs(i-j);
            }
         }
      }
      System.out.println(total);
   }
}
