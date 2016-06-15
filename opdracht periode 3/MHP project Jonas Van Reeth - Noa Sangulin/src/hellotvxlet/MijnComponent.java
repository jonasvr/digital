/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hellotvxlet;

import org.havi.ui.HComponent;
import java.awt.*;
import org.dvb.ui.*;

/**
 *
 * @author student
 */
public class MijnComponent extends HComponent {
    
     Image schip;
     int schipx= 10, schipy=10;
     
     public void verplaats(int x , int y)
     {
         this.setBounds(x,y,schip.getWidth(this),schip.getHeight(this));
     }
    
    public MijnComponent(String bitmapnaam, int x, int y){
        
        schip =this.getToolkit().getImage(bitmapnaam);//bitmapnaam
        MediaTracker mt = new MediaTracker(this);
        mt.addImage(schip, 1);
        try {
            mt.waitForAll();
        }
        catch(Exception e){
            System.out.println(e.toString());
        }
        this.setBounds(x,y,schip.getWidth(this),schip.getHeight(this));
       
    }
    
    public void paint(Graphics g)
    {
       g.drawImage(schip, 0, 0, null);
    }

}
