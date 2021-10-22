/**  
 * @Title:  ClienteService.java   
 * @Package co.edu.usbcali.viajesusb.service   
 * @Description: description   
 * @author: Emery Estupiñan     
 * @date:   20/09/2021 9:19:25 p. m.   
 * @version V1.0 
 * @Copyright: Universidad San de Buenaventura
 */
package co.edu.usbcali.viajesusb.service;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.edu.usbcali.viajesusb.domain.Cliente;
import co.edu.usbcali.viajesusb.dto.ClienteDTO;

/**   
 * @ClassName:  ClienteService   
  * @Description: TODO   
 * @author: Emery Estupiñan     
 * @date:   20/09/2021 9:19:25 p. m.      
 * @Copyright:  USB
 */
public interface ClienteService {
	
	/**
	 * 
	 * @Title: findByEstadoOrderByNumeroIdentificacion   
	   * @Description: TODO 
	 * @param: @param estado
	 * @param: @param pageable
	 * @param: @return
	 * @param: @throws SQLException      
	 * @return: Page<Cliente>      
	 * @throws
	 */
	public Page<Cliente> findByEstadoOrderByNumeroIdentificacion(String estado, Pageable pageable) throws Exception;
	
	/**
	 * 
	 * @Title: findByCorreoIgnoreCase   
	   * @Description: TODO 
	 * @param: @param correo
	 * @param: @return
	 * @param: @throws SQLException      
	 * @return: Cliente      
	 * @throws
	 */
	public Cliente findByCorreoIgnoreCase(String correo) throws Exception;
	
	/**
	 * 
	 * @Title: findByNumeroIdentificacionLike   
	   * @Description: TODO 
	 * @param: @param numeroIdentificaion
	 * @param: @return
	 * @param: @throws SQLException      
	 * @return: Cliente      
	 * @throws
	 */
	public Cliente findByNumeroIdentificacionLike(String numeroIdentificacion) throws Exception;
	
	/**
	 * 
	 * @Title: findByNombreIgnoreCaseLike   
	   * @Description: TODO 
	 * @param: @param nomobre
	 * @param: @return
	 * @param: @throws SQLException      
	 * @return: Cliente      
	 * @throws
	 */
	public Cliente findByNombreIgnoreCaseLike(String nombre) throws Exception;
	
	/**
	 * 
	 * @Title: findByFechaNacimientoBetween   
	   * @Description: TODO 
	 * @param: @param fechaUno
	 * @param: @param fechaDos
	 * @param: @return
	 * @param: @throws SQLException      
	 * @return: List<Cliente>      
	 * @throws
	 */
	public List<Cliente> findByFechaNacimientoBetween(Date fechaUno, Date fechaDos) throws Exception;
	
	/**
	 * 
	 * @Title: countByEstado   
	   * @Description: TODO 
	 * @param: @param estado
	 * @param: @return
	 * @param: @throws SQLException      
	 * @return: Long      
	 * @throws
	 */
	public Long countByEstado(String estado) throws Exception;
	
	/**
	 * 
	 * @Title: findByTipoIdentificacion_Codigo   
	   * @Description: TODO 
	 * @param: @param tipoIdentificacion
	 * @param: @param pageable
	 * @param: @return
	 * @param: @throws SQLException      
	 * @return: Page<Cliente>      
	 * @throws
	 */
	public Page<Cliente> findByTipoIdentificacionCodigo(String tipoIdentificacion, Pageable pageable) throws Exception;
	
	/**
	 * 
	 * @Title: findByPrimerApellidoOrSegundoApellido   
	   * @Description: TODO 
	 * @param: @param primerApellido
	 * @param: @param segundoApellido
	 * @param: @return
	 * @param: @throws SQLException      
	 * @return: List<Cliente>      
	 * @throws
	 */
	public List<Cliente> findByPrimerApellidoOrSegundoApellido(String primerApellido, String segundoApellido) throws Exception;
	
	/**
	 * 
	 * @Title: consultarClientesPorEstadoNumeroIdentificacionTipoIdentificacion   
	   * @Description: TODO 
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
    		@Param("pNumeroIdentificacion") String numeroIdentificacion, @Param("pNombre")String nombre) throws Exception;
	

	/**
	 * 
	 * @Title: guardarCliente   
	   * @Description: Metodo que guarda un nuevo cliente 
	 * @param: @param clienteDTO
	 * @param: @throws SQLException      
	 * @return: void      
	 * @throws
	 */
	public Cliente guardarCliente(ClienteDTO clienteDTO) throws Exception;
	
	
	/**
	 * 
	 * @Title: actualizarTipoIdentificacion   
	   * @Description: Metodo que actualiza cliente 
	 * @param: @param clienteDTO
	 * @param: @throws SQLException      
	 * @return: void      
	 * @throws
	 */
	public Cliente actualizarCliente(ClienteDTO clienteDTO) throws Exception;
	
	/**
	 * 
	 * @Title: eliminarCliente   
	   * @Description: Metodo que elimina un cliente 
	 * @param: @param clienteDTO
	 * @param: @throws SQLException      
	 * @return: void      
	 * @throws
	 */
	public void eliminarCliente(Long id) throws Exception;
	

}
