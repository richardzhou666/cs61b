public class DrawTriangle{
	public static void drawTringle(int N) {
		int x = 1;
		int y = 1;
		while (y <= N) {
			while (x <= y) {
				System.out.print('*');
				x = x +1;
			}
			System.out.println();
			y = y +1; 
			x = 1; /** Reset x to 1 */
		}
	}
	/** Call main function to invoke drawTriangle function*/
	public static void main(String[] args) {
		drawTringle(15);
		}
}
