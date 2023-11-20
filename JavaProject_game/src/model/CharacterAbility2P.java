package model;

import java.awt.Image;

public class CharacterAbility2P { // 캐릭터 능력치

	public CharacterAbility2P(int char2p, int speed2p, int bomb2p, int range2p) {
		super();
		this.char2P = char2p;
		this.speed2P = speed2p;
		this.bomb2P = bomb2p;
		this.range2P = range2p;
	}

	// 캐릭터 체력
	private int char2P = 300; // 2P 체력
	// 캐릭터 능력
	private int speed2P = 0; // 2P 스피드
	private int bomb2P = 1; // 2P 폭탄 갯수
	private int range2P = 1; // 2P 폭탄 범위

}
