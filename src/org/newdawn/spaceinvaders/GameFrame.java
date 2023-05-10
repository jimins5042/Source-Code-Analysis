package org.newdawn.spaceinvaders;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class GameFrame extends JFrame {
    //시작화면
    private CharacterChange characterChange;

    public GameFrame() {
        //프로그램의 타이틀을 표시한다.
        setTitle("character Change");
        //프레임의 크기를 정한다. px단위이다.
        setSize(800,600);
        //생성한 프레임이 화면에 보이도록 한다.

        //x버튼을 눌러 프로그램을 종료하도록한다.
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        //메뉴화면을 생성한다.
       characterChange = new CharacterChange(this);
        //메뉴화면을 컨텐트팬으로 지정한다.
        setContentPane(characterChange);


        setVisible(true);
    }
}

