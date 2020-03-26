package game;

import java.util.Random;

public class Control {
    static Random r;
    static {
    	r=new Random();
    }
	static void moveRight(Play p)
	{
		//System.out.println(p.q.back().x);
		if(p.q.back().x==39||p.e[p.q.back().x+1][p.q.back().y]==Element.SNAKE)
		{
			p.gameOver=true;
			return;
		}
		if(p.q.back().x+1==p.food.x&&p.q.back().y==p.food.y)
		{
			p.q.push(new Cell(p.q.back().x+1,p.q.back().y));
			p.e[p.q.back().x][p.q.back().y]=Element.SNAKE;
			p.food=generateFood(p);
			p.score+=6;
		}else
		{
			p.q.push(new Cell(p.q.back().x+1,p.q.back().y));
			p.e[p.q.back().x][p.q.back().y]=Element.SNAKE;
			Cell c=p.q.pop();
			p.e[c.x][c.y]=Element.BLANK;
		}
		
	}
	static void moveLeft(Play p)
	{
		if(p.q.back().x==0||p.e[p.q.back().x-1][p.q.back().y]==Element.SNAKE)
		{
			p.gameOver=true;
			return;
		}
		if(p.q.back().x-1==p.food.x&&p.q.back().y==p.food.y)
		{
			p.q.push(new Cell(p.q.back().x-1,p.q.back().y));
			p.e[p.q.back().x][p.q.back().y]=Element.SNAKE;
			p.food=generateFood(p);
			p.score+=6;

		}else
		{
			p.q.push(new Cell(p.q.back().x-1,p.q.back().y));
			p.e[p.q.back().x][p.q.back().y]=Element.SNAKE;
			Cell c=p.q.pop();
			p.e[c.x][c.y]=Element.BLANK;		}
		
	}
	static void moveUp(Play p)
	{
		if(p.q.back().y==0||p.e[p.q.back().x][p.q.back().y-1]==Element.SNAKE)
		{
			p.gameOver=true;
			return;
		}
		if(p.q.back().y-1==p.food.y&&p.q.back().x==p.food.x)
		{
			p.q.push(new Cell(p.q.back().x,p.q.back().y-1));
			p.e[p.q.back().x][p.q.back().y]=Element.SNAKE;
			p.food=generateFood(p);
			p.score+=6;

		}else
		{
			p.q.push(new Cell(p.q.back().x,p.q.back().y-1));
			p.e[p.q.back().x][p.q.back().y]=Element.SNAKE;
			Cell c=p.q.pop();
			p.e[c.x][c.y]=Element.BLANK;		}
		
	}
	static void moveDown(Play p)
	{
		if(p.q.back().y==39||p.e[p.q.back().x][p.q.back().y+1]==Element.SNAKE)
		{
			p.gameOver=true;
			return;
		}
		if(p.q.back().y+1==p.food.y&&p.q.back().x==p.food.x)
		{
			p.q.push(new Cell(p.q.back().x,p.q.back().y+1));
			p.e[p.q.back().x][p.q.back().y]=Element.SNAKE;
			p.food=generateFood(p);
			p.score+=6;

		}else
		{
			p.q.push(new Cell(p.q.back().x,p.q.back().y+1));
			p.e[p.q.back().x][p.q.back().y]=Element.SNAKE;
			Cell c=p.q.pop();
			p.e[c.x][c.y]=Element.BLANK;		}
	}
	static Cell generateFood(Play p)
	{
		int x=0,y=0;
		int k=0;
		int rand=r.nextInt(1600-p.q.length);
		a:for(int i=0;i<40;i++)
		{
			for(int j=0;j<40;j++)
			{
				if(p.e[i][j]!=Element.SNAKE)
				{
					if(k==rand)
					{
						x=i;
						y=j;
						break a;
					}else
					{
						k++;
					}
				}
			}
		}
		p.e[x][y]=Element.FOOD;
		Cell food=new Cell(x,y);
		return food;
	}
	
	static void disp(Play p)
	{
		for(int j=0;j<40;j++)
		{
			for(int i=0;i<40;i++)
			{
				if(p.e[i][j]==Element.SNAKE)
				{
					System.out.print("S ");
				}                
				else if(p.e[i][j]==Element.BLANK)
					System.out.print("  ");
				else if(p.e[i][j]==Element.FOOD)
					System.out.print("F ");
			}
			System.out.println();
		}
	}
}
