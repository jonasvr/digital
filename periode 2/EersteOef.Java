import java.lang.*;

		/**
                 * De klasse EersteProg is een java applicatie
                 *
                 * @author Jonas Van Reeth
                 * @version 1.5
                 */
	public class EersteOef{

		/**
		 * Dit is de main functie, hier start het programma
		 * @param args Dit is een parameter die kan meegegeven worden via de commandline
		 */

		public static void main(String args[])
		{
		drukaf(100);
		}

		/**
		 * Deze methode drukt getallen af tot een bepaald getal
		 * @param m Dit is de waarde tot waar getallen afgedrukt worden
		 */
		public static void drukaf(int m)
		{
		int a;
		for (a=0;a<m;a++)
			{
			System.out.println(a);
			}
		}

	}
