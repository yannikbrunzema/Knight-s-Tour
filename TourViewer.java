package chess;

import princeton.introcs.StdDraw;

public class TourViewer
{

	/**
	 * Draws a regular rectangular chess board of the specified size.
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

	//Demonstrates a Knight's tour on a 8x8 square board
	public static void main(String[] args) throws Exception
	{
		Location start = new Location(5,5);
		Piece knight = new Piece ("knight");
		Board b = new Board (9,9, start, knight);
		Tour t = new Tour(b);
		t.startTour(start);
		Location curr = start;
		drawBoard(b.getWidth(),b.getHeight());
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
			Thread.sleep(0);
			i++;
		}
	}
}
