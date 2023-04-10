import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;

public class LottoApp {
	
	private Display display;
	private Shell shell;
	
	public LottoApp() {
		createDisplay();
		createShell();
	
		shell.pack(); 
	}
	private void createDisplay() {
		display = new Display(); 
	}
	
	private void createShell() {
		shell = new Shell(display);
		GridLayout layout = new GridLayout(1, true); 
		shell.setLayout(layout);
	}
	
	public void open() {
		shell.open();
		while(!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
	

}
