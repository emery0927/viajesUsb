/**  
  * @Title:  DestinoServiceImpl.java   
 * @Package co.edu.usbcali.viajesusb.service   
 * @Description: description   
 * @author: Emery Estupiñan     
 * @date:   20/09/2021 8:06:55 p. m.   
 * @version V1.0 
 * @Copyright: Universidad San de Buenaventura
 */
package co.edu.usbcali.viajesusb.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import co.edu.usbcali.viajesusb.domain.Destino;
import co.edu.usbcali.viajesusb.domain.TipoDestino;
import co.edu.usbcali.viajesusb.dto.DestinoDTO;
import co.edu.usbcali.viajesusb.repository.DestinoRepository;
import co.edu.usbcali.viajesusb.utils.Constantes;
import co.edu.usbcali.viajesusb.utils.Utilities;

/**
 * @ClassName: DestinoServiceImpl
 * @Description: TODO
 * @author: Emery Estupiñan
 * @date: 20/09/2021 8:06:55 p. m.
 * @Copyright: USB
 */
@Scope("singleton")
@Service
public class DestinoServiceImpl implements DestinoService {

	@Autowired
	private DestinoRepository destinoRepository;

	@Autowired
	private TipoDestinoService tipoDestinoService;

	/**
	 * <p>
	 * Title: findByTipoDestinoCodigo
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param codigoTipoDestino
	 * @return
	 * @throws Exception
	 * @see co.edu.usbcali.viajesusb.service.DestinoService#findByTipoDestinoCodigo(java.lang.String)
	 */
	@Override
	public List<Destino> findByTipoDestinoCodigo(String codigoTipoDestino) throws Exception {
		List<Destino> lstDestino = null;

		if (codigoTipoDestino == null || codigoTipoDestino.trim().equals("")) {
			throw new Exception("El codigo de tipo destino es obligatorio");
		}
		if (codigoTipoDestino.matches("[0-9]+")) {
			throw new Exception("Solo son validas letras");
		}
		lstDestino = destinoRepository.findByTipoDestino_Codigo(codigoTipoDestino.trim());

		return lstDestino;
	}

	/**
	 * <p>
	 * Title: findByEstado
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param estado
	 * @param pageable
	 * @return
	 * @throws SQLException
	 * @see co.edu.usbcali.viajesusb.service.DestinoService#findByEstado(java.lang.String,
	 *      org.springframework.data.domain.Pageable)
	 */
	@Override
	public Page<Destino> findByEstado(String estado, Pageable pageable) throws Exception {

		Page<Destino> pageDestino = null;

		if (estado.matches("[^A|I]+")) {
			throw new Exception("Solo recibe las letras A e I");
		}

		pageDestino = destinoRepository.findByEstado(estado, pageable);

		return destinoRepository.findByEstado(estado, pageable);

	}

