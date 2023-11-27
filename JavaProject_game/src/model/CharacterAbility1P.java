package model;

public class CharacterAbility1P {
    // 캐릭터 체력
    private int char1P = 3; // 1P 체력
    // 캐릭터 능력
    private int speed1P = 0; // 1P 스피드
    private int bomb1P = 1; // 1P 폭탄 갯수
    private int range1P = 1; // 1P 폭탄 범위
    	    		
    // 생성자
    public CharacterAbility1P() {
    }

    public CharacterAbility1P(int char1P, int speed1P, int bomb1P, int range1P) {
        this.char1P = char1P;
        this.speed1P = speed1P;
        this.bomb1P = bomb1P;
        this.range1P = range1P;
    }

    // Getter 및 Setter 메서드
    public int getChar1P() {
        return char1P;
    }

    public void setChar1P(int char1P) {
        this.char1P = char1P;
    }

    public int getSpeed1P() {
        return speed1P;
    }

    public void setSpeed1P(int speed1P) {
        this.speed1P = speed1P;
    }

    public int getBomb1P() {
        return bomb1P;
    }

    public void setBomb1P(int bomb1P) {
        this.bomb1P = bomb1P;
    }

    public int getRange1P() {
        return range1P;
    }

    public void setRange1P(int range1P) {
        this.range1P = range1P;
    }
}