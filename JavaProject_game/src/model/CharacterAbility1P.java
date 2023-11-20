package model;

import java.awt.Image;

public class CharacterAbility1P { // 캐릭터 능력치
	public CharacterAbility1P(int char1p, int speed1p, int bomb1p, int range1p) {
		super();
		this.char1P = char1p;
		this.speed1P = speed1p;
		this.bomb1P = bomb1p;
		this.range1P = range1p;
	}

	// 캐릭터 체력
	private int char1P = 3; // 1P 체력
	// 캐릭터 능력
	private int speed1P = 0; // 1P 스피드
	private int bomb1P = 1; // 1P 폭탄 갯수
	private int range1P = 1; // 1P 폭탄 범위

}
