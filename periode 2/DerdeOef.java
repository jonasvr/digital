 import java.lang.*;

		/**
                 * De klasse EersteProg is een java applicatie
                 *
                 * @author Jonas Van Reeth
                 * @version 1.5
                 */
	public class DerdeOef{

		/**
		 * Dit is de main functie, hier start het programma
		 * @param args Dit is een parameter die kan meegegeven worden via de commandline
		 */

		public static void main(String args[])
		{
			int dag,weekdag=0;
			for (dag=1;dag<=28;dag++)
			{
			if(weekdag==0) System.out.println("zondag ");
			if(weekdag==1) System.out.println("maandag ");
			if(weekdag==2) System.out.println("dinsdag ");
			if(weekdag==3) System.out.println("woensdag ");
			if(weekdag==4) System.out.println("dondedag ");
			if(weekdag==5) System.out.println("vrijdag ");
			if(weekdag==6) System.out.println("zaterdag ");


			weekdag++;
			if(weekdag>6) weekdag=0;
			System.out.println( dag+ " februari 2009");
			}
		}
	}
