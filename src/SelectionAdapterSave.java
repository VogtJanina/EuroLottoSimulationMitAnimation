import java.util.ArrayList;
import java.util.ResourceBundle;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.*;
import org.eclipse.swt.widgets.*;

public class SelectionAdapterSave extends SelectionAdapter{

	private Shell parent;
	private ResourceBundle msgs;
	private ArrayList<String> selected5; 
	private ArrayList<String> selected2;
	private ArrayList<Integer> numbersDrawing50;
	private ArrayList<Integer> numbersDrawing12;
	private String content; 

	
	public SelectionAdapterSave(Shell parent, ResourceBundle msgs, ArrayList<String> selected5, ArrayList<String> selected2, ArrayList<Integer> numbersDrawing50, ArrayList<Integer> numbersDrawing12) {
		this.parent = parent; 
		this.msgs = msgs;
		this.selected5 = selected5; 
		this.selected2 = selected2;
		this.numbersDrawing50 = numbersDrawing50;
		this.numbersDrawing12 = numbersDrawing12;
	}
	
	@Override
	public void widgetSelected(SelectionEvent e) {
		FileDialog fileDialog = new FileDialog(parent, SWT.OPEN); 
		String fileName = fileDialog.open(); 
		if (fileName != null) {
			content = msgs.getString("selectedNumbers") +":\n" + msgs.getString("5oo50") + selected5 + "\n"
					+ msgs.getString("2oo12") + selected2 +"\n";
			content += msgs.getString("drawnNumbers")+ ":\n" + msgs.getString("5oo50") + numbersDrawing50 + "\n" 
					+ msgs.getString("2oo12") + numbersDrawing12+"\n";
			//TODO win/lose
			int count5oo50 = 0; 
			int count2oo12 = 0; 
			for (String s5 : selected5) {
				for (Integer n5 : numbersDrawing50) {
					if(n5.toString().equals(s5)) {
						count5oo50++; 
					}
				}
			}
			for (String s2 : selected2) {
				for (Integer n2 : numbersDrawing12) {
					if(n2.toString().equals(s2)) {
						count2oo12++; 
					}
				}
			}
			content += msgs.getString("win") + "\n"
					+msgs.getString("5oo50") + " " + count5oo50 + "\n"
					+msgs.getString("2oo12") + " " + count2oo12;
			
			FileIO.write(fileName, content);
		}
		

	}

}
