import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
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
	
	private Label labelToggle50;
	private Button [] toogle50; 
	private String [] text50 = new String[50]; 
	
	private Canvas canvas; 
	private Animation animation; 
	
	private Label labelToggle12; 
	private Button [] toogle12; 
	private String [] text12 = new String[12]; 

	public LottoApp() {
		createDisplay();
		createShell();
		createMenues();
		createToolBar();
		create50050area(); 
		createAnimationArea();
		create2oo12Area();
		shell.pack(); 
	}
	private void createDisplay() {
		display = new Display(); 
	}
	
	private void createShell() {
		shell = new Shell(display);
		GridLayout layout = new GridLayout(2, true); 
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
		GridData data = new GridData(SWT.FILL, SWT.CENTER, true, false,2,1); 
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
	
	private void create50050area() {
		GridLayout layoutGroup = new GridLayout(); 
		layoutGroup.numColumns = 5; 
		Group group = new Group(shell, SWT.LEFT); 
		group.setLayout(layoutGroup);
		labelToggle50 = new Label(group,SWT.CENTER); 
		labelToggle50.setText("5 aus 50:");
		GridData data = new GridData(SWT.LEFT, SWT.FILL, true, false,5,1); 
		labelToggle50.setLayoutData(data);
		
		for (int i = 1; i <=50; i++) {
			text50[i-1] = String.valueOf(i); 
		}
		System.out.println(text50);
		
		toogle50 = new Button[text50.length];
		for (int i=0; i<toogle50.length; i++) {
			toogle50[i] = new Button(group,SWT.PUSH);
			toogle50[i].setFont(new Font(display, "Arial",14,SWT.BOLD));
			toogle50[i].setText(text50[i]);
			toogle50[i].setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_FILL));
		}
	}
	
	private void createAnimationArea() {
		GridData groupData = new GridData(GridData.FILL, GridData.FILL,true,true);
		groupData.horizontalSpan =1;
		groupData.verticalSpan =1;
		  
		Group group = new Group(shell,SWT.NONE);
		group.setLayoutData(groupData);
		
		FillLayout layoutGroup = new FillLayout(SWT.VERTICAL);
		group.setLayout(layoutGroup);
		canvas = new Canvas(group, SWT.DOUBLE_BUFFERED);
		  
		animation = new Animation(canvas);
	}
	
	private void create2oo12Area() {
		GridLayout layoutGroup = new GridLayout(); 
		layoutGroup.numColumns = 5; 
		Group group = new Group(shell, SWT.LEFT); 
		group.setLayout(layoutGroup);
		labelToggle12 = new Label(group,SWT.CENTER); 
		labelToggle12.setText("2 aus 12:");
		GridData data = new GridData(SWT.LEFT, SWT.FILL, true, false,5,1); 
		labelToggle12.setLayoutData(data);
		
		for (int i = 1; i <=12; i++) {
			text12[i-1] = String.valueOf(i); 
		}
		System.out.println(text12);
		
		toogle12 = new Button[text12.length];
		for (int i=0; i<toogle12.length; i++) {
			toogle12[i] = new Button(group,SWT.PUSH);
			toogle12[i].setFont(new Font(display, "Arial",14,SWT.BOLD));
			toogle12[i].setText(text12[i]);
			toogle12[i].setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_FILL));
		}
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
