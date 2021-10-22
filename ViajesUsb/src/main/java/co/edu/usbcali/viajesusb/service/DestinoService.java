/**  
 * @Title:  DestinoService.java   
 * @Package co.edu.usbcali.viajesusb.service   
 * @Description: description   
 * @author: Emery Estupiñan     
 * @date:   20/09/2021 8:05:51 p. m.   
 * @version V1.0 
 * @Copyright: Universidad San de Buenaventura
 */
package co.edu.usbcali.viajesusb.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import co.edu.usbcali.viajesusb.domain.Destino;
import co.edu.usbcali.viajesusb.dto.DestinoDTO;

/**   
 * @ClassName:  DestinoService   
  * @Description: TODO   
 * @author: Emery Estupiñan     
 * @date:   20/09/2021 8:05:51 p. m.      
 * @Copyright:  USB
 */
public interface DestinoService {
	
	/**
	 * 
	 * @Title: findByTipoDestino_Codigo   
	   * @Description: consultar tipo de destino por codigo 
	 * @param: @param codigoTipoDestino
	 * @param: @return
	 * @param: @throws SQLException      
	 * @return: List<Destino>      
	 * @throws Exception 
	 * @throws
	 */
	public List<Destino> findByTipoDestinoCodigo(String codigoTipoDestino) throws Exception;
	
	/**
	 * 
	 * @Title: findByEstado   
	   * @Description: consultar tipo de destino por estado 
	 * @param: @param estado
	 * @param: @param pageable
	 * @param: @return
	 * @param: @throws SQLException      
	 * @return: Page<Destino>      
	 * @throws
	 */
	public Page<Destino> findByEstado(String estado, Pageable pageable) throws Exception;
	
	/**
	 * 
	 * @Title: guardarDestino   
	   * @Description: guarda un destino 
	 * @param: @param destinoDTO
	 * @param: @throws SQLException      
	 * @return: void      
	 * @throws
	 */
	public Destino guardarDestino(DestinoDTO destinoDTO) throws Exception;

	/**
	 * 
	 * @Title: actualizarDestino   
	   * @Description: metodo para actualizar destino 
	 * @param: @param destinoDTO
	 * @param: @throws SQLException      
	 * @return: void      
	 * @throws
	 */
	public Destino actualizarDestino(DestinoDTO destinoDTO) throws Exception;

	/**
	 * 
	 * @Title: eliminarDestino   
	   * @Description: Metodo para eliminar destino 
	 * @param: @param destinoDTO      
	 * @return: void      
	 * @throws
	 */
	public void eliminarDestino(Long idDest) throws Exception;
}
