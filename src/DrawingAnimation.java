import java.util.ArrayList;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Shell;

public class DrawingAnimation implements Runnable{

	private final int MILLSEC = 1500;
	private boolean start = false;
	
	private Shell parent;  
	ArrayList<Integer> drawingArray = new ArrayList<Integer>();
	private Drawing drawing1;
	private Drawing drawing2;
	private Group groupResult;
	private int counter;
	private int[] indexResultButtons = {1,2,3,4,5,7,8};
	
	public DrawingAnimation(Shell parent, Drawing drawing1, Drawing drawing2) {
		this.parent = parent; 
		this.drawing1 = drawing1;
		this.drawing2 = drawing2;
		
		Control[] children = parent.getChildren(); 
		this.groupResult = (Group) children[4];
		System.out.println("drawing: " + drawingArray);

		
	}
	public void count() {
		if (counter == 0) {
			drawingArray.addAll(drawing1.drawLotteryNumbers());
			drawingArray.addAll(drawing2.drawLotteryNumbers());
		}
		if (counter < indexResultButtons.length) {
			counter++;
			System.out.println("DrawingAnimation counter: " + counter);
			System.out.println("DrawingAnimation count if: start= "+ start);
			start = true;
			
		}
		else {
			start = false;
			parent.getDisplay().timerExec(-1, this);
			System.out.println("DrawingAnimation count else: start= "+ start);
		}
		
	}
	public void draw() {
		System.out.println("in DrawingAnimation draw(): ");
		if (start) {
			System.out.println("in draw() if");
			Control[] childrenResult = groupResult.getChildren();
			Button btn;
			btn = (Button)childrenResult[indexResultButtons[counter-1]];
			btn.setText(drawingArray.get(counter-1).toString());
			System.out.println("DrawingAnimation btn.set: "+ counter + " to " + btn.getText());	
			groupResult.redraw();
		}
		parent.getDisplay().timerExec(-1, this);
	}
	
	
	@Override
	public void run() {
		System.out.println("run DrawingAnimation");
		count();
		draw();

		parent.getDisplay().timerExec(MILLSEC, this);
		
	}

}
