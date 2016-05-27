package hellotvxlet;

import java.awt.event.ActionEvent;
import java.awt.event.*;
import javax.tv.xlet.*;
import org.havi.ui.*;
import org.davic.resources.*;
import org.havi.ui.event.*;

//zelf toegevoegd
import java.awt.*;
import org.dvb.ui.*;

public class HelloTVXlet implements Xlet, ResourceClient,
        HBackgroundImageListener, HActionListener {

    private String[] tictactoe = new String[9];
    private String winnaar;
    private HScreen screen;
    private XletContext actueleXletContext;
    private HScene scene;
    private HTextButton knop1,  knop2,  knop3,  knop4,  knop5,  knop6,  knop7,  knop8,  knop9,  newGame;
    private HBackgroundDevice bgDevice;
    private HBackgroundConfigTemplate bgTemplate;
    private HStillImageBackgroundConfiguration bgConfiguration;
    private HBackgroundImage agrondimg = new HBackgroundImage("pizza1.jpg");
    private boolean xO;
    private boolean bezig;

    public void notifyRelease(ResourceProxy proxy) {
    }

    public void release(ResourceProxy proxy) {
    }

    public boolean requestRelease(ResourceProxy proxy, Object requestData) {
        return false;
    }

    public void imageLoaded(HBackgroundImageEvent e) {
        try {
            bgConfiguration.displayImage(agrondimg);
        } catch (Exception s) {
            System.out.println(s.toString());
        }
    }

    public void imageLoadFailed(HBackgroundImageEvent e) {
        System.out.println("Image kan niet geladen worden. ");
    }

//Zelf nieuwe classen gemaakt

// Klasse van Hcomponent overerven
    public class MijnComponent extends HComponent {
//Plaats en locatie instellen in de constructor
        public MijnComponent(int breedte, int wat) {
                this.setBounds(0, 00, breedte, 100);
            
        }
        // Paint methode overschrijven

        public void paint(Graphics g) {
                g.setColor(new DVBColor(100, 100, 100, 179));
                g.fillRect(0, 0, this.getWidth(), this.getHeight());
                g.setColor(Color.white);
                g.drawString("Dit is een twee persoons spel Tic Tac Toe", this.getWidth() / 4, this.getHeight() / 2);

        }
    }

    public void initXlet(XletContext context) {
// HScreen object opvragen
        screen = HScreen.getDefaultHScreen();
// HBackgroundDevice opvragen
        bgDevice = screen.getDefaultHBackgroundDevice();
// HBackgroundDevice proberen te reserveren
        if (bgDevice.reserveDevice(this)) {
            System.out.println("BackgroundImage device has been reserved ");

        } else {
            System.out.println("Background image device cannot be reserved ");
        }
// Template maken
        bgTemplate = new HBackgroundConfigTemplate();
        //System.out.println("yoloooooooooooooooooooooooo2");
// Configuratieinstelling "STILL_IMAGE"

        bgTemplate.setPreference(HBackgroundConfigTemplate.STILL_IMAGE,
                HBackgroundConfigTemplate.REQUIRED);
// Configuratie aanvragen en activeren indien OK
        bgConfiguration = (HStillImageBackgroundConfiguration) bgDevice.getBestConfiguration(bgTemplate);
        try {
            bgDevice.setBackgroundConfiguration(bgConfiguration);
        } catch (java.lang.Exception e) {
            System.out.println(e.toString());
        }

        this.actueleXletContext = context;
// Template aanmaken
        HSceneTemplate sceneTemplate = new HSceneTemplate();
// Grootte en positie aangeven
        sceneTemplate.setPreference(HSceneTemplate.SCENE_SCREEN_DIMENSION,
                new HScreenDimension(1.0f, 1.0f), HSceneTemplate.REQUIRED);

        sceneTemplate.setPreference(HSceneTemplate.SCENE_SCREEN_LOCATION, new HScreenPoint(0.0f, 0.0f), HSceneTemplate.REQUIRED);
// Een instantie van de Scene aanvragen aan de factory .
        scene = HSceneFactory.getInstance().getBestScene(sceneTemplate);
        //Hoogte en breedte van Scene opvragen
        nieuwSpel();
        bezig = true;
        refresh();
    }

    public void startXlet() {
        System.out.println(" startXlet ");
//Image laden
        agrondimg.load(this);
        //TODO IMG VERVANGEN met RASTER
//START OF SCRIPT
        scene.setVisible(true);
        scene.validate();


// END OF SCRIPT
    }

    public void pauseXlet() {
        System.out.println(" pauseXlet ");
    }

    public void destroyXlet(boolean unconditional) {
        System.out.println(" destroyXlet ");
        agrondimg.flush();
    }

    public boolean checkAvailable(int place) {
        if (tictactoe[place - 1].equals(" ")) {
            xO = !xO;
            tictactoe[place - 1] = xO ? "X" : "O";

            return true;
        }
        return false;
    }

    public boolean checkWinner() {
        for (int x = 0; x < 9; x += 3) {
            if (tictactoe[x].equals(tictactoe[x + 1]) && tictactoe[x].equals(tictactoe[x + 2]) && !tictactoe[x].equals(" ")) {
                winnaar = tictactoe[x];
                return true;
            }
        }
        for (int x = 0; x < 3; x++) {
            if (tictactoe[x].equals(tictactoe[x + 3]) && tictactoe[x].equals(tictactoe[x + 6]) && !tictactoe[x].equals(" ")) {
                winnaar = tictactoe[x];
                return true;
            }
        }
        if (tictactoe[0].equals(tictactoe[4]) && tictactoe[0].equals(tictactoe[8]) && !tictactoe[0].equals(" ")) {
            winnaar = tictactoe[0];
            return true;
        }
        if (tictactoe[6].equals(tictactoe[2]) && tictactoe[4].equals(tictactoe[2]) && !tictactoe[2].equals(" ")) {
            winnaar = tictactoe[2];
            return true;
        }
        return false;
    }

    public void refresh() {
        System.out.println("refresh");
        scene.removeAll();
        int hoogte = scene.getHeight();
        int breedte = scene.getWidth();
        //Instellingen interface van rand spel berekenen
        int grootteKnop = (hoogte > breedte) ? (breedte / 5) : (hoogte / 5);
        int x = breedte / 2;
        int y = (hoogte / 2) + 50;
        knop1 = new HTextButton(tictactoe[0]);
        knop1.setLocation((int) (x - (1.5 * grootteKnop)), (int) (y - (1.5 * grootteKnop)));
        knop1.setSize(grootteKnop, grootteKnop);
        knop1.setBackground(new DVBColor(0, 0, 0, 179));
        knop1.setBackgroundMode(HVisible.BACKGROUND_FILL);
        scene.add(knop1);

        knop2 = new HTextButton(tictactoe[1]);
        knop2.setLocation(x - (grootteKnop / 2), (int) (y - (1.5 * grootteKnop)));
        knop2.setSize(grootteKnop, grootteKnop);
        knop2.setBackground(new DVBColor(0, 0, 0, 179));
        knop2.setBackgroundMode(HVisible.BACKGROUND_FILL);
        scene.add(knop2);

        knop3 = new HTextButton(tictactoe[2]);
        knop3.setLocation((int) (x + (0.5 * grootteKnop)), (int) (y - (1.5 * grootteKnop)));
        knop3.setSize(grootteKnop, grootteKnop);
        knop3.setBackground(new DVBColor(0, 0, 0, 179));
        knop3.setBackgroundMode(HVisible.BACKGROUND_FILL);
        scene.add(knop3);

        knop4 = new HTextButton(tictactoe[3]);
        knop4.setLocation((int) (x - (1.5 * grootteKnop)), (int) (y - (0.5 * grootteKnop)));
        knop4.setSize(grootteKnop, grootteKnop);
        knop4.setBackground(new DVBColor(0, 0, 0, 179));
        knop4.setBackgroundMode(HVisible.BACKGROUND_FILL);
        scene.add(knop4);

        knop5 = new HTextButton(tictactoe[4]);
        knop5.setLocation(x - (grootteKnop / 2), (int) (y - (0.5 * grootteKnop)));
        knop5.setSize(grootteKnop, grootteKnop);
        knop5.setBackground(new DVBColor(0, 0, 0, 179));
        knop5.setBackgroundMode(HVisible.BACKGROUND_FILL);
        scene.add(knop5);

        knop6 = new HTextButton(tictactoe[5]);
        knop6.setLocation(x + (grootteKnop / 2), (int) (y - (0.5 * grootteKnop)));
        knop6.setSize(grootteKnop, grootteKnop);
        knop6.setBackground(new DVBColor(0, 0, 0, 179));
        knop6.setBackgroundMode(HVisible.BACKGROUND_FILL);
        scene.add(knop6);

        knop7 = new HTextButton(tictactoe[6]);
        knop7.setLocation((int) (x - (1.5 * grootteKnop)), (int) (y + (0.5 * grootteKnop)));
        knop7.setSize(grootteKnop, grootteKnop);
        knop7.setBackground(new DVBColor(0, 0, 0, 179));
        knop7.setBackgroundMode(HVisible.BACKGROUND_FILL);
        scene.add(knop7);

        knop8 = new HTextButton(tictactoe[7]);
        knop8.setLocation((int) (x - (0.5 * grootteKnop)), (int) (y + (0.5 * grootteKnop)));
        knop8.setSize(grootteKnop, grootteKnop);
        knop8.setBackground(new DVBColor(0, 0, 0, 179));
        knop8.setBackgroundMode(HVisible.BACKGROUND_FILL);
        scene.add(knop8);

        knop9 = new HTextButton(tictactoe[8]);
        knop9.setLocation((int) (x + (0.5 * grootteKnop)), (int) (y + (0.5 * grootteKnop)));
        knop9.setSize(grootteKnop, grootteKnop);
        knop9.setBackground(new DVBColor(0, 0, 0, 179));
        knop9.setBackgroundMode(HVisible.BACKGROUND_FILL);
        scene.add(knop9);

        newGame = new HTextButton("New Game");
        newGame.setLocation(0, 0);
        newGame.setSize(150, 100);
        newGame.setBackground(new DVBColor(0, 0, 0, 179));
        newGame.setBackgroundMode(HVisible.BACKGROUND_FILL);
        newGame.setActionCommand("newgame_actioned");
        newGame.addHActionListener(this);
        scene.add(newGame);

        MijnComponent mc = new MijnComponent(scene.getWidth(), 0);
        scene.add(mc);
        if (!bezig) {
            
        }
        //                       op   neer    L      R
        knop1.setFocusTraversal(newGame, knop4, newGame, knop2);
        knop2.setFocusTraversal(null, knop5, knop1, knop3);
        knop3.setFocusTraversal(null, knop6, knop2, null);
        knop4.setFocusTraversal(knop1, knop7, null, knop5);
        knop5.setFocusTraversal(knop2, knop8, knop4, knop6);
        knop6.setFocusTraversal(knop3, knop9, knop5, null);
        knop7.setFocusTraversal(knop4, null, null, knop8);
        knop8.setFocusTraversal(knop5, null, knop7, knop9);
        knop9.setFocusTraversal(knop6, null, knop8, null);
        newGame.setFocusTraversal(knop1, knop1, knop1, knop1);


        knop1.setActionCommand("knop1_actioned");
        knop2.setActionCommand("knop2_actioned");
        knop3.setActionCommand("knop3_actioned");
        knop4.setActionCommand("knop4_actioned");
        knop5.setActionCommand("knop5_actioned");
        knop6.setActionCommand("knop6_actioned");
        knop7.setActionCommand("knop7_actioned");
        knop8.setActionCommand("knop8_actioned");
        knop9.setActionCommand("knop9_actioned");

        knop1.addHActionListener(this);
        knop2.addHActionListener(this);
        knop3.addHActionListener(this);
        knop4.addHActionListener(this);
        knop5.addHActionListener(this);
        knop6.addHActionListener(this);
        knop7.addHActionListener(this);
        knop8.addHActionListener(this);
        knop9.addHActionListener(this);

        knop1.requestFocus();
        knop2.requestFocus();
        knop3.requestFocus();
        knop4.requestFocus();
        knop5.requestFocus();
        knop6.requestFocus();
        knop7.requestFocus();
        knop8.requestFocus();
        knop9.requestFocus();
        newGame.requestFocus();
        knop5.requestFocus();
        scene.validate();
    }

    public void nieuwSpel() {
        for (int x = 0; x < 9; x++) {
            tictactoe[x] = " ";
        }
        xO = false;
        scene.removeAll();
        refresh();
    }

    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
        if (e.getActionCommand().equals("knop1_actioned")) {
            if (checkAvailable(1)) {
                if (checkWinner()) {
                    bezig = false;
                    nieuwSpel();
                }
            }
        } else if (e.getActionCommand().equals("knop2_actioned")) {
            if (checkAvailable(2)) {
                if (checkWinner()) {
                    bezig = false;
                    nieuwSpel();
                }
            }
        } else if (e.getActionCommand().equals("knop3_actioned")) {
            if (checkAvailable(3)) {
                if (checkWinner()) {
                    bezig = false;
                    nieuwSpel();
                }
            }
        } else if (e.getActionCommand().equals("knop4_actioned")) {
            if (checkAvailable(4)) {
                if (checkWinner()) {
                    bezig = false;
                    nieuwSpel();
                }
            }
        } else if (e.getActionCommand().equals("knop5_actioned")) {
            if (checkAvailable(5)) {
                if (checkWinner()) {
                    bezig = false;
                    nieuwSpel();
                }
            }
        } else if (e.getActionCommand().equals("knop6_actioned")) {
            if (checkAvailable(6)) {
                if (checkWinner()) {
                    bezig = false;
                    nieuwSpel();
                }
            }
        } else if (e.getActionCommand().equals("knop7_actioned")) {
            if (checkAvailable(7)) {
                if (checkWinner()) {
                    bezig = false;
                    nieuwSpel();
                }
            }
        } else if (e.getActionCommand().equals("knop8_actioned")) {
            if (checkAvailable(8)) {
                if (checkWinner()) {
                    bezig = false;
                    nieuwSpel();
                }
            }
        } else if (e.getActionCommand().equals("knop9_actioned")) {
            if (checkAvailable(9)) {
                if (checkWinner()) {
                    bezig = false;
                    nieuwSpel();
                }
            }
        } else if (e.getActionCommand().equals("newgame_actioned")) {
            bezig = false;
            nieuwSpel();
        }
        refresh();
    //throw new UnsupportedOperationException("Not supported yet.");
    }
}