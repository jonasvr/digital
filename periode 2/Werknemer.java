/** 
* @author Jonas Van Reeth
* @version 1.5
*/
public class Werknemer{

public String voornaam;
public String achternaam;
public int werknemerNummer;
protected float salaris;
private float RSZpercentage = 33.0f;

public Werknemer(String voornaam, String achternaam, int wNummer, float sal)
	{
	werknemerNummer=wNummer;
	this.voornaam=voornaam;
	this.achternaam=achternaam;
	salaris=sal;
	}

	public void salarisVerhogen(int percentage)
	{
	salaris=salaris+salaris*(percentage/100.0);
	}

	public float getSalaris()
	{
		return salaris;
	}

	public void setRSZ(float rsz)
	{
	RSZpercentage=rsz;
	}

	public float getRSZ()
	{
	return RSZpercentage;
	}
}
