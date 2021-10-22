/**  
 * @Title:  TipoIdentificacionService.java   
 * @Package co.edu.usbcali.viajesusb.service   
 * @Description: description   
 * @author: Emery Estupiñan     
 * @date:   20/09/2021 9:21:02 p. m.   
 * @version V1.0 
 * @Copyright: Universidad San de Buenaventura
 */
package co.edu.usbcali.viajesusb.service;

import java.util.List;

import co.edu.usbcali.viajesusb.domain.TipoIdentificacion;
import co.edu.usbcali.viajesusb.dto.TipoIdentificacionDTO;

/**   
 * @ClassName:  TipoIdentificacionService   
  * @Description: TODO   
 * @author: Emery Estupiñan     
 * @date:   20/09/2021 9:21:02 p. m.      
 * @Copyright:  USB
 */
public interface TipoIdentificacionService {
	
	/**
	 * 
	 * @Title: findByEstadoOrderByNombre   
	   * @Description: TODO 
	 * @param: @param estado
	 * @param: @return
	 * @param: @throws SQLException      
	 * @return: List<TipoIdentificacionMapper>      
	 * @throws
	 */
	public List<TipoIdentificacion> findByEstadoOrderByNombre(String estado) throws Exception;
	
	/**
	 * 
	 * @Title: findByCodigoAndEstado   
	   * @Description: TODO 
	 * @param: @param codigo
	 * @param: @param estado
	 * @param: @return
	 * @param: @throws SQLException      
	 * @return: TipoIdentificacionMapper      
	 * @throws
	 */
	public TipoIdentificacion findByCodigoAndEstado(String codigo, String estado) throws Exception;
	
	/**
	 * 
	 * @Title: guardarTipoIdentificacion   
	   * @Description: Metodo que guarda un cliente 
	 * @param: @param tipoIdentificacionDTO
	 * @param: @throws SQLException      
	 * @return: void      
	 * @throws
	 */
	public TipoIdentificacion guardarTipoIdentificacion(TipoIdentificacionDTO tipoIdentificacionDTO) throws Exception;
	
	/**
	 * 
	 * @Title: actualizarTipoIdentificacion   
	   * @Description: Metodo que actualiza un tipo identificacion 
	 * @param: @param tipoIdentificacionDTO
	 * @param: @throws SQLException      
	 * @return: void      
	 * @throws
	 */
	public TipoIdentificacion actualizarTipoIdentificacion(TipoIdentificacionDTO tipoIdentificacionDTO) throws Exception;

	/**
	 * 
	 * @Title: eliminarTipoIdentificacion   
	   * @Description: Metodo que elimina un tipo identifcacion 
	 * @param: @param tipoIdentificacionDTO
	 * @param: @throws SQLException      
	 * @return: void      
	 * @throws
	 */
	public void eliminarTipoIdentificacion(Long id) throws Exception;
	
}
