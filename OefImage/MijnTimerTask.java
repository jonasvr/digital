package hellotvxlet;

import java.util.TimerTask;

public class MijnTimerTask extends TimerTask{
    
    HelloTVXlet xlet; //link naar een HelloTVXLet, want ge hebt in MijnTimerTask geen toegang tot mijncomponent, ge kunt wel dinges afdrukke, maar voor de rest niks
    
    public MijnTimerTask(HelloTVXlet x) 
    {
    xlet = x;    
    }
    
    public void run()
    {
    System.out.println("tick...");
    xlet.callback();
    }
}
