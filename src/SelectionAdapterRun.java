import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.*;
import org.eclipse.swt.widgets.*;

public class SelectionAdapterRun extends SelectionAdapter{

	private Shell parent; 
	private ArrayList<Integer> numbers1; 
	private int quantity1;
	private ArrayList<Integer> numbers2; 
	private int quantity2; 
	
	public SelectionAdapterRun(Shell parent, ArrayList<Integer> numbers1, int quantity1, ArrayList<Integer> numbers2, int quantity2) {
		this.parent = parent; 
		this.numbers1 = numbers1; 
		this.quantity1 = quantity1; 
		this.numbers2 = numbers2; 
		this.quantity2 = quantity2; 
	}
	
	@Override
	public void widgetSelected(SelectionEvent e) {
		Drawing drawing1 = new Drawing(numbers1, quantity1); 
		ArrayList<Integer> drawingResult1 = drawing1.drawLotteryNumbers();
		Drawing drawing2 = new Drawing(numbers2, quantity2); 
		ArrayList<Integer> drawingResult2 = drawing2.drawLotteryNumbers();
		
		Control[] children = parent.getChildren(); 
		Group groupResult = (Group) children[4]; 
		Control[] childrenResult = groupResult.getChildren(); 
		
		int[] indexResultButtons5 = {1,2,3,4,5};
		int[] indexResultButtons2 = {7,8};
		Button btn; 
		for (int i = 0; i<indexResultButtons5.length; i++) {
			btn = (Button)childrenResult[indexResultButtons5[i]];
			btn.setText(drawingResult1.get(i).toString());
		}
		for (int i = 0; i<indexResultButtons2.length; i++) {
			btn = (Button)childrenResult[indexResultButtons2[i]];
			btn.setText(drawingResult2.get(i).toString());
		}
		
		for (int i=0; i<childrenResult.length; i++) {
			System.out.print(i);
			System.out.println(childrenResult[i]);
		}
		
	}

}
