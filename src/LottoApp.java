import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;

public class LottoApp {
	
	private Display display;
	private Shell shell;
	
	private Menu menuBar; 
	private MenuItem fileTitle; 
	private Menu fileMenu; 
	private MenuItem fileSaveItem; 
	private MenuItem fileCloseItem; 
	
	private ToolBar toolBar; 
	private ToolItem toolItemRun; 
	private ToolItem toolItemSave; 
	private ToolItem toolItemBackgroundColor; 
	private ToolItem toolItemFontColor; 
	private ToolItem toolItemReset; 
	
	public LottoApp() {
		createDisplay();
		createShell();
		createMenues();
		createToolBar();
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
	
	private void createMenues() {
		menuBar= new Menu(shell, SWT.BAR); 
		shell.setMenuBar(menuBar);
		fileTitle = new MenuItem(menuBar, SWT.CASCADE); 
		fileTitle.setText("Datei");
		
		fileMenu = new Menu(shell, SWT.DROP_DOWN); 
		fileTitle.setMenu(fileMenu);
		fileSaveItem = new MenuItem(fileMenu, SWT.PUSH); 
		//fileSaveItem.setAccelerator(SWT.CTRL + 'S');
		fileSaveItem.setText("Speichern");
		fileCloseItem = new MenuItem(fileMenu, SWT.PUSH); 
		//fileCloseItem.setAccelerator(SWT.CTRL + 'C');
		fileCloseItem.setText("Beenden");
	}
	
	private void createToolBar() {
		toolBar = new ToolBar(shell, SWT.HORIZONTAL); 
		GridData data = new GridData(SWT.FILL, SWT.CENTER, true, false,1,1); 
		toolBar.setLayoutData(data);
		toolItemRun = new ToolItem(toolBar, SWT.PUSH); 
		toolItemRun.setText("Run"); 
		toolItemSave = new ToolItem(toolBar, SWT.PUSH); 
		toolItemSave.setText("Save"); 
		toolItemBackgroundColor = new ToolItem(toolBar, SWT.PUSH); 
		toolItemBackgroundColor.setText("BackgrundColor"); 
		toolItemFontColor = new ToolItem(toolBar, SWT.PUSH); 
		toolItemFontColor.setText("FontColor"); 
		toolItemReset = new ToolItem(toolBar, SWT.PUSH); 
		toolItemReset.setText("Reset"); 
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
