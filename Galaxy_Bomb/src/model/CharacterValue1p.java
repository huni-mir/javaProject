package model;

import javax.swing.ImageIcon;

public class CharacterValue1p {
	// 캐릭터 체력
	private int heart1P = 0; // 1P 체력
	// 캐릭터 능력
	private int speed1P = 0; // 1P 스피드
	private int bomb1P = 0; // 1P 폭탄 갯수
	private int range1P = 0; // 1P 폭탄 범위

	// 이미지 아이콘
	private ImageIcon front1P; // 정면
	private ImageIcon back1P; // 뒷면
	private ImageIcon left1P; // 왼쪽
	private ImageIcon right1P; // 오른쪽
	private ImageIcon left1P_2; // 왼쪽 2
	private ImageIcon right1P_2; // 오른쪽 2
	private ImageIcon dieimg1P; // 죽음

	// 생성자
	public CharacterValue1p(int heart1P, int speed1P, int bomb1P, int range1P, ImageIcon front1P, ImageIcon back1P,
			ImageIcon left1P, ImageIcon right1P, ImageIcon left1P_2, ImageIcon right1P_2, ImageIcon dieimg1P) {
		this.heart1P = heart1P;
		this.speed1P = speed1P;
		this.bomb1P = bomb1P;
		this.range1P = range1P;
		this.front1P = front1P;
		this.back1P = back1P;
		this.left1P = left1P;
		this.right1P = right1P;
		this.left1P_2 = left1P_2;
		this.right1P_2 = right1P_2;
		this.dieimg1P = dieimg1P;
	}

	// Getter 및 Setter 메서드
	public int getHeart1P() {
		return heart1P;
	}

	public void setHeart1P(int heart1P) {
		this.heart1P = heart1P;
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
	
	public ImageIcon getLeft1P_2() {
		return left1P_2;
	}

	public void setLeft1P_2(ImageIcon left1P_2) {
		this.left1P_2 = left1P_2;
	}
	
	public ImageIcon getRight1P_2() {
		return right1P_2;
	}

	public void setRight1P_2(ImageIcon right1P_2) {
		this.right1P_2 = right1P_2;
	}

	public ImageIcon getDieimg1P() {
		return dieimg1P;
	}

	public void setDieimg1P(ImageIcon dieimg1P) {
		this.dieimg1P = dieimg1P;
	}
}