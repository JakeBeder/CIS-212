import java.awt.Color;
import java.awt.Graphics;


//Some code was inspired by class examples

public class Template {
	private int _x = 0;
	private int _y = 0;
	

	private Color _color = Color.BLACK;
	
	private int _size = 15;
	
	Template (int x, int y, Color color,  int size) {
		_x = x;
		_y = y;
		_color = color;
		_size = size;
		
	}
	
	public int getX() {
		return this._x;
	}
	
	public int getY() {
		return this._y;
	}
	
	public Color getColor() {
		return this._color;
	}

	public double getSize() {
		return this._size;
	}
	public void draw(Graphics g) {
	
			g.fillOval(_x, _y, _size, _size);
}
}