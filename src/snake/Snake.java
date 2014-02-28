package snake;

import java.util.ArrayList;

public class Snake 
{
	ArrayList<Body> body;
	
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
	
	void	move(char direction)
	{
		int	i = 0;
		
	}
}
