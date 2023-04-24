import org.eclipse.swt.events.*;
import org.eclipse.swt.widgets.*;

public class SelectionAdapterRun extends SelectionAdapter{

	private Animation animation;
	private DrawingAnimation drawingAnimation;
	
	public SelectionAdapterRun(  Animation animation,  DrawingAnimation drawingAnimation) {
		this.animation = animation; 
		this.drawingAnimation = drawingAnimation;
	}
	
	@Override
	public void widgetSelected(SelectionEvent e) {
		Display d = e.widget.getDisplay();
		d.timerExec(80,animation);
		d.timerExec(80, drawingAnimation);
	
	}
}