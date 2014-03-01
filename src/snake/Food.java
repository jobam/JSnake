package snake;

import org.jsfml.graphics.Color;
import org.jsfml.graphics.RectangleShape;

public class Food 
{
private	RectangleShape square;
private int				x;
private int				y;



public Food(int x, int y)
{
	this.x = x;
	this.y = y;
	this.square.setFillColor(Color.RED);
    this.square.setPosition(x, y);
}

public int getX()
{
	return (this.x);
}

public int getY()
{
	return (this.y);
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
























}
