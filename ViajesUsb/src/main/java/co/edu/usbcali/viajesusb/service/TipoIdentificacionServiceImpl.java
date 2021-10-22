/**  
 * @Title:  TipoIdentificacionServiceImpl.java   
 * @Package co.edu.usbcali.viajesusb.service   
 * @Description: description   
 * @author: Emery Estupiñan     
 * @date:   20/09/2021 9:21:48 p. m.   
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
import co.edu.usbcali.viajesusb.domain.TipoIdentificacion;
import co.edu.usbcali.viajesusb.dto.TipoIdentificacionDTO;
import co.edu.usbcali.viajesusb.repository.TipoIdentificacionRepository;
import co.edu.usbcali.viajesusb.utils.Utilities;

/**
 * @ClassName: TipoIdentificacionServiceImpl
 * @Description: TODO
 * @author: Emery Estupiñan
 * @date: 20/09/2021 9:21:48 p. m.
 * @Copyright: USB
 */
@Scope("singleton")
@Service
public class TipoIdentificacionServiceImpl implements TipoIdentificacionService {

	@Autowired
	private TipoIdentificacionRepository tipoIdentificacionRepository;

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
	 * @see co.edu.usbcali.viajesusb.service.TipoIdentificacionService#findByEstadoOrderByNombre(java.lang.String)
	 */
	@Override
	public List<TipoIdentificacion> findByEstadoOrderByNombre(String estado) throws Exception {

		List<TipoIdentificacion> lstTipoIdentificacion = null;

		if (estado.matches("[^A|I]+")) {
			throw new Exception("Solo recibe las letras A e I");
		}
		if (estado == null || estado.trim().equals("")) {
			throw new Exception("El estado es obligatorio");
		}
		if (estado.matches("[0-9]+")) {
			throw new Exception("Solo se aceptan letras ");
		}

		lstTipoIdentificacion = tipoIdentificacionRepository.findByEstadoOrderByNombre(estado);

		return lstTipoIdentificacion;

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
	 * @see co.edu.usbcali.viajesusb.service.TipoIdentificacionService#findByCodigoAndEstado(java.lang.String,
	 *      java.lang.String)
	 */
	@Override
	public TipoIdentificacion findByCodigoAndEstado(String codigo, String estado) throws Exception {

		TipoIdentificacion tipoIdentificacion = null;
		if (codigo == null || codigo.trim().equals("")) {
			throw new Exception("El tipo de identificacion es obligatorio");
		}
		if (codigo.matches("[^A-Z]+")) {
			throw new Exception("Solo se aceptan letras");
		}
		if (codigo.length() > 2) {
			throw new Exception("Solo pueden tener dos caracteres");
		}
		if (estado.matches("[^A|I]+")) {
			throw new Exception("Solo recibe las letras A e I");
		}
		if (estado == null || estado.trim().equals("")) {
			throw new Exception("El estado es obligatorio");
		}
		if (estado.matches("[0-9]+")) {
			throw new Exception("Solo se aceptan letras ");
		}
		tipoIdentificacion = tipoIdentificacionRepository.findByCodigoAndEstado(codigo, estado);

		return tipoIdentificacion;

	}

	/**
	 * 
	 * @Title: guardarTipoIdentificacion
	 * @Description: TODO
	 * @param: @param  tipoIdentificacionDTO
	 * @param: @throws SQLException
	 * @return: void
	 * @throws
	 */
	@Override
	public TipoIdentificacion guardarTipoIdentificacion(TipoIdentificacionDTO tipoIdentificacionDTO) throws Exception {

		TipoIdentificacion tipoIdentificacion = null;

		tipoIdentificacion = new TipoIdentificacion();

		// Validaciones para el codigo del tipo identificacion:
		if (Utilities.isNullString(tipoIdentificacionDTO.getCodigo()) == true) {
			throw new Exception("El codigo tipo de identificacion es obligatorio");
		}

		if (!Utilities.isOnlyLetters(tipoIdentificacionDTO.getCodigo())) {
			throw new Exception("El codigo solo recibe letras");
		}

		if (tipoIdentificacionDTO.getCodigo().length() > 2) {
			throw new Exception("Solo pueden tener dos caracteres");
		}
		tipoIdentificacion.setCodigo(tipoIdentificacionDTO.getCodigo());

		// Validaciones para el nombre del tipo identificacion:
		if (Utilities.isNullString(tipoIdentificacionDTO.getNombre()) == true) {
			throw new Exception("El nombre es obligatorio");
		}

		if (!Utilities.isOnlyLetters(tipoIdentificacionDTO.getNombre())) {
			throw new Exception("El nombre solo recibe letras");
		}

		if (tipoIdentificacionDTO.getNombre().length() > 15) {
			throw new Exception("Solo puede tener 15 caracteres");
		}
		tipoIdentificacion.setNombre(tipoIdentificacionDTO.getNombre());

		// Validaciones para la fecha de creacion:
		if (Utilities.isNullDate(tipoIdentificacionDTO.getFechaCreacion()) == true) {
			throw new Exception("La fecha de creación es obligatorio");
		}
		tipoIdentificacion.setFechaCreacion(tipoIdentificacionDTO.getFechaCreacion());
		
		// Validaciones para el usuario creador:
		if (Utilities.isNullString(tipoIdentificacionDTO.getUsuCreador()) == true) {
			throw new Exception("El usuario creador es obligatorio");
		}

		if (tipoIdentificacionDTO.getUsuCreador().length() > 10) {
			throw new Exception("El limite de caracteres es de 10");
		}
		tipoIdentificacion.setUsuCreador(tipoIdentificacionDTO.getUsuCreador());

		// Validaciones para el estado del tipo identificacion:
		if (Utilities.isNullString(tipoIdentificacionDTO.getEstado()) == true) {
			throw new Exception("El estado es obligatorio");
		}

		if (Utilities.isNumeric(tipoIdentificacionDTO.getEstado())) {
			throw new Exception("El estado no debe tener numeros");
		}

		if (tipoIdentificacionDTO.getEstado().length() > 1) {
			throw new Exception("Solo recibe 1 caracter");
		}

		if (tipoIdentificacionDTO.getEstado().matches("[^A|I]+")) {
			throw new Exception("Solo recibe las letras A e I");
		}
		tipoIdentificacion.setEstado(tipoIdentificacionDTO.getEstado());

		tipoIdentificacionRepository.save(tipoIdentificacion);
		
		return tipoIdentificacion;
	}

