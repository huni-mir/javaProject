package view;

import javax.swing.*;

public class Beullog extends JPanel{
	 int size;
	   String map[][];

	   public Beullog(int size) {
	      this.size = size;
	      map = new String[size][size+4];
	      this.setLayout(null);
	      this.setBounds(0, 0, 1200, 900);

	   }
}
