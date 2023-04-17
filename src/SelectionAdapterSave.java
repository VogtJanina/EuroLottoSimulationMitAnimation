import org.eclipse.swt.SWT;
import org.eclipse.swt.events.*;
import org.eclipse.swt.widgets.*;

public class SelectionAdapterSave extends SelectionAdapter{

	private Shell parent; 
	public SelectionAdapterSave(Shell parent) {
		this.parent = parent; 
	}
	
	@Override
	public void widgetSelected(SelectionEvent e) {
		FileDialog fileDialog = new FileDialog(parent, SWT.OPEN); 
		String fileName = fileDialog.open(); 
		if (fileName != null) {
			//TODO create content
			FileIO.write(fileName, fileName);
		}
		

	}

}
