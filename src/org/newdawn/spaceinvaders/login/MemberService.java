package org.newdawn.spaceinvaders.login;

import org.newdawn.spaceinvaders.Menu;
import org.newdawn.spaceinvaders.stage.StageLevel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class MemberService extends JFrame {

    private static int BUTTON_SIZE = 6;
    JTextField id, password, findId;//클래스 변수로 선언

    Member member = new Member();
    MemberRepository memberRepository = new MemberRepository();

    public MemberService() {

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

        // 입력창 배치
        JPanel panel = new JPanel();
        BoxLayout boxLayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
        panel.setLayout(boxLayout);

        panel.add(new JLabel("아이디:"));
        id = new JTextField(20);
        panel.add(id);

        panel.add(new JLabel("비밀번호:"));
        password = new JTextField(20);
        panel.add(password);

        JButton button = new JButton("확인");
        button.addActionListener(new SignUpListener(this));
        panel.add(button);

        panel.add(Box.createVerticalStrut(20)); // 수직 간격 20픽셀

        panel.add(new JLabel("찾으려는 아이디:"));
        findId = new JTextField(20);
        panel.add(findId);

        JButton button1 = new JButton("비밀번호 확인");
        button1.addActionListener(new MemberConfirmListener(this));
        panel.add(button1);

        panel.add(Box.createVerticalStrut(20)); // 수직 간격 20픽셀

        //정상 작동 x
        JButton signUpEnter = new JButton("회원목록 확인");
        signUpEnter.setBounds(350, 300, 200, 50);
        gbc[1] = new GridBagConstraints();
        gbc[1].gridx = 1;
        gbc[1].gridy = 1;
        getContentPane().add(signUpEnter, gbc[1]);
        signUpEnter.addActionListener(e -> {
/*
            memberRepository.save("name1", "1111");
            memberRepository.save("name2", "2222");
            memberRepository.save("name3", "3333");
*/
            Map<Long, Member> list = memberRepository.findAll();

            /*
            이상하다... 해쉬맵에 값은 잘 저장되어 있는데 왜 출력은 하나만 되는 것인가...
             */
            for(Long key : list.keySet()){
                System.out.println("key = " + key + " name = " + list.get(key).getName());
            }

        });


        JButton goMenu = new JButton("exit");
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

    class SignUpListener implements ActionListener {
        JFrame frame;

        public SignUpListener(JFrame f) {
            frame = f;
        }

        @Override
        public void actionPerformed(ActionEvent arg0) {
            //버튼을 누르면 이쪽으로 이동
            System.out.println(arg0.getActionCommand());
            //String memId = id.getText();
            System.out.println("id: " + id.getText());
            //String memPassword = password.getText();
            System.out.println("password: " + password.getText());

            //HashMap에 데이터를 {아이디 : 비밀번호} 형식으로 저장
            memberRepository.save(id.getText(), password.getText());
            //회원목록을 출력하기 위해 {회원번호 : Member 객체} 형식으로 저장

            //다이얼로그
            JOptionPane.showMessageDialog(frame, "환영합니다, " + member.getName() + "님.");
        }
    }

    class MemberConfirmListener implements ActionListener {
        JFrame frame;

        public MemberConfirmListener(JFrame f) {
            frame = f;
        }

        @Override
        public void actionPerformed(ActionEvent arg0) {
            //버튼을 누르면 이쪽으로 이동
            System.out.println(arg0.getActionCommand());
            //String memId = id.getText();
            System.out.println("id: " + findId.getText());

            String info = memberRepository.findPassword(findId.getText());
            if (info == null) {
                JOptionPane.showMessageDialog(frame, "존재하지 않는 회원입니다.");
            } else {
                JOptionPane.showMessageDialog(frame, findId.getText() + "님, 비밀번호는 " + info + "입니다.");
            }
            //다이얼로그

        }
    }
}