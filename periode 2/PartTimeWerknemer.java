/** 
* @author Jonas Van Reeth
* @version 1.5
*/

public class PartTimeWerknemer extends Werknemer
{

	public int urenGewerkt;

	public PartTimeWerknemer(String voornaam, String achternaam, int nr, float sal, int urengw)
	{
	super(voornaam, achternaam, nr, sal);
	this.urenGewerkt=urengw;
	}

	public float getWeekLoon()
	{
	return this.salaris*this.urenGewerkt;
	}

	public void salarisVerhogen(int percentage)
	{
		if(percentage>5)
		{
		percentage=0;
		System.out.println("FOUT: slechts 5% opslag toegestaan");
		}
		else
		{
		super.salarisVerhogen(percentage);
		}
	}
}