	/**
	 * 
	 * @Title: guardarDestino
	 * @Description: TODO
	 * @param: @param  destino
	 * @param: @throws SQLException
	 * @return: void
	 * @throws
	 */
	@Override
	public Destino guardarDestino(DestinoDTO destinoDTO) throws Exception {

		Destino destino = null;
		TipoDestino tipoDestino = null;

		destino = new Destino();

		// Validaciones para el atributo aire de Destino:
		if (Utilities.isNullString(destinoDTO.getAire()) == true) {
			throw new Exception("El atributo aire es obligatorio");
		}

		if (!Utilities.isOnlyLetters(destinoDTO.getAire())) {
			throw new Exception("El atributo aire solo recibe letras");
		}

		if (destinoDTO.getAire().length() > 1) {
			throw new Exception("Solo permite 1 caracter");
		}
		destino.setAire(destinoDTO.getAire());

		// Validaciones para el atributo tierra de Destino:
		if (Utilities.isNullString(destinoDTO.getTierra()) == true) {
			throw new Exception("El atributo tierra es obligatorio");
		}

		if (!Utilities.isOnlyLetters(destinoDTO.getTierra())) {
			throw new Exception("El atributo aire solo recibe letras");
		}

		if (destinoDTO.getTierra().length() > 1) {
			throw new Exception("Solo permite 1 caracter");
		}
		destino.setTierra(destinoDTO.getTierra());

		// Validaciones para el atributo mar de Destino:
		if (Utilities.isNullString(destinoDTO.getMar()) == true) {
			throw new Exception("El atributo aire es obligatorio");
		}

		if (!Utilities.isOnlyLetters(destinoDTO.getMar())) {
			throw new Exception("El atributo aire solo recibe letras");
		}
		if (destinoDTO.getMar().length() > 1) {
			throw new Exception("Solo permite 1 caracter");
		}
		destino.setMar(destinoDTO.getMar());

		// Validaciones para el codigo del Destino:
		if (Utilities.isNullString(destinoDTO.getCodigo()) == true) {
			throw new Exception("El codigo del destino es obligatorio");
		}

		if (!Utilities.isOnlyLetters(destinoDTO.getCodigo())) {
			throw new Exception("El codigo solo recibe letras");
		}

		if (destinoDTO.getCodigo().length() > 4) {
			throw new Exception("Solo pueden tener cuatro caracteres");
		}
		destino.setCodigo(destinoDTO.getCodigo());

		// Validaciones para el nombre del destino:
		if (Utilities.isNullString(destinoDTO.getNombre()) == true) {
			throw new Exception("El nombre es obligatorio");
		}

		/*if (!Utilities.isOnlyLetters(destinoDTO.getNombre())) {
			throw new Exception("El nombre solo recibe letras");
		}*/

		if (destinoDTO.getNombre().length() > 15) {
			throw new Exception("Solo puede tener 15 caracteres");
		}
		destino.setNombre(destinoDTO.getNombre());

		// Validaciones para la descripción de destino:
		if (destinoDTO.getDescripcion() == null || destinoDTO.getDescripcion().trim().equals("")) {
			throw new Exception("La descripcion no puede ser nula");
		}

		/*if (!Utilities.isOnlyLetters(destinoDTO.getDescripcion())) {
			throw new Exception("La descripción solo recibe letras");
		}*/

		if (destinoDTO.getDescripcion().length() > 150) {
			throw new Exception("La descripcion solo puede tener una longitud de 150");

		}
		destino.setDescripcion(destinoDTO.getDescripcion());

		// Validaciones para el estado del tipo identificacion:
		if (Utilities.isNullString(destinoDTO.getEstado()) == true) {
			throw new Exception("El estado es obligatorio");
		}

		if (Utilities.isNumeric(destinoDTO.getEstado())) {
			throw new Exception("El estado no debe tener numeros");
		}

		if (destinoDTO.getEstado().length() > 1) {
			throw new Exception("Solo recibe 1 caracter");
		}

		if (destinoDTO.getEstado().matches("[^A|I]+")) {
			throw new Exception("Solo recibe las letras A e I");
		}
		destino.setEstado(destinoDTO.getEstado());

		// Validaciones para la fecha de creacion:
		if (Utilities.isNullDate(destinoDTO.getFechaCreacion()) == true) {
			throw new Exception("La fecha de creación es obligatoria");
		}
		destino.setFechaCreacion(destinoDTO.getFechaCreacion());

		// Validaciones para el usuario creador:
		if (Utilities.isNullString(destinoDTO.getUsuCreador()) == true) {
			throw new Exception("El usuario creador es obligatorio");
		}

		if (destinoDTO.getUsuCreador().length() > 10) {
			throw new Exception("El limite de caracteres es de 10");
		}
		destino.setUsuCreador(destinoDTO.getUsuCreador());

		// Se consulta el tipo destino dando su id
		tipoDestino = tipoDestinoService.findByCodigoAndEstado(destinoDTO.getCodigoTipoDestino(), Constantes.ACTIVO);

		// Validamos que el tipo destino exista y este activo
		if (tipoDestino == null) {
			throw new Exception("El tipo destino " + destinoDTO.getCodigoTipoDestino() + " NO existe");
		}

		destino.setTipoDestino(tipoDestino);

		destinoRepository.save(destino);
		
		return destino;
	}

