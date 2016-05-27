 import java.lang.*;


        /**
        * @author Jonas Van Reeth
        * @version 1.5
        */
	public class TweedeOef{

		/**
		 * Dit is de main functie, hier start het programma
		 * @param args Dit is een parameter die kan meegegeven worden via de commandline
		 */

		public static void main(String args[])
		{
			int x,y;
			for ( x=0 ; x<=9 ; x++)
			{
				for ( y=0; y<=9 ; y++)
				{
				System.out.println(x + " x " + y +  " = " + x*y);
				}
			}
		}
	}
