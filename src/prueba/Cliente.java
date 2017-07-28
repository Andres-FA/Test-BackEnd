package prueba;


public class Cliente {

	private int idcliente;
	private String telefono;
	private String nombres;
	private String apellidos;
	private String nombreCompania;
	private String Direccion;
	private String Municipio;
	private int idMunicipio;
	private float latitud;
	private float lontitud;
	private String zonaDireccion;
	private String observacion;
	private String tienda;
	private int idtienda;
	
	
	
	
	public Cliente(int id, String telefono, String nombres, String direccion, String zonaDireccion, String observacion,
			String tienda, int idtienda) {
		super();
		this.idcliente = id;
		this.telefono = telefono;
		this.nombres = nombres;
		Direccion = direccion;
		this.zonaDireccion = zonaDireccion;
		this.observacion = observacion;
		this.tienda = tienda;
		this.idtienda = idtienda;
	}

	public Cliente(String telefono, String nombres, String direccion, String zonaDireccion, String observacion, String tienda) {
		super();
		this.telefono = telefono;
		this.nombres = nombres;
		Direccion = direccion;
		this.zonaDireccion = zonaDireccion;
		this.observacion = observacion;
		this.tienda = tienda;
	}
	
	public Cliente(String telefono, String nombres, String direccion, String zonaDireccion, String observacion, String tienda, int idtienda) {
		super();
		this.telefono = telefono;
		this.nombres = nombres;
		Direccion = direccion;
		this.zonaDireccion = zonaDireccion;
		this.observacion = observacion;
		this.tienda = tienda;
		this.idtienda = idtienda;
	}
	
	
	

	public Cliente(int idcliente, String telefono, String nombres, String direccion, String Municipio, float latitud,
			float lontitud, String zonaDireccion, String observacion, String tienda, int idtienda) {
		super();
		this.idcliente = idcliente;
		this.telefono = telefono;
		this.nombres = nombres;
		Direccion = direccion;
		this.Municipio = Municipio;
		this.latitud = latitud;
		this.lontitud = lontitud;
		this.zonaDireccion = zonaDireccion;
		this.observacion = observacion;
		this.tienda = tienda;
		this.idtienda = idtienda;
	}

	public Cliente( String telefono, String nombres, String direccion, String Municipio, int idmunicipio, float latitud,
			float lontitud, String zonaDireccion, String observacion, String tienda, int idtienda) {
		super();
		
		this.telefono = telefono;
		this.nombres = nombres;
		Direccion = direccion;
		this.Municipio = Municipio;
		this.idMunicipio = idmunicipio;
		this.latitud = latitud;
		this.lontitud = lontitud;
		this.zonaDireccion = zonaDireccion;
		this.observacion = observacion;
		this.tienda = tienda;
		this.idtienda = idtienda;
	}

	
	public Cliente(int idcliente, String telefono, String nombres, String apellidos, String nombreCompania,
			String direccion, String municipio, int idMunicipio, float latitud, float lontitud, String zonaDireccion,
			String observacion, String tienda, int idtienda) {
		super();
		this.idcliente = idcliente;
		this.telefono = telefono;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.nombreCompania = nombreCompania;
		Direccion = direccion;
		Municipio = municipio;
		this.idMunicipio = idMunicipio;
		this.latitud = latitud;
		this.lontitud = lontitud;
		this.zonaDireccion = zonaDireccion;
		this.observacion = observacion;
		this.tienda = tienda;
		this.idtienda = idtienda;
	}

	public int getIdMunicipio() {
		return idMunicipio;
	}

	public void setIdMunicipio(int idMunicipio) {
		this.idMunicipio = idMunicipio;
	}

	public String getMunicipio() {
		return Municipio;
	}




	public void setMunicipio(String idMunicipio) {
		this.Municipio = idMunicipio;
	}




	public float getLatitud() {
		return latitud;
	}




	public void setLatitud(float latitud) {
		this.latitud = latitud;
	}




	public float getLontitud() {
		return lontitud;
	}




	public void setLontitud(float lontitud) {
		this.lontitud = lontitud;
	}




	public int getIdtienda() {
		return idtienda;
	}



	public void setIdtienda(int idtienda) {
		this.idtienda = idtienda;
	}



	public int getIdcliente() {
		return idcliente;
	}



	public void setIdcliente(int idcliente) {
		this.idcliente = idcliente;
	}



	public String getTienda() {
		return tienda;
	}



	public void setTienda(String tienda) {
		this.tienda = tienda;
	}


	public String getTelefono() {
		return telefono;
	}



	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}



	public String getNombres() {
		return nombres;
	}



	public void setNombres(String nombres) {
		this.nombres = nombres;
	}



	public String getDireccion() {
		return Direccion;
	}



	public void setDireccion(String direccion) {
		Direccion = direccion;
	}



	public String getZonaDireccion() {
		return zonaDireccion;
	}



	public void setZonaDireccion(String zonaDireccion) {
		this.zonaDireccion = zonaDireccion;
	}



	public String getObservacion() {
		return observacion;
	}



	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	
	
	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getNombreCompania() {
		return nombreCompania;
	}

	public void setNombreCompania(String nombreCompania) {
		this.nombreCompania = nombreCompania;
	}

	public Cliente() {
		// TODO Auto-generated constructor stub
	}

}
