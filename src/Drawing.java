import java.util.ArrayList;
import java.util.Random;

public class Drawing {
	ArrayList<Integer> numbers; 
	int quantity; 
	ArrayList<Integer> drawing = new ArrayList<Integer>(); 
	public Drawing(ArrayList<Integer> numbers, int quantity) {
		this.numbers = numbers; 
		this.quantity = quantity; 
	}
	public void drawLotteryNumbers() {
		for (int i=0; i<quantity; i++) {
			Random lottofairy = new Random(); 
			int nextPos = lottofairy.nextInt(numbers.size()); 
			int nextNumber = numbers.remove(nextPos); 
			drawing.add(nextNumber); 
		}
		System.out.println(drawing);
	}
}
