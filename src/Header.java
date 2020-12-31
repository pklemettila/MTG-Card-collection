import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.awt.Image;



public class Header extends JLabel {

    public Header()  {
        ImageIcon headImgIcon = new ImageIcon(this.getClass().getResource("/images/logo.png"));
        Image headImg = headImgIcon.getImage().getScaledInstance(1080, 119, Image.SCALE_SMOOTH);
        ImageIcon headIcon = new ImageIcon(headImg);

        this.setIcon(headIcon);
    }


}
