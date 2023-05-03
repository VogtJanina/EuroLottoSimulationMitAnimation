import java.util.ResourceBundle;

import org.eclipse.swt.events.*;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.widgets.*;

public class SelectionAdapterFontColor extends SelectionAdapter{

	private Shell parent;
	private ResourceBundle msgs;
	private Button [] toggle50 ;
	private Button [] toggle12;
	private Button [] buttonResult50 ;
	private Button [] buttonResult12;
	
	
	public SelectionAdapterFontColor(Shell parent, ResourceBundle msgs, Button [] toggle50, Button [] toggle12, Button [] buttonResult50, Button [] buttonResult12 ) {
		this.parent = parent; 
		this.msgs = msgs;
		this.toggle50 = toggle50;
		this.toggle12 = toggle12;
		this.buttonResult50 = buttonResult50;
		this.buttonResult12 = buttonResult12;
	}
	
	@Override
	public void widgetSelected(SelectionEvent e) {
		ColorDialog dialog = new ColorDialog(parent );
		dialog.setText(msgs.getString("changeFontColor"));
		
		Color currentFontColor = toggle50[0].getForeground();
		
		dialog.setRGB(currentFontColor.getRGB());
		
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
		for(Button t: buttonResult50) {
			t.setForeground(new Color(parent.getDisplay(), newColor));
		}
		for(Button t: buttonResult12) {
			t.setForeground(new Color(parent.getDisplay(), newColor));
		}
		
		currentFontColor.dispose();
		
		

	}

}
