package snake;

import org.jsfml.graphics.RectangleShape;
import org.jsfml.system.Vector2f;

public class Body 
{
	private	RectangleShape	square;
	private int				x;
	private int				y;
	private static int		n = 0;
	
	public Body()
	{
		this.x = 0;
		this.y = 0;
		this.square = new RectangleShape(new Vector2f(12, 12));
		this.square.setPosition(this.x, this.y);
	}
	
	public Body(int x, int y)
	{
		this.x = x;
		this.y = y;
		this.square = new RectangleShape(new Vector2f(12, 12));
		this.square.setPosition(this.x, this.y);
	}
	
	//===================================================================
	
	public int		getX()
	  {
	    return (this.x);
	  } 

	public int 	getY()
	  {
	    return (this.y);
	  }

	public static int		getN()
	  {
	    return (n);
	  }

	public RectangleShape	getSquare()
	  {
	    return (this.square);
	  }

	public void	setX(int x)
	{
	  this.x = x % 800;
	  this.x = (this.x < 0) ? (800 + x) % 800 : this.x;
	}

	public void	setY(int y)
	{
	  this.y = y % 800;
	  this.y = (this.y < 0) ? (800 + y) % 800 : this.y;
	}

	public static void	increaseN()
	{
	  n += 1;
	}
}
