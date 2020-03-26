package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Play extends JPanel implements KeyListener, ActionListener {
	int score;
	int delay,length;
	Cell food;
	boolean gameOver;
	Queue q;
	private boolean resume;
	final int mat_len;
	final int mat_weidth;
	final int sq_size;
	Direction direction;
	Element e[][]=new Element[40][40];
	private Timer timer;
	static {


	}
	
	
	
	
	///temp
	int x=200,y=200;
	//Element [][]arr=new Element[40][40];
	
	Play()
	{
		length=1;
		resume=false;
		for(int i=0;i<40;i++)
			for(int j=0;j<40;j++)
				e[i][j]=Element.BLANK;
		//System.out.println("Start : ");
		//Control.disp(this);
		delay=100;
		mat_len=20;
		mat_weidth=20;
		q=new Queue();
		score=0;
		e[20][20]=Element.SNAKE;
		gameOver=false;
		q.push(new Cell(20,20));
		sq_size=20;
		food=Control.generateFood(this);
		e[food.x][food.y]=Element.FOOD;
		//System.out.println("Start food: ");
		//Control.disp(this);
		setFocusable(true);
		requestFocus();
		direction=Direction.RIGHT;
		this.addKeyListener(this);
		setBounds(0,0,412,500); 
		setFocusTraversalKeysEnabled(false);
		timer=new Timer(delay,this);

	}

public void paint(Graphics g)
{
	if(gameOver) {
		g.setColor(Color.RED);
		g.setFont(getFont());
		g.drawString("Game Over",175,200);
		g.drawString("Your Score is "+score,175,250);

		timer.stop();
		return;

	}
	

	
	
	requestFocus();
	System.out.println("befour : ");
	//Control.disp(this);
	move();
	//System.out.println("after : ");
	Control.disp(this);
	g.setColor(Color.BLACK);
	g.fillRect(6, 6, 400,400);
	g.setColor(Color.GREEN);
	g.fillRect(0, 412, 412,100);
	g.setColor(Color.YELLOW);
	g.fillRect(this.food.x*10+6,this.food.y*10+6, 10,10);
	g.setColor(Color.RED);
	for(int i=0;i<q.length;i++)
		g.fillRect(q.Q[(q.front+i)%400].x*10+6,q.Q[(q.front+i)%400].y*10+6, 10,10);
	g.setColor(Color.BLUE);
	g.drawString("Score  "+score, 50, 430);
	g.dispose();
}
void move()
{
     if(direction==direction.LEFT)
    	 Control.moveLeft(this);
     if(direction==direction.RIGHT)
    	 Control.moveRight(this);
     if(direction==direction.UP)
    	 Control.moveUp(this);
     if(direction==direction.DOWN)
    	 Control.moveDown(this);
     
     
}

	@Override
	public void actionPerformed(ActionEvent e) {

		  // timer.start();
         System.out.println(e.getSource()+"  "+e.getID()+"  "+e.getModifiers() );
         
		repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {

		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(direction!=Direction.LEFT&&e.getKeyCode()==KeyEvent.VK_RIGHT)
		{
			direction=Direction.RIGHT;
		}else if(direction!=Direction.RIGHT&&e.getKeyCode()==KeyEvent.VK_LEFT)
		{
			direction=Direction.LEFT;
		}
		else if(direction!=Direction.UP&&e.getKeyCode()==KeyEvent.VK_DOWN)
		{
			direction=Direction.DOWN;	
		}
		else if(direction!=Direction.DOWN&&e.getKeyCode()==KeyEvent.VK_UP)
		{
			direction=Direction.UP;
		}
		else if(e.getKeyCode()==KeyEvent.VK_SPACE)
		{
			if(resume)
			{
				resume=false;
				timer.stop();
			}else
			{
				resume=true;
				timer.start();
			}
			
		}

	
	}

	@Override
	public void keyReleased(KeyEvent e) {}

}
