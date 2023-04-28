import java.util.ArrayList;
import java.util.ResourceBundle;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.*;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.*;

public class SelectionAdapterReset extends SelectionAdapter{

	private Shell parent;
	private ResourceBundle msgs;
	private ToolItem toolItemRun;
	private Color background;
	private Color font;
	private Animation animation;
	private DrawingAnimation drawingAnimation;
	private ArrayList<String> selected5;
	private ArrayList<String> selected2;

	
	public SelectionAdapterReset(Shell parent,ResourceBundle msgs, ToolItem toolItemRun, Color font, Color background, Animation animation , DrawingAnimation drawingAnimation,
			ArrayList<String> selected5, ArrayList<String> selected2) {
		this.parent = parent;
		this.msgs = msgs;
		this.toolItemRun = toolItemRun;
		this.background = background;
		this.font = font;
		this.animation = animation;
		this.drawingAnimation = drawingAnimation;
		this.selected5 = selected5;
		this.selected2 = selected2;
	}
	
	@Override
	public void widgetSelected(SelectionEvent e) {
		MessageBox messageBox = new MessageBox(parent, SWT.ICON_QUESTION | SWT.YES | SWT.NO); 
		messageBox.setMessage(msgs.getString("resetMessage"));
		int result = messageBox.open();
		Button btn;
		Label label;
		Color currentFontColor;
		Color currentBackgroundColor;
		switch(result) {
		case SWT.YES:
			Control[] children = parent.getChildren();
			Group group = (Group) children[1];
			Control[] areaChildren = group.getChildren();
			currentFontColor =  areaChildren[1].getForeground();
			currentBackgroundColor = areaChildren[1].getBackground();
			int[] index = {1,3,4};
			for (int i: index) {
				Group area = (Group)children[i];
				areaChildren = area.getChildren();
				for (int j=1; j<areaChildren.length; j++) {
					if (((i==index[0] | i==index[1])) &(areaChildren[j] instanceof Button)){
						btn = (Button) areaChildren[j];
//						currentFontColor = btn.getForeground();
//						currentBackgroundColor = btn.getBackground();
						btn.setSelection(false);
						btn.setBackground(background);
						btn.setForeground(font);
					}
					else if ((i==index[2]) & (j > 0) & (j < 6) & (areaChildren[j] instanceof Button)){
						System.out.println("else if 0-6");
						btn = (Button) areaChildren[j];
//						currentFontColor = label.getForeground();
//						currentBackgroundColor = label.getBackground();
						btn.setBackground(background);
						btn.setForeground(font);
						System.out.print("Change btn.text from " + btn.getText() + " to ");
						btn.setText(" X ");
						System.out.println(btn.getText());
					}
					else if ((i==index[2]) & (j > 6) & (j <= 8) & (areaChildren[j] instanceof Button)){
						btn = (Button) areaChildren[j];
//						currentFontColor = label.getForeground();
//						currentBackgroundColor = label.getBackground();
						btn.setBackground(background);
						btn.setForeground(font);
						System.out.print("Change btn.text from " + btn.getText() + " to ");
						btn.setText(" e ");
						System.out.println(btn.getText());
					}
				
				}
							
			}
			toolItemRun.setEnabled(false);
			selected5.clear();
			selected2.clear();
//			System.out.println("selected5: " + selected5);
//			System.out.println("selected2: " + selected2);
			drawingAnimation.setCounter(0);			
		
			currentFontColor.dispose();
			currentBackgroundColor.dispose();
			Display display = parent.getDisplay();
			display.timerExec(-1,animation);
			display.timerExec(-1, drawingAnimation);
			
			break; 
		case SWT.NO: break; 
		}
		

	}

}
