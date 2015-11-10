//Written by Diana Arrieta
import java.util.Scanner;
import java.util.LinkedList;
class TI
{
//-------------------------------------------------------------------
	public static void main (String [] args) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		LinkedList<Time> set = new LinkedList<Time>();
		String in = sc.nextLine();
		while(in != "")
		{
			Time t = new Time(in);
			add(t,set);
			try
			{
				in = sc.nextLine();
			}
			catch(Exception e){break;}
		}
		for(int i = 0; i<set.size(); i++)
		{
			System.out.println(set.get(i));
		}
	}
//-------------------------------------------------------------------
	public static void add (Time in, LinkedList<Time> list)
	{
		if(list.isEmpty()) {list.add(in); return;}
		else
		{
			for (int i = 0; i < list.size(); i++)
			{
				if(in.LT(list.get(i))==0){list.add(i,in); return;}
				else if(in.LT(list.get(i))==2)
				{
	   		   if(in.AP(list.get(i))<0) {list.add(i,in); return;}
		      }
			}
		}
		list.add(in);
	}
//-------------------------------------------------------------------
}//end class TI
class Time
{
	int h,m,s,ho,mo,h2,m2;
	String st;
	char pm;
//-------------------------------------------------------------------
	public Time (String in)
	{
		this.st = in;
	   this.h = Integer.parseInt(in.substring(0,2));
	   this.m = Integer.parseInt(in.substring(3,5));	
	   this.s = Integer.parseInt(in.substring(6,8));
	   this.pm = in.charAt(9);
	   this.ho  = Integer.parseInt(in.substring(10,12));
	   this.mo  = Integer.parseInt(in.substring(12,14));
		if(pm == '+')
		{
		   this.h2 = h - ho; this.m2 = m - mo;
			if(this.h2<0) {}
			if(this.m2<0) {this.h2--; this.m2+=60;}
		}
		else
		{
		   this.h2 = h + ho; this.m2 = m + mo;
			if(this.m2>60){this.h2 += 1; this.m2 = this.m2-60;}
			if(this.h2>24){}
	   }
		System.out.println(h2+":"+m2+":"+s);
	}
//-------------------------------------------------------------------
	public int LT(Time in)
	{
	   if(this.h2< in.h2) return 0;
		else if(this.h2==in.h2 && this.m2 < in.m2) return 0;
		else if(this.h2==in.h2 && this.m2==in.m2 && this.s<in.s) return 0;
		else if(this.h2==in.h2 && this.m2==in.m2 && this.s==in.s)return 2;
		else return 1;
	}
//-------------------------------------------------------------------
	public int AP(Time in)
	{
		return this.st.compareTo(in.st);
	}
//-------------------------------------------------------------------
	public String toString()
	{
		String s1 = "";
		
		if((h+"").length()==1) s1+="0"+h;
		else s1+= h+"";
		s1 += ":";
		if((m+"").length()==1) s1+="0"+m;
		else s1+= m+"";
		s1+=":";
		if((s+"").length()==1) s1+="0"+s;
		else s1+= s+"";
		
		s1+= " "+st.charAt(9);
		
		if((ho+"").length()==1) s1+="0"+ho;
		else s1+= ho+"";
		
		if((mo+"").length()==1) s1+="0"+mo; 
		else s1 += mo+"";
		
		return s1;
	}
//-------------------------------------------------------------------
}//end class Time
