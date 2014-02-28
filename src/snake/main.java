package snake;
import org.jsfml.window.event.*;
import org.jsfml.graphics.*;
import org.jsfml.window.*;

public class main 
{
	public static void main(String[] args)
	{
Window window = new Window();

while (window.screen.isOpen())
{
	window.screen.clear();
	window.screen.display();
    //Process events
    Event event = window.screen.pollEvent();
        if (event != null && event.type == Event.Type.CLOSED)
            window.screen.close();
}
	}
}
