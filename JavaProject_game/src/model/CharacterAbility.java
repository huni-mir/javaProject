package model;

import java.awt.Image;

public class CharacterAbility { //캐릭터 능력치
	private Image image; //캐릭터 이미지
	
	public CharacterAbility(Image image, int char1p, int char2p, int speed1p, int speed2p, int bomb1p, int bomb2p,
			int range1p, int range2p) {
		super();
		this.image = image;
		this.char1p = char1p;
		this.char2p = char2p;
		this.speed1p = speed1p;
		this.speed2p = speed2p;
		this.bomb1p = bomb1p;
		this.bomb2p = bomb2p;
		this.range1p = range1p;
		this.range2p = range2p;
	}
	//캐릭터 체력
	private int char1p = 300;	//1P
	private int char2p = 300;	//2P
	
	//캐릭터 능력 
	private int speed1p = 0;	//1P 스피드
	private int speed2p = 0;	//2P 스피드
	private int bomb1p = 1;		//1P 폭탄 갯수
	private int bomb2p = 1;		//2P 폭탄 갯수
	private int range1p = 1;	//1P 폭탄 범위
	private int range2p = 1;	//2P 폭탄 범위
	
	
}
