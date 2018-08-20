package src;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Bolas extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int [] arreY = new int [1];
	private int [] arreX = new int [1];
	private int [] largo = new int [1];
	Bolas (){
		super();
		this.setPreferredSize(new Dimension(720,700));
		this.setLayout(null);
		this.pintaCirculos(super.getGraphics(), 16, 50, 350, 600);
	}
	
	public void pintaCirculos (Graphics g,int nivel,int x1, int y1, int largo) {
		int centroX = x1;
		int centroY = y1 - (largo/2);
		if(this.arreY.length - 1 < nivel) {
			int n = 1;
			for (int i = 1; i < nivel + 1; i++) {
				n += Math.pow(2,i);
			}
				this.arreY = new int [n];
				this.largo = new int [n];
				this.arreX = new int [n];
		}
		if (nivel != 0) {
			this.pintaCirculos(g, nivel -1, x1, y1, largo/2);
			this.pintaCirculos(g, nivel -1, x1 + largo/2, y1, largo/2);
		}
		for (int i = 0;i < arreY.length;i++) {
			if (arreY[i] == 0) {
				arreY[i] = centroY;
				arreX[i] = centroX;
				this.largo[i] = largo;
				i = arreY.length;
			}
		}
		this.repaint();
	}
	
	public void paint(Graphics g) {
		super.paint(g);
			for (int i = 0; i < arreY.length; i++) {
				g.drawOval(arreX[i], arreY[i], largo[i], largo[i]);
				System.out.println(largo[i] + " " + arreX[i] + " " + arreY[i] + " " + arreX.length + " " + i);
		}
		g.drawString("hola", 1, 1);
	}
}
