package hellotvxlet;

import java.awt.event.ActionEvent;
import javax.tv.xlet.*;
import org.havi.ui.HScene;
import org.havi.ui.HSceneFactory;


public class HelloTVXlet implements Xlet {
  
    HScene scene;
    public HelloTVXlet() {
        
    }

    public void initXlet(XletContext context) {
        scene = HSceneFactory.getInstance().getDefaultHScene();
        
        MijnComponent mc=new MijnComponent(0, 0, 720, 576);
        MijnComponent mcOef2=new MijnComponent(300, 300, 200, 200);
        
        scene.add(mc);
     //   scene.add(mcOef2);
        
        scene.validate();
        scene.setVisible(true);
    }

    public void startXlet() {
      
    }

    public void pauseXlet() {
     
    }

    public void destroyXlet(boolean unconditional) {
     
    }

    public void actionPerformed(ActionEvent event) {
    }
}
