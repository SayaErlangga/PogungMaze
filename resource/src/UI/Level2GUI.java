package UI;

import entity.PageContent;
import entity.Player;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Timer;

public class Level2GUI extends JFrame{
    private final Timer timer;

    private final Player player;

    private boolean isLose = false;

    private int count = 8;

    public Level2GUI(){
        setTitle("Maze Games");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800,630);
        setLocationRelativeTo(null);
        setResizable(false);

        player = new Player(280, 500);
        PageContent page = new PageContent();

        final JLabel backgroundLabel = page.bgLabel("src/assets/ground1.png");
        add(backgroundLabel);
        final JLabel obstacleLabel = page.obsLabel("src/assets/obstacle2.png");
        backgroundLabel.add(obstacleLabel);
        final JLabel characterLabel = page.charLabel("src/assets/cU.gif");
        backgroundLabel.add(characterLabel);

        final JLabel timerLabel = page.timeLabel("Timer : " + count);
        backgroundLabel.add(timerLabel);

        final JLabel winLabel = page.notifLabel();
        backgroundLabel.add(winLabel);

        timer = new Timer(1000, new ActionListener(){// Timer 1 seconds
            public void actionPerformed(ActionEvent e) {
                //System.out.println(count);
                if (count <= 0){
                    count = 8;
                    player.setX(280);
                    player.setY(500);
                    characterLabel.setLocation(player.getX(), player.getY());
                    isLose = true;
                }
                if (isLose){
                    winLabel.setText("TIME UP!!!");
                    if (count < 14) {
                        isLose = false;
                        winLabel.setText("");
                    }
                }
                timerLabel.setText("Timer : " + count);
                count--;
            }
        });

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
                        if (player.getY() > 440){//Bawah
                            player.setY(player.getY() - 10);
                        }else if (player.getY() > 300 && (player.getX() < 150 || player.getX() > 400)){//Kiri kanan bawah
                            player.setY(player.getY() - 10);
                        }else if (player.getY() < 370 && player.getY() > 300 && ((player.getX() > 60 && player.getX() < 290) || (player.getX() > 450 && player.getX() < 670))){
                            player.setY(player.getY() - 10);
                        }else if (player.getY() < 370 && player.getY() > 150 && player.getX() > 280 && player.getX() < 460){
                            player.setY(player.getY() - 10);
                        }else if (player.getY() > 150 && player.getY() < 220 && ((player.getX() < 330 && player.getX() > 60) || (player.getX() < 670 && player.getX() > 400))){
                            player.setY(player.getY() - 10);
                        }else if (player.getY() < 220 && player.getY() > 10 && (player.getX() > 530 || player.getX() < 370)){
                            player.setY(player.getY() - 10);
                        }else if (player.getY() < 80)
                        {
                            if (player.getY() > 10 && (player.getX() < 400 || player.getX() > 530)){
                                player.setY(player.getY() - 10);
                            }else if (player.getX() > 390 && player.getX() < 540){
                                player.setY(player.getY() - 10);
                                if (player.getY() == -10){
                                    timer.stop();
                                    dispose();
                                    new HomeGUI();
                                    new WinGUI();
                                }
                            }
                        }
                        characterLabel.setIcon(player.upAndDown(true));
                        System.out.println("X = " + player.getX() + " , Y = " + player.getY());
                        break;

                    case KeyEvent.VK_DOWN:
                    case KeyEvent.VK_S:
                        if (player.getY() >= 440 && player.getY() < 500){
                            player.setY(player.getY() + 10);
                        }else if (player.getY() < 500 && player.getY() > 290 && (player.getX() < 150 || player.getX() > 400)){
                            player.setY(player.getY() + 10);
                        }else if (player.getY() < 360 && player.getY() > 290 && ((player.getX() > 60 && player.getX() < 290) || (player.getX() > 450 && player.getX() < 670))){
                            player.setY(player.getY() + 10);
                        }else if (player.getY() < 360 && player.getY() > 140 && player.getX() > 280 && player.getX() < 440){
                            player.setY(player.getY() + 10);
                        }else if (player.getY() > 140 && player.getY() < 210 && ((player.getX() < 330 && player.getX() > 60) || (player.getX() == 700))){
                            player.setY(player.getY() + 10);
                        }else if (player.getY() < 210 && player.getY() > 10 && (player.getX() == 700 || player.getX() < 330)){
                            player.setY(player.getY() + 10);
                        }else if (player.getY() < 210){
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
                            }else if (player.getX() < 330 && player.getY() > 70){//Sisi kiri
                                if (player.getY() > 290){
                                    player.setX(player.getX() - 10);
                                }else if (player.getY() > 210 && player.getX() > 290){
                                    player.setX(player.getX() - 10);
                                }else if (player.getY() <= 210){
                                    player.setX(player.getX() - 10);
                                }
                            }else if (player.getX() > 410 && player.getY() > 70){//Sisi kanan
                                if (player.getY() > 360 && player.getX() > 450){
                                    player.setX(player.getX() - 10);
                                }else if (player.getY() > 140 && player.getY() < 370){
                                    if (player.getY() > 290 && player.getX() <= 700){
                                        player.setX(player.getX() - 10);
                                    }else if (player.getX() < 4600){
                                        player.setX(player.getX() - 10);
                                    }
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
                        if (player.getX() < 700){
                            if (player.getY() >= 440){//Bawah
                                player.setX(player.getX() + 10);
                            }else if (player.getX() > 400 && player.getY() > 70){//Sisi kanan
                                if (player.getY() > 290){
                                    player.setX(player.getX() + 10);
                                }else if (player.getY() > 210 && player.getX() < 450){
                                    player.setX(player.getX() + 10);
                                }else if (player.getY() <= 210 && player.getX() < 700){
                                    player.setX(player.getX() + 10);
                                }
                            }else if (player.getX() < 320 && player.getY() > 70){//Sisi kiri
                                if (player.getY() > 360 && player.getX() < 150){
                                    player.setX(player.getX() + 10);
                                }else if (player.getY() > 140 && player.getY() < 370){
                                    player.setX(player.getX() + 10);
                                }else if (player.getY() < 150 && player.getX() < 330){
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