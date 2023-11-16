package model;

import javax.swing.ImageIcon;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Character {

	private ImageIcon font; //정면
	private ImageIcon back; //뒷면
	private ImageIcon left; //왼쪽
	private ImageIcon right;//오른쪽
	private ImageIcon die;	//죽음
	
}