
import java.awt.Color;

public class Function_Color {

    GUI gui;

    public Function_Color(GUI gui){
        this.gui=gui;

    }
    public void changeColor(String color) {

        switch (color) {

            case "White":
                gui.window.getContentPane().setBackground(Color.white);
                gui.textField.setBackground(Color.white);
                gui.textField.setForeground(Color.black);  
                break;

            case "Black":
                gui.window.getContentPane().setBackground(Color.black);
                gui.textField.setBackground(Color.black);
                gui.textField.setForeground(Color.white);  
                break;
                
            case "Yellow":
                gui.window.getContentPane().setBackground(Color.yellow);
                gui.textField.setBackground(Color.yellow);
                gui.textField.setForeground(Color.black);  
                break;

            case "Red":
                gui.window.getContentPane().setBackground(Color.red);
                gui.textField.setBackground(Color.red);
                gui.textField.setForeground(Color.white);  
                break;

            case "Green":
                gui.window.getContentPane().setBackground(Color.green);
                gui.textField.setBackground(Color.green);
                gui.textField.setForeground(Color.black);  
                break;
        
            default:
                System.out.println("Error");
                break;
        }
    }



}
