/**  
 * @Title:  TipoDestinoImpl.java   
 * @Package co.edu.usbcali.viajesusb.service   
 * @Description: description   
 * @author: Emery Estupiñan     
 * @date:   17/09/2021 3:22:16 p. m.   
 * @version V1.0 
 * @Copyright: Universidad San de Buenaventura
 */
package co.edu.usbcali.viajesusb.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import co.edu.usbcali.viajesusb.domain.TipoDestino;
import co.edu.usbcali.viajesusb.dto.TipoDestinoDTO;
import co.edu.usbcali.viajesusb.repository.TipoDestinoRepository;
import co.edu.usbcali.viajesusb.utils.Utilities;

/**
 * @ClassName: TipoDestinoImpl
 * @Description: TODO
 * @author: Emery Estupiñan
 * @date: 17/09/2021 3:22:16 p. m.
 * @Copyright: USB
 */
@Scope("singleton")
@Service
public class TipoDestinoServiceImpl implements TipoDestinoService {

	@Autowired
	private TipoDestinoRepository tipoDestinoRepository;

	/**
	 * <p>
	 * Title: findByCodigo
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param codigo
	 * @return
	 * @throws SQLException
	 * @see co.edu.usbcali.viajesusb.service.TipoDestinoService#findByCodigo(java.lang.String)
	 */
	@Override
	public TipoDestino findByCodigo(String codigo) throws Exception {

		TipoDestino tipoDestino = null;

		if (codigo == null || codigo.trim().equals("")) {
			throw new SQLException("El codigo de tipo destino es obligatorio");
		}
		if (codigo.matches("[0-9]+")) {
			throw new SQLException("Solo son validas letras");
		}

		tipoDestino = tipoDestinoRepository.findByCodigo(codigo);

		return tipoDestino;

	}

	/**
	 * <p>
	 * Title: findByCodigoAndEstado
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param codigo
	 * @param estado
	 * @return
	 * @throws SQLException
	 * @see co.edu.usbcali.viajesusb.service.TipoDestinoService#findByCodigoAndEstado(java.lang.String,
	 *      java.lang.String)
	 */
	@Override
	public TipoDestino findByCodigoAndEstado(String codigo, String estado) throws Exception {

		TipoDestino tipoDestino = null;

		if (codigo == null || codigo.trim().equals("")) {
			throw new SQLException("El codigo de tipo destino es obligatorio");
		}
		if (codigo.matches("[0-9]+")) {
			throw new SQLException("Solo son validas letras");
		}
		if (estado == null || estado.trim().equals("")) {
			throw new SQLException("El codigo de estado es obligatorio");
		}
		if (estado.matches("[^A|I]")) {
			throw new SQLException("Solo recibe las letras A e I");
		}
		tipoDestino = tipoDestinoRepository.findByCodigoAndEstado(codigo, estado);

		return tipoDestino;

	}

	/**
	 * <p>
	 * Title: findByEstadoOrderByNombre
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param estado
	 * @return
	 * @throws SQLException
	 * @see co.edu.usbcali.viajesusb.service.TipoDestinoService#findByEstadoOrderByNombre(java.lang.String)
	 */
	@Override
	public List<TipoDestino> findByEstadoOrderByNombre(String estado) throws Exception {

		List<TipoDestino> lstTipoDestino = null;

		if (estado == null || estado.trim().equals("")) {
			throw new SQLException("El codigo de estado es obligatorio");
		}
		if (estado.matches("[^A|I]")) {
			throw new SQLException("Solo recibe las letras A e I");
		}

		lstTipoDestino = tipoDestinoRepository.findByEstadoOrderByNombre(estado);

		return lstTipoDestino;

	}

