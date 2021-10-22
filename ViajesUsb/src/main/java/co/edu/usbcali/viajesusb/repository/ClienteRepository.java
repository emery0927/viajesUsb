/**  
 * @Title:  ClienteRepository.java   
 * @Package co.edu.usbcali.viajesusb.repository   
 * @Description: description   
 * @author: Emery Estupiñan     
 * @date:   6/09/2021 2:44:39 p. m.   
 * @version V1.0 
 * @Copyright: Universidad San de Buenaventura
 */
package co.edu.usbcali.viajesusb.repository;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.edu.usbcali.viajesusb.domain.Cliente;
import co.edu.usbcali.viajesusb.dto.ClienteDTO;

/**   
 * @ClassName:  ClienteRepository   
  * @Description: TODO   
 * @author: Emery Estupiñan     
 * @date:   4/09/2021 2:44:39 p. m.      
 * @Copyright:  USB
 */
public interface ClienteRepository extends JpaRepository<Cliente,Long> {
	
	/**
	 * 
	 * @Title: findByEstadoOrderByNumeroIdentificacion   
	   * @Description: consultar clientes por estado de forma ascendente y paginada
	 * @param: @param estado
	 * @param: @param pageable
	 * @param: @return
	 * @param: @throws SQLException      
	 * @return: Page<Cliente>      
	 * @throws
	 */
	public Page<Cliente> findByEstadoOrderByNumeroIdentificacion(String estado, Pageable pageable) throws SQLException;
	
	/**
	 * 
	 * @Title: findByCorreoIgnoreCase   
	   * @Description: consultar un cliente por correo ignorando mayusculas y minusculas 
	 * @param: @param correo
	 * @param: @return
	 * @param: @throws SQLException      
	 * @return: Cliente      
	 * @throws
	 */
	public Cliente findByCorreoIgnoreCase(String correo) throws SQLException;
	
	/**
	 * 
	 * @Title: findByNumeroIdentificacionLike   
	   * @Description: consultar un cliente por numero de identificacion usando like 
	 * @param: @param numeroIdentificaion
	 * @param: @return
	 * @param: @throws SQLException      
	 * @return: Cliente      
	 * @throws
	 */
	public Cliente findByNumeroIdentificacionLike(String numeroIdentificacion) throws SQLException;
	
	/**
	 * 
	 * @Title: findByNombreIgnoreCaseLike   
	   * @Description: consultar un cliente por nombre ignorando mayusculas y minusculas usando like 
	 * @param: @param numeroIdentificaion
	 * @param: @return
	 * @param: @throws SQLException      
	 * @return: Cliente      
	 * @throws
	 */
	public Cliente findByNombreIgnoreCaseLike(String nombre) throws SQLException;
	
	/**
	 * 
	 * @Title: findByFechaNacimientoBetween   
	   * @Description: consultar clientes por fecha de nacimiento en un rango de fechas  
	 * @param: @param fechaUno
	 * @param: @param fechaDos
	 * @param: @return
	 * @param: @throws SQLException      
	 * @return: List<Cliente>      
	 * @throws
	 */
	public List<Cliente> findByFechaNacimientoBetween(Date fechaUno, Date fechaDos) throws SQLException;
	
	/**
	 * 
	 * @Title: countByEstado   
	   * @Description: calcular el total de clientes por estado 
	 * @param: @param estado
	 * @param: @return
	 * @param: @throws SQLException      
	 * @return: Cliente      
	 * @throws
	 */
	public Long countByEstado(String estado) throws SQLException;
	
	/**
	 * 
	 * @Title: findByTipoIdentificacion   
	   * @Description: consultar clientes por tipo de identificacion paginada
	 * @param: @param tipoIdentificacion
	 * @param: @param pageable
	 * @param: @return
	 * @param: @throws SQLException      
	 * @return: Page<Cliente>      
	 * @throws
	 */
	public Page<Cliente> findByTipoIdentificacion_Codigo(String tipoIdentificacion, Pageable pageable) throws SQLException;
	
	/**
	 * 
	 * @Title: findByPrimerApellidoOrSegundoApellido   
	   * @Description: consultar clientes por primer apellido o por seguundo apellido 
	 * @param: @return
	 * @param: @throws SQLException      
	 * @return: List<Cliente>      
	 * @throws
	 */
	public List<Cliente> findByPrimerApellidoOrSegundoApellido(String primerApellido, String segundoApellido) throws SQLException;
	
	
	/**
	 * 
	 * @Title: consultarClientesPorEstadoNoIdentificacionTipoIdentificacion   
	   * @Description: consultar clientes por filtro de estado, numero de identificacion y nombre usando like 
	 * @param: @param estado
	 * @param: @param numeroIdentificacion
	 * @param: @param nombre
	 * @param: @return
	 * @param: @throws SQLException      
	 * @return: List<ClienteDTO>      
	 * @throws
	 */
	@Query(nativeQuery = true)
    public List<ClienteDTO> consultarClientesPorEstadoNumeroIdentificacionTipoIdentificacion(@Param("pEstado") String estado, 
    		@Param("pNumeroIdentificacion") String numeroIdentificacion, @Param("pNombre")String nombre) throws SQLException;

}
