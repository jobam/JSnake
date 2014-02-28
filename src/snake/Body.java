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
		n++;
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
	
	int		getX()
	  {
	    return (this.x);
	  }

	int 	getY()
	  {
	    return (this.y);
	  }

	static int		getN()
	  {
	    return (n);
	  }

	RectangleShape	getSquare()
	  {
	    return (this.square);
	  }

	void	setX(int x)
	{
	  this.x = x % 800;
	  this.x = (this.x < 0) ? (800 + x) % 800 : this.x;
	}

	void	setY(int y)
	{
	  this.y = y % 800;
	  this.y = (this.y < 0) ? (800 + y) % 800 : this.y;
	}

	static void	setN(int x)
	{
	  n = x;
	}
}
