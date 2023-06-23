package entity;

import javax.swing.*;
import java.awt.*;

public class PageContent extends UIContent{
    @Override
    public JLabel bgLabel(String asset) {
        ImageIcon backgroundImage = new ImageIcon(asset);
        JLabel backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setBounds(0,0,800,600);
        return backgroundLabel;
    }

    public JLabel obsLabel(String asset) {
        ImageIcon obstacleImage = new ImageIcon(asset);
        JLabel obstacleLabel = new JLabel(obstacleImage);
        obstacleLabel.setBounds(0,0,800,600);
        return obstacleLabel;
    }

    @Override
    public JLabel homeUILabel(String asset) {
        ImageIcon homeUIImage = new ImageIcon(asset);
        JLabel homeUILabel = new JLabel(homeUIImage);
        homeUILabel.setBounds(0,0,800,600);
        return homeUILabel;
    }

    @Override
    public JLabel winLabel(String asset) {
        ImageIcon winImage = new ImageIcon(asset);
        JLabel winLabel = new JLabel(winImage);
        winLabel.setBounds(0,0,800,600);
        return winLabel;
    }

    @Override
    public JLabel charLabel(String asset) {
        ImageIcon characterImage = new ImageIcon(asset);
        JLabel characterLabel = new JLabel(characterImage);
        characterLabel.setBounds(280, 500,50,50);
        return characterLabel;
    }

    @Override
    public JLabel timeLabel(String text) {
        JLabel timerLabel = new JLabel(text);
        timerLabel.setFont(new Font("Arial", Font.BOLD, 20));
        timerLabel.setForeground(Color.BLACK);
        timerLabel.setBounds(30,40,400,30);
        return timerLabel;
    }

    @Override
    public JLabel notifLabel() {
        JLabel winLabel = new JLabel();
        winLabel.setFont(new Font("Arial", Font.BOLD, 20));
        winLabel.setForeground(Color.BLACK);
        winLabel.setBounds(350,40,400,30);
        return winLabel;
    }
}
