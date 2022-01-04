package chess;

import java.util.ArrayList;
import java.util.Iterator;


public class Board
{
	private int height;
	private int width;
	private Location pieceLoc;
	protected ArrayList<Location> visitedLocations;
	private Piece currentPiece;
	
	public Board (int w, int h, Location start, Piece p)
	{
		this.height = h;
		this.width = w;
		this.pieceLoc = start;
		this.visitedLocations = new ArrayList<Location>();
		visitedLocations.add(pieceLoc);
		this.currentPiece = p;
	}
	
	public ArrayList<Location> allMoves (Location from)
	{
		//Finds the possible moves that have not been visited.
		ArrayList<Location> possibleMoves = new ArrayList<Location>();
		int [][] offset = currentPiece.getOffset();
		for (int[]delta: offset)
		{
			Location newLoc = new Location (from.x()+delta[0], from.y()+delta[1]);
			if (isValidLoc(newLoc))
			{
				possibleMoves.add(newLoc);
			}
			
		}
		for (Iterator<Location> iter = visitedLocations.iterator(); iter.hasNext();)
		{
			Location elem = iter.next();
			if (possibleMoves.contains(elem))
			{
				possibleMoves.remove(elem);
			}	
		}
		return possibleMoves;
	}
	
	public Location findBestMove (ArrayList<Location> moves)
	{
		//Finds the best move using Warnsdorff's rule
		int currentMin = allMoves(moves.get(0)).size();
		int indexOfMin = 0;
	    for (int i = 0 ; i < moves.size(); i++)
	    {
	    	if (allMoves(moves.get(i)).size() < currentMin)
	    	{
	    		currentMin = allMoves(moves.get(i)).size();
	    		indexOfMin = i;
	    	}
	    } 
	    return moves.get(indexOfMin);
	}
	
	public boolean isValidLoc (Location futureLoc)
	{
		//Returns true if the location to be moved to is valid
		boolean validX = futureLoc.x() >= 1 && futureLoc.x() <= width;
		boolean validY = futureLoc.y() >= 1 && futureLoc.y() <= height;
		return validX && validY;
	}
	
	public int getWidth()
	{
		return this.width;
	}
	
	public int getHeight()
	{
		return this.height;
	}
}
