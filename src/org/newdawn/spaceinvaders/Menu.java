package org.newdawn.spaceinvaders;

import org.newdawn.spaceinvaders.login.MemberService;
import org.newdawn.spaceinvaders.stage.shop.Coin;

import org.newdawn.spaceinvaders.stage.shop.Shop;

import javax.swing.*;
import java.awt.*;

public class Menu extends JFrame {
    private JButton playgameButton;
    private JButton twoPlayergameButton;
    private JButton newgameButton;
    private JButton shipSelectButton;
    private JButton shopButton;

    private JButton signUp;
    private JButton exitButton;
    private static int BUTTON_SIZE = 8;
    Coin coin = new Coin();

    public Menu() {

        super("Space Invader 102");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        // get hold the content of the frame and set up the resolution of the game
        setContentPane(new JPanel());
        setIgnoreRepaint(false);
        setVisible(true);
        GridBagConstraints[] gbc = new GridBagConstraints[BUTTON_SIZE];
        GridBagLayout gbl = new GridBagLayout();
        setLayout(gbl);


        playgameButton = new JButton("playgame");
        playgameButton.setBounds(350, 50, 200, 50);
        gbc[1] = new GridBagConstraints();
        gbc[1].gridx = 1;
        gbc[1].gridy = 1;
        getContentPane().add(playgameButton, gbc[1]);
        playgameButton.addActionListener(e -> {
            Thread thread = new Thread(() -> {
                Game game = new Game();
                setVisible(false);
                game.gameLoop();
            });
            thread.start();
        });

        twoPlayergameButton = new JButton("2playergame");
        twoPlayergameButton.setBounds(350, 300, 200, 50);
        gbc[2] = new GridBagConstraints();
        gbc[2].gridx = 1;
        gbc[2].gridy = 2;
        getContentPane().add(twoPlayergameButton, gbc[2]);
        twoPlayergameButton.addActionListener(e -> {
            Thread thread = new Thread(() -> {
                TwoPlayer twoPlayer = new TwoPlayer();
                setVisible(false);
                twoPlayer.gameLoop();
            });
            thread.start();

        });

        newgameButton = new JButton("new game");
        newgameButton.setBounds(350, 350, 200, 50);
        gbc[3] = new GridBagConstraints();
        gbc[3].gridx = 1;
        gbc[3].gridy = 3;
        getContentPane().add(newgameButton, gbc[3]);
        newgameButton.addActionListener(e -> {
            System.exit(0); // 지금은 나가기, 이후 newgame
        });

        shipSelectButton = new JButton("shipselect");
        shipSelectButton.setBounds(350, 400, 200, 50);
        gbc[4] = new GridBagConstraints();
        gbc[4].gridx = 1;
        gbc[4].gridy = 4;
        getContentPane().add(shipSelectButton, gbc[4]);
        shipSelectButton.addActionListener(e -> {
            Thread thread = new Thread(() -> {
                dispose();
                GameFrame g = new GameFrame();
                new CharacterChange(g);
                setVisible(false);
            });
            thread.start();

        });

        shopButton = new JButton("shop");
        shopButton.setBounds(350, 450, 200, 50);
        gbc[5] = new GridBagConstraints();
        gbc[5].gridx = 1;
        gbc[5].gridy = 5;
        getContentPane().add(shopButton, gbc[5]);
        shopButton.addActionListener(e -> {
            Thread thread = new Thread(() -> {
                dispose();
                new Shop();
                setVisible(false);
            });
            thread.start();
        });

        signUp = new JButton("Sign up");
        signUp.setBounds(350, 450, 200, 50);
        gbc[6] = new GridBagConstraints();
        gbc[6].gridx = 1;
        gbc[6].gridy = 6;
        getContentPane().add(signUp, gbc[6]);
        signUp.addActionListener(e -> {
            Thread thread = new Thread(() -> {
                dispose();
                new MemberService();
                setVisible(false);
            });
            thread.start();
        });

        exitButton = new JButton("exitgame");
        exitButton.setBounds(350, 500, 200, 50);
        gbc[7] = new GridBagConstraints();
        gbc[7].gridx = 1;
        gbc[7].gridy = 7;
        getContentPane().add(exitButton, gbc[7]);
        exitButton.addActionListener(e -> {
            System.exit(0);
        });
        setVisible(true);
    }


    public static void main(String argv[]) {
        Menu m = new Menu();


    }
}


