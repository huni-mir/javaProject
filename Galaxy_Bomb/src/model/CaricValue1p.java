package model;

import javax.swing.ImageIcon;

public class CaricValue1p {
	// 캐릭터 체력
	private int char1P = 0; // 1P 체력
	// 캐릭터 능력
	private int speed1P = 0; // 1P 스피드
	private int bomb1P = 0; // 1P 폭탄 갯수
	private int range1P = 0; // 1P 폭탄 범위

	// 이미지 아이콘
	private ImageIcon front1P; // 정면
	private ImageIcon back1P; // 뒷면
	private ImageIcon left1P; // 왼쪽
	private ImageIcon right1P; // 오른쪽
	private ImageIcon dieimg1P; // 죽음

	// 생성자
	public CaricValue1p(int char1P, int speed1P, int bomb1P, int range1P, ImageIcon front1p, ImageIcon back1p,
			ImageIcon left1p, ImageIcon right1p, ImageIcon dieimg1p) {
		this.char1P = char1P;
		this.speed1P = speed1P;
		this.bomb1P = bomb1P;
		this.range1P = range1P;
		this.front1P = front1p;
		this.back1P = back1p;
		this.left1P = left1p;
		this.right1P = right1p;
		this.dieimg1P = dieimg1p;
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

	public ImageIcon getFront1P() {
		return front1P;
	}

	public void setFront1P(ImageIcon front1P) {
		this.front1P = front1P;
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
