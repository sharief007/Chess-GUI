
import java.awt.Font;
import javax.swing.*;
import java.awt.GraphicsEnvironment;

public class Fonts {
	
	public static void main(String[] args) {
		
		JFrame j = new JFrame("ALl Fonts In Java");
		j.setSize(500,500);
		JPanel p = new JPanel();
		JScrollPane pane = new JScrollPane(p);
		
		p.setLayout(new BoxLayout(p,BoxLayout.Y_AXIS));
		GraphicsEnvironment ge;
		ge = GraphicsEnvironment.getLocalGraphicsEnvironment();  
	    Font[] f = ge.getAllFonts();
	    JLabel l[] = new JLabel[f.length];
	    
	    try {
	    	
	    	for(int i=0;i<f.length;i++)
		    {
		    	l[i] = new JLabel(i+"  "+f[i].getFontName());
		    	l[i].setFont(new Font(f[i].getFontName(),Font.BOLD,20));
		    	p.add(l[i]);
		    //	System.out.println(i);
		    }
	    }
	    catch(Exception e)
	    {
	    	e.printStackTrace();
	    }
	    j.add(pane);
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		j.setLocationRelativeTo(null);
		j.setVisible(true);
	   
	    
	}
}
