package UI;

import entity.PageContent;
import entity.Player;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Timer;

public class Level1GUI extends JFrame{
    private final Timer timer;

    private final Player player;

    private boolean isLose = false;

    private int count = 10;

    public Level1GUI(){
        setTitle("Maze Games");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800,630);
        setLocationRelativeTo(null);
        setResizable(false);

        player = new Player(280, 500);
        PageContent page = new PageContent();


        final JLabel backgroundLabel = page.bgLabel("src/assets/ground1.png");
        add(backgroundLabel);
        final JLabel obstacleLabel = page.obsLabel("src/assets/obstacle1.png");
        backgroundLabel.add(obstacleLabel);

        final JLabel characterLabel = page.charLabel("src/assets/character.png");
        backgroundLabel.add(characterLabel);



        final JLabel timerLabel = page.timeLabel("Timer : " + count);
        backgroundLabel.add(timerLabel);

        final JLabel winLabel = page.notifLabel();
        backgroundLabel.add(winLabel);

        timer = new Timer(1000, new ActionListener(){// Timer 1 seconds
            public void actionPerformed(ActionEvent e) {
                if (count <= 0){
                    count = 10;
                    player.setX(280);
                    player.setY(500);
                    characterLabel.setLocation(player.getX(), player.getY());
                    isLose = true;
                }
                if (isLose) {
                    winLabel.setText("TIME UP!!!");
                    if (count < 9) {
                        isLose = false;
                        winLabel.setText("");
                    }
                }
                timerLabel.setText("Timer : " + count);
                count--;
            }
        });wwww

        timer.start();

        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                switch (keyCode){

                    case KeyEvent.VK_UP :
                    case KeyEvent.VK_W :
                        if (player.getY() > 460){//Bawah
                            player.setY(player.getY() - 10);
                        }else if (player.getY() > 320 && (player.getX() < 80 || player.getX() > 660)){//Kiri kanan bawah
                            player.setY(player.getY() - 10);
                        }else if (player.getY() < 370 && player.getY() > 320 && ((player.getX() > 60 && player.getX() < 130) || (player.getX() > 610 && player.getX() < 630))){
                            player.setY(player.getY() - 10);
                        }else if (player.getY() < 380 && player.getY() > 180 && player.getX() > 120 && player.getX() < 620){
                            player.setY(player.getY() - 10);
                        }else if (player.getY() > 180 && player.getY() < 240 && ((player.getX() < 130 && player.getX() > 20) || (player.getX() < 730 && player.getX() > 610))){
                            player.setY(player.getY() - 10);
                        }else if (player.getY() < 220 && player.getY() > 40 && (player.getX() > 660 || player.getX() < 80)){
                            player.setY(player.getY() - 10);
                        }else if (player.getY() < 80)
                        {
                            if (player.getY() > 40 && (player.getX() < 400 || player.getX() > 540)){
                                player.setY(player.getY() - 10);
                            }else if (player.getX() > 390 && player.getX() < 540){
                                player.setY(player.getY() - 10);
                                if (player.getY() == -10){
                                    timer.stop();
                                    dispose();
                                    new Level2GUI();
                                }
                            }
                        }
                        characterLabel.setIcon(player.upAndDown(true));
                        System.out.println("X = " + player.getX() + " , Y = " + player.getY());
                        break;

                    case KeyEvent.VK_DOWN:
                    case KeyEvent.VK_S:
                        if (player.getY() >= 440 && player.getY() < 520){
                            player.setY(player.getY() + 10);
                        }else if (player.getY() < 500 && player.getY() > 290 && (player.getX() < 80 || player.getX() > 660)){
                            player.setY(player.getY() + 10);
                        }else if (player.getY() < 360 && player.getY() > 290 && ((player.getX() > 60 && player.getX() < 130) || (player.getX() > 610 && player.getX() < 670))){
                            player.setY(player.getY() + 10);
                        }else if (player.getY() < 370 && player.getY() > 140 && player.getX() > 120 && player.getX() < 620){
                            player.setY(player.getY() + 10);
                        }else if (player.getY() > 140 && player.getY() < 230 && ((player.getX() < 130 && player.getX() > 60) || (player.getX() < 670 && player.getX() > 610))){
                            player.setY(player.getY() + 10);
                        }else if (player.getY() < 230 && player.getY() > 10 && (player.getX() > 660 || player.getX() < 70)){
                            player.setY(player.getY() + 10);
                        }else if (player.getY() < 70){
                            player.setY(player.getY() + 10);
                        }
                        characterLabel.setIcon(player.upAndDown(false));
                        System.out.println("X = " + player.getX() + " , Y = " + player.getY());
                        break;

                    case KeyEvent.VK_LEFT:
                    case KeyEvent.VK_A :
                        if (player.getX() > 30){
                            if (player.getY() >= 440){//Bawah
                                player.setX(player.getX() - 10);
                            }else if (player.getX() < 340 && player.getY() > 70){//Sisi kiri
                                if (player.getY() > 290){
                                    player.setX(player.getX() - 10);
                                }else if (player.getY() > 210 && player.getX() > 130){
                                    player.setX(player.getX() - 10);
                                }else if (player.getY() <= 230){
                                    player.setX(player.getX() - 10);
                                }
                            }else if (player.getX() > 410 && player.getY() > 70){//Sisi kanan
                                if (player.getY() > 360 && player.getX() > 670){
                                    player.setX(player.getX() - 10);
                                }else if (player.getY() > 140 && player.getY() < 380){
                                    player.setX(player.getX() - 10);
                                }else if (player.getY() < 150 && player.getX() > 670){
                                    player.setX(player.getX() - 10);
                                }
                            }else if (player.getY() < 80){
                                player.setX(player.getX() - 10);
                            }
                        }
                        characterLabel.setIcon(player.leftAndRight(true));
                        System.out.println("X = " + player.getX() + " , Y = " + player.getY());
                        break;

                    case KeyEvent.VK_RIGHT:
                    case KeyEvent.VK_D :
                        if (player.getX() < 720){
                            if (player.getY() >= 440){//Bawah
                                player.setX(player.getX() + 10);
                            }else if (player.getX() > 400 && player.getY() > 70){//Sisi kanan
                                if (player.getY() > 310){
                                    player.setX(player.getX() + 10);
                                }else if (player.getY() > 220 && player.getX() < 720){
                                    player.setX(player.getX() + 10);
                                }else if (player.getY() <= 210){
                                    player.setX(player.getX() + 10);
                                }
                            }else if (player.getX() < 330 && player.getY() > 70){//Sisi kiri
                                if (player.getY() > 360 && player.getX() < 80){
                                    player.setX(player.getX() + 10);
                                }else if (player.getY() > 140 && player.getY() < 380){
                                    player.setX(player.getX() + 10);
                                }else if (player.getY() < 150 && player.getX() < 60){
                                    player.setX(player.getX() + 10);
                                }
                            }else if (player.getY() < 80){
                                player.setX(player.getX() + 10);
                            }
                        }
                        characterLabel.setIcon(player.leftAndRight(false));
                        System.out.println("X = " + player.getX() + " , Y = " + player.getY());
                        break;

                    default:
                        break;
                }
                characterLabel.setLocation(player.getX(), player.getY());
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        setVisible(true);
    }
}
