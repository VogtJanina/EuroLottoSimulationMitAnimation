import java.util.ArrayList;
import java.util.ResourceBundle;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;

public class LottoApp {
	
	private ResourceBundle msgs;
	
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
	private ArrayList<String> text50 = new ArrayList<String>();  
	
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
	private ArrayList<Integer> numbersDrawing12;
	private int quantity2 = 2; 
	private Button [] buttonResult12; 
	private Drawing drawing5;
	private Drawing drawing2;
	private DrawingAnimation drawingAnimation;
	
	private Label labelError; 
	
	private ArrayList <String> selected5 = new ArrayList<String>();
	private ArrayList <String> selected2 = new ArrayList<String>();

	private Color fontColor;
	private Color backgroundColor;

	public LottoApp(ResourceBundle msgs) {
		this.msgs = msgs;
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
		fileTitle.setText(msgs.getString("file"));
		
		fileMenu = new Menu(shell, SWT.DROP_DOWN); 
		fileTitle.setMenu(fileMenu);
		fileSaveItem = new MenuItem(fileMenu, SWT.PUSH); 
		//fileSaveItem.setAccelerator(SWT.CTRL + 'S');
		fileSaveItem.setText(msgs.getString("save"));
		fileExitItem = new MenuItem(fileMenu, SWT.PUSH); 
		//fileCloseItem.setAccelerator(SWT.CTRL + 'C');
		fileExitItem.setText(msgs.getString("exit"));
	}
	
	private void createToolBar() {
		toolBar = new ToolBar(shell, SWT.HORIZONTAL); 
		GridData data = new GridData(SWT.FILL, SWT.CENTER, true, false,2,1); 
		toolBar.setLayoutData(data);
		toolItemRun = new ToolItem(toolBar, SWT.PUSH);
		toolItemRun.setEnabled(false); 
		//toolItemRun.setText(msgs.getString("run")); 
		toolItemSave = new ToolItem(toolBar, SWT.PUSH); 
		//toolItemSave.setText(msgs.getString("save")); 
		toolItemBackgroundColor = new ToolItem(toolBar, SWT.PUSH); 
		//toolItemBackgroundColor.setText(msgs.getString("backgroundColor")); 
		toolItemFontColor = new ToolItem(toolBar, SWT.PUSH); 
		//toolItemFontColor.setText(msgs.getString("FontColor")); 
		toolItemReset = new ToolItem(toolBar, SWT.PUSH); 
		//toolItemReset.setText(msgs.getString("Reset")); 

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
		labelToggle50.setText(msgs.getString("5oo50"));
		GridData data = new GridData(SWT.LEFT, SWT.FILL, true, false,5,1); 
		labelToggle50.setLayoutData(data);
		
		int k = 1; 
		for (int j = 1; j<=10; j++) {
			for (int i = 0; i<5; i++) {
				text50.add(String.valueOf(k));  
				numbers50.add(k); 
				k+=10; 
			}
			k = j+1; 
		}
		
		System.out.println("Text 50"+ text50.size());
		for (String i: text50) {
			System.out.println(i);
		}
		
		toggle50 = new Button[text50.size()];
		for (int i=0; i<toggle50.length; i++) {
			toggle50[i] = new Button(group,SWT.TOGGLE);
			toggle50[i].setFont(new Font(display, "Arial",14,SWT.BOLD));
			toggle50[i].setText(text50.get(i));
			toggle50[i].setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_FILL));
		}
	}
	
	private void createAnimationArea() {
		GridData groupData = new GridData(GridData.FILL, GridData.FILL,true,true);
		groupData.horizontalAlignment=  GridData.FILL;
		groupData.verticalAlignment = GridData.FILL;
		groupData.grabExcessHorizontalSpace = true;
		groupData.grabExcessVerticalSpace = true;
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
		labelToggle12.setText(msgs.getString("2oo12"));
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
		layoutGroup.makeColumnsEqualWidth = true; 
		Group group = new Group(shell, SWT.LEFT); 
		group.setLayout(layoutGroup);
		labelDrawing50 = new Label(group,SWT.CENTER); 
		labelDrawing50.setText(msgs.getString("drawing5oo50"));
		GridData data = new GridData(SWT.LEFT, SWT.FILL, true, false,5,1); 
		labelDrawing50.setLayoutData(data);
		buttonResult50 = new Button[5];
		for (int i=0; i<buttonResult50.length; i++) {
			buttonResult50[i] = new Button(group, SWT.CENTER); 
			buttonResult50[i].setFont(new Font(display, "Arial",14,SWT.BOLD));
			buttonResult50[i].setText(" X ");
			buttonResult50[i].setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_FILL));
		}
		labelDrawing12 = new Label(group, SWT.CENTER); 
		labelDrawing12.setText(msgs.getString("drawing2oo12"));
		buttonResult12 = new Button[2];
		for (int i=0; i<buttonResult12.length; i++) {
			buttonResult12[i] = new Button(group, SWT.CENTER); 
			buttonResult12[i].setFont(new Font(display, "Arial",14,SWT.BOLD));
			buttonResult12[i].setText(" e ");
			buttonResult12[i].setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_FILL));
		}
		labelDrawing12.setLayoutData(data);
		drawing5 = new Drawing(numbers50, quantity5);
		drawing2 = new Drawing(numbers12, quantity2);
		drawingAnimation = new DrawingAnimation(shell,drawing5, drawing2);
	}
	
	private void createErrorArea() {
		labelError = new Label(shell, SWT.CENTER); 
		labelError.setText(msgs.getString("noError"));
	}
	
	private void createListeners() {
		fileSaveItem.addSelectionListener(new SelectionAdapterSave(shell, msgs, selected5, selected2));
		toolItemSave.addSelectionListener(new SelectionAdapterSave(shell, msgs, selected5, selected2));
		fileExitItem.addSelectionListener(new SelectionAdapterExit(shell, msgs));
		toolItemRun.addSelectionListener(new SelectionAdapterRun( animation, drawingAnimation));
		toolItemFontColor.addSelectionListener(new SelectionAdapterFontColor(shell, toggle50, toggle12));
		toolItemBackgroundColor.addSelectionListener(new SelectionAdapterBackgroundColor(shell, toggle50, toggle12));
		toolItemReset.addSelectionListener(new SelectionAdapterReset(shell,toolItemRun, fontColor, backgroundColor, animation, 
											drawingAnimation, selected5, selected2));
		for (Button t: toggle50) {
			t.addSelectionListener(new SelectionAdapterToggle5(shell, selected5, selected2));
		}
		for (Button t: toggle12) {
			t.addSelectionListener(new SelectionAdapterToggle2(shell, selected5, selected2));
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
