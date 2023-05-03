import java.util.Locale;
import java.util.ResourceBundle;

public class LottoMain {

	public static void main(String[] args) {
		Locale currentLocale;
		if (args.length == 2) {
			currentLocale = new Locale(args[0], args[1]);
		}
		else {
			currentLocale = new Locale("de", "DE");
		}
		
		ResourceBundle msgs = ResourceBundle.getBundle("MessageBundle", currentLocale);
		LottoApp gui = new LottoApp(msgs);
		gui.open();

	}

}
