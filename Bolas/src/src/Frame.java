package src;

import javax.swing.JFrame;

public class Frame extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Frame(){
		super("Ya me hice Bolas");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(true);
		this.add(new Bolas ());
		this.pack();
	}
	
	public static void main(String[] args) {
		new Frame();
	}
}
