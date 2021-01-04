import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HelpWindow extends JDialog{


    public HelpWindow(JFrame f) {
        super(f, "HELP");

            JPanel infoPanel = new JPanel();
            infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.PAGE_AXIS));
            ImageIcon magGlass = (new ImageIcon(this.getClass().getResource("/images/maglass.png")));
            ImageIcon plusMinus = (new ImageIcon(this.getClass().getResource("/images/plusminuslapinakyvä.png")));


            JLabel l1 = new JLabel("Use the search bar to search for cards by name, keyword or artist. Type card name, artist name or keyword");
            JLabel l2 = new JLabel("into the text input field and press the search icon.", magGlass, SwingConstants.TRAILING);
            l2.setHorizontalTextPosition(SwingConstants.LEADING);
            JLabel l3 = new JLabel("You can modify the search by clicking one or more of the mana symbols. Default setting searches for all");
            JLabel l4 = new JLabel("coloured and colourless cards.");
            JLabel l5 = new JLabel(new ImageIcon(this.getClass().getResource("/images/manasymbols.png")));
            JLabel l6 = new JLabel("If you want to search based on card type, click the drop-down menu and select your card type.");
            JLabel l7 = new JLabel(new ImageIcon(this.getClass().getResource("/images/cardtype.png")));
            JLabel l8 = new JLabel("You can also search by price range by entering values into the top-right fields ");
            JLabel l9 = new JLabel("If you want to search only for cards you have in your collection, click the checkbox 'show only collected'");
            JLabel l10 = new JLabel("Add or remove cards to your collection with the plus and minus icons next to the cards.", plusMinus, SwingConstants.LEADING);
            l10.setHorizontalTextPosition(SwingConstants.TRAILING);


            JButton close = new JButton("Close");
            close.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    HelpWindow.this.setVisible(false);
                }
            });


            JPanel buttonPanel = new JPanel();
            buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.LINE_AXIS));
            buttonPanel.add(close);
            buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 300, 10, 10));

            infoPanel.setBorder(BorderFactory.createEmptyBorder(5, 10, 0, 0));
            infoPanel.add(l1);
            infoPanel.add(l2);
            infoPanel.add(l3);
            infoPanel.add(l4);
            infoPanel.add(Box.createRigidArea(new Dimension(0, 5)));
            infoPanel.add(l5);
            infoPanel.add(Box.createRigidArea(new Dimension(0, 20)));
            infoPanel.add(l6);
            infoPanel.add(Box.createRigidArea(new Dimension(0, 10)));
            infoPanel.add(l7);
            infoPanel.add(Box.createRigidArea(new Dimension(0, 10)));
            infoPanel.add(l8);
            infoPanel.add(Box.createRigidArea(new Dimension(0, 10)));
            infoPanel.add(l9);
            infoPanel.add(l10);


            this.setLayout(new BorderLayout());
            this.add(infoPanel, BorderLayout.CENTER);
            this.add(buttonPanel, BorderLayout.PAGE_END);
            this.setSize(650, 440);
            pack();
            setLocationRelativeTo(f);
            this.setVisible(true);

        }

    }


