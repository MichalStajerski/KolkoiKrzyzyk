package kolkoikrzyzyk;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
 

public class kolkoikrzyzykFrame extends JFrame {
	   private char whoseTurn = 'X';
	   private  boolean gameOver = false;
	 
	   //tworzy siatke komorek
	   private Cell[][] cells = new Cell[3][3];
	 
	   //tworzy etykiete
	   JLabel jlblStatus = new JLabel("X zaczyna");
	 
	   //konstruktor
	   public kolkoikrzyzykFrame()
	   {
	       //tworzy panel na komorki
	       JPanel panel = new JPanel(new GridLayout(3, 3, 0, 0));
	       for (int i = 0; i < 3; i++)
	           for (int j = 0; j < 3; j++)
	               panel.add(cells[i][j] = new Cell());
	 
	       panel.setBorder(new LineBorder(Color.red, 1));
	       jlblStatus.setBorder(new LineBorder(Color.yellow, 1));
	       
	       //dodaje oba panele
	       add(panel, BorderLayout.CENTER);
	       add(jlblStatus, BorderLayout.SOUTH);
	   }
	 
	   
	    //sprawdza czy jest pe³ne
	    public boolean isFull()
	    {
	       for (int i = 0; i < 3; i++)
	           for (int j = 0; j < 3; j++)
	               if (cells[i][j].getToken() == ' ') {
	                   return false;
	               }return true;      
	    }
	 
	   //sprawdza czy ktoœ wygra³
	   public boolean isWon(char token)
	   {
	       //wiersze
	       for (int i = 0; i < 3; i++)
	           if ((cells[i][0].getToken() == token)
	                   && (cells[i][1].getToken() == token)
	                   && (cells[i][2].getToken() == token))
	           {
	               return true;
	           }
	 
	       //kolumny
	       for (int j = 0; j < 3; j++)
	           if ((cells[0][j].getToken() == token)
	               && (cells[1][j].getToken() == token)
	               && (cells[2][j].getToken() == token))
	           {
	               return true;
	           }
	       //na ukos
	       if ((cells[0][0].getToken() == token)
	               && (cells[1][1].getToken() == token)
	               && (cells[2][2].getToken() == token))
	           {
	               return true;
	           }
	 
	       if ((cells[0][2].getToken() == token)
	               && (cells[1][1].getToken() == token)
	               && (cells[2][0].getToken() == token))
	           {
	               return true;
	           }
	 
	       return false;
	   }
	 
	    //tworzenie komórki na planszy
	    public class Cell extends JPanel
	    {
	       // znak pola
	       private char token = ' ';
	 
	       //konstruktor
	       public Cell()
	       {
	           setBorder(new LineBorder(Color.black,1));
	           addMouseListener(new MyMouseListener());
	       }
	 
	       //zwraca warrtosc znaku
	       public char getToken()
	       {
	           return token;
	       }
	 
	       //ustala wartosc znaku
	       public void setToken(char c)
	       {
	           token = c;
	           repaint();		
	           //metoda repaint() wywo³ujê metodê paint()
	       }
	 
	     
		public void paint(Graphics g)
	       {
	           super.paint(g);
	 
	           if (token == 'X')
	           {
	               g.drawLine(10, 10, getWidth() - 10, getHeight() - 10);
	               g.drawLine(getWidth() - 10, 10, 10, getHeight() - 10);
	           }
	 
	           else if (token == 'O')
	           {
	               g.drawOval(10, 10, getWidth() - 20, getHeight() - 20);
	           }
	       }
	 
	       private class MyMouseListener extends MouseAdapter
	       {
	           
	           public void mouseClicked(MouseEvent e)
	           {
	        	   //zapobiega dalszej grze po zwyciêstwie
	               if (gameOver== true)
	                   return;
	               
	               // jesli pole jest puste i jest czyjaœ tura
	               if (token == ' ' && whoseTurn != ' ')
	                   setToken(whoseTurn);
	 
	               // Sprawdza status gry
	               if (isWon(whoseTurn))
	               {
	                   jlblStatus.setText(whoseTurn + " wygra³o!");
	                   whoseTurn = ' ';
	                   gameOver = true;
	               }
	               else if (isFull())
	               {
	                   jlblStatus.setText("Remis!");
	                   whoseTurn = ' ';
	                   gameOver = true;
	               }
	               else
	               {
	            	   //zamiana ruchów z X na O lub O na X
	            	   if(whoseTurn == 'X') {
	            		   whoseTurn = 'O';
	            		   
	            	   }else whoseTurn = 'X';
	                   jlblStatus.setText(whoseTurn + " twój ruch.");
	               }
	           }
	       }
	    } 
}
