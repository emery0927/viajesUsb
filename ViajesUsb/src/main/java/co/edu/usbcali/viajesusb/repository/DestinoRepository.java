/**  
 * @Title:  DestinoRepository.java   
 * @Package co.edu.usbcali.viajesusb.repository   
 * @Description: description   
 * @author: Emery Estupiñan     
 * @date:   6/09/2021 10:19:47 a. m.   
 * @version V1.0 
 * @Copyright: Universidad San de Buenaventura
 */
package co.edu.usbcali.viajesusb.repository;

import java.sql.SQLException;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.usbcali.viajesusb.domain.Destino;

/**   
 * @ClassName:  DestinoRepository   
  * @Description: TODO   
 * @author: Emery Estupiñan     
 * @date:   4/09/2021 10:19:47 a. m.      
 * @Copyright:  USB
 */
public interface DestinoRepository extends JpaRepository<Destino,Long> {
	
	/**
	 * 
	 * @Title: findByTipoDestino_Codigo   
	   * @Description: todos los destinos que pertenecen a un tipo de destino el list es porque son va a enviar varios 
	 * @param: @param codigoTipoDestino
	 * @param: @return
	 * @param: @throws SQLException      
	 * @return: List<Destino>      
	 * @throws
	 */
	public List<Destino> findByTipoDestino_Codigo(String codigoTipoDestino) throws SQLException;
	
	/**
	 * 
	 * @Title: findByEstado   
	   * @Description: Retorna una pagina de la lista de destinos por estado 
	 * @param: @param estado
	 * @param: @param pageable
	 * @param: @return
	 * @param: @throws SQLException      
	 * @return: Page<Destino>      
	 * @throws
	 */
	public Page<Destino> findByEstado(String estado, Pageable pageable) throws SQLException;
	
	

}
