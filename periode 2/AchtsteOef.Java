import java.lang.*;
		/**
                 * De klasse EersteProg is een java applicatie
                 *
                 * @author Jonas Van Reeth
                 * @version 1.5
                 */
	public class AchtsteOef{

		/**
		 * Dit is de main functie, hier start het programma
		 * @param args Dit is een parameter die kan meegegeven worden via de commandline
		 */

		public static void main(String args[])
		{
		int a[]={12,34,56,78,123,234,99,88};
		int b[]=new int[a.length]; //maak een even grote array

		int i,j;

		int max=0 , plaats=0;
		for (j=0;j<b.length;j++)//vul nieuwe array op
		{
			max=0;
			for (i=0; i<a.length; i++)//zoek grootste element
			{
			if (a[i]>max) {max = a[i]; plaats=i;}
			}
		b[j]=max; a[plaats]=0;
		}

		//druk de array af
		for (i=0;i<b.length;i++)
		{
		System.out.println(b[i]);
		}
		}


	}
