import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class LineGraph extends JPanel {
	
	/*
	 *Should create and declare the window in another class in order to make the code clean and neat
	 *This class should be soley for the equation and solving for the line equation
	 */
	
	public String equation;
	public Double x;
	public Double y;
	public Double m;
	public String strM;
	public Double b;
	public String strB;
	
	public static ArrayList<Double> xPoints = new ArrayList<Double>();
	public static ArrayList<Double> yPoints = new ArrayList<Double>();
	
	public static int windowWidth;
	public static int windowHeight;
	public Boolean windowVisable;
	
	
	public void function(String equation) {
		int indexOfX = equation.indexOf("x");
		strM = equation.substring(0, indexOfX);
		m = Double.parseDouble(strM);
		strB = equation.substring(indexOfX+1, equation.length());
		b = Double.parseDouble(strB);
			}

	public void solveXY() {
		for(int i=-100; i <= 100; i++) {
			y = (double)i;
			x = ((y-b)/m);
			xPoints.add(x);
			yPoints.add(y);
		}
	}
	
	public static void main(String [] args) {
		
		JFrame window = new JFrame();
		windowWidth = 100;
		windowHeight = 100;
		window.setSize(windowWidth, windowHeight);
		window.setTitle("Graph");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		LineGraph graph = new LineGraph();
		window.add(graph);
		//window.pack();
		
		Scanner kbd = new Scanner(System.in);
		LineGraph line = new LineGraph();
		line.equation = kbd.nextLine();
		line.function(line.equation);
		line.solveXY();
		/*
		 * Testing variables for broken apart and solved equation
		 */
		System.out.println(line.m);
		System.out.println(line.b);
		
		/*
		for(Double doub : yPoints) {
		System.out.println(doub);
		}
		*/
		for(int i = 0; i <= xPoints.size()-1; i++) {
			System.out.println("(" + xPoints.get(i) + "," + yPoints.get(i) + ")");
		}
		System.out.println(xPoints.size()-1);
		
	}
	
	public void paint(Graphics g) {
		
		g.setColor(Color.BLACK);
		
		//Draws the line with the opposite slope
		for(int i = 0; i <= xPoints.size()-2; i++) {
			
			double dblFstYPt = yPoints.get(i);
			int fstYPt = (int)dblFstYPt;
			double dblScndYPt = yPoints.get(i+1);
			int scndYPt = (int)dblScndYPt;
			
			double dblFstXPt = xPoints.get(i);
			int fstXPt = (int)dblFstXPt;
			double dblScndXPt = xPoints.get(i+1);
			int scndXPt = (int)dblScndXPt;
			g.drawLine(fstXPt, fstYPt, scndXPt, scndYPt);
			System.out.print("(" + fstXPt + "," + fstYPt  + ") ");
			System.out.println(“Hello”);
		}
		
	}

}
