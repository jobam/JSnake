package snake;
import org.jsfml.window.*;
import org.jsfml.graphics.*;

public class Window
{
	private String	 	name;
	private int			width;
	private int			height;
	public RenderWindow	screen;
	
	
	public Window()
	{
		this.name = "JSnake";
		this.width = 800;
		this.height = 800;
		this.screen = new RenderWindow(new VideoMode(this.width, this.height), this.name, WindowStyle.CLOSE | WindowStyle.TITLEBAR);
	}
}
