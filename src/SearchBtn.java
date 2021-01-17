import java.io.File;
import javax.swing.*;

public class SearchBtn extends JButton {

    static final long serialVersionUID = 42L;

    public SearchBtn() {

        ImageIcon searchImgIcon = new ImageIcon(this.getClass()
                .getResource(File.separator + "images" + File.separator + "maglass.png" + File.separator));
        this.setIcon(searchImgIcon);
    }
}