package chess;

import java.util.ArrayList;

public class Tour 
{
	private Board currentBoard;
	private Location pieceLoc;
	
	public Tour (Board b)
	{
		this.currentBoard = b;
	}
	
	public void startTour(Location loc) 
	{
		this.pieceLoc = loc;
	}
	
	
	public boolean hasNext() 
	{
		if (currentBoard.allMoves(pieceLoc).size() > 0)
		{
			return true;
		}
		return false;
	}
	
	public Location next()
	{
		ArrayList<Location> possibleMoves =  currentBoard.allMoves(pieceLoc);
		if (possibleMoves.size() >= 1)
		{
			pieceLoc = currentBoard.findBestMove(possibleMoves);
			currentBoard.visitedLocations.add(pieceLoc);
			return pieceLoc;
		}
		return null;
	}
}
