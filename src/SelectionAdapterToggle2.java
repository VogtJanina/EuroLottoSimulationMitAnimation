import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.*;
import org.eclipse.swt.widgets.*;

public class SelectionAdapterToggle2 extends SelectionAdapter{

	private ArrayList<String> selected2; 
	private Label labelError; 
	public SelectionAdapterToggle2(ArrayList<String> selected2, Label labelError) { 
		this.selected2 = selected2;
		this.labelError = labelError; 
	}
	
	@Override
	public void widgetSelected(SelectionEvent e) {
		
		Button toggleButton = (Button)e.widget;
		String text = toggleButton.getText(); 
		System.out.println(text);
		
		boolean selected = toggleButton.getSelection(); 
		System.out.println(selected);
		if(selected) {
			if (selected2.isEmpty() || selected2.size() < 2) {
				selected2.add(text);  
			}
			else {
				toggleButton.setSelection(false);
				labelError.setText("Nur 2");
			}
		}
		else {
			selected2.remove(text); 
			labelError.setText("No Error");
		}
		System.out.println(selected2);
	}

}
