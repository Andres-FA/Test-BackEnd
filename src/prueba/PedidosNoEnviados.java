package prueba;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PedidosNoEnviados {
	
	
	public static void main(String[] args) {
		
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
		
		ResultSet resultado;
		PreparedStatement  consultaValidacion;
		try 
		{
			
			Date ahora = new Date();
			SimpleDateFormat formateador = new SimpleDateFormat("dd-MM-yyyy");
			Timestamp ts = new Timestamp(System.currentTimeMillis());
			String fechainicial = formateador.format(ahora);
			String fechafinal = fechainicial.substring(6, 10)+"-"+fechainicial.substring(3, 5)+"-"+fechainicial.substring(0, 2);
			System.out.println(fechafinal);
			consultaValidacion = con.prepareStatement("select * from pedido where total_bruto > 0 and enviadopixel = 0 and fechapedido = ?");
			consultaValidacion.setString(1, fechafinal);
			
			while(true) 
			{
				ts = new Timestamp(System.currentTimeMillis());
				System.out.println("Hora de Consulta: "+ts);
				resultado = consultaValidacion.executeQuery();
				while(resultado.next())
				{
					System.out.println("CUIDADO PROBLEMA CON IDPEDIDO: ");
					System.out.println(resultado.getString("idpedido")+" "+resultado.getString("idcliente"));
				}
				System.out.println("=========Listo=========");
				System.out.println();
				Thread.sleep(150000);
				
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		
	}

}
