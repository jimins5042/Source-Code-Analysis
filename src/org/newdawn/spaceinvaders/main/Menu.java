package org.newdawn.spaceinvaders.main;

import org.newdawn.spaceinvaders.jdbcdb.GameInfo;
import org.newdawn.spaceinvaders.login.LoginService;
import org.newdawn.spaceinvaders.login.Member;
import org.newdawn.spaceinvaders.stage.SettingValue;
import org.newdawn.spaceinvaders.stage.shop.Coin;

import org.newdawn.spaceinvaders.stage.shop.Shop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame {

    private static int BUTTON_SIZE = 8;
    Coin coin = new Coin();

    public Menu() {

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setContentPane(new JPanel());
        frame.setIgnoreRepaint(false);
        frame.setTitle("메인 메뉴");
        frame.setLayout(new GridBagLayout());

        GridBagConstraints[] gbc = new GridBagConstraints[BUTTON_SIZE];
        int gap = 20; // 버튼 사이의 간격

        String[] buttonLabels = {
                "", // 인덱스 0은 비워둡니다.
                "새 게임",
                "게임 이어가기",
                "2인 플레이",
                "캐릭터 선택",
                "상점",
                "Sign In/Sign up",
                "게임 종료"
        };

        for (int i = 1; i < BUTTON_SIZE; i++) {
            gbc[i] = new GridBagConstraints();
            gbc[i].gridx = 1;
            gbc[i].gridy = i;
            gbc[i].insets = new Insets(gap, 0, 0, 0); // 위쪽 여백 설정

            JButton button = new JButton(buttonLabels[i]);
            button.setPreferredSize(new Dimension(200, 50)); // 버튼 크기 설정
            frame.getContentPane().add(button, gbc[i]);

            // 버튼 이벤트 리스너 등록


                /*
                따로 listener로 빼니까 메뉴 창이 사라지지 않는 문제 발생
                 -> 아마도 listener에서 또 라는 listener로 이동하면서 setVisible이 동작 안하는 듯?

            new game 실행 로직
                1. 모든 변수를 초기화
                2. 로그인 여부를 확인
                2-1. 로그인이 되어있을 경우 바로 게임 시작
                2-2. 로그인이 안 되어 있을 경우, LoginService로 넘김
                     동시에 gameCookie를 true로 변경
                        -> 로그인이 되면 새 게임 시작한 후, gameCookie를 false로 변경
                */

            if (i == 1) {
                //button.addActionListener(new Menu.NewGameListener(this));
                button.addActionListener(e -> {
                    //새 게임이 시작하면 모든 변수 초기화
                    //SettingValue value = new SettingValue(1, 10, 1);
                    SettingValue.setAlienY(10);
                    GameInfo info = new GameInfo(0, 0, 0, 0);
                    Member member = new Member();

                    //loginCookie가 true다 -> 로그인이 되어 있다.
                    if (member.isLoginCookie()) {

                        JOptionPane.showMessageDialog(frame, member.getLoginName() + "님, 새 게임이 시작됩니다.");

                        Thread thread = new Thread(() -> {
                            dispose();
                            Game game = new Game();
                            frame.setVisible(false);
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
                            frame.setVisible(false);
                        });
                        thread.start();
                    }
                });
            }

            //"playgame"
            else if (i == 2) {

                button.addActionListener(e -> {
                    Member member = new Member();
                    GameInfo info = new GameInfo();

                    //JFrame frame1 = new JFrame();

            /*
                로그인 쿠키가 있다면 -> static으로 저장된 변수 값들 그대로 유지한 체로 게임 시작
                로그인 쿠키가 없다면 -> 알림창 팝업
             */

                    if (!member.isLoginCookie()) {
                        JOptionPane.showMessageDialog(frame, "저장된 기록이 없습니다. 로그인 해주세요.");
                    } else if (info.getStage() == 0) {
                        JOptionPane.showMessageDialog(frame, "저장된 기록이 없습니다. new game을 시작해주세요.");
                    } else {
                        Thread thread = new Thread(() -> {

                            Game game = new Game();
                            frame.setVisible(false);
                            game.gameLoop();
                        });
                        thread.start();
                    }
                });
            }

            //"twoPlayergame",
            else if (i == 3) {
                button.addActionListener(e -> {
                    Thread thread = new Thread(() -> {
                        TwoPlayer twoPlayer = new TwoPlayer();
                        frame.setVisible(false);
                        twoPlayer.gameLoop();
                    });
                    thread.start();

                });
            }


            // "shipselect"
            else if (i == 4) {
                button.addActionListener(new Menu.CharacterChangeListener(this));
            }
            //"shop",
            else if (i == 5) {
                button.addActionListener(e -> {

                    if(Member.isLoginCookie()){
                        Thread thread = new Thread(() -> {
                            dispose();
                            new Shop();
                            frame.setVisible(false);
                        });
                        thread.start();
                    }else {
                        JOptionPane.showMessageDialog(frame, "로그인 해주세요.");
                    }


                });

            }
            //"Sign In/Sign up" 또는 마이페이지
            else if (i == 6) {
                Member member = new Member();
                if (member.isLoginCookie()) {
                    button.setText("마이페이지/로그아웃");
                } else {
                    button.setText("로그인/회원가입");
                }

                button.addActionListener(e -> {
                    Thread thread = new Thread(() -> {
                        dispose();
                        new LoginService();
                        frame.setVisible(false);
                    });
                    thread.start();
                });

            }
            //"exitgame"
            else if (i == 7) {
                button.addActionListener(e -> {
                    // exitButton 클릭 시 동작
                    System.exit(0);
                });
            }
        }

        frame.setVisible(true);

    }


    class CharacterChangeListener implements ActionListener {
        JFrame frame;
        SettingValue value = new SettingValue();

        public CharacterChangeListener(JFrame f) {
            frame = f;
        }

        @Override
        public void actionPerformed(ActionEvent arg0) {
            JFrame frame = new JFrame();
            frame.setBounds(50, 50, 700, 550); // 전체 창 크기
            frame.setTitle("캐릭터 목록");
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // 창 닫기 버튼 누르면 꺼지게 설정

            JPanel panel = new JPanel(new GridBagLayout());

            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0; // 그리드 X 좌표
            gbc.gridy = 0; // 그리드 Y 좌표
            gbc.fill = GridBagConstraints.VERTICAL; // 수직으로 채우기
            gbc.insets = new Insets(20, 0, 10, 0); // 위, 오른쪽, 아래, 왼쪽 여백 설정


            // 첫 번째 버튼
            JButton changeButton = new JButton("basic");
            changeButton.setPreferredSize(new Dimension(200, 50)); // 버튼의 크기 설정

            changeButton.addActionListener(e -> {
                value.setChangeShip(1);
                JOptionPane.showMessageDialog(frame, "캐릭터 변경 : basic");
                System.out.println("캐릭터 변경 : basic");
            });
            panel.add(changeButton, gbc);

            gbc.gridy++; // Y 좌표 증가

            // 첫 번째 버튼
            JButton changeButton1 = new JButton("Tank");
            changeButton1.setPreferredSize(new Dimension(200, 50)); // 버튼의 크기 설정

            changeButton1.addActionListener(e -> {
                value.setChangeShip(2);
                JOptionPane.showMessageDialog(frame, "캐릭터 변경 : Tank");
                System.out.println("캐릭터 변경 : Tank");
            });
            panel.add(changeButton1, gbc);

            gbc.gridy++; // Y 좌표 증가

            // 두 번째 버튼
            JButton changeButton2 = new JButton("Fighter Plane");
            changeButton2.setPreferredSize(new Dimension(200, 50)); // 버튼의 크기 설정

            changeButton2.addActionListener(e -> {
                value.setChangeShip(3);
                JOptionPane.showMessageDialog(frame, "캐릭터 변경 : Fighter Plane");
                System.out.println("캐릭터 변경 : Fighter Plane");
            });
            panel.add(changeButton2, gbc);

            gbc.gridy++; // Y 좌표 증가

            // 세 번째 버튼
            JButton changeButton3 = new JButton("Rocket");
            changeButton3.setPreferredSize(new Dimension(200, 50)); // 버튼의 크기 설정

            changeButton3.addActionListener(e -> {
                value.setChangeShip(4);
                JOptionPane.showMessageDialog(frame, "캐릭터 변경 : Rocket");
                System.out.println("캐릭터 변경 : Rocket");
            });
            panel.add(changeButton3, gbc);
            gbc.gridy++; // Y 좌표 증가

            // 뒤로가기
            JButton changeButton4 = new JButton("뒤로가기");
            changeButton4.setPreferredSize(new Dimension(150, 40)); // 버튼의 크기 설정

            changeButton4.addActionListener(e -> {
                frame.dispose();
            });
            panel.add(changeButton4, gbc);

            frame.add(panel);
            frame.setVisible(true);
        }
    }


    public static void main(String argv[]) {
        Menu m = new Menu();


    }
}

