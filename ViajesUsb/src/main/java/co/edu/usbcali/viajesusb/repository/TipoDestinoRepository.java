package co.edu.usbcali.viajesusb.repository;

import java.sql.SQLException;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.usbcali.viajesusb.domain.TipoDestino;

/**   
 * @ClassName:  TipoDestinoRepository   
  * @Description: TODO   
 * @author: Emery Estupiñan     
 * @date:   4/09/2021 10:22:18 a. m.      
 * @Copyright:  USB
 */
public interface TipoDestinoRepository extends JpaRepository<TipoDestino,Long>{
	
	/**
	 * 
	 * @Title: findByCodigo   
	   * @Description: consulta un tipo destino por codigo 
	 * @param: @param codigo
	 * @param: @return
	 * @param: @throws SQLException      
	 * @return: TipoDestino      
	 * @throws
	 */
	public TipoDestino findByCodigo(String codigo) throws SQLException;
	
	/**
	 * 
	 * @Title: findByCodigoAndEstado   
	   * @Description: consulta tipo destino por codigo y estado  
	 * @param: @param codigo
	 * @param: @param estado
	 * @param: @return
	 * @param: @throws SQLException      
	 * @return: TipoDestino      
	 * @throws
	 */
	public TipoDestino findByCodigoAndEstado(String codigo, String estado) throws SQLException;
	
	/**
	 * 
	 * @Title: findByEstadoOrderByNombre   
	   * @Description: consultar tipo destino por estado 
	 * @param: @param estado
	 * @param: @return
	 * @param: @throws SQLException      
	 * @return: List<TipoDestino>      
	 * @throws
	 */
	public List<TipoDestino> findByEstadoOrderByNombre(String estado) throws SQLException;
	

}
