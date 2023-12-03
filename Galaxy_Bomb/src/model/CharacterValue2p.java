package model;

import javax.swing.ImageIcon;

public class CharacterValue2p {
	// 캐릭터 체력
	private int heart2P = 0; // 2P 체력
	// 캐릭터 능력
	private int speed2P = 0; // 2P 스피드
	private int bomb2P = 0; // 2P 폭탄 갯수
	private int range2P = 0; // 2P 폭탄 범위

	// 이미지 아이콘
	private ImageIcon front2P; // 정면
	private ImageIcon back2P; // 뒷면
	private ImageIcon left2P; // 왼쪽
	private ImageIcon right2P; // 오른쪽
	private ImageIcon dieimg2P; // 죽음

	// 생성자
	public CharacterValue2p(int heart2P, int speed2P, int bomb2P, int range2P, ImageIcon front2p, ImageIcon back2p,
			ImageIcon left2p, ImageIcon right2p, ImageIcon dieimg2p) {
		this.heart2P = heart2P;
		this.speed2P = speed2P;
		this.bomb2P = bomb2P;
		this.range2P = range2P;
		this.front2P = front2p;
		this.back2P = back2p;
		this.left2P = left2p;
		this.right2P = right2p;
		this.dieimg2P = dieimg2p;
	}

	// Getter 및 Setter 메서드
	public int getHeart2P() {
		return heart2P;
	}

	public void setHeart2P(int heart2P) {
		this.heart2P = heart2P;
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

	public ImageIcon getFront2P() {
		return front2P;
	}

	public void setFront2P(ImageIcon front2P) {
		this.front2P = front2P;
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