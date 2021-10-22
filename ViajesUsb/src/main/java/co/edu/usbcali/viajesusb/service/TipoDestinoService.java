/**  
 * @Title:  TipoDestinoService.java   
 * @Package co.edu.usbcali.viajesusb.service   
 * @Description: description   
 * @author: Emery Estupiñan     
 * @date:   17/09/2021 3:11:08 p. m.   
 * @version V1.0 
 * @Copyright: Universidad San de Buenaventura
 */
package co.edu.usbcali.viajesusb.service;

import java.util.List;

import co.edu.usbcali.viajesusb.domain.TipoDestino;
import co.edu.usbcali.viajesusb.dto.TipoDestinoDTO;

/**   
 * @ClassName:  TipoDestinoService   
  * @Description: TODO   
 * @author: Emery Estupiñan     
 * @date:   17/09/2021 3:11:08 p. m.      
 * @Copyright:  USB
 */
public interface TipoDestinoService {
	
	/**
	 * 
	 * @Title: findByCodigo   
	   * @Description: Metodo que consulta un tipo destino por codigo 
	 * @param: @param codigo
	 * @param: @return
	 * @param: @throws SQLException      
	 * @return: TipoDestino      
	 * @throws
	 */
	public TipoDestino findByCodigo(String codigo) throws Exception;
	
	/**
	 * 
	 * @Title: findByCodigoAndEstado   
	   * @Description: Metodo que consulta un tipo destino por codigo y estado 
	 * @param: @param codigo
	 * @param: @param estado
	 * @param: @return
	 * @param: @throws SQLException      
	 * @return: TipoDestino      
	 * @throws
	 */
	public TipoDestino findByCodigoAndEstado(String codigo, String estado) throws Exception;
	
	/**
	 * 
	 * @Title: findByEstadoOrderByNombre   
	   * @Description: Metodo que consulta un tipo destino por estado ordenado por nombre 
	 * @param: @param estado
	 * @param: @return
	 * @param: @throws SQLException      
	 * @return: List<TipoDestino>      
	 * @throws
	 */
	public List<TipoDestino> findByEstadoOrderByNombre(String estado) throws Exception;
	
	/**
	 * 
	 * @Title: guardarTipoDestino   
	   * @Description: Metodo que guarda un tipo de destino 
	 * @param: @param tipoDestinoDTO
	 * @param: @throws SQLException      
	 * @return: void      
	 * @throws
	 */
	public TipoDestino guardarTipoDestino(TipoDestinoDTO tipoDestinoDTO) throws Exception;

	/**
	 * 
	 * @Title: actualizarTipoDestino   
	   * @Description: Metodo que actualiza un tipo destino 
	 * @param: @param tipoDestinoDTO
	 * @param: @throws SQLException      
	 * @return: void      
	 * @throws
	 */
	public TipoDestino actualizarTipoDestino(TipoDestinoDTO tipoDestinoDTO) throws Exception;
	
	/**
	 * 
	 * @Title: eliminarTipoDestino   
	   * @Description: TODO 
	 * @param: @param tipoDestinoDTO
	 * @param: @throws SQLException      
	 * @return: void      
	 * @throws
	 */
	public void eliminarTipoDestino(Long id) throws Exception;
}
