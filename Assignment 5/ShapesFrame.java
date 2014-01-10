import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.geom.*;

public class ShapesFrame extends JFrame{
	public ShapesFrame(){
		setTitle("Shapes");
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension d = tk.getScreenSize();
		int width = 320;
		int height = 175;
		setBounds((int) (d.width-width)/2,
				  (int) (d.height-height)/2, width, height);

		setResizable(false);
 		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});

		Container contentPane = getContentPane();
		ShapesPanel panel = new ShapesPanel();
		contentPane.add(panel);
	}
	public static void main(String[] args){
		ShapesFrame frame = new ShapesFrame();
		frame.show();
	}
}

class ShapesPanel extends JPanel implements ItemListener{

	JComboBox shapeComboBox, colorComboBox;
	
	//fillbox init
	JCheckBox fillCheckBox;
	Shape shape;
	
	//color init
	Color color;

	public ShapesPanel(){
		String[] shapes = {"Rectangle", "Round Rectangle", "Ellipse", "Arc", "Triangle"};
		shapeComboBox = new JComboBox(shapes);
		shapeComboBox.addItemListener(this);
		shapeComboBox.setSelectedItem("Rectangle");
		shape = new Rectangle2D.Double(30,40,200,60);

		// add different colors + template
		String[] colors = {"Black", "White", "Red", "Green", "Blue", "Pink"};
		colorComboBox = new JComboBox(colors);
		colorComboBox.setSelectedItem("Black");
		colorComboBox.addItemListener(this);


		// fill template
		fillCheckBox = new JCheckBox("Fill");
		fillCheckBox.setSelected(true);
		fillCheckBox.addItemListener(this);

		add(shapeComboBox);
		add(colorComboBox);
		add(fillCheckBox);

	}

	public void itemStateChanged(ItemEvent e){
		String shapeString = (String) shapeComboBox.getSelectedItem();
		int x = 30;
		int y = 40;
		int w = 200;
		int h = 60;
		if (shapeString.equals("Rectangle"))
			shape = new Rectangle2D.Double(x, y, w, h);
		else if (shapeString.equals("Round Rectangle"))
			shape = new RoundRectangle2D.Double(x, y, w, h, 40, 40);
		else if (shapeString.equals("Ellipse"))
			shape = new Ellipse2D.Double(x, y, w, h);
		else if (shapeString.equals("Arc"))
			shape = new Arc2D.Double(x, y, w, h, 30, 210, Arc2D.CHORD);
		else if (shapeString.equals("Triangle")){
			int[] xPoints = {x, (x+w)/2, w};
			int[] yPoints = {y+h, y, y+h};
			shape = new Polygon(xPoints, yPoints, 3);
		}
		
		//add color to shapes
		String colorString = (String) colorComboBox.getSelectedItem();
		if (colorString.equals("Black"))
			color = Color.black;
		else if (colorString.equals("White"))
			color = Color.white;
		else if (colorString.equals("Red"))
			color = Color.red;
		else if (colorString.equals("Green"))
			color = Color.green;
		else if (colorString.equals("Blue"))
			color = Color.blue;
		else if (colorString.equals("Pink"))
			color = Color.pink;
		repaint();
	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2D = (Graphics2D) g;
		
		//fill option
		g2D.setColor(color);
		if (fillCheckBox.isSelected())
			g2D.fill(shape);
		else
			g2D.draw(shape);
	}
}
