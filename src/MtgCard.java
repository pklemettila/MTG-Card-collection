import javax.swing.*;
import java.awt.*;
import java.io.File;

public class MtgCard {

    private ImageIcon cardImage;
    private int owned = 0;
    private double price;
    private String name;

    public MtgCard(String n, double p) {

        this.name = n;
        this.price = p;
        this.cardImage = checkCardImage(this.name);



    }

    public void addOwned() {
        this.owned++;
    }

    private ImageIcon checkCardImage(String filename) {

        ImageIcon imageToReturn;
        ImageIcon rawImage;
        Image imgImage;

        String imgName = filename.replaceAll("\\s+","_");
        File tempFile = new File(("/images/cards/" + imgName + ".png"));
        if (tempFile.exists()) {

            rawImage = new ImageIcon(this.getClass().getResource("/images/cards/" + imgName + ".jpg"));
            imgImage = rawImage.getImage().getScaledInstance(172, 240, Image.SCALE_SMOOTH);
            imageToReturn= new ImageIcon(imgImage);

            return imageToReturn;
        } else {

            rawImage = new ImageIcon(this.getClass().getResource("/images/cards/tempCard.jpg" ));
            imgImage = rawImage.getImage().getScaledInstance(172, 240, Image.SCALE_SMOOTH);
            imageToReturn= new ImageIcon(imgImage);

            return imageToReturn;
        }


    }

}
