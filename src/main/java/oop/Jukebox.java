package oop;

import javax.swing.*;

public class Jukebox {
    public void music(int position) {
        if (position == 1) {
            System.out.println("Пусть бегут неуклюже");
        } else if (position == 2) {
            System.out.println("Спокойной ночи");
        } else {
            System.out.println("Песня не найдена");
        }
    }

    public static void main(String[] args) {
        Jukebox sovietCartrtoons = new Jukebox();
        sovietCartrtoons.music(1);
        sovietCartrtoons.music(2);
        sovietCartrtoons.music(3);
    }
}
