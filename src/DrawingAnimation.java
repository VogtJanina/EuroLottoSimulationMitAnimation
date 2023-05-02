import java.awt.MenuBar;
import java.util.ArrayList;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

public class DrawingAnimation implements Runnable{

	private final int MILLSEC = 1500;
	private boolean start = false;
	
	private Shell parent;  
	private ArrayList<Integer> drawingArray = new ArrayList<Integer>();
	private ArrayList<Integer> numbersDrawing50;
	private ArrayList<Integer> numbersDrawing12;
	private Drawing drawing1;
	private Drawing drawing2;
	private Group groupResult;
	private int counter = 0;
	private int[] indexResultButtons = {1,2,3,4,5,7,8};
	
	public DrawingAnimation(Shell parent, Drawing drawing1, Drawing drawing2, ArrayList<Integer> numbersDrawing50, ArrayList<Integer> numbersDrawing12) {
		this.parent = parent; 
		this.drawing1 = drawing1;
		this.drawing2 = drawing2;
		this.numbersDrawing50 = numbersDrawing50;
		this.numbersDrawing12 = numbersDrawing12;
		
		Control[] children = parent.getChildren(); 
		this.groupResult = (Group) children[4];
//		System.out.println("drawing: " + drawingArray);

		
	}
	public void count() {
		if (counter == 0) {
			numbersDrawing50.clear();
			numbersDrawing12.clear();
			drawingArray.addAll(drawing1.drawLotteryNumbers());
			drawingArray.addAll(drawing2.drawLotteryNumbers());
			numbersDrawing50.addAll(drawingArray.subList(0, 5));
			numbersDrawing12.addAll(drawingArray.subList(5, 7));
		}
		if (counter < indexResultButtons.length) {
			counter++;
//			System.out.println("DrawingAnimation counter: " + counter);
//			System.out.println("DrawingAnimation count if: start= "+ start);
			start = true;
		}
		else {
			start = false;
			
			Control[] children = parent.getChildren(); 
			ToolBar toolBar = (ToolBar) children[0]; 
			ToolItem toolItemSave = toolBar.getItem(1); 
			toolItemSave.setEnabled(true);
			
			Menu menuBar = parent.getMenuBar(); 
			MenuItem fileTitle = menuBar.getItem(0); 
			Menu fileMenu = fileTitle.getMenu(); 
			MenuItem fileSaveItem = fileMenu.getItem(0); 
			fileSaveItem.setEnabled(true);
			
			parent.getDisplay().timerExec(-1, this);
		}
		
	}
	public void draw() {
		System.out.println("in DrawingAnimation draw(): ");
		if (start) {
//			System.out.println("in draw() if");
			Control[] childrenResult = groupResult.getChildren();
			Button btn;
			btn = (Button)childrenResult[indexResultButtons[counter-1]];
			btn.setText(drawingArray.get(counter-1).toString());
//			System.out.println("DrawingAnimation btn.set: "+ counter + " to " + btn.getText());	
			groupResult.redraw();
		}
		else {
			parent.getDisplay().timerExec(-1, this);
		}
	}
	
	public int getCounter() {
		return counter;
	}
	public void setCounter(int counter) {
		this.counter = counter;
	}
	
	public ArrayList<Integer> getDrawingArray() {
		return drawingArray;
	}
	@Override
	public void run() {
//		System.out.println("run DrawingAnimation");
		count();
		draw();

		parent.getDisplay().timerExec(MILLSEC, this);
		
	}

}
