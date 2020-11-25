package window;

import javax.swing.*;
import java.awt.*;

public class ChatWindow extends JFrame {
    public ChatWindow(){

        setTitle("GeekBrainsChat");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        centreWindowOnScreen(700,900);

//TODO
        JPanel left = new JPanel();
        JPanel right = new JPanel();
        JPanel top = new JPanel();
        JPanel bottom = new JPanel();






        setVisible(true);
    }
    private void centreWindowOnScreen(int width, int height){
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - width) / 2 );
        int y = (int) ((dimension.getHeight() - height) / 2);
        setBounds(x,y,width,height);
    }


}
