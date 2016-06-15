/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hellotvxlet;

import org.havi.ui.HComponent;
import java.awt.*;
import org.dvb.ui.*;
import org.havi.ui.*;
import java.lang.Object;

/**
 *
 * @author student
 */
public class Sprite extends HComponent{
    
    protected int _posX;
    protected int _posY;
    protected int _width;
    protected int _height;
    protected Image _image;
    protected Dimension _screenSize;
    private MediaTracker mtrack;    
    
    //Moving
    protected boolean _isMovingLeft;
    protected boolean _isMovingRight;
    protected int _velocityX;
    //private int _velocityX = 12;
    
    //setter
    public void setXPos(int initXPos) {
        this._posX = initXPos;
    }
    //setter
    public void setYPos(int initYpos) {
        this._posY = initYpos;
    }
    
    //colliding
    //private Rectangle _bottomRectangle;
    //private Rectangle _playerblockRectangle;
    
    //constructor voor playerblock en platformblock
//    public Sprite(String initBitmapNaam, int initXPos, int initYPos, int initWidth, int initHeight, int initVelocityX, Dimension initScreenSize){
     public Sprite(String initBitmapNaam, int initXPos, int initYPos, int initWidth, int initHeight, int initVelocityX ){
        
        _posX = initXPos;
        _posY = initYPos;
        _width = initWidth;
        _height = initHeight;
        _velocityX = initVelocityX;

        _image = this.getToolkit().getImage(initBitmapNaam);
        mtrack = new MediaTracker(this);
        mtrack.addImage(_image, 0);

        try {
            mtrack.waitForAll(); 
        //wacht tot alle bitmaps geladen zijn
        } catch (Exception e) {
            e.printStackTrace();
        }

        this.setBounds(_posX, _posY, _width, _height);
       
    }
    
    //constructor voor groundblock
    public Sprite(String initBitmapNaam, int initXPos, int initYPos, int initWidth, int initHeight) {

        _posX = initXPos;
        _posY = initYPos;
        _width = initWidth;
        _height = initHeight;

        _image = this.getToolkit().getImage(initBitmapNaam);
        mtrack = new MediaTracker(this);
        mtrack.addImage(_image, 0);

        try {
            mtrack.waitForAll();
        //wacht tot alle bitmaps geladen zijn
        } catch (Exception e) {
            e.printStackTrace();
        }

        this.setBounds(_posX, _posY, _width, _height);

    }
    
    public void paint(Graphics g)
    {
       g.drawImage(_image, 0, 0, null);
    }
    
    


}
