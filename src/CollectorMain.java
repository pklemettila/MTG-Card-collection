//on windows: java -classpath ".;sqlite-jdbc-3.32.3.2.jar" CollectorMain
//on linux: java -classpath ".:sqlite-jdbc-3.32.3.2.jar" CollectorMain

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class CollectorMain {

    public static void main(String[] args) {
        MainInterface minterface = new MainInterface();
        Database app = new Database();
        //app.selectAllCreatureCards();
        //System.out.println("by color: ");
        //app.getCardColor("U");
        //app.getArtist("Ittoku");
        //app.updatePrice(0.33, "uncommon", "Mark Zug");
        //app.getPrice(0.33);
        //app.substractFromOwned(3);
        //app.addToOwned(2543);
        
        //app.getOwnedCards();



    }

}