	/**
	 * 
	 * <p>
	 * Title: guardarTipoDestino
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param tipoDestinoDTO
	 * @throws SQLException
	 * @see co.edu.usbcali.viajesusb.service.TipoDestinoService#guardarTipoDestino(co.edu.usbcali.viajesusb.dto.TipoDestinoDTO)
	 */
	@Override
	public TipoDestino guardarTipoDestino(TipoDestinoDTO tipoDestinoDTO) throws Exception {

		TipoDestino tipoDestino = null;

		tipoDestino = new TipoDestino();

		// Validaciones para el codigo de tipo destino:
		if (tipoDestinoDTO.getCodigo() == null || tipoDestinoDTO.getCodigo().trim().equals("")) {
			throw new Exception("El tipo destino no puede ser nulo");
		}

		if (!Utilities.isOnlyLetters(tipoDestinoDTO.getCodigo())) {
			throw new Exception("El codigo solo recibe letras");
		}

		if (tipoDestinoDTO.getCodigo().length() > 5) {
			throw new Exception("El codigo de tipo destino solo puede tener longitud de 5");

		}
		tipoDestino.setCodigo(tipoDestinoDTO.getCodigo());

		// Validaciones para el nombre de tipo destino:
		if (tipoDestinoDTO.getNombre() == null || tipoDestinoDTO.getNombre().trim().equals("")) {
			throw new Exception("El tipo destino no puede ser nulo");
		}

		if (!Utilities.isOnlyLetters(tipoDestinoDTO.getNombre())) {
			throw new Exception("El codigo solo recibe letras");
		}

		if (tipoDestinoDTO.getNombre().length() > 100) {
			throw new Exception("El nombre solo puede tener una longitud de 100");

		}
		tipoDestino.setNombre(tipoDestinoDTO.getNombre());

		// Validaciones para la descripción de tipo destino:
		if (tipoDestinoDTO.getDescripcion() == null || tipoDestinoDTO.getDescripcion().trim().equals("")) {
			throw new Exception("El tipo destino no puede ser nulo");
		}

		if (!Utilities.isOnlyLetters(tipoDestinoDTO.getDescripcion())) {
			throw new Exception("El codigo solo recibe letras");
		}

		if (tipoDestinoDTO.getDescripcion().length() > 300) {
			throw new Exception("La descripcion solo puede tener una longitud de 300");

		}
		tipoDestino.setDescripcion(tipoDestinoDTO.getDescripcion());

		// Validaciones para la fecha de creacion del tipo destino:
		if (tipoDestinoDTO.getFechaCreacion() == null) {
			throw new Exception("La fecha de creacion de un cliente no puede ser nula");
		}
		tipoDestino.setFechaCreacion(tipoDestinoDTO.getFechaCreacion());

		// Validaciones para el usuario creador del tipo destino:
		if (tipoDestinoDTO.getUsuCreador() == null || tipoDestinoDTO.getUsuCreador().trim().equals("")) {
			throw new Exception("El nombre del creador de un cliente no puede ser nulo");
		}

		if (tipoDestinoDTO.getUsuCreador().length() > 10) {
			throw new Exception(
					"La cantidad de caracteres del nombre del usuario creador no puede exceder el total de 10");
		}

		tipoDestino.setUsuCreador(tipoDestinoDTO.getUsuCreador());

		// Validaciones para el estado del tipo destino:
		if (tipoDestinoDTO.getEstado() == null || tipoDestinoDTO.getEstado().trim().equals("")) {
			throw new Exception("El estado del cliente no puede ser nulo");
		}

		if (Utilities.isNumeric(tipoDestinoDTO.getEstado())) {
			throw new Exception("El estado no debe contener numeros");
		}

		if (tipoDestinoDTO.getEstado().length() > 1) {
			throw new Exception("La cantidad de caracteres del estado no puede exceder el total de 1");
		}
		tipoDestino.setEstado(tipoDestinoDTO.getEstado());

		tipoDestinoRepository.save(tipoDestino);
		
		return tipoDestino;
	}

