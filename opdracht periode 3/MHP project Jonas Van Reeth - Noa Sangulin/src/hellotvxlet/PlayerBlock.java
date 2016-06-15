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
public class PlayerBlock extends Sprite {
   
   //Falling 
   //Deze hoeven geen properties te hebben, want zijn enkel nodig voor PlayerBlock
   private boolean _isFalling = true;
   private int _velocityY = 20; //Hoe hard je naar beneden valt
   
   //Jump
   private boolean _isJumping = false;
   private boolean _isStartJumping = false;
   private int _jumpForce = 9;
   private int _isStartJumpForce = 9;
   
    //getter
    public boolean getIsMovingLeft() {
        return this._isMovingLeft;
    }
    //setter
    public void setIsMovingLeft(boolean initIsMovingLeft) {
        this._isMovingLeft = initIsMovingLeft;
        this._isMovingRight = false; //gn 2 toetsen tegelijk indrukken
    }
    //getter
    public boolean getIsMovingRight() {
        return this._isMovingRight;
    }
    //setter
    public void setIsMovingRight(boolean initIsMovingRight) {
        this._isMovingRight = initIsMovingRight;
        this._isMovingLeft = false; //gn 2 toetsen tegelijk indrukken
    }
   
   //getter
   public boolean getIsJumping()
   {
       return this._isJumping;
   }
   
   //setter
   public void setIsJumping(boolean initIsJumping)
   {
       this._isJumping = initIsJumping;
       //this._isFalling = false; //kan niet vallen terwijl hij springt
   }
   
   //getter
   public int getJumpforce()
   {
       return this._jumpForce;
   }
   
   //setter
   public void setJumpForce(int initJumpForce)
   {
       this._jumpForce = initJumpForce;
   }
   
   //getter
   public int getStartJumpforce()
   {
       return this._isStartJumpForce;
   }
   
   //getter
   public boolean getIsFalling()
   {
       return this._isFalling;
   }
   
   //setter
   public void setIsFalling(boolean initIsFalling)
   {
       this._isFalling = initIsFalling;
   }
   
    //getter
    public boolean getIsStartJumping() {
        return this._isStartJumping;
    }
    
    //setter
    public void setIsStartJumping(boolean initIsStartJumping) 
    {
        this._isStartJumping = initIsStartJumping;
    }
      
   public PlayerBlock(String initBitmapNaam, int initXPos, int initYPos, int initWidth, int initHeight, int initVelocityX )
   {
        super(initBitmapNaam, initXPos, initYPos, initWidth, initHeight, initVelocityX);
  
   }
   
   public void move()
   {
//       if (this.getIsBottomCollided())
//       {
//            System.out.println("bottom coll: " + this.getIsBottomCollided());
//       }
//       if (this.getIsTopCollided())
//       {
//            System.out.println("top coll: " + this.getIsTopCollided());
//       }
//
//       if (this.getIsLeftCollided())
//       {
//           System.out.println("left coll: " + this.getIsLeftCollided());
//       } 
//
//       if (this.getIsRightCollided())
//       {
//           System.out.println("right coll: " + this.getIsRightCollided());
//       }
//     
//  
//       
       //System.out.println("move");
       
        if (this._isMovingLeft == true)
        {
//            System.out.println("Playerblock is moving left.");
            this._posX -= this._velocityX; //Left
        }
        else if (this._isMovingRight == true)
        {
//            System.out.println("Playerblock is moving right.");
            this._posX += this._velocityX; //right
        }
       
        //hij valt altijd
        this._posY += this._velocityY;
        
        //vallen wordt tegengewerkt als hij springt
//        System.out.println("isjumping : " + this._isJumping);
//        System.out.println("isstartjumping : " + this._isStartJumping);
        if (this._isJumping == true || this._isStartJumping == true) //jumping
        {
            if (this._posY < this._posY + this._jumpForce && this._isFalling == false)
            {
//                System.out.println("jumping");
                this._posY -= this._velocityY;
                this._posY -= this._velocityY;
                this._jumpForce--;
                this._isStartJumping = true;
            }
            else
            {
                this._isFalling = true;
            }
        }

        
////        //tijdelijke oplossing voor implementatie van colliden
////        //als playerblock beneden komt, moet hij stoppen met vallen
////        /*if (this._posY >= this._screenSize.height - 150)
////        {
////            System.out.print("Playerblock stops falling.");
////            this._isFalling = false;
////            
////        }*/
////        
////               
////           /*
////            case 2:
////                this._posY -= this._jumpForce; //Up
////                break;
////            case 3:
////              
////                break;
////            case 4:
////                this._posY += this._jumpForce; //down
////                break;*/
////        
////        this.setBounds(this._posX, this._posY, _image.getWidth(this), _image.getHeight(this));
//    }
//    
//    
//   
   
//   public void move(int direction)
//    {
//        switch (direction)
//        {
//            case 1:
//                this._posX -= this._velocityX; //Left
//                break;
//            case 2:
//                this._posY -= this._jumpForce; //Up
//                break;
//            case 3:
//                this._posX += this._velocityX; //right
//                break;
//            case 4:
//                this._posY += this._jumpForce; //down
//                break;
//        }
          this.setBounds(this._posX, this._posY, _image.getWidth(this), _image.getHeight(this));
    }
   
    public boolean getIsBottomCollided(Sprite sprite)
    {
       Rectangle otherSpriteRectangle = new Rectangle(sprite._posX, (sprite._posY + sprite._height - this._velocityY), sprite._width, this._velocityY);
       Rectangle _playerblockRectangle = new Rectangle(this._posX, this._posY, this._width, this._height);
       
       return otherSpriteRectangle.intersects(_playerblockRectangle);
    }
    
    public boolean getIsTopCollided(Sprite sprite)
    {
       Rectangle otherSpriteRectangle = new Rectangle(sprite._posX, sprite._posY, sprite._width, sprite._height);
       Rectangle _playerblockRectangle = new Rectangle(this._posX, this._posY, this._width, this._height);
       
       return otherSpriteRectangle.intersects(_playerblockRectangle);
    }
   
    public boolean getIsLeftCollided(Sprite sprite)
    {
       Rectangle otherSpriteRectangle = new Rectangle(sprite._posX, sprite._posY + this._velocityY, this._velocityX, sprite._height - (2 * this._velocityY));
       Rectangle _playerblockRectangle = new Rectangle(this._posX, this._posY, this._width, this._height);
       
       return otherSpriteRectangle.intersects(_playerblockRectangle);
    }
    
    public boolean getIsRightCollided(Sprite sprite)
    {
       Rectangle otherSpriteRectangle = new Rectangle(sprite._posX + sprite._width - this._velocityX, sprite._posY + this._velocityY, this._velocityX, sprite._height - (2 * this._velocityY));
       Rectangle _playerblockRectangle = new Rectangle(this._posX, this._posY, this._width, this._height);
       
       return otherSpriteRectangle.intersects(_playerblockRectangle);
    }
    
    public boolean getIsCollided(Sprite sprite)
    {
       Rectangle otherSpriteRectangle = new Rectangle(sprite._posX, sprite._posY, sprite._width, sprite._height);
       Rectangle _playerblockRectangle = new Rectangle(this._posX, this._posY, this._width, this._height);
       
       return otherSpriteRectangle.intersects(_playerblockRectangle);
    }
    
    
   
    
}
   
   
    
    


