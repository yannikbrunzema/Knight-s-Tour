package chess;

public class Piece 
{
	private final int [][] knightOffset = {{-2,1},{-2,-1}, {2,1},{2,-1},{-1,-2},{-1,2},{1,2},{1,-2}};
	private final int [][] kingOffset = {{1,1},{-1,1},{0,1},{0,-1},{1,0},{-1,0},{-1,-1},{1,-1}};
	private final int [][] rookOffset = {{0,1},{0,-1},{1,0},{-1,0}};
	private final int [][] irregularKnightOffset = {{-4,1},{-4,-1},{4,1},{4,-1},{-1,-4},{-1,4},{1,4},{1,-4}};
	private final String [] pieces = {"king", "rook", "knight", "irregular knight"};
	private String name;
	
	
	public Piece (String n)
	{
		n=n.toLowerCase();
		for (int i = 0; i < pieces.length; i++)
		{
			if (n.equals(pieces[i]))
			{
				this.name = n;
			}
		}
		
		if (name == null)
		{
			throw new IllegalArgumentException("Expected valid piece name");
		}
	}
	
	public int [][] getOffset ()
	{
		if (this.name.equals("king"))
		{
			return this.kingOffset;
		}
		
		else if (this.name.equals("knight"))
		{
			return this.knightOffset;
		}
		
		else if (this.name.equals("irregular knight"))
		{
			return irregularKnightOffset;
		}
		
		else 
		{
			return this.rookOffset;
		}
	}
}
