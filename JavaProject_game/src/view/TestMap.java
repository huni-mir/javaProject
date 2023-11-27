package view;

import java.awt.*;

import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import view.*;

import model.Character1P;
import model.Character2P;
import model.CharacterAbility1P;
import model.CharacterAbility2P;

public class TestMap extends JFrame {
	 private JLabel contentPane;
	
	 
	 private ArrayList<JLabel> itemlist = new ArrayList<JLabel>();
	public TestMap() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1600, 945);
		// setBounds(0, 0, 1600, 900);
		setLocationRelativeTo(null);
		setContentPane(new GameMap());
		setVisible(true);
	}
	
	
	class Beullog extends JPanel {
		int size;
		int size1;
		String map[][];

		public Beullog(int size, int size1) {
			this.size = size;
			this.size1 = size1;
			map = new String[size][size1];
			this.setLayout(null);
			this.setBounds(0, 0, 1200, 900);
		}
	}

	public class GameMap extends JPanel {
		private ImageIcon MainGame = new ImageIcon("img/background/MainGame.png"); // 인트로 이미지
		private ImageIcon[] item2 = { new ImageIcon("img/speed_up.png"), new ImageIcon("img/range_up.png"),
			new ImageIcon("img/heart_up.png"), new ImageIcon("img/bomb_up.png"), null };
		private Vector<JLabel> item = new Vector<JLabel>();
		 private ArrayList<JLabel> itemlist = new ArrayList<JLabel>();
		Random random = new Random();
		ImageIcon item3;
		boolean die = false;
		
		String move;
		String shape;
		int x;
		int y;
		int char2Bx, char2By;
		int char1bx, char1by;
		int char1X = 75;
		int char1Y = 75;

		int char2X = 1050;
		int char2Y = 750;
		
		
		private ImageIcon font1P; // 정면
	    private ImageIcon back1P; // 뒷면
	    private ImageIcon left1P; // 왼쪽
	    private ImageIcon right1P; // 오른쪽
	    private ImageIcon dieimg1P; // 죽음
	    
	    private ImageIcon font2P; // 정면
	    private ImageIcon back2P; // 뒷면
	    private ImageIcon left2P; // 왼쪽
	    private ImageIcon right2P; // 오른쪽
	    private ImageIcon dieimg2P; // 죽음
	    
	    // 캐릭터 체력
	    private int char1P; // 1P 체력
	    // 캐릭터 능력
	    private int speed1P; // 1P 스피드
	    private int bomb1P; // 1P 폭탄 갯수
	    private int range1P; // 1P 폭탄 범위
	    
	    // 캐릭터 체력
	    private int char2P; // 2P 체력
	    // 캐릭터 능력
	    private int speed2P; // 2P 스피드
	    private int bomb2P; // 2P 폭탄 갯수
	    private int range2P; // 2P 폭탄 범위

		
		JLabel itemLabel;
		public void paintComponent(Graphics g) {
			super.paintComponent(g); // 화면을 비운다

			g.drawImage(MainGame.getImage(), 0, 0, null);

		}
		 public void Die() {
		      if(die==true) {
		         
		         JOptionPane.showMessageDialog(null, "게임 끝!");
		         die=false;
		         dispose();
		         
		      }
		   }
		 public void gameSet(Character1P ci) {


				initCookieImg(ci); // 쿠키이미지를 세팅

			}
		 private void initCookieImg(Character1P ci) {
			    // 쿠키 이미지 아이콘들
			    font1P = ci.getFont1P(); // 정면 모션
			    back1P = ci.getBack1P(); // 뒷면 모션
			    left1P = ci.getLeft1P(); // 왼쪽 모션
			    right1P = ci.getRight1P(); // 오른쪽 모션
			    dieimg1P = ci.getDieimg1P(); // 죽음 모션 
			}
			
		 public void char2CheckLocation(int char2Bx,int char2By) {//enemyCheckLocation
		      if((char1X>char2Bx-65 && char1X<char2Bx+60) &&(char1Y>char2By-40 &&char1Y<char2By+20)) {
		         
		      }
		      else if((char1X>char2Bx-10 && char1X<char2Bx+50) &&(char1Y>char2By-80 &&char1Y<char2By+45)) {
		         
		      }
		      // 풍선위치를 기준으로 동서남북
		      for (int i = 0; i < item.size(); i++) {

		         // 동서남북으로 찾아야 함.
		         // 496.525
		         y -= 40;
		         if ((char2Bx + 40 >= item.get(i).getX() && char2Bx + 40 <= item.get(i).getX() + 16)
		               && (char2By >= item.get(i).getY() && char2By <= item.get(i).getY() + 5)) {
		            item.get(i).setIcon(null);

		            item3 = item2[random.nextInt(3)];
		            item3 = item2[random.nextInt(5)];
		            itemLabel = new JLabel(item3);
		            itemLabel.setLocation(item.get(i).getX(), item.get(i).getY());
		            itemLabel.setSize(40, 40);
		            contentPane.add(itemLabel);
		            itemlist.add(itemLabel);
		            item.remove(i);

		         } else if ((char2Bx >= item.get(i).getX() && char2Bx <= item.get(i).getX() + 16)
		               && (char2By + 40 >= item.get(i).getY() && char2By + 40 <= item.get(i).getY() + 5)) {
		            item.get(i).setIcon(null);

		            item3 = item2[random.nextInt(3)];
		            item3 = item2[random.nextInt(5)];
		            itemLabel = new JLabel(item3);
		            itemLabel.setLocation(item.get(i).getX(), item.get(i).getY());
		            itemLabel.setSize(40, 40);
		            contentPane.add(itemLabel);
		            itemlist.add(itemLabel);
		            item.remove(i);

		         } else if ((char2Bx - 40 >= item.get(i).getX() && char2Bx - 40 <= item.get(i).getX() + 16)
		               && (char2By >= item.get(i).getY() && char2By <= item.get(i).getY() + 5)) {

		            item.get(i).setIcon(null);
		            item3 = item2[random.nextInt(3)];
		            item3 = item2[random.nextInt(5)];
		            itemLabel = new JLabel(item3);
		            itemLabel.setLocation(item.get(i).getX(), item.get(i).getY());
		            itemLabel.setSize(40, 40);
		            contentPane.add(itemLabel);
		            itemlist.add(itemLabel);
		            item.remove(i);

		         } else if ((char2Bx >= item.get(i).getX() && char2Bx <= item.get(i).getX() + 16)
		               && (char2By - 40 >= item.get(i).getY() && char2By - 40 <= item.get(i).getY() + 5)) {
		            item.get(i).setIcon(null);

		            item3 = item2[random.nextInt(3)];
		            item3 = item2[random.nextInt(5)];
		            itemLabel = new JLabel(item3);
		            itemLabel.setLocation(item.get(i).getX(), item.get(i).getY());
		            itemLabel.setSize(40, 40);
		            contentPane.add(itemLabel);
		            itemlist.add(itemLabel);
		            item.remove(i);

		         }

		         // item.get(i).setIcon(null); //23
		      }

		      
		   }
		 
		 public void ItemOptions1() {
		        for (int i = 0; i < itemlist.size(); i++) {
		            JLabel currentItem = itemlist.get(i);

		            if ((char1X >= currentItem.getX() - 20 && char1X <= currentItem.getX() + 10)
		                    && (char1Y >= currentItem.getY() - 10 && char1Y <= currentItem.getY() + 30)) {
		                currentItem.setIcon(null);

		                item3 = item2[random.nextInt(4)];
		                itemLabel = new JLabel(item3);
		                itemLabel.setLocation(currentItem.getX(), currentItem.getY());
		                itemLabel.setSize(40, 40);
		                add(itemLabel);
		                itemlist.add(itemLabel);
		                itemlist.remove(i);
		                
		                // 아이템의 타입에 따라 다르게 동작
		                String itemType = getItemType(item3); 
		                ItemEffect(itemType); 
		            }
		        }
		    }
		 public void ItemOptions2() {
		        for (int i = 0; i < itemlist.size(); i++) {
		            JLabel currentItem = itemlist.get(i);

		            if ((char2X >= currentItem.getX() - 20 && char2X <= currentItem.getX() + 10)
		                    && (char2Y >= currentItem.getY() - 10 && char2Y <= currentItem.getY() + 30)) {
		                currentItem.setIcon(null);

		                item3 = item2[random.nextInt(4)];
		                itemLabel = new JLabel(item3);
		                itemLabel.setLocation(currentItem.getX(), currentItem.getY());
		                itemLabel.setSize(40, 40);
		                add(itemLabel);
		                itemlist.add(itemLabel);
		                itemlist.remove(i);
		                
		                // 아이템의 타입에 따라 다르게 동작
		                String itemType = getItemType(item3); 
		                ItemEffect(itemType); 
		            }
		        }
		    }

		    private String getItemType(ImageIcon itemIcon) {
		    	 // ImageIcon에서 이미지 파일의 경로를 가져옴
		        String imagePath = itemIcon.getDescription();

		        // 파일 경로에서 파일 이름만 추출
		        String fileName = imagePath.substring(imagePath.lastIndexOf("/") + 1);

		        // 파일 이름을 기반으로 아이템의 타입을 판별
		        if (fileName.equals("heart_up.png")) {
		            return "HeartUp";
		        } else if (fileName.equals("speed_up.png")) {
		            return "SpeedUp";
		        } else if (fileName.equals("range_up.png")) {
		            return "RangeUp";
		        } else if (fileName.equals("bomb_up.png")) {
		            return "BombUp";
		        } else {
		            // 알 수 없는 아이템 타입일 경우
		            return "UnknownItemType";
		        }
		        
		    }

		    private void ItemEffect(String itemType) {
		    	 switch (itemType) {
		         case "HeartUp":
		             // 체력 증가 동작 수행
		             increaseHealth();
		             break;
		         case "SpeedUp":
		             // 속도 증가 동작 수행
		             increaseSpeed();
		             break;
		         case "RangeUp":
		             // 범위 증가 동작 수행
		             increaseRange();
		             break;
		         case "BombUp":
		             // 폭탄 증가 동작 수행
		             increaseBombCount();
		             break;
		         default:
		             // 알 수 없는 아이템 타입 처리
		             break;
		     }
		    }
		    private void increaseHealth() {
		    	int heart=3;
		        heart += 1;
		    }
		    private void increaseSpeed() {	
		    	int speed=1;
		        speed += 5;
		    }
		    private void increaseRange() {	
		    	int range=1;
		        range += 1;
		    }
		    private void increaseBombCount() {		
		    	int bombCount=1;
		        bombCount += 1;
		    } //각 아이템별 함수

		

		private GameMap() {
			setLayout(null);
			Beullog beullog = new Beullog(16, 12);
			
			for (int i = 0; i < beullog.size; i++) {
				for (int j = 0; j < beullog.size1; j++) {
					beullog.map[i][j] = "1";
					String block = beullog.map[i][j];
					if (i < 3 && j == 0 || ((i > 12 && i < 16) && j == 0)/* 1번쨰열 */
							 || i < 1 && j == 1 || ((i > 14 && i < 16) && j == 1)/* 2번쨰열 */
							|| i < 1 && j == 10 || ((i > 14 && i < 16) && j == 10)/* 11번쨰열 */
							|| i < 3 && j == 11 || ((i > 12 && i < 16) && j == 11)/* 12번쨰열 */) {
						JLabel beullog1 = new JLabel(new ImageIcon("img/block/RedBlock.png"));
						// item.add 자리
						item.add(beullog1);
						this.add(beullog1);
						beullog1.setBounds(i * 75, j * 75, 75, 75);
					} else if (i < 3 && j == 3 /* 4번쨰열 */
							|| (i < 2 && i > 0) && (j > 3 && j < 7)/* 5,6,7번쨰열 */
								|| i < 2 && j == 7 /* 8번쨰열 */) {
						JLabel beullog5 = new JLabel(new ImageIcon("img/block/SkyBlock.png"));
						// item.add 자리
						item.add(beullog5);
						this.add(beullog5);
						beullog5.setBounds(i * 75, j * 75, 75, 75); // J
					} else if ((i > 3 && i < 6) && j == 3 /* 4번쨰열 */
							|| i == 3 && j == 4 || i == 6 && j == 4 /* 5번쨰열 */
							|| (i > 2 && i < 7) && j == 5 /* 6번쨰열 */
							|| i == 3 && j == 6 || i == 6 && j == 6 /* 7번쨰열 */
							|| i == 3 && j == 7 || i == 6 && j == 7 /* 8번쨰열 */) {
						JLabel beullog3 = new JLabel(new ImageIcon("img/block/PinkBlock.png"));
						// item.add 자리
						item.add(beullog3);
						this.add(beullog3);
						beullog3.setBounds(i * 75, j * 75, 75, 75);// A
					} else if (i == 7 && j == 3 || i == 11 && j == 3 /* 4번쨰열 */
							|| i == 7 && j == 4 || i == 11 && j == 4 /* 5번쨰열 */
							|| i == 7 && j == 5 || i == 11 && j == 5 /* 6번쨰열 */
							|| i == 8 && j == 6 || i == 10 && j == 6 /* 7번쨰열 */
							|| i == 9 && j == 7 /* 8번쨰열 */) {
						JLabel beullog2 = new JLabel(new ImageIcon("img/block/BlueBlock.png"));
						// item.add 자리
						item.add(beullog2);
						this.add(beullog2);
						beullog2.setBounds(i * 75, j * 75, 75, 75);// V
					} else if ((i > 12 && i < 15) && j == 3 /* 4번쨰열 */
							|| i == 12 && j == 4 || i == 15 && j == 4 /* 5번쨰열 */
							|| (i > 11 && i < 16) && j == 5 /* 6번쨰열 */
							|| i == 12 && j == 6 || i == 15 && j == 6 /* 7번쨰열 */
							|| i == 12 && j == 7 || i == 15 && j == 7 /* 8번쨰열 */) {
						JLabel beullog1 = new JLabel(new ImageIcon("img/block/PupleBlock.png"));
						// item.add 자리
						this.add(beullog1);
						beullog1.setBounds(i * 75, j * 75, 75, 75);// A
						JLabel beullog4 = new JLabel(new ImageIcon("img/block/PupleBlock.png"));
						item.add(beullog4);
						this.add(beullog4);
						beullog4.setBounds(i * 75, j * 75, 75, 75);// A
					}
				}
			}

		}
		public class Character_Move extends JPanel implements KeyListener {
		    private boolean[] char1Key = new boolean[256];
		    private boolean[] char2Key = new boolean[256];
		    private int char1x = 0;
		    private int char1y = 0;
		    private int char2x = 0;
		    private int char2y = 0;
		    
		    
		    
		    @Override
		    public void keyTyped(KeyEvent e) {
		        
		    }
		    
		    @Override
		    public void keyPressed(KeyEvent e) {
		        int keyCode = e.getKeyCode();

		        // 1p
		        if (keyCode == KeyEvent.VK_W || keyCode == KeyEvent.VK_A ||
		            keyCode == KeyEvent.VK_S || keyCode == KeyEvent.VK_D ||
		            keyCode == KeyEvent.VK_SHIFT) {
		            char1Key[keyCode] = true;
		        }

		        // 2p
		        else if (keyCode == KeyEvent.VK_UP || keyCode == KeyEvent.VK_DOWN ||
		                 keyCode == KeyEvent.VK_LEFT || keyCode == KeyEvent.VK_RIGHT ||
		                 keyCode == KeyEvent.VK_CONTROL) {
		            char2Key[keyCode] = true;
		        }

		        // 여기서 각 플레이어의 입력에 따른 게임 로직을 수행
		        processInputs();
		    }

		    @Override
		    public void keyReleased(KeyEvent e) {
		        int keyCode = e.getKeyCode();   
		        if (keyCode == KeyEvent.VK_W || keyCode == KeyEvent.VK_A ||
		            keyCode == KeyEvent.VK_S || keyCode == KeyEvent.VK_D ) {
		            char1Key[keyCode] = false;
		            // 1p
		        }
		        else if (keyCode == KeyEvent.VK_UP || keyCode == KeyEvent.VK_DOWN ||
		                 keyCode == KeyEvent.VK_LEFT || keyCode == KeyEvent.VK_RIGHT) {
		            char2Key[keyCode] = false;
		            //2p
		        }
		        processInputs();
		    }

		    private void processInputs() {
		    	//1p
		    	if (char1Key[KeyEvent.VK_W]) {
		            char1y -= 10; // 위로 이동
		        }
		        if (char1Key[KeyEvent.VK_A]) {
		            char1x -= 10; // 왼쪽으로 이동
		        }
		        if (char1Key[KeyEvent.VK_S]) {
		            char1y += 10; // 아래로 이동
		        }
		        if (char1Key[KeyEvent.VK_D]) {
		            char1x += 10; // 오른쪽으로 이동
		        }
		        if (char1Key[KeyEvent.VK_SHIFT]) {
		        	//new Thread(one).start(); //one 스레드 dropBomb
		        }

		        //2p
		        if (char2Key[KeyEvent.VK_UP]) {
		            char2y -= 10; // 위로 이동
		        }
		        if (char2Key[KeyEvent.VK_LEFT]) {
		            char2x -= 10; // 왼쪽으로 이동
		        }
		        if (char2Key[KeyEvent.VK_DOWN]) {
		            char2y += 10; // 아래로 이동
		        }
		        if (char2Key[KeyEvent.VK_RIGHT]) {
		            char2x += 10; // 오른쪽으로 이동
		        }
		        if (char2Key[KeyEvent.VK_CONTROL]) {
		        	//new Thread(two).start();
		        }
		    }
		    //thread dropBomp 추가 해야됨
		}
		public void gameSet(Character1P getci1p, Character2P getci2p, CharacterAbility1P getca1p,
				CharacterAbility2P getca2p) {
			charCi1P(getci1p);
			charCi2P(getci2p);
			charCa1P(getca1p);
			charCa2P(getca2p);
			 JLabel font1PLabel = new JLabel(new ImageIcon(font1P.getImage()));
			 add(font1PLabel);
			 font1PLabel.setBounds(75,75, 75, 75);
		}
		private void charCa1P(CharacterAbility1P getca1p) {
			char1P = getca1p.getChar1P(); 
			speed1P = getca1p.getSpeed1P(); 
			range1P = getca1p.getRange1P(); 
		}
		private void charCa2P(CharacterAbility2P getca2p) {
			char2P = getca2p.getChar2P(); 
			speed2P = getca2p.getSpeed2P(); 
			range2P = getca2p.getRange2P(); 
		}


		private void charCi1P(Character1P getci1p) {
			font1P = getci1p.getFont1P(); // 
			back1P = getci1p.getBack1P(); //
			left1P = getci1p.getLeft1P(); //
			right1P = getci1p.getRight1P(); //
			dieimg1P = getci1p.getDieimg1P(); // 
		}
		
		private void charCi2P(Character2P getci2p) {
			font2P = getci2p.getFont2P(); // 
			back2P = getci2p.getBack2P(); //
			left2P = getci2p.getLeft2P(); //
			right2P = getci2p.getRight2P(); //
			dieimg2P = getci2p.getDieimg2P(); // 
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TestMap();
	}

}