	/**
	 * 
	 * @Title: actualizarTipoIdentificacion
	 * @Description: TODO
	 * @param: @param  tipoIdentificacionDTO
	 * @param: @throws SQLException
	 * @return: void
	 * @throws
	 */
	@Override
	public TipoIdentificacion actualizarTipoIdentificacion(TipoIdentificacionDTO tipoIdentificacionDTO) throws Exception {

		TipoIdentificacion tipoIdentificacion = null;

		tipoIdentificacion = findById(tipoIdentificacionDTO.getIdTiid());

		// Validaciones para el codigo del tipo identificacion:
		if (Utilities.isNullString(tipoIdentificacionDTO.getCodigo()) == true) {
			throw new Exception("El tipo de identificacion es obligatorio");
		}

		if (!Utilities.isOnlyLetters(tipoIdentificacionDTO.getCodigo())) {
			throw new Exception("El codigo solo recibe letras");
		}
		if (tipoIdentificacionDTO.getCodigo().length() > 2) {
			throw new Exception("Solo pueden tener dos caracteres");
		}

		tipoIdentificacion.setCodigo(tipoIdentificacionDTO.getCodigo());

		// Validaciones para el nombre del tipo identificacion:
		if (Utilities.isNullString(tipoIdentificacionDTO.getNombre()) == true) {
			throw new Exception("El nombre es obligatorio");
		}

		if (!Utilities.isOnlyLetters(tipoIdentificacionDTO.getNombre())) {
			throw new Exception("El nombre solo recibe letras");
		}

		if (tipoIdentificacionDTO.getNombre().length() > 15) {
			throw new Exception("Solo puede tener 15 caracteres");
		}
		tipoIdentificacion.setNombre(tipoIdentificacionDTO.getNombre());

		// Validaciones para la fecha de creacion:
		if (Utilities.isNullDate(tipoIdentificacionDTO.getFechaCreacion()) == true) {
			throw new SQLException("La fecha de creación es obligatorio");
		}
		
		tipoIdentificacion.setFechaCreacion(tipoIdentificacionDTO.getFechaCreacion());


		// Validaciones para el usuario creador:
		if (Utilities.isNullString(tipoIdentificacionDTO.getUsuCreador()) == true) {
			throw new Exception("El usuario creador es obligatorio");
		}

		if (tipoIdentificacionDTO.getUsuCreador().length() > 10) {
			throw new Exception("El limite de caracteres es de 10");
		}
		tipoIdentificacion.setUsuCreador(tipoIdentificacionDTO.getUsuCreador());


		// Validaciones para el estado del tipo identificacion:
		if (Utilities.isNullString(tipoIdentificacionDTO.getEstado()) == true) {
			throw new Exception("El estado es obligatorio");
		}

		if (Utilities.isNumeric(tipoIdentificacionDTO.getEstado())) {
			throw new Exception("El estado no debe tener numeros");
		}

		if (tipoIdentificacionDTO.getEstado().length() > 1) {
			throw new Exception("Solo recibe 1 caracter");
		}

		if (tipoIdentificacionDTO.getEstado().matches("[^A|I]+")) {
			throw new Exception("Solo recibe las letras A e I");
		}
		tipoIdentificacion.setEstado(tipoIdentificacionDTO.getEstado());

		tipoIdentificacionRepository.save(tipoIdentificacion);
	
		return tipoIdentificacion;
	}

	/**
	 * 
	 * @Title: findById
	 * @Description: TODO
	 * @param: @param  idTiid
	 * @param: @return
	 * @param: @throws SQLException
	 * @return: TipoIdentificacionMapper
	 * @throws
	 */
	public TipoIdentificacion findById(Long idTiid) throws Exception {

		if (idTiid == null) {
			throw new Exception("Debe ingresar un id tipo identificacion");
		}

		if (!tipoIdentificacionRepository.findById(idTiid).isPresent()) {
			throw new Exception("El tipo identificacion con id: " + idTiid + " no existe");
		}
		return tipoIdentificacionRepository.findById(idTiid).get();
	}

	/**
	 * 
	 * @Title: eliminarTipoIdentificacion
	 * @Description: TODO
	 * @param: @param  tipoIdentificacionDTO
	 * @param: @throws SQLException
	 * @return: void
	 * @throws
	 */
	@Override
	public void eliminarTipoIdentificacion(Long id) throws Exception {

		// Validar que se ingrese el id destino a eliminar
		if (id == null) {
			throw new Exception("El id tipo identificacion es obligatorio");
		}

		Optional<TipoIdentificacion> tipoIdentificacionBD = tipoIdentificacionRepository
				.findById(id);

		if (tipoIdentificacionBD.isPresent()) {
			tipoIdentificacionRepository.delete(tipoIdentificacionBD.get());
		} else {
			throw new Exception("El tipo de identificacion no se encontró");
		}
	}

}
