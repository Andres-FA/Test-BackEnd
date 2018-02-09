package prueba;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.text.*;

public class VerificacionInicioDia {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Obteniendo el dia de apertura
		try {
			
			Connection con = DriverManager.getConnection("jdbc:sqlanywhere:dsn=Pixel;uid=admin;pwd=xxx");
			
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date parsedDate = dateFormat.parse("1899-12-29");
			System.out.println(parsedDate);
			java.sql.Date Inicialts = new java.sql.Date(parsedDate.getTime());
			System.out.println("Fecha Inicial Sistema: "+Inicialts);
			
			Statement state = con.createStatement();
			String consulta = "select DBA.PixOpenDate() as Opendate";
			ResultSet rs;
			rs = state.executeQuery(consulta);
			rs.next();
			java.sql.Date DiaApertura = rs.getDate("OpenDate");
			System.out.println("Día de apertura como Date: "+DiaApertura);
			rs.close();
			
			Timestamp Inicialts2 = new java.sql.Timestamp(DiaApertura.getTime());
			System.out.println("Dia De Apertura como Timestamp: "+Inicialts2);
			
			if (DiaApertura.equals(Inicialts)) {
				System.out.println("No se ha iniciado el dia en el sistema");
				System.out.println("Es necesario que el día sea iniciado en la tienda para continuar");
				System.out.println("Comuniquese con la tienda respectiva. Gracias");
			}else {
				System.out.println("El dia de apertura es el siguiente: "+DiaApertura);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
	}

}
