package snake;

import java.io.IOException;
import java.nio.file.Paths;

import org.jsfml.graphics.Color;
import org.jsfml.graphics.Font;
import org.jsfml.graphics.Text;
import org.jsfml.system.Clock;
import org.jsfml.window.Keyboard;
import org.jsfml.window.event.Event;
import org.jsfml.window.event.KeyEvent;

public class Game {
	private Window app;
	private Snake snake;
	private Food food;
	private Clock clock;
	private char direction;
	private int speed;

	public Game() {
		this.app = new Window();
		this.snake = new Snake();
		this.food = new Food(150, 150);
		this.clock = new Clock();
		this.app.screen.setFramerateLimit(80);
		this.direction = 'r';
		this.speed = 20;
	}

	// ===========================================================================

	public void exec() {
		long last_move = clock.getElapsedTime().asMilliseconds();
		long timeDiff = 0;
		int plost = 0;
		Font font = new Font();

		try {
			font.loadFromFile(Paths.get("arial.ttf"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Text text = new Text("Socre : 0", font, 15);
		text.setColor(Color.YELLOW);
		text.setStyle(Text.BOLD);
		text.setPosition(700, 20);
		
		while (this.app.screen.isOpen()) {
			timeDiff = clock.getElapsedTime().asMilliseconds() - last_move;
			manageEvent();
			this.app.screen.clear();
			if (timeDiff >= this.speed && plost == 0) {
				// check si le this.snake se touche
				if (this.snake.lost()) {
					System.out.println("You loose...");
					plost = 1;
				}
				this.snake.move(direction);
				this.manageFood();
				clock.restart();
				last_move = clock.getElapsedTime().asMilliseconds();
			}
			this.snake.print(this.app.screen);
			text.setString("Score : " + this.snake.getScore());
			this.app.screen.draw(this.food.getSquare());
			this.app.screen.draw(text);
			this.app.screen.display();
		}
	}

	public void checkEntry(Event event) {
		KeyEvent key = event.asKeyEvent();
		char tempdirection;
		
		if (key.key == Keyboard.Key.RIGHT)
			tempdirection = 'r';
		else if (key.key == Keyboard.Key.LEFT)
			tempdirection = 'l';
		else if (key.key == Keyboard.Key.UP)
			tempdirection = 'u';
		else if (key.key == Keyboard.Key.DOWN)
			tempdirection = 'd';
		else
			tempdirection = this.direction;

		if (tempdirection == this.direction
				|| (tempdirection == 'r' && this.direction == 'l')
				|| (tempdirection == 'l' && this.direction == 'r')
				|| (tempdirection == 'u' && this.direction == 'd')
				|| (tempdirection == 'd' && this.direction == 'u'))
			return;
		this.direction = tempdirection;
	}

	// ===============================================================================

	public void manageFood() {
		Body head;
		Body temp;
		int i;
		int tempx;
		int tempy;
		int randomx;
		int randomy;
		boolean find = true;

		head = this.snake.body.get(0);
		tempx = head.getX();
		tempy = head.getY();
		randomx = (int) (Math.random() * (750 - 13)) + 13;
		randomy = (int) (Math.random() * (750 - 13)) + 13;

		if ((tempx >= this.food.getX() - 8 && tempx <= this.food.getX() + 8)
				&& (tempy >= this.food.getY() - 10 && tempy <= this.food.getY() + 10)) {
			this.snake.eat();
			// on génère une nouvelle nourriture
			while (find) {
				i = 0;
				randomx = (int) (Math.random() * (750 - 13)) + 13;
				randomy = (int) (Math.random() * (750 - 13)) + 13;
				find = false;
				while (i < this.snake.body.size()) {
					temp = this.snake.body.get(i);
					if (temp.getX() == randomx && temp.getY() == randomy) {
						find = true;
						break;
					}
					i++;
				}
			}
			this.food.setX(randomx);
			this.food.setY(randomy);
			this.food.getSquare().setPosition(randomx, randomy);

			// ==========================================
		}
	}

	private void manageEvent() {
		Event event = new Event(0);
		while ((event = this.app.screen.pollEvent()) != null) {
			if (event.type == Event.Type.CLOSED)
				this.app.screen.close();
			if (event.type == Event.Type.KEY_PRESSED)
				this.checkEntry(event);
		}
	}

}