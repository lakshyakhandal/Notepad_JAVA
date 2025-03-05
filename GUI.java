import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;

///import javax.swing.Action;
import java.awt.event.ActionListener;
// import java.text.Format;
import java.awt.event.ActionEvent;

public class GUI implements ActionListener {

	JFrame window;
	JTextArea textField; 
	JScrollPane scrollPane;
	JMenuBar menuBar;
	JMenu menuFile, menuEdit, menuColor, menuFormat;
	JMenuItem iNew,iOpen, iSave, iSaveAs, iExit;
	JMenuItem icolor1, icolor2,icolor3,icolor4, icolor5;
	JMenuItem iUndo, iRedo;

	//// FOnt edit
	JMenu iFont, iSize;
	JMenuItem iArial, iTimesNewRoman, iSerif, iSize8, iSize12, iSize16, iSize20, iSize30, iSize100;


	FunctionFile file = new FunctionFile(this);
	Function_Color color = new Function_Color(this);
	Function_Format font = new Function_Format(this); 
	UndoManager um = new UndoManager();
	
	public static void main(String[] args) {
		new GUI();
	}

	public GUI() {
		createWindow();
		createtextField();
		createMenuBar();
		createFileMenu();
		createColorMenu();
		createFontMenu();

		color.changeColor("White");
		font.selectedFont = "Arial";
		font.editFont(12);


		window.setVisible(true);
	}

	public void createWindow() {
		window = new JFrame("Notepad by Lakshya");
		window.setSize(500, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void createtextField(){
		textField = new JTextArea();
		textField.getDocument().addUndoableEditListener(
			new UndoableEditListener(){
				public void undoableEditHappened(UndoableEditEvent e) {
					um.addEdit(e.getEdit());				
				}
			}
		);

		scrollPane = new JScrollPane(textField, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		window.add(scrollPane);
	} 

	public void createMenuBar(){

		menuBar = new JMenuBar();
		window.setJMenuBar(menuBar);

		 menuFile = new JMenu("File");
		 menuBar.add(menuFile);

		 menuColor = new JMenu("Color");
		 menuBar.add(menuColor);

		 menuFormat = new JMenu("Format");
		 menuBar.add(menuFormat); 
	}
	
	public void createFileMenu () {

		iNew = new JMenuItem("New");
		iNew.addActionListener(this);
		iNew.setActionCommand("New");
		menuFile.add(iNew);

		iOpen = new JMenuItem("Open");
		iOpen.addActionListener(this);
		iOpen.setActionCommand("Open");
		menuFile.add(iOpen);

		iSave = new JMenuItem("Save");
		iSave.addActionListener(this);
		iSave.setActionCommand("Save");
		menuFile.add(iSave);
		
		icolor1 = new JMenuItem("SaveAs");
		icolor1.addActionListener(this);
		icolor1.setActionCommand("SaveAs");
		menuFile.add(icolor1);

		iExit = new JMenuItem("Exit");
		iExit.addActionListener(this);
		iExit.setActionCommand("Exit");
		menuFile.add(iExit);
	}

	public void createColorMenu() {
		icolor1 = new JMenuItem("Black");
		icolor1.addActionListener(this);
		icolor1.setActionCommand("Black");
		menuColor.add(icolor1);	

		icolor2 = new JMenuItem("White");
		icolor2.addActionListener(this);
		icolor2.setActionCommand("White");
		menuColor.add(icolor2);	

		icolor3 = new JMenuItem("Yellow");
		icolor3.addActionListener(this);
		icolor3.setActionCommand("Yellow");
		menuColor.add(icolor3);

		icolor4 = new JMenuItem("Green");
		icolor4.addActionListener(this);
		icolor4.setActionCommand("Green");
		menuColor.add(icolor4);	

		icolor5 = new JMenuItem("Red");
		icolor5.addActionListener(this);
		icolor5.setActionCommand("Red");
		menuColor.add(icolor5);			
	}

	public void createFontMenu() {

		iFont = new JMenu("Font");
		iFont.addActionListener(this);
		iFont.setActionCommand("Font");
		menuFormat.add(iFont);

		iSize = new JMenu("Size");
		iSize.addActionListener(this);
		iSize.setActionCommand("Size");
		menuFormat.add(iSize);

		iArial= new JMenuItem("Arial");
		iArial.addActionListener(this);
		iArial.setActionCommand("Arial");
		iFont.add(iArial);

		iTimesNewRoman= new JMenuItem("Times New Roman");
		iTimesNewRoman.addActionListener(this);
		iTimesNewRoman.setActionCommand("Times New Roman");
		iFont.add(iTimesNewRoman);

		iSerif= new JMenuItem("Serif");
		iSerif.addActionListener(this);
		iSerif.setActionCommand("Serif");
		iFont.add(iSerif);

		iSize8= new JMenuItem("8");
		iSize8.addActionListener(this);
		iSize8.setActionCommand("8");
		iSize.add(iSize8);

		iSize12= new JMenuItem("12");
		iSize12.addActionListener(this);
		iSize12.setActionCommand("12");
		iSize.add(iSize12);

		iSize16 = new JMenuItem("16");
		iSize16.addActionListener(this);
		iSize16.setActionCommand("16");
		iSize.add(iSize16);
		
		iSize20= new JMenuItem("20");
		iSize20.addActionListener(this);
		iSize20.setActionCommand("20");
		iSize.add(iSize20);
		
		iSize30= new JMenuItem("30");
		iSize30.addActionListener(this);
		iSize30.setActionCommand("30");
		iSize.add(iSize30);
		
		iSize100= new JMenuItem("100");
		iSize100.addActionListener(this);
		iSize100.setActionCommand("100");
		iSize.add(iSize100);
	}

	@Override

	public void actionPerformed(ActionEvent e) {

		String command = e.getActionCommand();

		switch(command){
			//// file cases
			case "New" : file.newFile();
				break;

			case "Open" : file.open();
				break;

			case "Save" : file.save();
				break;

			case "SaveAs" : file.saveAs();
				break;

			case "Exit" : file.exit();
				break;

			//// color cases
			case "Black" : color.changeColor(command);
				break;

			case "White" : color.changeColor(command);
				break;

			case "Yellow" : color.changeColor(command);
				break;
		
			case "Green" : color.changeColor(command);
				break;
		
			case "Red" : color.changeColor(command);
				break;
			
			/// Font and Size Cases
			case "Arial" : font.setFont(command);
				break;

			case "Times New Roman" : font.setFont(command);
				break;

			case "Serif" : font.setFont(command);
				break;
			
			case "8"  : font.editFont(8);
				break;

			case "12"  : font.editFont(12);
				break;

			case "16"  : font.editFont(16);
				break;
				
			case "20"  : font.editFont(20);
				break;

			case "30"  : font.editFont(30);
				break;
				
			case "100" : font.editFont(100);
				break;
		}
	}
}