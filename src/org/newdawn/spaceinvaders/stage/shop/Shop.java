package org.newdawn.spaceinvaders.stage.shop;

import org.newdawn.spaceinvaders.Menu;
import org.newdawn.spaceinvaders.stage.StageLevel;

import javax.swing.*;
import java.awt.*;

public class Shop extends JFrame {

    private JButton attackDamageInhenceButton;
    private JButton attackSpeedInhenceButton;
    private JButton alienSpeedDecreaseButton;
    private JButton goMenu;
    private static int BUTTON_SIZE = 6;
    ShopService shopService = new ShopService();

    Coin coin = new Coin();

    public Shop(){

        super("Space Invader 102");

        StageLevel level = new StageLevel();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);
        // get hold the content of the frame and set up the resolution of the game
        setContentPane(new JPanel());
        setIgnoreRepaint(false);
        GridBagConstraints[] gbc = new GridBagConstraints[BUTTON_SIZE];
        GridBagLayout gbl = new GridBagLayout();
        setLayout(gbl);

        attackDamageInhenceButton = new JButton("attack damage ++");
        attackDamageInhenceButton.setBounds(350, 300, 200, 50);
        gbc[1] = new GridBagConstraints();
        gbc[1].gridx = 1;
        gbc[1].gridy = 1;
        getContentPane().add(attackDamageInhenceButton,gbc[1]);
        attackDamageInhenceButton.addActionListener(e -> {
            System.exit(0); // 지금은 나가기, 공격력 증가
        });

        attackSpeedInhenceButton = new JButton("attack speed ++");
        attackSpeedInhenceButton.setBounds(350, 350, 200, 50);
        gbc[2] = new GridBagConstraints();
        gbc[2].gridx = 1;
        gbc[2].gridy = 2;
        getContentPane().add(attackSpeedInhenceButton,gbc[2]);
        attackSpeedInhenceButton.addActionListener(e -> {

            shopService.Increase();
            System.out.println("상점 구매 - 공격속도 증가버튼");

            System.out.println("샵 => 발사 속도 증가 성공 : 현재 속도: " + level.getChangeFiringInterval() + " 현재 코인 : " + coin.getCoin());

            //System.exit(0); // 지금은 나가기, 공격속도증가
        });

        alienSpeedDecreaseButton = new JButton("alien speed down");
        alienSpeedDecreaseButton.setBounds(350, 400, 200, 50);
        gbc[3] = new GridBagConstraints();
        gbc[3].gridx = 1;
        gbc[3].gridy = 3;
        getContentPane().add(alienSpeedDecreaseButton,gbc[3]);
        alienSpeedDecreaseButton.addActionListener(e -> {

            shopService.Decrease();
            System.out.println("상점 구매 - 적 하강속도 감소버튼");
            //System.exit(0); // 지금은 나가기, 슬로우
        });

        goMenu = new JButton("exit");
        goMenu.setBounds(350, 450, 200, 50);
        gbc[4] = new GridBagConstraints();
        gbc[4].gridx = 1;
        gbc[4].gridy = 4;
        getContentPane().add(goMenu,gbc[4]);
        goMenu.addActionListener(e -> {
            dispose();
            new Menu();
            setVisible(false);
        });
    }
}
