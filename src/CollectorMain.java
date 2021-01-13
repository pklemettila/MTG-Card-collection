//on windows: java -classpath ".;sqlite-jdbc-3.32.3.2.jar" CollectorMain
//on linux: java -classpath ".:sqlite-jdbc-3.32.3.2.jar" CollectorMain

import javax.swing.*;
import java.awt.*;
import java.awt.Dimension;

public class CollectorMain {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        Container pane = frame.getContentPane();
        SearchBtn searchButton = new SearchBtn();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pane.setLayout(new GridBagLayout());

        MainInterface.headerArea(pane);
        MainInterface.secondAndThirdRow(pane, searchButton);
        MainInterface.fourthAndFifthRow(pane);
        MainInterface.collectedCheckBox(pane);
        MainInterface.cardArea(pane);
        MainInterface.help(pane);

        frame.pack();
        frame.setMinimumSize(new Dimension(900, 600));
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.getRootPane().setDefaultButton(searchButton);

    }

}
