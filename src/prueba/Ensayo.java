package prueba;
import java.text.*;
import java.lang.Thread.State;
import java.sql.*;
import java.util.Locale;



public class Ensayo {
	
	

	public static void main(String[] args) {
//		int i = 0,j = 0;
//		double Quan = .5,Price=71161;
//		NumberFormat Formatter = NumberFormat.getInstance(Locale.ENGLISH);
//		String FinalString= null,Tax="                   INC 8%",NetoTotal="              Neto Total:";
//		String SubTotal="               Sub-Total:",Cambio="                  Cambio:";
//		String Efectivo="Efectivo                 ";
//		StringBuilder StrPrice = null,StrQuan = null,FinalChain = new StringBuilder();
//		
//		System.out.println(NetoTotal+" "+NetoTotal.length());
//		System.out.println(Tax+" "+Tax.length());
//		System.out.println(SubTotal+" "+SubTotal.length());
//		System.out.println(Cambio+" "+Cambio.length());
//		System.out.println(Efectivo+" "+Efectivo.length());
//		
//		Formatter.setMinimumFractionDigits(0);
//		StrPrice = new StringBuilder(Formatter.format(Price));
//		StrPrice.insert(0, "$ ");
//		StrPrice.insert(0, NetoTotal);
//		System.out.println(StrPrice+" "+StrPrice.length());
//		for (j = StrPrice.length(); j < 40; j++) {
//			StrPrice.insert(25, " ");
//		}
//		System.out.println(StrPrice+" "+StrPrice.length());
		
		try {
			/**
			 * Se realiza el registro del drive de Mysql
			 */
		    Class.forName("com.mysql.jdbc.Driver").newInstance();
		    

		} catch (Exception e) {

		    System.out.println(e.toString());

		}
		
		Connection con = null;
		//...

		try {

			
			/**
			 * Se realiza la creación de la conexión a la base de datos
			 */
			con = DriverManager.getConnection(
		            "jdbc:mysql://192.168.0.25/pizzaamericana?"
		            + "user=root&password=4m32017");

		    // Otros y operaciones sobre la base de datos...

		} catch (SQLException ex) {

		    // Mantener el control sobre el tipo de error
		    System.out.println("SQLException: " + ex.getMessage());

		}
		
		try {
			Connection conSqlAnywhere = DriverManager.getConnection("jdbc:sqlanywhere:dsn=PixelAmerica;uid=admin;pwd=xxx");
			
			int MemberCode = 0,idtienda = 7,Existentes = 0,Total = 0,Sincronizado = 0,NoSincronizado = 0;
			String telefono = "";
			
			Statement Synchronization = conSqlAnywhere.createStatement();
			PreparedStatement  MySqlSynchronization = con.prepareStatement("SELECT memcode FROM cliente WHERE idtienda = 7 AND memcode = ?");
			PreparedStatement InsertintoMySql = con.prepareStatement("INSERT INTO cliente (idtienda,nombre,apellido,nombrecompania,direccion,idmunicipio,zona,telefono,observacion,memcode) VALUES (?,?,?,?,?,?,?,?,?,?)");
			ResultSet rsSynchronization = Synchronization.executeQuery("SELECT a.MEMCODE,a.FIRSTNAME,a.LASTNAME,a.ADRESS1,a.ADRESS2,a.HOMETELE,a.Directions,a.CompanyName FROM dba.Member a where a.LASTVISIT >= '2017-01-01 00:00:00.000' ORDER BY MEMCODE ASC ");
			ResultSet rsMySqlSynchronization = null;
			while (rsSynchronization.next()) {
				Total++;
				MemberCode = rsSynchronization.getInt("memcode");
				System.out.print(MemberCode);
				MySqlSynchronization.setInt(1, MemberCode);
				rsMySqlSynchronization = MySqlSynchronization.executeQuery();
				if (rsMySqlSynchronization.next()) {
					System.out.print(" Ya esta");
					Existentes++;
				} else {
					System.out.print(" No esta. Sincronizar");
					telefono = rsSynchronization.getString("HOMETELE");
					if (telefono == null) {
						System.out.print(" Telefono vacio, no sincronizado");
						NoSincronizado++;
					} else {
						InsertintoMySql.setInt(1, idtienda);
						InsertintoMySql.setString(2, rsSynchronization.getString("FIRSTNAME"));
						InsertintoMySql.setString(3, rsSynchronization.getString("LASTNAME"));
						InsertintoMySql.setString(4, rsSynchronization.getString("CompanyName"));
						InsertintoMySql.setString(5, rsSynchronization.getString("ADRESS1"));
						InsertintoMySql.setInt(6, 1);//idmunicipio
						InsertintoMySql.setString(7, rsSynchronization.getString("ADRESS2"));
						InsertintoMySql.setString(8, rsSynchronization.getString("HOMETELE"));
						InsertintoMySql.setString(9, rsSynchronization.getString("Directions"));
						InsertintoMySql.setInt(10, rsSynchronization.getInt("memcode"));
						InsertintoMySql.execute();
						Sincronizado++;
					}
					
				}
				System.out.println();
				
			}
			InsertintoMySql.close();
			
			MySqlSynchronization.close();
			rsMySqlSynchronization.close();
			
			Synchronization.close();
			rsSynchronization.close();
			
			System.out.println("---------");
			System.out.println("# de registros...........: "+Total);
			System.out.println("Previamente Sincronizados: "+Existentes);
			System.out.println("Sincronizado.............: "+Sincronizado);
			System.out.println("No Sincronizados.........: "+NoSincronizado);
			System.out.println("Listo----");
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		
	}

}
