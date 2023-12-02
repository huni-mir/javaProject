package model;

import javax.swing.JPanel;

public class BlockSet extends JPanel {

	public int size;
	public int size1;
	public String map[][];

	public BlockSet(int size, int size1) {
		this.size = size;
		this.size1 = size1;
		map = new String[size][size1];
		this.setLayout(null);
		this.setBounds(0, 0, 1200, 900);
	}
}
