import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.*;
import org.eclipse.swt.widgets.*;

public class SelectionAdapterToggle5 extends SelectionAdapter{

	private ArrayList<String> selected5; 
	private Label labelError; 
	public SelectionAdapterToggle5(ArrayList<String> selected5, Label labelError) { 
		this.selected5 = selected5;
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
			if (selected5.isEmpty() || selected5.size() < 5) {
				selected5.add(text);  
			}
			else {
				toggleButton.setSelection(false);
				labelError.setText("Nur 5");
			}
		}
		else {
			selected5.remove(text); 
			labelError.setText("No Error");
		}
		System.out.println(selected5);
	}

}
