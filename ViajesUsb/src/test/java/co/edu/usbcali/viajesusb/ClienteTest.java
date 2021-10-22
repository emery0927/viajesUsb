/**  
 * @Title:  ClienteTest.java   
 * @Package co.edu.usbcali.viajesusb   
 * @Description: description   
 * @author: Emery Estupiñan     
 * @date:   6/09/2021 2:54:39 p. m.   
 * @version V1.0 
 * @Copyright: Universidad San de Buenaventura
 */
package co.edu.usbcali.viajesusb;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import co.edu.usbcali.viajesusb.domain.Cliente;
import co.edu.usbcali.viajesusb.domain.TipoDestino;
import co.edu.usbcali.viajesusb.domain.TipoIdentificacion;
import co.edu.usbcali.viajesusb.dto.ClienteDTO;
import co.edu.usbcali.viajesusb.dto.DestinoDTO;
import co.edu.usbcali.viajesusb.repository.ClienteRepository;
import co.edu.usbcali.viajesusb.repository.TipoIdentificacionRepository;
import co.edu.usbcali.viajesusb.service.ClienteService;
import co.edu.usbcali.viajesusb.utils.Constantes;

/**   
 * @ClassName:  ClienteTest   
  * @Description: TODO   
 * @author: Emery Estupiñan     
 * @date:   4/09/2021 2:54:39 p. m.      
 * @Copyright:  USB
 */
@SpringBootTest
@Rollback(false)
class ClienteTest {

	@Autowired
	private ClienteService clienteService;

