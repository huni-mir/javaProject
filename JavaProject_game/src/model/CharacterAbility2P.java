package model;

import java.awt.Image;

public class CharacterAbility2P {
    // 캐릭터 체력
    private int char2P = 0; // 2P 체력
    // 캐릭터 능력
    private int speed2P = 0; // 2P 스피드
    private int bomb2P = 0; // 2P 폭탄 갯수
    private int range2P = 0; // 2P 폭탄 범위

    // 생성자
    public CharacterAbility2P() {
    }

    public CharacterAbility2P(int char2P, int speed2P, int bomb2P, int range2P) {
        this.char2P = char2P;
        this.speed2P = speed2P;
        this.bomb2P = bomb2P;
        this.range2P = range2P;
    }

    // Getter 및 Setter 메서드
    public int getChar2P() {
        return char2P;
    }

    public void setChar2P(int char2P) {
        this.char2P = char2P;
    }

    public int getSpeed2P() {
        return speed2P;
    }

    public void setSpeed2P(int speed2P) {
        this.speed2P = speed2P;
    }

    public int getBomb2P() {
        return bomb2P;
    }

    public void setBomb2P(int bomb2P) {
        this.bomb2P = bomb2P;
    }

    public int getRange2P() {
        return range2P;
    }

    public void setRange2P(int range2P) {
        this.range2P = range2P;
    }
}