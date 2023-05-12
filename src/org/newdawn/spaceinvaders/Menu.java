package org.newdawn.spaceinvaders;

import org.newdawn.spaceinvaders.login.LoginService;
import org.newdawn.spaceinvaders.login.Member;
import org.newdawn.spaceinvaders.login.MemberService;
import org.newdawn.spaceinvaders.stage.StageLevel;
import org.newdawn.spaceinvaders.stage.shop.Coin;

import org.newdawn.spaceinvaders.stage.shop.Shop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame {

    private JButton playgameButton;
    private JButton twoPlayergameButton;
    private JButton newgameButton;
    private JButton shipSelectButton;
    private JButton shopButton;

    private JButton signUp;
    private JButton exitButton;

    private JButton signIn;
    private static int BUTTON_SIZE = 9;
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
            Member member = new Member();
            StageLevel level = new StageLevel();
            JFrame frame = new JFrame();
            if (!member.isLoginCookie()) {

                JOptionPane.showMessageDialog(frame, "저장된 기록이 없습니다. 로그인 해주세요.");
            } else if (level.getCurrentLevel() == 0) {
                JOptionPane.showMessageDialog(frame, "저장된 기록이 없습니다. new game을 시작해주세요.");
            } else {
                Thread thread = new Thread(() -> {

                    Game game = new Game();
                    setVisible(false);
                    game.gameLoop();
                });
                thread.start();
            }
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

        newgameButton.addActionListener(new Menu.NewGameListener(this));


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


        signUp = new JButton("Sign In/Sign up");
        signUp.setBounds(350, 450, 200, 50);
        gbc[6] = new GridBagConstraints();
        gbc[6].gridx = 1;
        gbc[6].gridy = 6;
        getContentPane().add(signUp, gbc[6]);
        signUp.addActionListener(e -> {
            Thread thread = new Thread(() -> {
                dispose();
                new LoginService();
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
/*
        signIn = new JButton("Sign In");
        signIn.setBounds(350, 450, 200, 50);
        gbc[8] = new GridBagConstraints();
        gbc[8].gridx = 1;
        gbc[8].gridy = 8;
        getContentPane().add(signIn, gbc[8]);
        signIn.addActionListener(e -> {
            Thread thread = new Thread(() -> {
                dispose();
                new LoginService();
                setVisible(false);
            });
            thread.start();
        });

 */
        setVisible(true);
    }

    /*
    new game 실행 로직
        1. 모든 변수를 초기화
        2. 로그인 여부를 확인
        2-1. 로그인이 되어있을 경우 바로 게임 시작
        2-2. 로그인이 안 되어 있을 경우, LoginService로 넘김
             동시에 gameCookie를 true로 변경
             -> 로그인이 되면 새 게임 시작한 후, gameCookie를 false로 변경
     */
    class NewGameListener implements ActionListener {
        JFrame frame;

        public NewGameListener(JFrame f) {
            frame = f;
        }

        @Override
        public void actionPerformed(ActionEvent arg0) {

            //새 게임이 시작하면 모든 변수 초기화
            StageLevel stageLevel = new StageLevel();
            Member member = new Member();

            stageLevel.setChangeFiringInterval(500);
            stageLevel.setCurrentLevel(0);
            stageLevel.setAlienY(10);
            stageLevel.setSlowInvaderSpeed(1);

            //loginCookie가 true다 -> 로그인이 되어 있다.
            if (member.isLoginCookie()) {
                JFrame frame = new JFrame();
                JOptionPane.showMessageDialog(frame, member.getLoginName() + "님, 새 게임이 시작됩니다.");

                Thread thread = new Thread(() -> {
                    Game game = new Game();
                    setVisible(false);
                    game.gameLoop();
                });
                thread.start();

            } else {
                //로그인 쿠키가 false다 -> 로그인이 안되어 있다.
                member.setLoginName("");
                member.setLoginPassword("");
                member.setGameCookie(true);

                Thread thread = new Thread(() -> {
                    dispose();
                    new LoginService();
                    setVisible(false);
                });
                thread.start();
            }

        }
    }


    public static void main(String argv[]) {
        Menu m = new Menu();


    }
}

