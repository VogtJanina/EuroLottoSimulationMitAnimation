import org.eclipse.swt.SWT;
import org.eclipse.swt.events.*;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.widgets.*;

public class SelectionAdapterFontColor extends SelectionAdapter{

	private Shell parent;
	private Button [] toggle50 ;
	private Button [] toggle12;
	
	public SelectionAdapterFontColor(Shell parent, Button [] toggle50, Button [] toggle12) {
		this.parent = parent; 
		this.toggle50 = toggle50;
		this.toggle12 = toggle12;
	}
	
	@Override
	public void widgetSelected(SelectionEvent e) {
		ColorDialog dialog = new ColorDialog(parent );
		dialog.setText("Change Font color");
		
		dialog.setRGB(null);
		
		RGB newColor = dialog.open(); 
		if (newColor == null) {
			return;
		}
		for(Button t: toggle50) {
			t.setForeground(new Color(parent.getDisplay(), newColor));
		}
		for(Button t: toggle12) {
			t.setForeground(new Color(parent.getDisplay(), newColor));
		}
		
		

	}

}
