package kolkoikrzyzyk;
import javax.swing.JFrame;

public class kolkoikrzyzk  {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JFrame kolkoikrzyzyk = new kolkoikrzyzykFrame();
		kolkoikrzyzyk.setTitle("Kó³ko i krzy¿yk");
		kolkoikrzyzyk.setSize(600, 600);
		//przestaje dzialac wraz zakmnieciem
		kolkoikrzyzyk.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		//umieszcza gre na œrodku ekranu
		kolkoikrzyzyk.setLocationRelativeTo(null); 
		kolkoikrzyzyk.setVisible(true);
 }

}
