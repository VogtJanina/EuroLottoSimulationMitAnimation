import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Canvas;

public class Animation implements Runnable{
	private final int MILLSEC = 120; 
	private Canvas canvas;
	
	private  int x = 0;
	private  int y = 0;
	private int width;
	private int height;
	
	private int moveStep = 6;
	private int xStep = moveStep;
	private int yStep = moveStep;
	
	private  int growStep=3;
	private final int SZ_INIT_RECT = 50;
	private int sz = SZ_INIT_RECT;
	
	private boolean start = false;
	
	public Animation(Canvas canvas) {
		this.canvas = canvas; 
		this.width = canvas.getClientArea().width;
		this.height = canvas.getClientArea().height;
		x = canvas.getClientArea().width;
		y = canvas.getClientArea().height;
		
		canvas.addPaintListener(new PaintListener() {
			
			@Override
			public void paintControl(PaintEvent event) {				
				if(start) {
					
					event.gc.setBackground(new Color(255,0,0));
					event.gc.fillRoundRectangle(x,y,sz,sz, 30, 30);
					
				}
				start = true;
			}
		});
	}
	
	public void grow() {
		Rectangle rect = canvas.getClientArea();
		System.out.println("Rectangle animation rect: x: " +rect.x + " y: " +rect.y + " width: "+rect.width + " height: "+rect.height);
		sz += growStep;
		if ((sz <= 30) || (sz >= 80)) {
			growStep = growStep *-1;
		}
	    canvas.redraw();
	}
	
	public void move() {
		width = canvas.getClientArea().width;
		height = canvas.getClientArea().height;
		
		x = x + xStep;
		System.out.println("circle: x: " +x + " y: " +y + " width: "+width + " height: "+height);

		
		if (x+sz >= width){
			xStep = -moveStep;
		}
		else if (x<=0) {
			xStep = moveStep;
		}
		
		y = y + yStep;
		if (y+sz >= height){
			yStep = -moveStep;
		}
		else if (y<=0) {
			yStep = moveStep;
		}
		
		canvas.redraw();
	}
	
	@Override
	public void run() {
		grow();
		move();
		
		canvas.getDisplay().timerExec(MILLSEC, this);
	}
}
