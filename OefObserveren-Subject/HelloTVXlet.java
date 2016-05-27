package hellotvxlet;

import java.awt.event.KeyEvent;
import java.util.Timer;
import javax.tv.xlet.Xlet;
import javax.tv.xlet.XletContext;
import javax.tv.xlet.XletStateChangeException;
import org.bluray.ui.event.HRcEvent;
import org.dvb.event.EventManager;
import org.dvb.event.UserEvent;
import org.dvb.event.UserEventListener;
import org.dvb.event.UserEventRepository;
import org.havi.ui.HScene;
import org.havi.ui.HSceneFactory;

public class HelloTVXlet implements Xlet, UserEventListener
{
    static HScene scene = null;
    static Subject publisher = null;
    Player p1;
    
    public static HScene getScene()
    {
        return scene;
    }
    public static Subject getPublisher()
    {
        return publisher;
    }
    
    public void destroyXlet(boolean unconditional) {
        
    }

    public void initXlet(XletContext ctx) {
        scene = HSceneFactory.getInstance().getDefaultHScene();
        p1 = new Player(400,500);
        EnemyRocket s2= new EnemyRocket(100,200);
        scene.add(s2); //zet s2 op de scene
        scene.add(p1);
        
        publisher = new Subject();
        Timer tim1 = new Timer();
        tim1.scheduleAtFixedRate(publisher, 0, 10); //elke 10 ms
        
        for(int x = 0; x< 10;x++)
            for(int y=0; y<5;y++)
            {
                Enemy e=new Enemy(x*50, y*50);
                scene.add(e);
                publisher.register(e);
            }
       
        publisher.register(s2);
        publisher.register(p1);
        
        scene.validate();
        scene.setVisible(true);
    }

    public void pauseXlet() {
        
    }

    public void startXlet() throws XletStateChangeException {
       UserEventRepository rep = new UserEventRepository("naam");
       rep.addAllArrowKeys(); //alle pijlti-jes toevoegen
       EventManager m=EventManager.getInstance(); 
       m.addUserEventListener(this,rep); // stuur event this voor alle knoppen in rep  
    }
    
    public void userEventReceived(UserEvent e) {
        if(e.getType()==KeyEvent.KEY_PRESSED && e.getCode()==HRcEvent.VK_LEFT)
        {
        p1.moveleft();
        } 
        else if(e.getType()==KeyEvent.KEY_PRESSED && e.getCode()==HRcEvent.VK_RIGHT)
        {
        p1.moveright();
        }
        else if(e.getType()==KeyEvent.KEY_PRESSED && e.getCode()==HRcEvent.VK_UP)
        {
        p1.moveup();
        } 
        else if(e.getType()==KeyEvent.KEY_PRESSED && e.getCode()==HRcEvent.VK_DOWN)
        {
        p1.movedown();
        }
    }
}