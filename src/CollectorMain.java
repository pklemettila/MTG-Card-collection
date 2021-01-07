//on windows: java -classpath ".;sqlite-jdbc-3.32.3.2.jar" CollectorMain
//on linux: java -classpath ".:sqlite-jdbc-3.32.3.2.jar" CollectorMain

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class CollectorMain {


  

    public static void main(String[] args) {
        MainInterface minterface = new MainInterface();
        Database app = new Database();
      /*  //app.getPrice(15);
        //app.substractFromOwned(3);
        //app.addToOwned(2543);
        //app.getOwnedCards();
        ArrayList<Integer> matti = new ArrayList<>();
        matti = app.searchAll(
            false, false, false, false, false, false, false, 
            false, false, false, false,
            false, 0, false, 0,
            false,
            false, "Creature",
            false, false, false, false, "false");
        int num = app.searchOwnedById(3);
        System.out.println(num);
        System.out.println(matti);
        String pirkko = app.searchCardsById(53);
System.out.println(pirkko); */

    }

}
