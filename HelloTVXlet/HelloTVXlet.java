package hellotvxlet;

import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.tv.xlet.*;
import org.dvb.ui.DVBColor;
import org.havi.ui.HScene;
import org.havi.ui.HSceneFactory;
import org.havi.ui.HStaticText;
import org.havi.ui.HTextButton;
import org.havi.ui.HVisible;
import org.havi.ui.event.HActionListener;


public class HelloTVXlet implements Xlet, HActionListener {
//HActionListener nodig als je ergens op wilt klikken
        HScene scene;
        HTextButton button1;
  
    public HelloTVXlet() {
        
    }

    public void initXlet(XletContext context) {
     scene = HSceneFactory.getInstance().getDefaultHScene();
     
    }

    public void startXlet() {
        System.out.println("StartXlet");
        HStaticText label = new HStaticText("HELLO", 300, 100, 100, 50);
        //maakt textbox label met x, y, hoogte en breedte
        
        label.setBackgroundMode(HVisible.BACKGROUND_FILL); //vult de achtergrond en maakt zichbaar
        label.setBackground(Color.CYAN); //achtergrondkleur aanpassen
        
        button1 = new HTextButton("BUTTON1", 100, 200, 100, 50);///maakt button aan
        HTextButton button2 = new HTextButton("BUTTON2", 100, 300, 100, 50);
            
        scene.add(button1);//zet button op scene
        scene.add(button2);
        
        button1.setFocusTraversal(null, button2, null, button1);//wisselen tussen buttons met pijltjes, links, onder, rechts, boven
        button2.setFocusTraversal(null, button1, null, button2);
       
        button1.setBackgroundMode(HVisible.BACKGROUND_FILL);//vullen van achtergrond
        button1.setBackground(new DVBColor(63,63, 0, 127)); //rgb waarden, alpha
        
        button1.setActionCommand("button1klik");
        button1.addHActionListener(this);
        
        scene.add(label);
        scene.validate();//werkt zoals paint methode
        scene.setVisible(true);
        button1.requestFocus(); //zet focus op button1
    }

    public void pauseXlet() {
     
    }

    public void destroyXlet(boolean unconditional) {
     
    }

    public void actionPerformed(ActionEvent event) {
        System.out.println(event.getActionCommand());
        if (event.getActionCommand().equals("button1klik"))//als tekst gelijk aan
        {
            button1.setBackground(Color.BLUE);
            scene.repaint(); //herpainten
        }
    }
}
