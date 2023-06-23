package UI;

import entity.PageContent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WinGUI extends JFrame {
    public WinGUI(){

        final JFrame mainFrame = new JFrame();
        mainFrame.setTitle("Home Page");

        PageContent page2 = new PageContent();

        final JLabel winLabel = page2.homeUILabel("src/assets/winui.png");
        add(winLabel);

        mainFrame.add(winLabel);

        mainFrame.setSize(800, 600);

        mainFrame.setLayout(null);
        mainFrame.setResizable(false);

        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainFrame.setVisible(true);

    }
}
