import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;


public class Pacman {
	private Image image;
	// 0 = right, 1 = left, 2=up, 3=down
	private int direction = 0;
	
	private int x = 36;
	private int y = 31;
	
	private int[][] walls = {
			{1,1}, {2,1}, {3,1}, {5,1}, {6,1}, {7,1}, {8,1}, {10,1}, {11,1}, {12,1}, {13,1}, {15,1}, {16,1}, {17,1},
			{1,2}, {1,17}, {1,3}, {3,3}, {5,3}, {7,3}, {9,3}, {11,3}, {13,3}, {15,3}, {17,3}, {3,4}, {5,4}, {7,4}, {9,4},
			{11,4}, {13,4}, {15,4}, {1,5}, {3,5}, {5,5}, {7,5}, {9,5}, {11,5}, {13,5}, {15,5}, {17,5}, {1,6}, {3,6}, {15,6}, {17,6},
			{1,7}, {3,7}, {5,7}, {7,7}, {9,7}, {11,7}, {13,7}, {15,7}, {17,7}, {3,8}, {5,8}, {7,8}, {9,8}, {11,8}, {13,8}, {15,8},
			{1,9}, {3,9}, {5,9}, {7,9}, {9,9}, {11,9}, {13,9}, {15,9}, {17,9}, {1,10}, {3,10}, {5,10}, {7,10}, {9,10}, {11,10}, {13,10},
			{15,10}, {17,10}, {1,11}, {17,11}, {1,12}, {2,12}, {3,12}, {5,12}, {6,12}, {7,12}, {8,12}, {10,12}, {11,12}, {12,12},
			{13,12}, {15,12}, {16,12}, {17,12}
	};

	public Pacman() throws SlickException{
		image = new Image("res/pacman.png"); 
	}
	
	public void render(){
		image.draw(x, y);
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public void update() {
		int newX = x;
		int newY = y;
		if(direction == 1){
			newX -= 30;
		}
		if(direction == 0){
			newX += 30;
		}
		if(direction == 2){
			newY -= 30;
		}
		if(direction == 3){
			newY += 30;
		}
		
		if(newX < 36 || newX > 36 + 30*18){
			return;
		}
		if(newY < 31 || newY > 31 + 30*13){
			return;
		}
		
		int gridX = (newX - 36)/30;
		int gridY = (newY - 31)/30;
		for(int[] wall : walls){
			if(wall[0] == gridX && wall[1] == gridY){
				return;
			}
		}
		
		x = newX;
		y = newY;
	}
}
