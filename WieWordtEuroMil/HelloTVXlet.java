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

        HScene scene;
        HTextButton button1;
        HTextButton button2;
        HTextButton button3;
        HTextButton button4;
        HTextButton buttonHulp;
  
    public HelloTVXlet() {
        
    }

    public void initXlet(XletContext context) {
     scene = HSceneFactory.getInstance().getDefaultHScene();
     
    }

    public void startXlet() {
        System.out.println("StartXlet");
        HStaticText label = new HStaticText("Wie is Jeff?", 25, 300, 675, 100);
        //maakt textbox label met x, y, hoogte en breedte
        
        label.setBackgroundMode(HVisible.BACKGROUND_FILL);
        label.setBackground(new DVBColor(0,0, 255, 200));
        
        button1 = new HTextButton("Jeff", 25, 410, 325, 50);///maakt button aan
        button2 = new HTextButton("Een Monster", 375, 410, 325, 50);
        button3 = new HTextButton("Niemand", 25, 475, 325, 50);
        button4 = new HTextButton("De slimste mens", 375, 475, 325, 50);
        buttonHulp = new HTextButton("Hulplijn", 375, 10, 325, 50);
            
        scene.add(button1);//zet button op scene
        scene.add(button2);
        scene.add(button3);
        scene.add(button4);
        scene.add(buttonHulp);
        
        button1.setFocusTraversal(buttonHulp, button3, null, button2);//wisselen tussen buttons met pijltjes, up down left right
        button2.setFocusTraversal(buttonHulp, button4, button1, null);
        button3.setFocusTraversal(button1, null, null, button4);
        button4.setFocusTraversal(button2, null, button3, null);
        buttonHulp.setFocusTraversal(null, button1, null, null);

        button1.setBackgroundMode(HVisible.BACKGROUND_FILL);//vullen van achtergrond
        button1.setBackground(new DVBColor(0,0, 255, 255)); //rgb waarden, alpha
        button2.setBackgroundMode(HVisible.BACKGROUND_FILL);//vullen van achtergrond
        button2.setBackground(new DVBColor(0,0, 255, 255)); //rgb waarden, alpha
        button3.setBackgroundMode(HVisible.BACKGROUND_FILL);//vullen van achtergrond
        button3.setBackground(new DVBColor(0,0, 255, 255)); //rgb waarden, alpha
        button4.setBackgroundMode(HVisible.BACKGROUND_FILL);//vullen van achtergrond
        button4.setBackground(new DVBColor(0,0, 255, 255)); //rgb waarden, alpha
        buttonHulp.setBackgroundMode(HVisible.BACKGROUND_FILL);//vullen van achtergrond
        buttonHulp.setBackground(new DVBColor(0,0, 255, 255)); //rgb waarden, alpha
       
        button1.addHActionListener(this);
        
        button2.setActionCommand("fout2klik");
        button2.addHActionListener(this);
        
        button3.setActionCommand("fout3klik");
        button3.addHActionListener(this);
        
        button4.setActionCommand("fout4klik");
        button4.addHActionListener(this);
        
        buttonHulp.setActionCommand("Hulp");
        buttonHulp.addHActionListener(this);
        
        scene.add(label);
        scene.validate();
        scene.setVisible(true);
        button1.requestFocus(); //zet focus op button1
    }

    public void pauseXlet() {
     
    }

    public void destroyXlet(boolean unconditional) {
     
    }

    public void actionPerformed(ActionEvent event) {
        System.out.println(event.getActionCommand());
        if (event.getActionCommand().equals("fout2klik"))
        {
            button2.setBackground(Color.RED);
        }
        if (event.getActionCommand().equals("fout3klik"))
        {
            button3.setBackground(Color.RED);
        }
        if (event.getActionCommand().equals("fout4klik"))
        {
            button4.setBackground(Color.RED);
        }
        if (event.getActionCommand().equals("Hulp"))
        {
            scene.remove(button4);
            scene.remove(button2);
        }
        
        button1.setBackground(Color.GREEN);
        scene.repaint();
    }
}
