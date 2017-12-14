import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JPanel;

//Some code was inspired by class examples

public class DrawPoints extends JPanel {
	private final ArrayList<Template> _points;
	
	private Color _globalColor;
	
	private int _size = 15;
	
	public DrawPoints() {
		_points = new ArrayList<Template>();
		_globalColor = Color.BLACK;
		
		
		
		MouseAdapter adapter = new MouseAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				Template point = new Template(e.getX(), e.getY(), _globalColor, _size);
				_points.add(point);
				repaint();
			}
			public void mouseClicked(MouseEvent e) {
				Template point = new Template(e.getX(), e.getY(), _globalColor, _size);
				_points.add(point);
				repaint();
			}
		};
		
		addMouseListener(adapter);
		addMouseMotionListener(adapter);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		
		for (Template point : _points) {
			g.setColor(point.getColor());
			point.draw(g);
		}
	}
	
	public void setGlobalColor(Color color) {
		_globalColor = color;
		repaint();
		
	}
	public void setGlobalSize(int size) {
		_size = size;
		repaint();
	}
	
	public void setClearPoints() {
		_points.clear();
		repaint();
	}
}


