package chess;

import princeton.introcs.StdDraw;

public class TourViewer2
{
	/**
	 * Draws a 10x10 square board using a king.
	 * 
	 * <p>
	 * Students will need to modify this method to draw irregular boards
	 * if their solutions allows for irregular boards. 
	 * 
	 * @param width the number of squares in the width of the board
	 * @param height the number of squares in the height of the board
	 */
	private static void drawBoard(int width, int height) {
		if (width < 1 || height < 1) {
			throw new IllegalArgumentException();
		}
		int max = Math.max(width, height);
		StdDraw.setScale(0.5, max + 0.5);
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				if ((i + j) % 2 == 0) {
					StdDraw.setPenColor(StdDraw.BLUE);
				} else {
					StdDraw.setPenColor(StdDraw.WHITE);
				}
				StdDraw.filledSquare(i + 1, j + 1, 0.5);
			}
		}
	}

	
	//Demonstrates a King's tour on a 10x10 square board.
	public static void main(String[] args) throws Exception
	{
		Location start = new Location(2,2);
	    Piece king = new Piece ("king");
	    Board currentBoard = new Board (10,10, start, king);
	    Tour t = new Tour(currentBoard);
		t.startTour(start);
		Location curr = start;
		drawBoard(currentBoard.getWidth(), currentBoard.getHeight());
		StdDraw.setPenColor(StdDraw.BLACK);
		int i = 0;
		while (t.hasNext()) 
		{
			Location next = t.next();
			System.out.println(i + " : moving from " + curr + " to " + next);
			StdDraw.line(curr.x(), curr.y(), next.x(), next.y());
			StdDraw.filledCircle(next.x(), next.y(), 0.1);
			curr = new Location(next);
			// uncomment the next line to slow down the viewer; 500 is the pause time in milliseconds
			Thread.sleep(100);
			i++;
		}
	}
}
