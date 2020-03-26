package game;

public class Queue {
	Cell []Q=new Cell[400];
	int front;
	int rare;
	int length;
	Queue(){
		front=-1;
	    rare=-1;
		length=0;
	}
	Cell back()
	{
		return Q[rare];
	}
	boolean push(Cell new_cell)
	{
		if((rare+1)%400==front)
			return false;
		if(front==-1&&rare==-1)
		{
			front=0;
			rare=0;
			Q[rare]=new_cell;
		}
		else
		{
			rare=(rare+1)%400;
			
			Q[rare]=new_cell;
		}
		length++;
		return true;
	}
	Cell pop()
	{
		
		if(front==-1&&rare==-1)
		{
			return null;
		}
		else
		{
			length--;
			Cell c=Q[front];
			front=(front+1)%400;
			return c;
		}
		
	
	}
	


}
