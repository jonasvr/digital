/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hellotvxlet;

/**
 *
 * @author student
 */
public class CoinBlock extends Sprite
{
 
    private int _value = 1;
    private boolean _isCollected = false;
    
   public CoinBlock(String initBitmapNaam, int initXPos, int initYPos, int initWidth, int initHeight)
   {
          super(initBitmapNaam, initXPos, initYPos, initWidth, initHeight);  
   }
   
   public int getValue()
   {
       return this._value;
   }
   
   public boolean getIsCollected()
   {
       return this._isCollected;
   }
   
   public void setIsCollected(boolean initIsCollected)
   {
       this._isCollected = initIsCollected;
   }
 }
           
           


