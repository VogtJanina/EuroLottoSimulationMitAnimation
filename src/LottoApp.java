import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;

public class LottoApp {
	
	private Display display;
	private Shell shell;
	
	private Menu menuBar; 
	private MenuItem fileTitle; 
	private Menu fileMenu; 
	private MenuItem fileSaveItem; 
	private MenuItem fileExitItem; 
	
	private ToolBar toolBar; 
	private ToolItem toolItemRun; 
	private ToolItem toolItemSave; 
	private ToolItem toolItemBackgroundColor; 
	private ToolItem toolItemFontColor; 
	private ToolItem toolItemReset; 
	
	private Image iconRun;
	private Image iconSave;
	private Image iconBackgroundColor;
	private Image iconFontColor;
	private Image iconReset;
	
	private Label labelToggle50;
	private ArrayList<Integer> numbers50 = new ArrayList<Integer>(); 
	private Button [] toggle50; 
	private String [] text50 = new String[50]; 
	
	private Canvas canvas; 
	private Animation animation; 
	
	private Label labelToggle12; 
	private ArrayList<Integer> numbers12 = new ArrayList<Integer>(); 
	private Button [] toggle12; 
	private String [] text12 = new String[12]; 
	
	private Label labelDrawing50; 
	private ArrayList<Integer> numbersDrawing50; 
	private int quantity5 = 5; 
	private Button [] buttonResult50; 
	private Label labelDrawing12; 
	private ArrayList<Integer> numberDrawings12;
	private int quantity2 = 2; 
	private Button [] buttonResult12; 
	
	private Label labelError; 
	
	private ArrayList <String> selected5 = new ArrayList<String>();
	private ArrayList <String> selected2 = new ArrayList<String>();

	private Color fontColor;
	private Color backgroundColor;

	public LottoApp() {
		createDisplay();
		createShell();
		createMenues();
		createToolBar();
		create5oo50Area(); 
		createAnimationArea();
		create2oo12Area();
		createDrawingArea();
		createErrorArea();
		createListeners();
		shell.pack(); 
	}
	private void createDisplay() {
		display = new Display(); 
	}
	
	private void createShell() {
		shell = new Shell(display);
		GridLayout layout = new GridLayout(2, true); 
		shell.setLayout(layout);
		shell.setText("Simulation Euro-Lotto");
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
		fileExitItem = new MenuItem(fileMenu, SWT.PUSH); 
		//fileCloseItem.setAccelerator(SWT.CTRL + 'C');
		fileExitItem.setText("Beenden");
	}
	
	private void createToolBar() {
		toolBar = new ToolBar(shell, SWT.HORIZONTAL); 
		GridData data = new GridData(SWT.FILL, SWT.CENTER, true, false,2,1); 
		toolBar.setLayoutData(data);
		toolItemRun = new ToolItem(toolBar, SWT.PUSH); 
		//toolItemRun.setText("Run"); 
		toolItemSave = new ToolItem(toolBar, SWT.PUSH); 
		//toolItemSave.setText("Save"); 
		toolItemBackgroundColor = new ToolItem(toolBar, SWT.PUSH); 
		//toolItemBackgroundColor.setText("BackgrundColor"); 
		toolItemFontColor = new ToolItem(toolBar, SWT.PUSH); 
		//toolItemFontColor.setText("FontColor"); 
		toolItemReset = new ToolItem(toolBar, SWT.PUSH); 
		//toolItemReset.setText("Reset"); 

		// Set Icons
		iconRun = new Image(display, Image.class.getResourceAsStream("/16x16/icons8-bmo-16.png"));
		toolItemRun.setImage(iconRun);
		iconSave = new Image(display, Image.class.getResourceAsStream("/16x16/icons8-speichern-16.png"));
		toolItemSave.setImage(iconSave);
		iconBackgroundColor = new Image(display, Image.class.getResourceAsStream("/16x16/aquarell.png"));
		toolItemBackgroundColor.setImage(iconBackgroundColor);
		iconFontColor = new Image(display, Image.class.getResourceAsStream("/16x16/icons8-textfarbe-16.png"));
		toolItemFontColor.setImage(iconFontColor);
		iconReset = new Image(display, Image.class.getResourceAsStream("/16x16/icons8-reset-16.png"));
		toolItemReset.setImage(iconReset);
	}
	
