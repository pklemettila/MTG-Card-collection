import javax.swing.*;
import java.awt.Image;
import java.io.File;

public class Header extends JLabel {
    static final long serialVersionUID = 42L;

    public Header() {
        ImageIcon headImgIcon = new ImageIcon(
                this.getClass().getResource(File.separator + "images" + File.separator + "logo.png" + File.separator));
        Image headImg = headImgIcon.getImage().getScaledInstance(1080, 119, Image.SCALE_SMOOTH);
        ImageIcon headIcon = new ImageIcon(headImg);
        this.setIcon(headIcon);
    }
}
