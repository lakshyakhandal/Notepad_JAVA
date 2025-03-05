import java.awt.FileDialog;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;


public class FunctionFile{
    
    GUI gui;
    String FileName;
    String FileAddress;

    public FunctionFile(GUI gui) {
        
        this.gui= gui;
    }
    public void newFile(){

        gui.textField.setText("");
        gui.window.setTitle("New");
        FileName = null;
        FileAddress = null;
    }

    public void open () {
        FileDialog fd = new FileDialog(gui.window, "Open", FileDialog.LOAD);
        fd.setVisible(true);

        if(fd.getFile()!=null){
            FileName = fd.getFile();
            FileAddress = fd.getDirectory();
            gui.window.setTitle(FileName);
        }

        try {
            BufferedReader br = new BufferedReader(new FileReader(FileAddress + FileName)); /// You need to know the file address to read a file
            gui.textField.setText("");

            String line = null;

            while((line = br.readLine())!=null){
                gui.textField.append(line + "\n");
            }
            br.close();
        }catch (Exception e) {
            System.out.println("File not Found! ");    
        }
    }

    public void save () {
        if(FileName==null){
            saveAs();
        }
        else{
            try {
                FileWriter fw = new FileWriter(FileAddress + FileName);
                fw.write(gui.textField.getText());
                gui.window.setTitle(FileName);
                fw.close();
                
            } catch (Exception e) {
                System.out.println("Error!");
            }
        }

    }

    public void saveAs() {
        FileDialog fd = new FileDialog(gui.window, "Save", FileDialog.SAVE);
        fd.setVisible(true);

        if(fd.getFile()!=null){
            FileName = fd.getFile();
            FileAddress = fd.getDirectory();
            gui.window.setTitle(FileName);
        }

        try {
            FileWriter fw = new FileWriter(FileAddress + FileName);
            fw.write(gui.textField.getText());
            fw.close();
        } catch (Exception e) {
            System.out.println("Error");
        }




    }

    public void exit() {
        System.exit(0);
    }

}

