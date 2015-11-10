//Written by Diana Arrieta
import java.util.Scanner;
import java.util.StringTokenizer;
class Vote
{
//-------------------------------------------------------------------
	public static void main (String [] args) throws Exception
	{
		Scanner sc = new Scanner (System.in);
		int n = sc.nextInt(); sc.nextLine();
		int n1, n2, n3;
		StringTokenizer s;
		String s1, s2, s3;
		while(true)
		{	try{
				s = new StringTokenizer(sc.nextLine()," ");
				s1 = s.nextToken();
			   s2 = s.nextToken();
				s3 = s.nextToken();
			}
			catch (Exception e) {break;}
				

			mod(n,Integer.parseInt(s1),s2,s3);
		}
	}
//-------------------------------------------------------------------
	public static void mod (int n, int index, String cip, String key)
	{
		String s1 = "";
		int k = 0;
		for (int i =0; i < key.length(); i++)
		{
			k = Integer.parseInt(cip.substring(i,i+1))+
			    Integer.parseInt(key.substring(i,i+1));
		   k = k%10;
		   s1 += k+"";
		}
		
		System.out.println("plaintext ballot: "  + s1 + "  index: " + index +
		                   "  vote for candidate: "+ s1.charAt(index-1));
	}
//-------------------------------------------------------------------
}//end class Vote