	@Test
	@Transactional
	void debeConsultarUnClientePorEstadoOrdenadosDeFormaAscendentePorNumeroDeIdentificacion() throws Exception {
		
		Page<Cliente> pageCliente = null;
		
		try {
			Pageable pageable = PageRequest.of(0,6);
			pageCliente = clienteService.findByEstadoOrderByNumeroIdentificacion("A", pageable);
			
			for(Cliente cliente : pageCliente.getContent()) {
				System.out.println(cliente.getNumeroIdentificacion()+"-"+cliente.getNombre());
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	@Transactional
	void debeConsultarUnClientePorCorreoElectronicoIgnorandoMayusculasYMinusculas() throws Exception {
		
		Cliente cliente = null;
		
		try {
			cliente = clienteService.findByCorreoIgnoreCase("emeryesro2008");
			System.out.println(cliente.getNombre()+"-"+cliente.getNumeroIdentificacion()+"-"+cliente.getCorreo());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	@Transactional
	void debeConsultarUnClientePorNumeroIdentificacionConLike() throws Exception {
		
		Cliente cliente = null;
		
		try {
			cliente = clienteService.findByNumeroIdentificacionLike("1192912013");
			System.out.println(cliente.getNombre()+"-"+cliente.getNumeroIdentificacion());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	@Transactional
	void debeConsultarUnClientePorNombreIgnorandoMayusculasConLike() throws Exception {
		
		Cliente cliente = null;
		
		try {
			cliente = clienteService.findByNombreIgnoreCaseLike("%eMERY%");
			System.out.println(cliente.getNombre()+"-"+cliente.getPrimerApellido());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	@Transactional
	void debeConsultarUnClientePorRangoDeFecha() throws Exception {
		
		List<Cliente> lstCliente = null;
		Calendar fechaUno = new GregorianCalendar(1979,01,01);
		Calendar fechaDos = new GregorianCalendar(2021,12,31);
		
		try {
			lstCliente = clienteService.findByFechaNacimientoBetween(fechaUno.getTime(),fechaDos.getTime());
			for(Cliente cliente : lstCliente) {
				System.out.println(cliente.getIdClie()+"-"+cliente.getNombre()+"-"+cliente.getPrimerApellido()+"-"+cliente.getFechaNacimiento());
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	@Transactional
	void debeCalcularElTotalDeClientesPorEstado() throws Exception {
		
		Long cliente;
		
		try {
			cliente = clienteService.countByEstado("I");
			System.out.println("Total clientes: " + cliente);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	@Transactional
	void debeConsultarUnClientePorNumeroDeIdentificacion() throws Exception {
		
		Page<Cliente> pageCliente = null;
		
		try {
			Pageable pageable = PageRequest.of(0,5);
			pageCliente = clienteService.findByTipoIdentificacionCodigo("CCC", pageable);
			
			for(Cliente cliente : pageCliente.getContent()) {
				System.out.println(cliente.getNumeroIdentificacion()+"-"+cliente.getNombre()+"-"+cliente.getTipoIdentificacion());
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	@Transactional
	void debeConsultarUnClientePorPrimerApellidoOSegundoApellido() throws Exception {
		
		List<Cliente> lstCliente = null;
		
		try {
			lstCliente = clienteService.findByPrimerApellidoOrSegundoApellido("ESTUPIÑAN","RODRIGUEZ");
			for(Cliente cliente : lstCliente) {
				System.out.println(cliente.getIdClie()+"-"+cliente.getNombre()+"-"+cliente.getPrimerApellido()+"-"+cliente.getSegundoApellido());
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
    @Transactional
    void debeConsultarClientePorEstadoPorNumeroIdentificacionPorTipoIdentificacionYPorNombre() throws Exception {

        List<ClienteDTO> lstCliente = null;

        try {
            lstCliente = clienteService.consultarClientesPorEstadoNumeroIdentificacionTipoIdentificacion("A", "1192912013", "123");
            for (ClienteDTO cliente : lstCliente) {
                System.out.println(cliente.getNombre());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
	
	@Test
	@Transactional
	void debeGuardarElCliente() {

		try {
			Calendar fechaNacimiento = new GregorianCalendar(1980,05,23);

			ClienteDTO clienteDTO = new ClienteDTO();
			
			clienteDTO.setNumeroIdentificacion("123456789");
			clienteDTO.setPrimerApellido("GARCIA");
			clienteDTO.setSegundoApellido(null);
			clienteDTO.setNombre("GUILLERMO");
			clienteDTO.setTelefono1("3153589652");
			clienteDTO.setCorreo("guigj25@hotmail.com");
			clienteDTO.setSexo(Constantes.MASCULINO);
			clienteDTO.setFechaNacimiento(fechaNacimiento.getTime());
			clienteDTO.setFechaCreacion(Constantes.FECHA_ACTUAL);
			clienteDTO.setUsuCreador("CLOPEZ");
			clienteDTO.setEstado(Constantes.ACTIVO);
			
			clienteDTO.setCodigoTipoIdentificacion("CC");
			clienteDTO.setNombreTipoIdentificacion("CEDULA CIUDADANIA");

			clienteService.guardarCliente(clienteDTO);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
	
	@Test
	@Transactional
	void debeActualizarElCliente() {

		try {
			
			Calendar fechaNacimiento = new GregorianCalendar(1980,05,23);

			ClienteDTO clienteDTO = new ClienteDTO();
			
			clienteDTO.setIdClie(9L);
			clienteDTO.setNumeroIdentificacion("1192912013");
			clienteDTO.setPrimerApellido("ESTUPIÑANN");
			clienteDTO.setSegundoApellido("RODRIGUEZ");
			clienteDTO.setNombre("EMERY");
			clienteDTO.setTelefono1("3106360320");
			clienteDTO.setCorreo("emeryesro2008@hotmail.com");
			clienteDTO.setSexo(Constantes.MASCULINO);
			clienteDTO.setFechaNacimiento(fechaNacimiento.getTime());
			clienteDTO.setFechaCreacion(Constantes.FECHA_ACTUAL);
			clienteDTO.setUsuCreador("CLOPEZ");
			clienteDTO.setEstado(Constantes.ACTIVO);
			
			clienteDTO.setCodigoTipoIdentificacion("CC");
			clienteDTO.setNombreTipoIdentificacion("CEDULA CIUDADANIA");

			clienteService.actualizarCliente(clienteDTO);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
	
	@Test
	@Transactional
	void debeEliminarElCliente() {

		try {

			ClienteDTO clienteDTO = new ClienteDTO();
			clienteDTO.setIdClie(9L);
			clienteService.eliminarCliente(clienteDTO.getIdClie());
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}



}
