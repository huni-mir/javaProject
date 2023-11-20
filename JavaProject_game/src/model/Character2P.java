package model;

import javax.swing.ImageIcon;

public class Character2P {
	public Character2P(ImageIcon font, ImageIcon back, ImageIcon left, ImageIcon right, ImageIcon dieimg) {
		super();
		this.font2P = font;
		this.back2P = back;
		this.left2P = left;
		this.right2P = right;
		this.dieimg2P = dieimg;
	}

	private ImageIcon font2P; // 정면
	private ImageIcon back2P; // 뒷면
	private ImageIcon left2P; // 왼쪽
	private ImageIcon right2P;// 오른쪽
	private ImageIcon dieimg2P; // 죽음

}