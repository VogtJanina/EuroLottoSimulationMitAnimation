import org.eclipse.swt.SWT;
import org.eclipse.swt.events.*;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.*;

public class SelectionAdapterReset extends SelectionAdapter{

	private Shell parent;
	private Color background;
	private Color font;
	
	public SelectionAdapterReset(Shell parent, Color font, Color background ) {
		this.parent = parent;
		this.background = background;
		this.font = font; 
	}
	
	@Override
	public void widgetSelected(SelectionEvent e) {
		MessageBox messageBox = new MessageBox(parent, SWT.ICON_QUESTION | SWT.YES | SWT.NO); 
		messageBox.setMessage("Möchtest du deine Änderungen wirklich zurücksetzen?");
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
					if (areaChildren[j] instanceof Button){
						btn = (Button) areaChildren[j];
//						currentFontColor = btn.getForeground();
//						currentBackgroundColor = btn.getBackground();
						btn.setSelection(false);
						btn.setBackground(background);
						btn.setForeground(font);
					}
					else if (j > 0 & j < 6 & areaChildren[j] instanceof Label){
						label = (Label) areaChildren[j];
//						currentFontColor = label.getForeground();
//						currentBackgroundColor = label.getBackground();
						label.setBackground(background);
						label.setForeground(font);
						label.setText("X");
					}
					else if (j > 6 & j <= 8 & areaChildren[j] instanceof Label){
						label = (Label) areaChildren[j];
//						currentFontColor = label.getForeground();
//						currentBackgroundColor = label.getBackground();
						label.setBackground(background);
						label.setForeground(font);
						label.setText("e");
					}
				
				}
				
			}
			currentFontColor.dispose();
			currentBackgroundColor.dispose();
			
			
			break; 
		case SWT.NO: break; 
		}
		

	}

}