	/**
	 * 
	 * @Title: actualizarTipoDestino
	 * @Description: TODO
	 * @param: @param  tipoDestinoDTO
	 * @param: @throws SQLException
	 * @return: void
	 * @throws
	 */
	@Override
	public TipoDestino actualizarTipoDestino(TipoDestinoDTO tipoDestinoDTO) throws Exception {

		TipoDestino tipoDestino = null;

		tipoDestino = findById(tipoDestinoDTO.getIdTide());

		// Validaciones para el codigo de tipo destino:
		if (tipoDestinoDTO.getCodigo() == null || tipoDestinoDTO.getCodigo().trim().equals("")) {
			throw new Exception("El tipo destino no puede ser nulo");
		}

		if (!Utilities.isOnlyLetters(tipoDestinoDTO.getCodigo())) {
			throw new Exception("El codigo solo recibe letras");
		}

		if (tipoDestinoDTO.getCodigo().length() > 5) {
			throw new Exception("El codigo de tipo destino solo puede tener longitud de 5");

		}
		tipoDestino.setCodigo(tipoDestinoDTO.getCodigo());

		// Validaciones para el nombre de tipo destino:
		if (tipoDestinoDTO.getNombre() == null || tipoDestinoDTO.getNombre().trim().equals("")) {
			throw new Exception("El tipo destino no puede ser nulo");
		}

		if (!Utilities.isOnlyLetters(tipoDestinoDTO.getNombre())) {
			throw new Exception("El codigo solo recibe letras");
		}

		if (tipoDestinoDTO.getNombre().length() > 100) {
			throw new Exception("El nombre solo puede tener una longitud de 100");

		}
		tipoDestino.setNombre(tipoDestinoDTO.getNombre());

		// Validaciones para la descripción de tipo destino:
		if (tipoDestinoDTO.getDescripcion() == null || tipoDestinoDTO.getDescripcion().trim().equals("")) {
			throw new Exception("El tipo destino no puede ser nulo");
		}

		if (!Utilities.isOnlyLetters(tipoDestinoDTO.getDescripcion())) {
			throw new Exception("El codigo solo recibe letras");
		}

		if (tipoDestinoDTO.getDescripcion().length() > 300) {
			throw new Exception("La descripcion solo puede tener una longitud de 300");

		}
		tipoDestino.setDescripcion(tipoDestinoDTO.getDescripcion());

		// Validaciones para la fecha de creacion del tipo destino:
		if (tipoDestinoDTO.getFechaCreacion() == null) {
			throw new Exception("La fecha de creacion de un cliente no puede ser nula");
		}
		tipoDestino.setFechaCreacion(tipoDestinoDTO.getFechaCreacion());

		// Validaciones para el usuario creador del tipo destino:
		if (tipoDestinoDTO.getUsuCreador() == null || tipoDestinoDTO.getUsuCreador().trim().equals("")) {
			throw new Exception("El nombre del creador de un cliente no puede ser nulo");
		}

		if (tipoDestinoDTO.getUsuCreador().length() > 10) {
			throw new Exception(
					"La cantidad de caracteres del nombre del usuario creador no puede exceder el total de 10");
		}

		tipoDestino.setUsuCreador(tipoDestinoDTO.getUsuCreador());

		// Validaciones para el estado del tipo destino:
		if (tipoDestinoDTO.getEstado() == null || tipoDestinoDTO.getEstado().trim().equals("")) {
			throw new Exception("El estado del cliente no puede ser nulo");
		}

		if (Utilities.isNumeric(tipoDestinoDTO.getEstado())) {
			throw new Exception("El estado no debe contener numeros");
		}

		if (tipoDestinoDTO.getEstado().length() > 1) {
			throw new Exception("La cantidad de caracteres del estado no puede exceder el total de 1");
		}
		tipoDestino.setEstado(tipoDestinoDTO.getEstado());

		tipoDestinoRepository.save(tipoDestino);
		
		return tipoDestino;
	}

	/**
	 * 
	 * @Title: findById
	 * @Description: TODO
	 * @param: @param  idTide
	 * @param: @return
	 * @param: @throws SQLException
	 * @return: TipoDestino
	 * @throws
	 */
	public TipoDestino findById(Long idTide) throws Exception {

		if (idTide == null) {
			throw new Exception("Debe ingresar un id tipo destino");
		}

		if (!tipoDestinoRepository.findById(idTide).isPresent()) {
			throw new Exception("El tipo destino con id: " + idTide + " no existe");
		}

		return tipoDestinoRepository.findById(idTide).get();
	}

	/**
	 * 
	 * @Title: eliminarTipoDestino
	 * @Description: TODO
	 * @param: @param  tipoDestinoDTO
	 * @param: @throws SQLException
	 * @return: void
	 * @throws
	 */
	@Override
	public void eliminarTipoDestino(Long id) throws Exception {

		// Validar que se ingrese el id destino a eliminar
		if (id == null) {
			throw new Exception("El id tipo destino es obligatorio");
		}

		Optional<TipoDestino> tipoDestinoBD = tipoDestinoRepository.findById(id);

		if (tipoDestinoBD.isPresent()) {
			tipoDestinoRepository.delete(tipoDestinoBD.get());
		} else {
			throw new Exception("El destino no se encontró");
		}
	}

}
