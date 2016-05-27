 import java.lang.*;

		/**
        * @author Jonas Van Reeth
        * @version 1.5
        */
	public class ZesdeOef{

		/**
		 * Dit is de main functie, hier start het programma
		 * @param args Dit is een parameter die kan meegegeven worden via de commandline
		 */

	public static void main(String args[])
	{
		for (int getal=3;getal<100;getal++)
		{
		boolean ispriem=true;
		for (int deler=2;deler<getal;deler++)
		{
		if (getal % deler==0)	//rest is 0, dus geen priem!
			{
			ispriem=false;
			}
		}
		if (ispriem==true) System.out.println(getal +" is een priemgetal");
		}
	}
	}
