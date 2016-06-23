/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hellotvxlet;
import java.awt.*;
import org.dvb.ui.*;
import java.awt.*;
import org.dvb.ui.*;
import org.havi.ui.*;
import java.lang.Object;


/**
 *
 * @author student
 */
public class PlatformBlock extends Sprite {
    
//   private int _posX;
//   private int _posY;
//   private int _width;
//   private int _height;
//   private Image _image;
//   
//   private MediaTracker mtrack; 
   
   public PlatformBlock(String initBitmapNaam, int initXPos, int initYPos, int initWidth, int initHeight, int initVelocityX )
   {
//         _posX = initXPos;
//         _posY = initYPos;
//         _width = initWidth;
//         _height = initHeight;
//         
//         _image = this.getToolkit().getImage(initBitmapNaam);
//         mtrack = new MediaTracker(this);
//         mtrack.addImage(_image, 0);
//       
//        try
//        {
//            mtrack.waitForAll(); //wacht tot alle bitmaps geladen zijn
//        }
//        catch (Exception e)
//        {
//            e.printStackTrace();
//        }
//        
//        this.setBounds(_posX, _posY, _width, _height);
       
        super(initBitmapNaam, initXPos, initYPos, initWidth, initHeight, initVelocityX);
   }
   
//    public void paint (Graphics g)
//    {
//        g.drawImage(_image, 0, 0, this);
//    }
}
