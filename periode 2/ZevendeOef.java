 import java.lang.*;

		/**
                 * De klasse EersteProg is een java applicatie
                 *
                 * @author Jonas Van Reeth
                 * @version 1.5
                 */
	public class ZevendeOef{

		/**
		 * Dit is de main functie, hier start het programma
		 * @param args Dit is een parameter die kan meegegeven worden via de commandline
		 */

	public static void main(String args[])
	{
		int a[]={12,34,56,78,123,234,99,88};

		int i;
		int max = 0;
		for(i=0;i<a.length;i++)
		{
		if(a[i]>max) {max=a[i];}
		}

		System.out.println("Max = "+max);
	}
	}
