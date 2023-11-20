package model;

import javax.swing.ImageIcon;

public class Character1P {
	public Character1P(ImageIcon font, ImageIcon back, ImageIcon left, ImageIcon right, ImageIcon dieimg) {
		super();
		this.font1P = font;
		this.back1P = back;
		this.left1P = left;
		this.right1P = right;
		this.dieimg1P = dieimg;
	}

	private ImageIcon font1P; // 정면
	private ImageIcon back1P; // 뒷면
	private ImageIcon left1P; // 왼쪽
	private ImageIcon right1P;// 오른쪽
	private ImageIcon dieimg1P; // 죽음

}