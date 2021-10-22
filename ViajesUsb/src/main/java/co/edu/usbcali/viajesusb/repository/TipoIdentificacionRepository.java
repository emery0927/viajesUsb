/**  
 * @Title:  TipoIdentificacionRepository.java   
 * @Package co.edu.usbcali.viajesusb.repository   
 * @Description: description   
 * @author: Emery Estupiñan     
 * @date:   6/09/2021 2:45:43 p. m.   
 * @version V1.0 
 * @Copyright: Universidad San de Buenaventura
 */
package co.edu.usbcali.viajesusb.repository;

import java.sql.SQLException;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.usbcali.viajesusb.domain.TipoIdentificacion;

/**   
 * @ClassName:  TipoIdentificacionRepository   
  * @Description: TODO   
 * @author: Emery Estupiñan     
 * @date:   4/09/2021 2:45:43 p. m.      
 * @Copyright:  USB
 */
public interface TipoIdentificacionRepository extends JpaRepository<TipoIdentificacion,Long> {
	
	/**
	 * 
	 * @Title: findByEstadoOrderByNombre   
	   * @Description: consulta los tipos de identificacion por estado ordenados alfabeticamente 
	 * @param: @param estado
	 * @param: @return
	 * @param: @throws SQLException      
	 * @return: List<TipoIdentificacionMapper>      
	 * @throws
	 */
	public List<TipoIdentificacion> findByEstadoOrderByNombre(String estado) throws SQLException;
	
	
	/**
	 * 
	 * @Title: findByCodigoAndEstado   
	   * @Description: consulta tipo de identificacion por codigo y estado 
	 * @param: @param codigo
	 * @param: @param estado
	 * @param: @return
	 * @param: @throws SQLException      
	 * @return: TipoIdentificacionMapper      
	 * @throws
	 */
	public TipoIdentificacion findByCodigoAndEstado(String codigo, String estado) throws SQLException;

}
