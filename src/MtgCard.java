import javax.print.attribute.standard.JobKOctets;
import javax.swing.*;
import java.awt.*;
import java.io.File;

public class MtgCard extends JPanel {

    private double price;
    private String name;

    public MtgCard(String n, double p, int id) {


        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        this.name = n;
        this.price = p;

        JLabel cardImageLabel = checkCardImage(this.name);
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 0;
        c.gridwidth = 2;
        c.gridheight = 2;
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(0, 0, 0, 0);
        this.add(cardImageLabel, c);

        JButton plusButton = new JButton("+");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.gridx =  3;
        c.gridy = 0;
        c.insets = new Insets(0,10, 0, 0);
        this.add(plusButton, c);

        JButton minusButton = new JButton("-");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.gridx =  3;
        c.gridy = 1;
        c.insets = new Insets(0, 10, 0, 0);
        this.add(minusButton, c);

        JLabel priceLabel = new JLabel("Price: " + String.valueOf(price));
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.gridx =  1;
        c.gridy = 3;
        c.insets = new Insets(10, 60, 0, 0);
        this.add(priceLabel, c);

        JLabel ownedLabel = new JLabel("Owned: " + String.valueOf("5"));
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.gridx =  1;
        c.gridy = 4;
        c.insets = new Insets(10, 60, 0, 0);
        this.add(ownedLabel, c);

    }



    private JLabel checkCardImage(String name) {

/*
        Database app = new Database();
        app.addToOwned(13508);
        app.getOwnedCards();
*/
        JLabel LabelToReturn = new JLabel();
        ImageIcon rawImage;
        Image imgImage;

        String imgName = name.replaceAll("\\s+","_");

        if ((this.getClass().getResource("/images/cards/" + imgName + ".jpg") != null)) {

            rawImage = new ImageIcon(this.getClass().getResource("/images/cards/" + imgName + ".jpg"));

        } else {

            rawImage = new ImageIcon(this.getClass().getResource("/images/cards/tempCard.jpg"));
            LabelToReturn.setText(name);
            LabelToReturn.setHorizontalTextPosition(JLabel.CENTER);

        }
        imgImage = rawImage.getImage().getScaledInstance(172, 240, Image.SCALE_SMOOTH);
        LabelToReturn.setIcon(new ImageIcon(imgImage));
        return LabelToReturn;


    }

}
