package model;

import javax.swing.ImageIcon;

public class Character1P {
    private ImageIcon font1P; // 정면
    private ImageIcon back1P; // 뒷면
    private ImageIcon left1P; // 왼쪽
    private ImageIcon right1P; // 오른쪽
    private ImageIcon dieimg1P; // 죽음

    public Character1P(ImageIcon font, ImageIcon back, ImageIcon left, ImageIcon right, ImageIcon dieimg) {
        this.font1P = font;
        this.back1P = back;
        this.left1P = left;
        this.right1P = right;
        this.dieimg1P = dieimg;
    }

    public ImageIcon getFont1P() {
        return font1P;
    }

    public void setFont1P(ImageIcon font1P) {
        this.font1P = font1P;
    }

    public ImageIcon getBack1P() {
        return back1P;
    }

    public void setBack1P(ImageIcon back1P) {
        this.back1P = back1P;
    }

    public ImageIcon getLeft1P() {
        return left1P;
    }

    public void setLeft1P(ImageIcon left1P) {
        this.left1P = left1P;
    }

    public ImageIcon getRight1P() {
        return right1P;
    }

    public void setRight1P(ImageIcon right1P) {
        this.right1P = right1P;
    }

    public ImageIcon getDieimg1P() {
        return dieimg1P;
    }

    public void setDieimg1P(ImageIcon dieimg1P) {
        this.dieimg1P = dieimg1P;
    }
}