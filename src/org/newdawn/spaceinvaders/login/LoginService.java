package org.newdawn.spaceinvaders.login;

import org.newdawn.spaceinvaders.Game;
import org.newdawn.spaceinvaders.Menu;
import org.newdawn.spaceinvaders.stage.StageLevel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginService extends JFrame {

    private static int BUTTON_SIZE = 6;
    JFrame frame;
    JTextField id, password, findId;//클래스 변수로 선언
    Member member = new Member();
    MemberRepository memberRepository = new MemberRepository();

    public LoginService() {

        super("로그인 창");

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

        // 입력창 배치
        JPanel panel = new JPanel();
        BoxLayout boxLayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
        panel.setLayout(boxLayout);

        panel.add(new JLabel("로그인 창"));

        panel.add(Box.createVerticalStrut(20)); // 수직 간격 20픽셀

        panel.add(new JLabel("아이디:"));
        id = new JTextField(20);
        panel.add(id);

        panel.add(new JLabel("비밀번호:"));
        password = new JTextField(20);
        panel.add(password);

        JButton button = new JButton("확인");
        button.addActionListener(new LoginService.SignInListener(this));
        panel.add(button);

        panel.add(Box.createVerticalStrut(20)); // 수직 간격 20픽셀


        panel.add(Box.createVerticalStrut(20)); // 수직 간격 20픽셀

        JButton button1 = new JButton("게스트 로그인");
        button1.addActionListener(new LoginService.GuestLoginListener(this));
        panel.add(button1);

        panel.add(Box.createVerticalStrut(20)); // 수직 간격 20픽셀


        JButton signUp = new JButton("회원가입/비밀번호 찾기");
        signUp.addActionListener(e -> {
            dispose();
            new MemberService();
            setVisible(false);
        });
        panel.add(signUp);

        panel.add(Box.createVerticalStrut(20)); // 수직 간격 20픽셀

        JButton button2 = new JButton("로그아웃");
        button2.setBounds(350, 600, 200, 50);
        gbc[3] = new GridBagConstraints();
        gbc[3].gridx = 1;
        gbc[3].gridy = 3;
        getContentPane().add(button2, gbc[3]);
        button2.addActionListener(e -> {

            Member member  = new Member();
            member.setLoginCookie(false);
            member.setLoginName("");
            member.setLoginPassword("");

            level.setCurrentLevel(0);
            //알림창 구현
            JOptionPane.showMessageDialog(frame, "로그아웃 되었습니다.");

            dispose();
            new Menu();
            setVisible(false);

        });
        panel.add(button2);

        panel.add(Box.createVerticalStrut(20)); // 수직 간격 20픽셀

        JButton goMenu = new JButton("뒤로가기");
        goMenu.setBounds(350, 600, 200, 50);
        gbc[4] = new GridBagConstraints();
        gbc[4].gridx = 1;
        gbc[4].gridy = 4;
        getContentPane().add(goMenu, gbc[4]);
        goMenu.addActionListener(e -> {
            dispose();
            new Menu();
            setVisible(false);
        });

        this.add(panel);
        this.setVisible(true);

    }

    /*
    로그인 로직
        입력 받은 아이디와 비밀번호를 통해 DB에 저장되어있는 비밀번호와 비교
     */

    class SignInListener implements ActionListener {
        JFrame frame;

        public SignInListener(JFrame f) {
            frame = f;
        }

        @Override
        public void actionPerformed(ActionEvent arg0) {
            //버튼을 누르면 이쪽으로 이동
            System.out.println(arg0.getActionCommand());

            if (id.getText() == null) {
                JOptionPane.showMessageDialog(frame, "아이디는 비어있을 수 없습니다.");
            } else {

                System.out.println("id: " + id.getText());
                System.out.println("password: " + password.getText());

                //아이디를 통해 저장되어 있는 비밀번호를 찾은후, 입력 받은 비밀번호와 동일한지 확인
                String checkPassword = memberRepository.findPassword(id.getText());
                System.out.println("checkPassword = " + checkPassword);

                if (checkPassword.equals(password.getText())) {
                    System.out.println("로그인 성공");

                    //로그인 쿠키  true로 설정
                    member.setLoginCookie(true);
                    //현재 로그인한 회원 정보 저장
                    member.setLoginName(id.getText());
                    member.setLoginPassword(password.getText());

                    JOptionPane.showMessageDialog(frame, "로그인 성공 - 환영합니다, " + member.getLoginName() + "님.");

                    //new game을 경유하여 로그인 요청이 들어온 경우
                    if (member.isGameCookie()) {
                        //new game 쿠키를 초기화
                        member.setGameCookie(false);

                        dispose();

                        //게임 시작!
                        Thread thread = new Thread(() -> {
                            Game game = new Game();
                            setVisible(false);
                            game.gameLoop();
                        });
                        thread.start();

                    //메뉴로 복귀
                    }else {
                        dispose();
                        new Menu();
                        setVisible(false);
                    }


                } else {
                    System.out.println("로그인 실패");
                    JOptionPane.showMessageDialog(frame, "로그인 실패 - 아이디나 비밀번호를 확인해주세요.");
                }

            }

        }
    }

    class GuestLoginListener implements ActionListener {
        JFrame frame;

        public GuestLoginListener(JFrame f) {
            frame = f;
        }

        @Override
        public void actionPerformed(ActionEvent arg0) {

            System.out.println("게스트 로그인");
            member.setLoginCookie(true);
            member.setLoginName("guest");
            member.setLoginPassword("guest");

            JOptionPane.showMessageDialog(frame, "게스트로 로그인 하셨습니다.");

            //new game을 경유하여 게스트 로그인 요청이 들어온 경우
            if (member.isGameCookie()) {
                //new game 쿠키 제거
                member.setGameCookie(false);

                Thread thread = new Thread(() -> {
                    Game game = new Game();
                    setVisible(false);
                    game.gameLoop();
                });
                thread.start();
            }else {
                dispose();
                new Menu();
                setVisible(false);
            }


        }
    }
}

