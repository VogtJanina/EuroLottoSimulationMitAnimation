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
		drawing1.drawLotteryNumbers();
		Drawing drawing2 = new Drawing(numbers2, quantity2); 
		drawing2.drawLotteryNumbers();
	}

}
