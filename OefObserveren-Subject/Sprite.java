package hellotvxlet;

import org.havi.ui.HStaticIcon;

public abstract class Sprite extends HStaticIcon implements ObserverInterface{//extends/implements hetzelfde maar 1 voor class ander voor interface
    //abstract maakt geen objecten van sprite
    public Sprite(int x, int y)//geef x en y pos mee
    {
        super(); //constructor superklasse aanroepen
        this.setLocation(x, y);
        this.setSize(50, 50);
    }
}
