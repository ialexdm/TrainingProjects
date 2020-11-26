package window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChatWindow extends JFrame {
    JPanel left, right, bottom;
    JButton sendButton;
    public ChatWindow(){

        setTitle("GeekBrainsChat");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        centreWindowOnScreen(700,900);

        left = new JPanel();
        left.setSize(500,700);
        right = new JPanel();
        right.setSize(200,700);
        right.setBackground(Color.black);
        bottom = new JPanel();
        bottom.setSize(700,200);


        left.setLayout(new BorderLayout());
        final JTextArea chatArea = new JTextArea();
        chatArea.setSize(500,700);
        chatArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(chatArea);
        scrollPane.setBounds(0,0,500,700);
        left.add(scrollPane);

        right.setLayout(new FlowLayout());
        JButton pub = new JButton("public");
        JButton pub2 = new JButton("public2");
        right.add(pub);
        right.add(pub2);


        sendButton = new JButton("Send");
        final JTextField message = new JTextField();
        bottom.setLayout(new BorderLayout());
        bottom.add(message, BorderLayout.PAGE_START);
        bottom.add(sendButton, BorderLayout.PAGE_END);

        sendButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                chatArea.setText(chatArea.getText() + message.getText()+"\n");
                message.setText("");
            }
        });


        add(right, BorderLayout.EAST);
        add(bottom, BorderLayout.SOUTH);
        add(left, BorderLayout.CENTER);




        setVisible(true);
    }
    private void centreWindowOnScreen(int width, int height){
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - width) / 2 );
        int y = (int) ((dimension.getHeight() - height) / 2);
        setBounds(x,y,width,height);
    }


}
