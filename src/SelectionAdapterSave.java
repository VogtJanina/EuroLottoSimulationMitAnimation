import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.*;
import org.eclipse.swt.widgets.*;

public class SelectionAdapterSave extends SelectionAdapter{

	private Shell parent; 
	private ArrayList<String> selected5; 
	private ArrayList<String> selected2; 
	private String content; 
	
	public SelectionAdapterSave(Shell parent, ArrayList<String> selected5, ArrayList<String> selected2) {
		this.parent = parent; 
		this.selected5 = selected5; 
		this.selected2 = selected2; 
	}
	
	@Override
	public void widgetSelected(SelectionEvent e) {
		FileDialog fileDialog = new FileDialog(parent, SWT.OPEN); 
		String fileName = fileDialog.open(); 
		if (fileName != null) {
			content = "ausgewählte Zahlen: \n5 aus 50: " + selected5 + "\n2 aus 12: " + selected2;
			content +="gezogene Zahlen: \n5 aus 50: " + selected5 + "\n2 aus 12:" + selected2;
			//TODO win/lose
			FileIO.write(fileName, content);
		}
		

	}

}
