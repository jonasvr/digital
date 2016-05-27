package hellotvxlet;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import org.havi.ui.HComponent;

public class MijnComponent extends HComponent {
    int br,ho; //breedte en hoogte
    Image schipImg,sterrenImg;
    int x,y;
    int sy;
    
    public MijnComponent(int x, int y, int width, int height)
    {
        this.setBounds(x,y,width,height); //x,y,breedte,hoogte component
        br = width;
        ho = height;
        x=500;
        y=500;
        sy = 0;
       
        schipImg= this.getToolkit().getImage("schip.jpg"); //zit in map C:\Program Files\TechnoTrend\TT-MHP-Browser\fileio\DSMCC\0.0.3
        sterrenImg=this.getToolkit().getImage("sterren.jpg");
        MediaTracker mt=new MediaTracker(this);
        mt.addImage(schipImg,0); //img, volgnummer
        
        try{
                 mt.waitForAll();
           }  catch (InterruptedException ex){
           ex.printStackTrace();      
           }
    }

    public void paint(Graphics g)
    {
       g.drawImage(sterrenImg,0,sy,null);//twee keer sterrenhemel want als beeld 1 onderkant heeft bereikt, dan zie je dat niet ==> continuiteit
       g.drawImage(sterrenImg,0,sy-570,null);
       g.drawImage(schipImg,x,y,null);
    }
    
    public void moveleft()
    {
    x-=5;
    this.repaint();    
    }
    
    public void moveright()
    {
    x+=5;
    this.repaint();
    }
    
    public void moveup()
    {
    y-=5;
    this.repaint();  
    }
    
    public void movedown()
    {
    y+=5;
    this.repaint();
    }
            
    public void scroll() //achtergrond scrollen
    {
     sy+=5;
     if(sy>=570){sy=0;} // als onderkant bereikt te hebben, terug naar begin
     this.repaint();
    }
    
}
