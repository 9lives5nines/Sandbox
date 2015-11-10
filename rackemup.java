import java.util.*;
class rackemup
{
   public static void main (String [] args) throws Exception
   {

   	Scanner sc = new Scanner (System.in);
   	String [] test = sc.nextLine().split(" ");
   	int [] in = new int [test.length];

   	for ( int i = 0; i < test.length; i++)
   	{
   		in[i]=Integer.parseInt(test[i]);
		}

		int [] si = new int [10];
		int pi = 0;
		int j =0;
		int sum = 0;

		for ( int i = 0; i < si.length; i++)
		{
			if(in[j]==10 && i>=2)
			{
				si[i]=in[j]+si[i-1]+si[i-2];
				j++;
			}
			else if(in[j]==10 && i == 0)
			{
				si[i]=in[j];
				j++;
			}
			else if(in[j]==10 && i==1)
			{
				si[i]=in[j]+si[i-1];
				j++;
			}
			else if((in[j]+in[j+1])==10 && i>=1)
			{
				si[i]=in[j]+in[j+1]+si[i-1];
				j++; j++;
			}
			else {si[i] = in[j]+in[j+1]; j++; j++;}
		}
		for ( int i = 0; i < si.length; i++) sum += si[i];
		for ( int i = 0; i < si.length; i++) System.out.printf("%5d",si[i]);
		System.out.print(" = "); System.out.printf("%5d",sum);
   }
}