	/**
	 * 
	 * <p>
	 * Title: actualizarDestino
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param destinoDTO
	 * @throws SQLException
	 * @see co.edu.usbcali.viajesusb.service.DestinoService#actualizarDestino(co.edu.usbcali.viajesusb.dto.DestinoDTO)
	 */
	@Override
	public Destino actualizarDestino(DestinoDTO destinoDTO) throws Exception {

		Destino destino = null;
		TipoDestino tipoDestino = null;

		// TODO: Pendiente validaciones

		// Se arma el destino
		destino = findById(destinoDTO.getIdDest());

		// Validaciones para el atributo aire de Destino:
		if (Utilities.isNullString(destinoDTO.getAire()) == true) {
			throw new Exception("El atributo aire es obligatorio");
		}

		if (!Utilities.isOnlyLetters(destinoDTO.getAire())) {
			throw new Exception("El atributo aire solo recibe letras");
		}
		if (destinoDTO.getAire().length() > 1) {
			throw new Exception("Solo permite 1 caracter");
		}
		destino.setAire(destinoDTO.getAire());

		// Validaciones para el atributo tierra de Destino:
		if (Utilities.isNullString(destinoDTO.getTierra()) == true) {
			throw new Exception("El atributo tierra es obligatorio");
		}

		if (!Utilities.isOnlyLetters(destinoDTO.getTierra())) {
			throw new Exception("El atributo aire solo recibe letras");
		}

		if (destinoDTO.getTierra().length() > 1) {
			throw new Exception("Solo permite 1 caracter");
		}
		destino.setTierra(destinoDTO.getTierra());

		// Validaciones para el atributo mar de Destino:
		if (Utilities.isNullString(destinoDTO.getMar()) == true) {
			throw new Exception("El atributo aire es obligatorio");
		}

		if (!Utilities.isOnlyLetters(destinoDTO.getMar())) {
			throw new Exception("El atributo aire solo recibe letras");
		}

		if (destinoDTO.getMar().length() > 1) {
			throw new Exception("Solo permite 1 caracter");
		}
		destino.setMar(destinoDTO.getMar());

		// Validaciones para el codigo del Destino:
		if (Utilities.isNullString(destinoDTO.getCodigo()) == true) {
			throw new Exception("El codigo del destino es obligatorio");
		}

		if (!Utilities.isOnlyLetters(destinoDTO.getCodigo())) {
			throw new Exception("El codigo solo recibe letras");
		}

		if (destinoDTO.getCodigo().length() > 4) {
			throw new Exception("Solo pueden tener cuatro caracteres");
		}
		destino.setCodigo(destinoDTO.getCodigo());

		// Validaciones para el nombre del destino:
		if (Utilities.isNullString(destinoDTO.getNombre()) == true) {
			throw new Exception("El nombre es obligatorio");
		}

		if (!Utilities.isOnlyLetters(destinoDTO.getNombre())) {
			throw new Exception("El nombre solo recibe letras");
		}

		if (destinoDTO.getNombre().length() > 15) {
			throw new Exception("Solo puede tener 15 caracteres");
		}
		destino.setNombre(destinoDTO.getNombre());

		// Validaciones para la descripción de destino:
		if (destinoDTO.getDescripcion() == null || destinoDTO.getDescripcion().trim().equals("")) {
			throw new Exception("La descripcion no puede ser nula");
		}

		if (!Utilities.isOnlyLetters(destinoDTO.getDescripcion())) {
			throw new Exception("La descripción solo recibe letras");
		}

		if (destinoDTO.getDescripcion().length() > 150) {
			throw new Exception("La descripcion solo puede tener una longitud de 150");

		}
		destino.setDescripcion(destinoDTO.getDescripcion());

		// Validaciones para el estado del tipo identificacion:
		if (Utilities.isNullString(destinoDTO.getEstado()) == true) {
			throw new Exception("El estado es obligatorio");
		}

		if (Utilities.isNumeric(destinoDTO.getEstado())) {
			throw new Exception("El estado no debe tener numeros");
		}

		if (destinoDTO.getEstado().length() > 1) {
			throw new Exception("Solo recibe 1 caracter");
		}

		if (destinoDTO.getEstado().matches("[^A|I]+")) {
			throw new Exception("Solo recibe las letras A e I");
		}
		destino.setEstado(destinoDTO.getEstado());

		// Validaciones para la fecha de creacion:
		if (Utilities.isNullDate(destinoDTO.getFechaCreacion()) == true) {
			throw new Exception("La fecha de creación es obligatoria");
		}

		// Validaciones para el usuario creador:
		if (Utilities.isNullString(destinoDTO.getUsuCreador()) == true) {
			throw new Exception("El usuario creador es obligatorio");
		}

		if (destinoDTO.getUsuCreador().length() > 10) {
			throw new Exception("El limite de caracteres es de 10");
		}
		destinoDTO.setUsuCreador(destinoDTO.getUsuCreador());

		// Se consulta el tipo destino dado su id
		tipoDestino = tipoDestinoService.findByCodigoAndEstado(destinoDTO.getCodigoTipoDestino(), Constantes.ACTIVO);

		// Validamos que el tipo destino exista y este activo
		if (tipoDestino == null) {
			throw new Exception("El tipo destino " + destinoDTO.getCodigoTipoDestino() + " NO existe");
		}

		destino.setTipoDestino(tipoDestino);

		destinoRepository.save(destino);
		
		return destino;

	}

	/**
	 * 
	 * @Title: findById
	 * @Description: TODO
	 * @param: @param  idDest
	 * @param: @return
	 * @param: @throws Exception
	 * @return: Optional<Destino>
	 * @throws
	 */

	public Destino findById(Long idDest) throws Exception {

		// Validamos el idDest venga con info
		if (idDest == null) {
			throw new Exception("Debe ingresar un id destino");
		}

		if (!destinoRepository.findById(idDest).isPresent()) {
			throw new Exception("El destino con id: " + idDest + " no existe");
		}

		return destinoRepository.findById(idDest).get();

	}

	@Override
	public void eliminarDestino(Long idDest) throws Exception {

		// Validar que se ingrese el id destino a eliminar
		if (idDest == null) {
			throw new Exception("El id destino es obligatorio");
		}

		Optional<Destino> destinoBD = destinoRepository.findById(idDest);

		if (destinoBD.isPresent()) {
			destinoRepository.delete(destinoBD.get());
		} else {
			throw new Exception("El destino no se encontró");
		}
	}
}
