public class Triangle{
	public static void main(String[] args) {
		int x = 1;
		int y = 1;
		while (y <= 5) {
			while (x <= y) {
				System.out.print('*');
				x = x +1;
			}
			System.out.println();
			y = y +1; 
			x = 1; /** Reset x to 1 */
		}
	}
}
