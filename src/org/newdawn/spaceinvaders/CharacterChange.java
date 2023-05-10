package org.newdawn.spaceinvaders;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;



public class CharacterChange extends JPanel {

        private GameFrame parent;
        Game g;

        //배경 이미지

        public CharacterChange(GameFrame parent) {
            this.parent = parent; //프레임 래퍼랜스 저장 => GameFrame에 작성할 함수를 이용하기 위함

            //원하는 위치에 버튼을 붙이기 위해 배치관리자 제거
            setLayout(null);

            //3개의 버튼을 달고 있는 panel을 생성
            JButton changeButton1 = new JButton("Tank");
            changeButton1.setSize(600,110);
            changeButton1.setLocation(100, 0);
            add(changeButton1);
            changeButton1.addActionListener(e -> {
                Thread thread = new Thread(() -> {

                    Game g = new Game();
                    g.change1= true;
                    g.gameLoop();
                    setVisible(false);
                });
                thread.start();

            });


            JButton changeButton2 = new JButton("Fighter Plane");
            changeButton2.setSize(600,110);
            changeButton2.setLocation(100, 110);
            add(changeButton2);
            changeButton2.addActionListener(e -> {
                Thread thread = new Thread(() -> {
                    Game g = new Game();
                    g.change2= true;
                    g.gameLoop();
                    setVisible(false);
                });
                thread.start();

            });


            JButton changeButton3 = new JButton("Rocket");
            changeButton3.setSize(600,110);
            changeButton3.setLocation(100, 220);
            add(changeButton3);
            changeButton3.addActionListener(e -> {
                        Thread thread = new Thread(() -> {
                            Game g = new Game();
                            g.change3= true;
                            g.gameLoop();
                            setVisible(false);
                        });
                        thread.start();

                    });
        }


        public static void main(String argv[]){
            GameFrame g = new GameFrame();
            CharacterChange characterChange = new CharacterChange(g);

        }
    }


