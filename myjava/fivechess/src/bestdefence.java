
public class bestdefence {
	int attack,defence,x,y;
	public void clear()
	{
		attack=-100000;
		defence=-100000;
		x=0;y=0;
	}
	public void insert(int attack,int defence,int x,int y)
	{
		if(defence>=this.defence)
		{
			this.x=x;
			this.y=y;
			this.attack=attack;
			this.defence=defence;
		}
	}
	public boolean empty()
	{
		if(attack==-100000) return true;
		else return false;
	}
}
