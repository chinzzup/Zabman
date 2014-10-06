import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;


public class PacmanGame extends BasicGame {
	private Map map;
	private Pacman pacman;

	public PacmanGame(String gamename) {
		super(gamename);
	}

	@Override
	public void init(GameContainer gc) throws SlickException {
		map = new Map();
		pacman = new Pacman();
		gc.setMinimumLogicUpdateInterval(250);
	}

	@Override
	public void update(GameContainer gc, int dt) throws SlickException {
	    pacman.update();
	}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException {
		map.render();
		pacman.render();
	}

	@Override
	public void keyReleased(int key, char c) {
		if(key == Input.KEY_LEFT){
			pacman.setDirection(1);
		}
		if(key == Input.KEY_RIGHT){
			pacman.setDirection(0);
		}
		if(key == Input.KEY_UP){
			pacman.setDirection(2);
		}
		if(key == Input.KEY_DOWN){
			pacman.setDirection(3);
		}
	}

	public static void main(String[] args) {
		try {
			AppGameContainer appgc;
			appgc = new AppGameContainer(new PacmanGame("Pacman"));
			appgc.setDisplayMode(640, 480, false);
			appgc.start();
		} catch (SlickException ex) {
			Logger.getLogger(PacmanGame.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
