import javax.print.attribute.standard.JobKOctets;
import javax.swing.*;
import javax.xml.crypto.Data;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class MtgCard extends JPanel {     // Class representing a single MTG card

    private int idNumber;

    public MtgCard(int id) {

        Database app = new Database();

        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        this.idNumber = id;

        JLabel cardImageLabel = checkCardImage(id);
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 0;
        c.gridwidth = 2;
        c.gridheight = 2;
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(0, 0, 0, 0);
        this.add(cardImageLabel, c);


        JLabel priceLabel = new JLabel("Price: " + app.getPrice(id));
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.gridx =  1;
        c.gridy = 3;
        c.insets = new Insets(0, 60, 0, 0);
        this.add(priceLabel, c);

        JLabel ownedLabel = new JLabel("Owned: " + app.searchOwnedById(id));
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.gridx =  1;
        c.gridy = 4;
        c.insets = new Insets(0, 60, 0, 0);
        this.add(ownedLabel, c);

        JButton plusButton = new JButton("+");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.gridx =  3;
        c.gridy = 0;
        c.insets = new Insets(0,10, 0, 0);

        plusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ownedLabel.setText("Owned: " + addToOwned(id));
            }
        });

        this.add(plusButton, c);

        JButton minusButton = new JButton("-");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.gridx =  3;
        c.gridy = 1;
        c.insets = new Insets(0, 10, 0, 0);

        minusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ownedLabel.setText("Owned: " + subtractFromOwned(id));
            }
        });
        this.add(minusButton, c);


    }



    private JLabel checkCardImage(int id) {   // Gets an image of the specific MTG card from the directory. If no image is available, uses a placeholder

        Database app = new Database();

        JLabel LabelToReturn = new JLabel();
        ImageIcon rawImage;
        Image imgImage;

        String imgName = Integer.toString(id);

        if ((this.getClass().getResource("/images/cards/" + imgName + ".jpg") != null)) {

            rawImage = new ImageIcon(this.getClass().getResource("/images/cards/" + imgName + ".jpg"));

        } else {

            rawImage = new ImageIcon(this.getClass().getResource("/images/cards/tempCard.jpg"));
            LabelToReturn.setText(app.searchCardsById(id));
            LabelToReturn.setHorizontalTextPosition(JLabel.CENTER);

        }
        imgImage = rawImage.getImage().getScaledInstance(172, 240, Image.SCALE_SMOOTH);
        LabelToReturn.setIcon(new ImageIcon(imgImage));
        return LabelToReturn;


    }


    private int addToOwned(int id) {   // adds 1 owned card with this id to the database and returns updated amount of owned cards

        Database app = new Database();
        app.addToOwned(id);
        return (app.searchOwnedById(id));

    }

    private int subtractFromOwned(int id) {   // removes 1 owned card with this id from the database and returns updated amount of owned cards

        Database app = new Database();
        app.substractFromOwned(id);
        return (app.searchOwnedById(id));

    }

}
