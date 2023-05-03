import java.util.ArrayList;
import java.util.ResourceBundle;

import org.eclipse.swt.events.*;
import org.eclipse.swt.widgets.*;

public class SelectionAdapterToggle2 extends SelectionAdapter{
	
	private Shell parent;
	private ResourceBundle msgs;
	private ArrayList<String> selected5; 
	private ArrayList<String> selected2; 
	
	public SelectionAdapterToggle2(Shell parent, ResourceBundle msgs, ArrayList<String> selected5, ArrayList<String> selected2) { 
		this.parent = parent; 
		this.msgs = msgs;
		this.selected5 = selected5; 
		this.selected2 = selected2; 
	}
	
	@Override
	public void widgetSelected(SelectionEvent e) {
		
		Button toggleButton = (Button)e.widget;
		String text = toggleButton.getText(); 
		
		Control[] children = parent.getChildren(); 
		ToolBar toolBar = (ToolBar) children[0]; 
		ToolItem toolItemRun = toolBar.getItem(0); 
		Label labelError = (Label) children[5];
		
		boolean selected = toggleButton.getSelection(); 
		System.out.println("Selected numbers: "+selected);
		if(selected) {
			if (selected2.isEmpty() || selected2.size() < 2) {
				selected2.add(text);  
			}
			else {
				toggleButton.setSelection(false);
				labelError.setText(msgs.getString("error2"));
			}
			if(selected5.size() == 5 && selected2.size()==2) {
				toolItemRun.setEnabled(true);
			}
		}
		else {
			selected2.remove(text); 
			toolItemRun.setEnabled(false);
			labelError.setText(msgs.getString("noError"));
		}
		System.out.println(selected2);
	}
}