	private void create5oo50Area() {
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
			numbers50.add(i); 
		}
		System.out.println(text50);
		
		toggle50 = new Button[text50.length];
		for (int i=0; i<toggle50.length; i++) {
			toggle50[i] = new Button(group,SWT.TOGGLE);
			toggle50[i].setFont(new Font(display, "Arial",14,SWT.BOLD));
			toggle50[i].setText(text50[i]);
			toggle50[i].setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_FILL));
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
		layoutGroup.makeColumnsEqualWidth = true; 
		Group group = new Group(shell, SWT.LEFT); 
		group.setLayout(layoutGroup);
		labelToggle12 = new Label(group,SWT.CENTER); 
		labelToggle12.setText("2 aus 12:");
		GridData data = new GridData(SWT.LEFT, SWT.FILL, true, false,5,1); 
		labelToggle12.setLayoutData(data);
		
		for (int i = 1; i <=12; i++) {
			text12[i-1] = String.valueOf(i); 
			numbers12.add(i); 
		}
		System.out.println(text12);
		
		toggle12 = new Button[text12.length];
		for (int i=0; i<toggle12.length; i++) {
			toggle12[i] = new Button(group,SWT.TOGGLE);
			toggle12[i].setFont(new Font(display, "Arial",14,SWT.BOLD));
			toggle12[i].setText(text12[i]);
			toggle12[i].setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_FILL));
		}
	}
	
	private void createDrawingArea() {
		GridLayout layoutGroup = new GridLayout(); 
		layoutGroup.numColumns = 5; 
		Group group = new Group(shell, SWT.LEFT); 
		group.setLayout(layoutGroup);
		labelDrawing50 = new Label(group,SWT.CENTER); 
		labelDrawing50.setText("Ziehung 5 aus 50:");
		GridData data = new GridData(SWT.LEFT, SWT.FILL, true, false,5,1); 
		labelDrawing50.setLayoutData(data);
		buttonResult50 = new Button[5];
		for (int i=0; i<buttonResult50.length; i++) {
			buttonResult50[i] = new Button(group, SWT.CENTER); 
			buttonResult50[i].setFont(new Font(display, "Arial",14,SWT.BOLD));
			buttonResult50[i].setText("X");
			buttonResult50[i].setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_FILL));
		}
		labelDrawing12 = new Label(group, SWT.CENTER); 
		labelDrawing12.setText("Ziehung 2 aus 12:");
		buttonResult12 = new Button[2];
		for (int i=0; i<buttonResult12.length; i++) {
			buttonResult12[i] = new Button(group, SWT.CENTER); 
			buttonResult12[i].setFont(new Font(display, "Arial",14,SWT.BOLD));
			buttonResult12[i].setText("e");
			buttonResult12[i].setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_FILL));
		}
		labelDrawing12.setLayoutData(data);
	}
	
	private void createErrorArea() {
		labelError = new Label(shell, SWT.CENTER); 
		labelError.setText("No Error");
	}
	
	private void createListeners() {
		fileSaveItem.addSelectionListener(new SelectionAdapterSave(shell, selected5, selected5));
		toolItemSave.addSelectionListener(new SelectionAdapterSave(shell, selected5, selected5));
		fileExitItem.addSelectionListener(new SelectionAdapterExit(shell));
		toolItemRun.addSelectionListener(new SelectionAdapterRun(shell, numbers50, quantity5, numbers12, quantity2));
		toolItemFontColor.addSelectionListener(new SelectionAdapterFontColor(shell, toggle50, toggle12));
		toolItemBackgroundColor.addSelectionListener(new SelectionAdapterBackgroundColor(shell, toggle50, toggle12));
		toolItemReset.addSelectionListener(new SelectionAdapterReset(shell, fontColor, backgroundColor));
		for (Button t: toggle50) {
			t.addSelectionListener(new SelectionAdapterToggle5(selected5, labelError));
		}
		for (Button t: toggle12) {
			t.addSelectionListener(new SelectionAdapterToggle2(selected2, labelError));
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
