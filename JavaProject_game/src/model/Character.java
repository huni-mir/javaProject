package model;

import javax.swing.ImageIcon;

public class Character {
	public Character(ImageIcon font, ImageIcon back, ImageIcon left, ImageIcon right, ImageIcon die) {
		super();
		this.font = font;
		this.back = back;
		this.left = left;
		this.right = right;
		this.die = die;
	}

	private ImageIcon font; // 정면
	private ImageIcon back; // 뒷면
	private ImageIcon left; // 왼쪽
	private ImageIcon right;// 오른쪽
	private ImageIcon die; // 죽음

}