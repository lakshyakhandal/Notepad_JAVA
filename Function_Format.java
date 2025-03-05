import java.awt.Font;
public class Function_Format{
    GUI gui;

    Font Arial, TimesNewRoman, Serif, ComicSans;
    String selectedFont;

    public Function_Format(GUI gui){
        this.gui=gui;
    }
     public void editFont(int fontSize) {

        Arial = new Font("Arial", Font.PLAIN, fontSize);
        TimesNewRoman = new Font("Times New Roman", Font.PLAIN, fontSize);
        Serif = new Font("Serif", Font.PLAIN, fontSize);

        setFont(selectedFont);

        }
   public void setFont(String Font) {

        selectedFont = Font;

        switch (selectedFont) {
            case "Arial":
                gui.textField.setFont(Arial);
                break;
            case "Times New Roman":
                gui.textField.setFont(TimesNewRoman);
                break;
            case "Serif":
                gui.textField.setFont(Serif);
                break;
            default:
                System.out.println("Error");
                break;
        }

    }

}
