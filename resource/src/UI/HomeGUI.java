package UI;

import entity.PageContent;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeGUI extends JFrame {

    public HomeGUI(){
        final JFrame mainFrame = new JFrame();
        mainFrame.setTitle("Home Page");

        PageContent page1 = new PageContent();

        final JLabel homeUILabel = page1.homeUILabel("src/assets/homeui.png");
        add(homeUILabel);

        final JButton startButton = new JButton();

        startButton.setBounds(270, 350, 200, 50);

        ImageIcon icon = new ImageIcon(HomeGUI.class.getResource("/assets/start.png"));
        startButton.setIcon(icon);

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.dispose();
                new Level1GUI();
            }
        });

        mainFrame.add(homeUILabel);
        mainFrame.add(startButton);

        mainFrame.setSize(800, 600);

        mainFrame.setLayout(null);
        mainFrame.setResizable(false);

        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainFrame.setVisible(true);

    }

}
