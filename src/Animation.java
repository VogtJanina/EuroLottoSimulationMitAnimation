import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Canvas;

public class Animation implements Runnable{
	private final int MILLSEC = 150; 
	private Canvas canvas;
	
	private  int x = 0;
	private  int y = 0;
	
	private  int step=5;
	private final int SZ_INIT_RECT = 150;
	private int sz = SZ_INIT_RECT;
	
	public Animation(Canvas canvas) {
		this.canvas = canvas; 
		canvas.addPaintListener(new PaintListener() {
			
			@Override
			public void paintControl(PaintEvent event) {
				Image image = new Image(canvas.getDisplay(), canvas.getBounds()); 
				x = canvas.getBounds().width/2-sz/2; 
				y = canvas.getBounds().height/2-sz/2; 
				GC gcImage = new GC(image); 
				gcImage.setBackground(event.gc.getBackground());
			    gcImage.fillRectangle(image.getBounds());
			    gcImage.setBackground(new Color(255,0,0));
			    gcImage.fillRectangle(x, y, sz, sz);
			    event.gc.drawImage(image, 0, 0);
			    image.dispose();
			    gcImage.dispose();
			}
		});
	}
	
	public void grow() {
		Rectangle rect = canvas.getClientArea();
		System.out.println("Rectangle animation rect: x: " +rect.x + " y: " +rect.y + " width: "+rect.width + " height: "+rect.height);
		sz += step;
		if (sz < 30) {
			step = 5;
		}
		if (sz > 250) {
			step = -5;
		}
	    canvas.redraw();
	}
	
	@Override
	public void run() {
		grow();
		canvas.getDisplay().timerExec(MILLSEC, this);
	}
}
