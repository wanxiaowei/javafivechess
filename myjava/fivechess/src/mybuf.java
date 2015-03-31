
public class mybuf {
	public int k;
	public int [][]key = new int[20][2];
	public mybuf()
	{
		clear();
	}
	public void clear()
	{
		k=0;
		for(int i=0;i<20;i++)
		{
			key[i][0]=0;
			key[i][1]=0;
		}
	}
	public void insert(int x,int y)
	{
		k++;
		key[k][0]=x;
		key[k][1]=y;
	}
}
