package model;

import javax.swing.ImageIcon;

public class Character2P {
    private ImageIcon font2P; // 정면
    private ImageIcon back2P; // 뒷면
    private ImageIcon left2P; // 왼쪽
    private ImageIcon right2P; // 오른쪽
    private ImageIcon dieimg2P; // 죽음

    public Character2P(ImageIcon font, ImageIcon back, ImageIcon left, ImageIcon right, ImageIcon dieimg) {
        this.font2P = font;
        this.back2P = back;
        this.left2P = left;
        this.right2P = right;
        this.dieimg2P = dieimg;
    }

    public ImageIcon getFont2P() {
        return font2P;
    }

    public void setFont2P(ImageIcon font2P) {
        this.font2P = font2P;
    }

    public ImageIcon getBack2P() {
        return back2P;
    }

    public void setBack2P(ImageIcon back2P) {
        this.back2P = back2P;
    }

    public ImageIcon getLeft2P() {
        return left2P;
    }

    public void setLeft2P(ImageIcon left2P) {
        this.left2P = left2P;
    }

    public ImageIcon getRight2P() {
        return right2P;
    }

    public void setRight2P(ImageIcon right2P) {
        this.right2P = right2P;
    }

    public ImageIcon getDieimg2P() {
        return dieimg2P;
    }

    public void setDieimg2P(ImageIcon dieimg2P) {
        this.dieimg2P = dieimg2P;
    }
}