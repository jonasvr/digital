 import java.lang.*;

		/**
                 * De klasse EersteProg is een java applicatie
                 *
                 * @author Jonas Van Reeth
                 * @version 1.5
                 */
	public class EersteProg{

		/**
		 * Dit is de main functie, hier start het programma
		 * @param args Dit is een parameter die kan meegegeven worden via de commandline
		 */

	public static void main(String args[])
	{
	Werknemer jan = new Werknemer("jan", "janssens", 1, 900.0f );
	Werknemer herman = new Werknemer("herman", "hermans", 4, 1200.0f );
	Werknemer els = new Werknemer("els", "de bolle", 3, 1700.0f );
	Werknemer ludo = new Werknemer("ludo", "lauwens", 2, 1500.0f );

	jan.salarisVerhogen(10);
	herman.salarisVerhogen(10);

	PartTimeWerknemer frans = new PartTimeWerknemer("frans", "franssens", 5,15.0f,20);
	PartTimeWerknemer ivo = new PartTimeWerknemer("jos", "de man", 8,12.0f, 26);

	frans.salarisVerhogen(7);
	ivo.salarisVerhogen(4);

	System.out.println(jan.voornaam + " verdient " + jan.getSalaris());
	System.out.println(herman.voornaam + " verdient " + herman.getSalaris());
	System.out.println(els.voornaam + " verdient " + els.getSalaris());
	System.out.println(ludo.voornaam+ " verdient " + ludo.getSalaris());
	System.out.println(frans.voornaam+ " verdient "+ frans.getSalaris());
	System.out.println(ivo.voornaam+ " verdient " + ivo.getSalaris());
	}
	}
