import java.util.*;
class Elevator
{
   public static void main (String [] args) throws Exception
   {
      Scanner in = new Scanner (System.in);         

         int f, start, dir;
         f = in.nextInt(); in.nextLine();
         start = in.nextInt(); dir = in.nextInt(); in.nextLine();
         E elevator = new E(f,start,dir);
         while (true)
         {
            try 
            {
               StringTokenizer s = new StringTokenizer(in.nextLine(), " ");
               while (s.hasMoreTokens())
               {
                  elevator.add(Integer.parseInt(s.nextToken()));
               }
               System.out.println(elevator.v);
               while (true)
               {
                  elevator.addQueue(in.nextLine());
               }

            }
            catch (Exception e)
            {
               elevator.go();
               break;
            }
         }
   }
}

class E
{
   TreeSet<Integer> v;
   int dir, current, f;
   ArrayList<TreeSet<Integer>> queue = new ArrayList<TreeSet<Integer>>();
   String ud;
   
   public E (int f, int start, int dir)
   {
      v = new TreeSet<Integer>();
      this.current = start;
      this.dir = dir; 
      for (int i = 0; i < f; i++) queue.add(new TreeSet<Integer>()); 
      System.out.printf("start       @ %s ",start);
      System.out.println(getDir());
   }
   
   public String getDir()
   {
      if (dir == -1) return "down";
      else return "up";
   }
   public int getNext()
   {
      if (dir == -1)
      { 
         int next = current-1;
         while (next != 0)
         {
            if (v.contains(next)) return next;
            else next--;
         }
      }
      else
      {
         int next = current+1;
         while (next != f)
         {
            if (v.contains(next)) return next;
            else next++;
         }
      }
      return -1;
   }
   public void add(int n)
   {
      v.add(n);
   }
   public void leaving(int next)
   {
      System.out.println();
   }
   public void addQueue (String in)
   {  
      StringTokenizer s = new StringTokenizer(in," ");
      int floor = Integer.parseInt(s.nextToken());
      floor--;
      while(s.hasMoreTokens())
      {
         queue.get(floor).add(Integer.parseInt(s.nextToken()));
      }
      System.out.println(queue.get(floor));
   }
   public void go ()
   {
      int getNext = getNext();
      leaving(getNext);
   }
}