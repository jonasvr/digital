package hellotvxlet;

import java.awt.event.KeyEvent;
import java.util.Timer;
import javax.tv.xlet.Xlet;
import javax.tv.xlet.XletContext;
import javax.tv.xlet.XletStateChangeException;
import org.dvb.event.EventManager;
import org.dvb.event.UserEvent;
import org.dvb.event.UserEventListener;
import org.dvb.event.UserEventRepository;
import org.havi.ui.HScene;
import org.havi.ui.HSceneFactory;
import org.havi.ui.event.HRcEvent;

public class HelloTVXlet implements Xlet, UserEventListener
{
HScene scene;
MijnComponent mc=new MijnComponent(0,0,720,576);

    public void destroyXlet(boolean unconditional) {
  
    }

    public void initXlet(XletContext ctx)
    {
        scene=HSceneFactory.getInstance().getDefaultHScene();
        //MijnComponent mc=new MijnComponent(0,0,720,576);
        scene.add(mc);
        
        scene.validate();
        scene.setVisible(true);
    }

    public void callback() //blijven oproepen
    {
    mc.scroll();
    }
    
    
    public void pauseXlet() {
    
    }

    public void startXlet() throws XletStateChangeException {
       UserEventRepository rep = new UserEventRepository("naam");
       rep.addAllArrowKeys(); //alle pijlti-jes toevoegen
       EventManager m=EventManager.getInstance(); 
       m.addUserEventListener(this,rep); // stuur event this voor alle knoppen in rep
       
       MijnTimerTask objMijnTimerTask = new MijnTimerTask(this);
       Timer t=new Timer();
       t.scheduleAtFixedRate(objMijnTimerTask, 0, 500); //start op 0 ms, elke 5 ms
       
    }

    public void userEventReceived(UserEvent e) {
     //  System.out.println(e.toString()); //test of key wordt geprint
        if(e.getType()==KeyEvent.KEY_PRESSED && e.getCode()==HRcEvent.VK_LEFT)
        {
        mc.moveleft();
       //   System.out.println("Left pressed");
        } 
        else if(e.getType()==KeyEvent.KEY_PRESSED && e.getCode()==HRcEvent.VK_RIGHT)
        {
        mc.moveright();
      //  System.out.println("Right pressed");
        }
        else if(e.getType()==KeyEvent.KEY_PRESSED && e.getCode()==HRcEvent.VK_UP)
        {
        mc.moveup();
       // System.out.println("Up pressed");
        } 
        else if(e.getType()==KeyEvent.KEY_PRESSED && e.getCode()==HRcEvent.VK_DOWN)
        {
        mc.movedown();
       // System.out.println("Down pressed");
        }
    }
}