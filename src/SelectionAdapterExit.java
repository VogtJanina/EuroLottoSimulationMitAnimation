import java.util.ResourceBundle;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.*;
import org.eclipse.swt.widgets.*;

public class SelectionAdapterExit extends SelectionAdapter{

	private Shell parent; 
	private ResourceBundle msgs;
	
	public SelectionAdapterExit(Shell parent, ResourceBundle msgs) {
		this.parent = parent; 
		this.msgs = msgs;
	}
	
	@Override
	public void widgetSelected(SelectionEvent e) {
		MessageBox messageBox = new MessageBox(parent, SWT.ICON_QUESTION | SWT.YES | SWT.NO); 
		messageBox.setMessage(msgs.getString("exitMessage"));
		int result = messageBox.open(); 
		switch(result) {
		case SWT.YES:
			parent.close();
			break; 
		case SWT.NO: break; 
		}
		

	}

}
