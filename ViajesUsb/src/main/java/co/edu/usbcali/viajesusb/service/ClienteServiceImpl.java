/**  
 * @Title:  ClienteServiceImpl.java   
 * @Package co.edu.usbcali.viajesusb.service   
 * @Description: description   
 * @author: Emery Estupiñan     
 * @date:   20/09/2021 9:19:50 p. m.   
 * @version V1.0 
 * @Copyright: Universidad San de Buenaventura
 */
package co.edu.usbcali.viajesusb.service;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import co.edu.usbcali.viajesusb.domain.Cliente;
import co.edu.usbcali.viajesusb.domain.TipoIdentificacion;
import co.edu.usbcali.viajesusb.dto.ClienteDTO;
import co.edu.usbcali.viajesusb.repository.ClienteRepository;
import co.edu.usbcali.viajesusb.utils.Constantes;
import co.edu.usbcali.viajesusb.utils.Utilities;

/**
 * @ClassName: ClienteServiceImpl
 * @Description: TODO
 * @author: Emery Estupiñan
 * @date: 20/09/2021 9:19:50 p. m.
 * @Copyright: USB
 */
@Scope("singleton")
@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private TipoIdentificacionService tipoIdentificacionService;


	/**
	 * <p>
	 * Title: findByEstadoOrderByNumeroIdentificacion
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param estado
	 * @param pageable
	 * @return
	 * @throws SQLException
	 * @see co.edu.usbcali.viajesusb.service.ClienteService#findByEstadoOrderByNumeroIdentificacion(java.lang.String,
	 *      org.springframework.data.domain.Pageable)
	 */
	@Override
	public Page<Cliente> findByEstadoOrderByNumeroIdentificacion(String estado, Pageable pageable) throws Exception {

		Page<Cliente> pageCliente = null;

		if (estado.matches("[^A|I]+")) {
			throw new Exception("Solo recibe las letras A e I");
		}
		if (estado == null || estado.trim().equals("")) {
			throw new Exception("El estado es obligatorio");
		}
		if (estado.matches("[0-9]+")) {
			throw new Exception("Solo se aceptan letras ");
		}

		pageCliente = clienteRepository.findByEstadoOrderByNumeroIdentificacion(estado, pageable);

		return pageCliente;

	}

	/**
	 * <p>
	 * Title: findByCorreoIgnoreCase
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param correo
	 * @return
	 * @throws SQLException
	 * @see co.edu.usbcali.viajesusb.service.ClienteService#findByCorreoIgnoreCase(java.lang.String)
	 */
	@Override
	public Cliente findByCorreoIgnoreCase(String correo) throws Exception {

		Cliente cliente = null;

		Pattern pattern = Pattern.compile(
				"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

		if (correo == null || correo.trim().equals("")) {
			throw new Exception("El correo es obligatorio");
		}

		if (correo != null) {
			Matcher mather = pattern.matcher(correo);
			if (mather.find() == true) {

			} else {
				throw new Exception("Escribir correo correctaemnte");
			}
		}

		cliente = clienteRepository.findByCorreoIgnoreCase(correo);

		return cliente;

	}

	/**
	 * <p>
	 * Title: findByNumeroIdentificacionLike
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param numeroIdentificaion
	 * @return
	 * @throws SQLException
	 * @see co.edu.usbcali.viajesusb.service.ClienteService#findByNumeroIdentificacionLike(java.lang.String)
	 */
	@Override
	public Cliente findByNumeroIdentificacionLike(String numeroIdentificacion) throws Exception {

		Cliente cliente = null;

		if (numeroIdentificacion == null || numeroIdentificacion.trim().equals("")) {
			throw new Exception("El codigo de numero de identificación es obligatorio");
		}
		if (numeroIdentificacion.matches("[^0-9]")) {
			throw new Exception("Solo se aceptan numeros");
		}

		cliente = clienteRepository.findByNumeroIdentificacionLike(numeroIdentificacion);

		return cliente;

	}

	/**
	 * <p>
	 * Title: findByNombreIgnoreCaseLike
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param nomobre
	 * @return
	 * @throws SQLException
	 * @see co.edu.usbcali.viajesusb.service.ClienteService#findByNombreIgnoreCaseLike(java.lang.String)
	 */
	@Override
	public Cliente findByNombreIgnoreCaseLike(String nombre) throws Exception {

		Cliente cliente = null;

		if (nombre == null || nombre.trim().equals("")) {
			throw new Exception("El nombre de cliente es obligatorio");
		}
		if (nombre.matches("[^A-Z]")) {
			throw new Exception("Solo son validas letras");
		}

		cliente = clienteRepository.findByNombreIgnoreCaseLike(nombre);

		return cliente;

	}

	/**
	 * <p>
	 * Title: findByFechaNacimientoBetween
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param fechaUno
	 * @param fechaDos
	 * @return
	 * @throws SQLException
	 * @see co.edu.usbcali.viajesusb.service.ClienteService#findByFechaNacimientoBetween(java.util.Date,
	 *      java.util.Date)
	 */
	@Override
	public List<Cliente> findByFechaNacimientoBetween(Date fechaUno, Date fechaDos) throws Exception {

		List<Cliente> lstCliente = null;

		if (fechaUno == null || fechaDos == null) {
			throw new Exception("El rango de fechas es obligatorio");
		}

		lstCliente = clienteRepository.findByFechaNacimientoBetween(fechaUno, fechaDos);

		return lstCliente;

	}

	/**
	 * <p>
	 * Title: countByEstado
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param estado
	 * @return
	 * @throws SQLException
	 * @see co.edu.usbcali.viajesusb.service.ClienteService#countByEstado(java.lang.String)
	 */
	@Override
	public Long countByEstado(String estado) throws Exception {

		Long cliente;

		if (estado.matches("[^A|I]+")) {
			throw new Exception("Solo recibe las letras A e I");
		}
		if (estado == null || estado.trim().equals("")) {
			throw new Exception("El estado es obligatorio");
		}
		if (estado.matches("[0-9]+")) {
			throw new Exception("Solo se aceptan letras ");
		}
		if (estado.length() > 1) {
			throw new Exception("Solo puede tener 1 caracter");
		}
		cliente = clienteRepository.countByEstado(estado);

		return cliente;

	}

	/**
	 * <p>
	 * Title: findByTipoIdentificacionCodigo
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param tipoIdentificacion
	 * @param pageable
	 * @return
	 * @throws SQLException
	 * @see co.edu.usbcali.viajesusb.service.ClienteService#findByTipoIdentificacion_Codigo(java.lang.String,
	 *      org.springframework.data.domain.Pageable)
	 */
	@Override
	public Page<Cliente> findByTipoIdentificacionCodigo(String tipoIdentificacion, Pageable pageable)
			throws Exception {

		Page<Cliente> pageCliente = null;

		if (tipoIdentificacion == null || tipoIdentificacion.trim().equals("")) {
			throw new Exception("El tipo de identificacion es obligatorio");
		}
		if (tipoIdentificacion.matches("[^A-Z]+")) {
			throw new Exception("Solo se aceptan letras");
		}
		if (tipoIdentificacion.length() > 2) {
			throw new Exception("Solo pueden tener dos caracteres");
		}
		// Mayor
		pageCliente = clienteRepository.findByTipoIdentificacion_Codigo(tipoIdentificacion, pageable);

		return pageCliente;
	}

	/**
	 * <p>
	 * Title: findByPrimerApellidoOrSegundoApellido
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param primerApellido
	 * @param segundoApellido
	 * @return
	 * @throws SQLException
	 * @see co.edu.usbcali.viajesusb.service.ClienteService#findByPrimerApellidoOrSegundoApellido(java.lang.String,
	 *      java.lang.String)
	 */
	@Override
	public List<Cliente> findByPrimerApellidoOrSegundoApellido(String primerApellido, String segundoApellido)
			throws Exception {
		List<Cliente> lstCliente = null;

		if (primerApellido == null || primerApellido.trim().equals("")) {
			throw new Exception("El primer apellido es obligatorio");
		}

		if (primerApellido.matches("[^A-Z]")) {
			throw new Exception("No se aceptan caracteres especiales");
		}
		if (primerApellido.matches("[0-9]+")) {
			throw new Exception("Solo se aceptan letras");
		}
		if (segundoApellido != null) {
			if (segundoApellido.matches("[^A-Z]")) {
				throw new Exception("No se aceptan caracteres especiales ");
			}
			if (segundoApellido.matches("[0-9]+")) {
				throw new Exception("Solo se aceptan letras ");
			}
		}

		lstCliente = clienteRepository.findByPrimerApellidoOrSegundoApellido(primerApellido, segundoApellido);

		return lstCliente;

	}

	/**
	 * <p>
	 * Title: consultarClientesPorEstadoNumeroIdentificacionTipoIdentificacion
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param estado
	 * @param numeroIdentificacion
	 * @param nombre
	 * @return
	 * @throws SQLException
	 * @see co.edu.usbcali.viajesusb.service.ClienteService#consultarClientesPorEstadoNumeroIdentificacionTipoIdentificacion(java.lang.String,
	 *      java.lang.String, java.lang.String)
	 */
	@Override
	public List<ClienteDTO> consultarClientesPorEstadoNumeroIdentificacionTipoIdentificacion(String estado,
			String numeroIdentificacion, String nombre) throws Exception {
		List<ClienteDTO> lstCliente = null;

		if (estado.matches("[^A|I]+")) {
			throw new Exception("Solo recibe las letras A e I");
		}
		if (estado == null || estado.trim().equals("")) {
			throw new Exception("El estado es obligatorio");
		}
		if (estado.matches("[0-9]+")) {
			throw new Exception("Solo se aceptan letras ");
		}
		if (numeroIdentificacion == null || numeroIdentificacion.trim().equals("")) {
			throw new Exception("El numero de identificacion es obligatorio");
		}
		if (numeroIdentificacion.matches("[^0-9]+")) {
			throw new Exception("Solo se aceptan numeros");
		}
		if (nombre == null || nombre.trim().equals("")) {
			throw new Exception("El nombre de cliente es obligatorio");
		}
		if (nombre.matches("[^A-Z]")) {
			throw new Exception("No se aceptan caracteres especiales");
		}
		if (nombre.matches("[0-9]+")) {
			throw new Exception("Solo se aceptan letras ");
		}

		lstCliente = clienteRepository.consultarClientesPorEstadoNumeroIdentificacionTipoIdentificacion(estado,
				numeroIdentificacion, nombre);

		return lstCliente;

	}

	/**
	 * 
	 * @Title: guardarCliente
	 * @Description: TODO
	 * @param: @param  clienteDTO
	 * @param: @throws SQLException
	 * @return: void
	 * @throws
	 */
	@Override
	public Cliente guardarCliente(ClienteDTO clienteDTO) throws Exception {

		Cliente cliente = null;
		TipoIdentificacion tipoIdentificacion = null;

		cliente = new Cliente();

		// Validaciones para el numero identificacion:
		if (Utilities.isNullString(clienteDTO.getNumeroIdentificacion()) == true) { // Valida que no sea nulo o no
																					// contenga nada
			throw new Exception("El numero de identificacion no puede ser nulo");
		}

		if (!Utilities.isNumeric(clienteDTO.getNumeroIdentificacion())) { // Valida que no contenga letras
			throw new Exception(
					"El numero de identificacion no puede contener letras " + clienteDTO.getNumeroIdentificacion());
		}

		if (clienteDTO.getNumeroIdentificacion().length() > 15) {
			throw new Exception("El maximo de caracteres para el numero de identificacion es 15");
		}
		cliente.setNumeroIdentificacion(clienteDTO.getNumeroIdentificacion());

		// Validaciones para primer apellido:
		if (Utilities.isNullString(clienteDTO.getPrimerApellido()) == true) { // Valida que no sea nulo o no contenga
																				// nada
			throw new Exception("El primer apellido del cliente no puede ser nulo");
		}

		if (clienteDTO.getPrimerApellido().length() > 50) {
			throw new Exception("Solo acepta 50 caracteres");
		}

		cliente.setPrimerApellido(clienteDTO.getPrimerApellido());

		// Validaciones para segundo apellido:
		if (clienteDTO.getSegundoApellido() != null) {
			if (clienteDTO.getSegundoApellido().length() > 50) {
				throw new Exception("Solo acepta 50 caracteres");
			}
		}
		cliente.setSegundoApellido(clienteDTO.getSegundoApellido());

		// Validaciones para el nombre:
		if (Utilities.isNullString(clienteDTO.getNombre()) == true) { // Valida que no sea nulo o no contenga nada
			throw new Exception("El nombre del cliente no puede ser nulo");
		}

		if (clienteDTO.getNombre().length() > 50) {
			throw new Exception("El maximo de caracteres para el nombre de cliente es 50");
		}
		cliente.setNombre(clienteDTO.getNombre());

		// Validaciones para el numero de telefono 1:
		if (Utilities.isNullString(clienteDTO.getTelefono1()) == true) { // Valida que no sea nulo o no contenga nada
			throw new Exception("El telefono 1 del cliente no puede ser nulo");
		}

		if (!Utilities.isNumeric(clienteDTO.getTelefono1())) { // Valida que solo contenga numeros
			throw new Exception("El numero telefonico debe tener solo numeros");
		}

		if (clienteDTO.getTelefono1().length() > 15) {
			throw new Exception("El maximo de caracteres para el numero de telefono1 es 15");
		}
		cliente.setTelefono1(clienteDTO.getTelefono1());

		// Validaciones para el correo electronico del cliente:
		if (Utilities.isNullString(clienteDTO.getCorreo()) == true) { // Valida que no sea nulo o no contenga nada
			throw new Exception("El correo del cliente no puede ser nulo");
		}

		if (!Utilities.isValidEmail(clienteDTO.getCorreo())) { // Valida que el correo sea valido
			throw new Exception("El correo no es valido");
		}

		if (clienteDTO.getCorreo().length() > 50) {
			throw new Exception("El maximo de caracteres para el correo del cliente es 50");
		}
		cliente.setCorreo(clienteDTO.getCorreo());

		// Validaciones para el sexo del cliente:
		if (Utilities.isNullString(clienteDTO.getSexo()) == true) { // Valida que no sea nulo o no contenga nada
			throw new Exception("El sexo del cliente no puede ser nulo");
		}

		if (Utilities.isNumeric(clienteDTO.getSexo())) { // Valida que no contenga numeros
			throw new Exception("El sexo no debe contener numeros");
		}

		if (clienteDTO.getSexo().length() > 1) { // Valida que solo tenga 1 caracter
			throw new Exception("Maximo de caracteres para el sexo es de 1");
		}
		cliente.setSexo(clienteDTO.getSexo());

		// Validaciones para la fecha de nacimiento del cliente:
		if (Utilities.isNullDate(clienteDTO.getFechaNacimiento()) == true) {
			throw new Exception("La fecha de nacimiento del cliente no puede ser nula");
		}

		if (clienteDTO.getFechaNacimiento().compareTo(Constantes.FECHA_ACTUAL) > 0) {
			throw new Exception("La fecha de nacimiento indicada no puede ser mayor a la actual");
		}
		cliente.setFechaNacimiento(clienteDTO.getFechaNacimiento());

		// Validaciones para la fecha de creacion de un cliente:
		if (Utilities.isNullDate(clienteDTO.getFechaCreacion()) == true) {
			throw new Exception("La fecha de creacion de un cliente no puede ser nula");
		}
		cliente.setFechaCreacion(clienteDTO.getFechaCreacion());

		// Validaciones para el nombre del usuario creador de un cliente:
		if (Utilities.isNullString(clienteDTO.getUsuCreador()) == true) {
			throw new Exception("El nombre del creador de un cliente no puede ser nulo");
		}

		if (clienteDTO.getUsuCreador().length() > 10) {
			throw new Exception("El maximo de caracteres para el nombre de usucreador es 10");
		}
		cliente.setUsuCreador(clienteDTO.getUsuCreador());

		// Validaciones para el estado del cliente:
		if (Utilities.isNullString(clienteDTO.getEstado()) == true) {
			throw new Exception("El estado del cliente no puede ser nulo");
		}

		if (Utilities.isNumeric(clienteDTO.getEstado())) {
			throw new Exception("El estado no debe contener numeros");
		}

		if (clienteDTO.getEstado().length() > 1) {
			throw new Exception("Solo puede tener 1 caracter");
		}
		cliente.setEstado(clienteDTO.getEstado());

		// Consulta el tipo de identificacion dando su id
		tipoIdentificacion = tipoIdentificacionService.findByCodigoAndEstado(clienteDTO.getCodigoTipoIdentificacion(),
				Constantes.ACTIVO);

		// Validamos que el tipo identificacion exista y se encuentre activo
		if (tipoIdentificacion == null) {
			throw new Exception("El tipo identificacion " + clienteDTO.getCodigoTipoIdentificacion() + " no existe");
		}
		cliente.setTipoIdentificacion(tipoIdentificacion);

		clienteRepository.save(cliente);
		
		return cliente;
	}

	/**
	 * 
	 * <p>
	 * Title: actualizarCliente
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param clienteDTO
	 * @throws SQLException
	 * @see co.edu.usbcali.viajesusb.service.ClienteService#actualizarCliente(co.edu.usbcali.viajesusb.dto.ClienteDTO)
	 */
	@Override
	public Cliente actualizarCliente(ClienteDTO clienteDTO) throws Exception {

		Cliente cliente = null;
		TipoIdentificacion tipoIdentificacion = null;

		cliente = findById(clienteDTO.getIdClie());

		// Validaciones para el numero identificacion:
		if (Utilities.isNullString(clienteDTO.getNumeroIdentificacion()) == true) {
			throw new Exception("El numero de identificacion no puede ser nulo");
		}

		if (!Utilities.isNumeric(clienteDTO.getNumeroIdentificacion())) {
			throw new Exception("El numero de identificacion no puede tener letras");
		}

		if (clienteDTO.getNumeroIdentificacion().length() > 15) {
			throw new Exception("El maximo de caracteres para el numero de identificacion es 15");
		}
		cliente.setNumeroIdentificacion(clienteDTO.getNumeroIdentificacion());

		// Validaciones para primer apellido:
		if (Utilities.isNullString(clienteDTO.getPrimerApellido()) == true) {
			throw new Exception("El primer apellido del cliente no puede ser nulo");
		}

		if (clienteDTO.getPrimerApellido().length() > 50) {
			throw new Exception("Solo acepta 50 caracteres");
		}
		cliente.setPrimerApellido(clienteDTO.getPrimerApellido());

		// Validaciones para segundo apellido:
		if (clienteDTO.getSegundoApellido() != null) {
			if (clienteDTO.getSegundoApellido().length() > 50) {
				throw new Exception("Solo acepta 50 caracteres");
			}
		}
		cliente.setSegundoApellido(clienteDTO.getSegundoApellido());

		// Validaciones para el nombre:
		if (Utilities.isNullString(clienteDTO.getNombre()) == true) {
			throw new Exception("El nombre del cliente no puede ser nulo");
		}

		if (clienteDTO.getNombre().length() > 50) {
			throw new Exception("El maximo de caracteres para el nombre de cliente es 50");
		}
		cliente.setNombre(clienteDTO.getNombre());

		// Validaciones para el numero de telefono 1:
		if (Utilities.isNullString(clienteDTO.getTelefono1()) == true) {
			throw new Exception("El telefono 1 del cliente no puede ser nulo");
		}

		if (!Utilities.isNumeric(clienteDTO.getTelefono1())) {
			throw new Exception("El numero telefonico no debe contener letras");
		}

		if (clienteDTO.getTelefono1().length() > 15) {
			throw new Exception("El maximo de caracteres para el numero de telefono1 es 15");
		}
		cliente.setTelefono1(clienteDTO.getTelefono1());

		// Validaciones para el correo electronico del cliente:
		if (Utilities.isNullString(clienteDTO.getCorreo()) == true) {
			throw new Exception("El correo del cliente no puede ser nulo");
		}

		if (!Utilities.isValidEmail(clienteDTO.getCorreo())) {
			throw new Exception("El correo no es valido");
		}

		if (clienteDTO.getCorreo().length() > 100) {
			throw new Exception("El maximo de caracteres para el correo del cliente es 50");
		}
		cliente.setCorreo(clienteDTO.getCorreo());

		// Validaciones para el sexo del cliente:
		if (Utilities.isNullString(clienteDTO.getSexo()) == true) {
			throw new Exception("El sexo del cliente no puede ser nulo");
		}

		if (Utilities.isNumeric(clienteDTO.getSexo())) {
			throw new Exception("El sexo no debe contener numeros");
		}

		if (clienteDTO.getSexo().length() > 1) {
			throw new Exception("Maximo de caracteres para el sexo es de 1");
		}
		cliente.setSexo(clienteDTO.getSexo());

		// Validaciones para la fecha de nacimiento del cliente:
		if (Utilities.isNullDate(clienteDTO.getFechaNacimiento()) == true) {
			throw new Exception("La fecha de nacimiento del cliente no puede ser nula");
		}

		if (clienteDTO.getFechaNacimiento().compareTo(Constantes.FECHA_ACTUAL) > 0) {
			throw new Exception("La fecha de nacimiento indicada no puede ser mayor a la actual");
		}
		cliente.setFechaNacimiento(clienteDTO.getFechaNacimiento());

		// Validaciones para la fecha de creacion de un cliente:
		if (Utilities.isNullDate(clienteDTO.getFechaCreacion()) == true) {
			throw new Exception("La fecha de creacion de un cliente no puede ser nula");
		}
		cliente.setFechaCreacion(clienteDTO.getFechaCreacion());

		// Validaciones para el nombre del usuario creador de un cliente:
		if (Utilities.isNullString(clienteDTO.getUsuCreador()) == true) {
			throw new Exception("El nombre del creador de un cliente no puede ser nulo");
		}

		if (clienteDTO.getUsuCreador().length() > 10) {
			throw new Exception("El maximo de caracteres para el nombre de usucreador es 10");
		}
		cliente.setUsuCreador(clienteDTO.getUsuCreador());

		// Validaciones para el estado del cliente:
		if (Utilities.isNullString(clienteDTO.getEstado()) == true) {
			throw new Exception("El estado del cliente no puede ser nulo");
		}

		if (Utilities.isNumeric(clienteDTO.getEstado())) {
			throw new Exception("El estado no debe contener numeros");
		}

		if (clienteDTO.getEstado().length() > 1) {
			throw new Exception("Solo puede tener 1 caracter");
		}
		cliente.setEstado(clienteDTO.getEstado());
		

		// Consulta el tipo de identificacion dando su id
		tipoIdentificacion = tipoIdentificacionService.findByCodigoAndEstado(clienteDTO.getCodigoTipoIdentificacion(),
				Constantes.ACTIVO);

		// Validamos que el tipo identificacion exista y se encuentre activo
		if (tipoIdentificacion == null) {
			throw new Exception("El tipo identificacion " + clienteDTO.getCodigoTipoIdentificacion() + " no existe");
		}
		cliente.setTipoIdentificacion(tipoIdentificacion);

		clienteRepository.save(cliente);
		
		return cliente;
	}

	/**
	 * 
	 * @Title: findById
	 * @Description: TODO
	 * @param: @param  idClie
	 * @param: @return
	 * @param: @throws SQLException
	 * @return: Cliente
	 * @throws
	 */
	public Cliente findById(Long idClie) throws Exception {

		// Validamos el idClie venga con info
		if (idClie == null) {
			throw new Exception("Debe ingresar un id cliente");
		}

		if (!clienteRepository.findById(idClie).isPresent()) {
			throw new Exception("El cliente con id: " + idClie + " no existe");
		}

		return clienteRepository.findById(idClie).get();
	}

	/**
	 * 
	 * <p>
	 * Title: eliminarCliente
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param clienteDTO
	 * @throws SQLException
	 * @see co.edu.usbcali.viajesusb.service.ClienteService#eliminarCliente(co.edu.usbcali.viajesusb.dto.ClienteDTO)
	 */
	@Override
	public void eliminarCliente(Long idClie) throws SQLException {

		// Validar que se ingrese el id destino a eliminar
		if (idClie == null) {
			throw new SQLException("El id cliente es obligatorio");
		}

		Optional<Cliente> clienteBD = clienteRepository.findById(idClie);

		if (clienteBD.isPresent()) {
			clienteRepository.delete(clienteBD.get());
		} else {
			throw new SQLException("El cliente no se encontró");
		}
	}

}
