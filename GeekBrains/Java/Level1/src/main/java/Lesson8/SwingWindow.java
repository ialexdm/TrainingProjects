package Lesson8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingWindow extends JFrame {
    static Integer result = 0;
    public  SwingWindow(){
        setTitle("My first Calculator");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        final int BUTTON_SIZE = 100;
        setBounds(1200,300,BUTTON_SIZE*4 + 16,BUTTON_SIZE*4 + 139);
        setLayout(null);

        final JTextField field = new JTextField("Result");
        field.setBackground(Color.BLACK);
        field.setForeground(Color.YELLOW);
        field.setBounds(0,0,416,100);
        field.setEditable(false);
        add(field);
        String[][] buttonNames = {
                {"*","/","=","c"},
                {"-","7","8","9"},
                {"+","4","5","6"},
                {"0","1","2","3"},
        };



        final JButton[][] button = new JButton[4][4];
        for (int i = 0; i < button.length; i++) {
            for (int j = 0; j < button[i].length; j++) {
                button[i][j] = new JButton(buttonNames[i][j]);
                button[i][j].setBounds(j*100,100+i*100,100,100);
                if (i == 0 || j == 0 && i!=3){
                    button[i][j].setBackground(Color.green);
                    button[i][j].setForeground(Color.black);
                }
                else{
                    button[i][j].setBackground(Color.black);
                    button[i][j].setForeground(Color.green);

                }

                final String str = buttonNames[i][j];
                button[i][j].addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (str.equals("c")){
                            field.setText("Result");
                        }else if (str.equals("=")){
                            field.setText(String.valueOf("Result: "+ result));
                            result =0;
                        }else{
                            if (field.getText().startsWith("Result"))
                            {
                                result += Integer.parseInt(str);
                                field.setText(str);
                            }else if (field.getText().endsWith("+"))
                            {
                                result += Integer.parseInt(str);
                                field.setText(field.getText() + str);
                            }else if (field.getText().endsWith("-"))
                            {
                                result -= Integer.parseInt(str);
                                field.setText(field.getText() + str);
                            }else if (field.getText().endsWith("*"))
                            {
                                result *= Integer.parseInt(str);
                                field.setText(field.getText() + str);
                            }else if (field.getText().endsWith("/"))
                            {
                                if (str.equals("0")){
                                    field.setText("Result error. Divided by zero");
                                }else {
                                    result /= Integer.parseInt(str);
                                    field.setText(field.getText() + str);
                                }

                            }else {
                                field.setText(field.getText() + str);
                            }


                        }

                    }
                });
                add(button[i][j]);
            }
        }
        setVisible(true);
    }
}
