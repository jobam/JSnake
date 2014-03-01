package snake;

import java.util.ArrayList;

import org.jsfml.graphics.RenderWindow;

public class Snake 
{
	public ArrayList<Body> body;
	
	public Snake()
	{
		Body temp = new Body(390, 400);
	    Body temp2 = new Body(378, 400);
	    Body temp3 = new Body(366, 400);
	    
	    this.body.add(temp);
	    this.body.add(temp2);
	    this.body.add(temp3);
	}
	
	//===========================================================
	
	public void	move(char direction)
	{
		int	i = 0;
		Body 		temp = this.body.get(0);
		int			tempx = temp.getX();
		int			tempy = temp.getY();
		int			tempx2;
		int			tempy2;
		
		if (direction == 'u')
	    {
	      temp.setY(temp.getY() - 12);
	    }
	  if (direction == 'd')
	    {
	      temp.setY(temp.getY() + 12);
	    }
	  if (direction == 'l')
	    {
	      temp.setX(temp.getX() - 12);
	    }
	  if (direction == 'r')
	    {
	      temp.setX(temp.getX() + 12);
	    }
	  temp.getSquare().setPosition(tempx, tempy);
	  i++;
	  
	  while (i < this.body.size())
	    {
		  temp = this.body.get(i);
	      tempx2 = temp.getX();
	      tempy2 = temp.getY();
	      temp.setX(tempx);
	      temp.setY(tempy);
	      temp.getSquare().setPosition(tempx, tempy);
	      tempx = tempx2;
	      tempy = tempy2;
	      i++;
	    }
	}
	
public void	eat()
{
	Body	temp = new Body(this.body.get(this.body.size() - 1).getX(), this.body.get(this.body.size() - 1).getY());
	  this.body.add(temp);
}

public void	print(RenderWindow dest)
{
	Body	temp;
	
	int i = 0;
    while (i < this.body.size())
      {
    	temp = this.body.get(i);
	dest.draw(temp.getSquare());
	i++;
      }
}

public int	lost()
{
	Body	temp;
	int		i = 0;
	int		hx;
	int		hy;

	temp = this.body.get(0);
	  hx = temp.getX();
	  hy = temp.getY();
	  i++;
	  while (i < this.body.size())
	    {
		  temp = this.body.get(i);
	      if (hx == temp.getX() && hy == temp.getY())
		return (1);
	      i++;
	    }
	  return (0);
}
























}
