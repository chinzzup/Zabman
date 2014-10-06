import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;


public class Map {
	private Image image;

	public Map() throws SlickException{
		image = new Image("res/map.png"); 
	}
	
	public void render(){
		image.draw(0, 0);
	}
}
