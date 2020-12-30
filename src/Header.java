import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Header extends JLabel {

    public Header()  {
        ImageIcon headImg = new ImageIcon(this.getClass().getResource("/images/logo.png"));
        this.setIcon(headImg);
        this.setVisible(true);
    }


}
