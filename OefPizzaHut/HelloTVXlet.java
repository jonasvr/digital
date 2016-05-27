package hellotvxlet;

import java.awt.event.KeyEvent;
import javax.tv.xlet.Xlet;
import javax.tv.xlet.XletContext;
import javax.tv.xlet.XletStateChangeException;
import org.bluray.ui.event.HRcEvent;
import org.davic.resources.ResourceClient;
import org.davic.resources.ResourceProxy;
import org.dvb.event.EventManager;
import org.dvb.event.UserEvent;
import org.dvb.event.UserEventListener;
import org.dvb.event.UserEventRepository;
import org.havi.ui.HBackgroundConfigTemplate;
import org.havi.ui.HBackgroundDevice;
import org.havi.ui.HBackgroundImage;
import org.havi.ui.HConfigurationException;
import org.havi.ui.HPermissionDeniedException;
import org.havi.ui.HScene;
import org.havi.ui.HSceneFactory;
import org.havi.ui.HScreen;
import org.havi.ui.HStaticText;
import org.havi.ui.HStillImageBackgroundConfiguration;
import org.havi.ui.event.HBackgroundImageEvent;
import org.havi.ui.event.HBackgroundImageListener;

public class HelloTVXlet implements Xlet, ResourceClient, HBackgroundImageListener, UserEventListener
{
    HBackgroundDevice hBackGroundDev;
    HBackgroundImage pizza1, pizza2, pizza3, pizza4;
    
    HStillImageBackgroundConfiguration hsimbc;
    int imageTeller;
    int cursor;
    
    HScene scene = HSceneFactory.getInstance().getDefaultHScene(); //voor button
    HStaticText orderhst;
    String orderString = "Orderlijst\n";
 
    
    public void destroyXlet(boolean unconditional) throws XletStateChangeException {
       
    }

    public void initXlet(XletContext ctx) throws XletStateChangeException {
        HScreen hscreen = HScreen.getDefaultHScreen();
        hBackGroundDev = hscreen.getDefaultHBackgroundDevice();
        hBackGroundDev.reserveDevice(this); //bovenaan implements ResourceClient + import van abstract methods doen
        
        HBackgroundConfigTemplate cfgTemplate =new HBackgroundConfigTemplate();
        cfgTemplate.setPreference(HBackgroundConfigTemplate.STILL_IMAGE, HBackgroundConfigTemplate.REQUIRED);
        
        hsimbc = (HStillImageBackgroundConfiguration)hBackGroundDev.getBestConfiguration(cfgTemplate);
        try {

            if (hBackGroundDev.setBackgroundConfiguration(hsimbc)) {
                System.out.println("Reservatie & configuratie gelukt!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } 
        
        pizza1 = new HBackgroundImage("Pizza1.m2v");
        pizza2 = new HBackgroundImage("Pizza2.m2v");
        pizza3 = new HBackgroundImage("Pizza3.m2v");
        pizza4 = new HBackgroundImage("Pizza4.m2v");
        pizza1.load(this); //bovenaan implements HBackgroundImageListener
        pizza2.load(this); //bovenaan implements HBackgroundImageListener
        pizza3.load(this); //bovenaan implements HBackgroundImageListener
        pizza4.load(this); //bovenaan implements HBackgroundImageListener
        UserEventRepository rep = new UserEventRepository("Naam");
        rep.addAllArrowKeys();
        rep.addKey(HRcEvent.VK_ENTER);
        
        EventManager e=EventManager.getInstance();
        e.addUserEventListener(this, rep);
        
        orderhst = new HStaticText(orderString, 300, 50, 500, 400);
        orderhst.setVerticalAlignment(HStaticText.VALIGN_TOP);
       // orderhst.setHorizontalAlignment(HStaticText.)
        scene.add(orderhst);
        scene.validate();
        scene.setVisible(true);                
    }   
   

    public void startXlet() throws XletStateChangeException {

    }

    public void pauseXlet() {
    }


    public boolean requestRelease(ResourceProxy proxy, Object requestData) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void release(ResourceProxy proxy) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void notifyRelease(ResourceProxy proxy) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void imageLoaded(HBackgroundImageEvent e) {
       imageTeller++;
        if (imageTeller ==4) 
        {
            System.out.println("Alles geladen.");
            try {hsimbc.displayImage(pizza1);}
            catch (Exception ex){
                ex.printStackTrace();
            }
        }
        
    }

    public void imageLoadFailed(HBackgroundImageEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void userEventReceived(UserEvent e) {
        if( e.getType()==KeyEvent.KEY_PRESSED)
        {
            if (e.getCode()==HRcEvent.VK_LEFT)
            {
                cursor--; if(cursor <1) cursor = 4;
            }
        }
        if( e.getType()==KeyEvent.KEY_PRESSED)
        {
            if (e.getCode()==HRcEvent.VK_RIGHT)
            {
                cursor++; if(cursor >4) cursor = 1;
            }
        }
        if( e.getType()==KeyEvent.KEY_PRESSED)
        {
            if( e.getCode()==HRcEvent.VK_ENTER) 
            {
                if (cursor==1) orderString = orderString + "Meat Lover's\n";
                if (cursor==2) orderString = orderString + "Pepperoni Lover's\n";
                if (cursor==3) orderString = orderString + "Cheese Lover's\n";
                if (cursor==4) orderString = orderString + "Vegi Lover's\n";
            }
        }
        try{
            if (cursor==1) hsimbc.displayImage(pizza1);
            if (cursor==2) hsimbc.displayImage(pizza2);
            if (cursor==3) hsimbc.displayImage(pizza3);
            if (cursor==4) hsimbc.displayImage(pizza4);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        
        orderhst.setTextContent(orderString, HStaticText.NORMAL_STATE);
    }
    
}