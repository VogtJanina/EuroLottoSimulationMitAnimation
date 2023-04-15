import org.eclipse.swt.SWT;
import org.eclipse.swt.events.*;
import org.eclipse.swt.widgets.*;

public class SelectionAdapterExit extends SelectionAdapter{

	private Shell parent; 
	public SelectionAdapterExit(Shell parent) {
		this.parent = parent; 
	}
	
	@Override
	public void widgetSelected(SelectionEvent e) {
		MessageBox messageBox = new MessageBox(parent, SWT.ICON_QUESTION | SWT.YES | SWT.NO); 
		messageBox.setMessage("Möchtest du wirklich die Lotto-Sumulation beenden?");
		int result = messageBox.open(); 
		switch(result) {
		case SWT.YES:
			parent.close();
			break; 
		case SWT.NO: break; 
		}
		

	}

}
