import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LCICheckingToolWindow extends JFrame {
    JButton check;
    JButton chagePath;
    JLabel timeResult;
    JLabel complete;
    public LCICheckingToolWindow(){
        JMenuBar jMenuBar = new JMenuBar();
        setJMenuBar(jMenuBar);
        setTitle("ToolForLCICheckingReport");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        centreWindowOnScreen(600,300);
        JLabel label = new JLabel("Press button for");
        String[] settingPaths = {"./LCICheckingReport.txt", "./ASTRO.txt","./LCIResult.txt"};
        String[] paths = new String[3];
        add(label);


        setLayout(new GridLayout(8,0));
        //setLayout(new BoxLayout(BoxLayout.Y_AXIS));

        check = new JButton("CHECK");
        chagePath = new JButton("Change path");
        add(check);
        JMenu settings = new JMenu("Settings");
        String[] jMenuItemNames = {"LCI_Checking_Report path","Astro path","Result path"};
        JMenuItem[] jMenuItems = new JMenuItem[3];
        JTextField[] jTextFields = new JTextField[3];
        for (int i = 0; i < jMenuItems.length; i++) {
            paths[i] = Settings.readPath(settingPaths[i]);
            jMenuItems[i] = new JMenuItem(jMenuItemNames[i]);
            settings.add(jMenuItems[i]);
            jTextFields[i] = new JTextField(paths[i]);
            add(jTextFields[i]);
        }
        jMenuBar.add(settings);
        add(chagePath);

        chagePath.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Settings.setPath(settingPaths[0],jTextFields[0].getText());
                    Settings.setPath(settingPaths[1],jTextFields[1].getText());
                    Settings.setPath(settingPaths[2],jTextFields[2].getText());
                }
            });
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                long startTime = System.currentTimeMillis();
                remove(check);
                remove(label);
                new LCIChecker();
                timeResult = new JLabel(((System.currentTimeMillis() - startTime)/1000) + " seconds. ");
                complete = new JLabel(" Excel File creating success. " + LCIChecker.count + " rows checked. " + Data.dataList.size() + " pallets found.");


                add(timeResult);
                add(complete);

                setVisible(true);
            }
        });

        setVisible(true);
    }


    private void centreWindowOnScreen(int width, int height){
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - width) / 2 );
        int y = (int) ((dimension.getHeight() - height) / 2);
        setBounds(x,y,width,height);
    }
}
