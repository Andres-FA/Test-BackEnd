package prueba;
import java.text.*;
import java.util.Locale;

public class Ensayo {

	public static void main(String[] args) {
		int i = 0,j = 0;
		double Quan = .5,Price=71161;
		NumberFormat Formatter = NumberFormat.getInstance(Locale.ENGLISH);
		String FinalString= null,Tax="                   INC 8%",NetoTotal="              Neto Total:";
		String SubTotal="               Sub-Total:",Cambio="                  Cambio:";
		String Efectivo="Efectivo                 ";
		StringBuilder StrPrice = null,StrQuan = null,FinalChain = new StringBuilder();
		
		System.out.println(NetoTotal+" "+NetoTotal.length());
		System.out.println(Tax+" "+Tax.length());
		System.out.println(SubTotal+" "+SubTotal.length());
		System.out.println(Cambio+" "+Cambio.length());
		System.out.println(Efectivo+" "+Efectivo.length());
		
		Formatter.setMinimumFractionDigits(0);
		StrPrice = new StringBuilder(Formatter.format(Price));
		StrPrice.insert(0, "$ ");
		StrPrice.insert(0, NetoTotal);
		System.out.println(StrPrice+" "+StrPrice.length());
		for (j = StrPrice.length(); j < 40; j++) {
			StrPrice.insert(25, " ");
		}
		System.out.println(StrPrice+" "+StrPrice.length());
	}

}
