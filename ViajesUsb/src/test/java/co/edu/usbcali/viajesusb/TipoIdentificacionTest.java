/**  
 * @Title:  TipoIdentificacionTest.java   
 * @Package co.edu.usbcali.viajesusb   
 * @Description: description   
 * @author: Emery Estupiñan     
 * @date:   6/09/2021 2:54:56 p. m.   
 * @version V1.0 
 * @Copyright: Universidad San de Buenaventura
 */
package co.edu.usbcali.viajesusb;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import co.edu.usbcali.viajesusb.domain.TipoIdentificacion;
import co.edu.usbcali.viajesusb.dto.TipoIdentificacionDTO;
import co.edu.usbcali.viajesusb.service.TipoIdentificacionService;
import co.edu.usbcali.viajesusb.utils.Constantes;

/**   
 * @ClassName:  TipoIdentificacionTest   
  * @Description: TODO   
 * @author: Emery Estupiñan     
 * @date:   4/09/2021 2:54:56 p. m.      
 * @Copyright:  USB
 */
@SpringBootTest
class TipoIdentificacionTest {
	
	@Autowired
	private TipoIdentificacionService tipoIdentificacionService;

	@Test
	@Transactional
	void debeConsultarUnTipoDeIdentificacionPorEstadoOrdenadosAlfabeticamente() throws Exception {
		
		List<TipoIdentificacion> lstTipoIdentificacion = null;
		
		try {
			lstTipoIdentificacion = tipoIdentificacionService.findByEstadoOrderByNombre("A");
			for(TipoIdentificacion tipoIdentificacion : lstTipoIdentificacion) {
				System.out.println(tipoIdentificacion.getNombre());
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	@Transactional
	void debeConsultarUnTipoDeIdentificacionPorCodigoYEstado() throws Exception {
		
		TipoIdentificacion tipoIdentificacion = null;
		
		try {
			tipoIdentificacion = tipoIdentificacionService.findByCodigoAndEstado("CC","A");
			System.out.println(tipoIdentificacion.getCodigo()+"-"+tipoIdentificacion.getNombre());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	@Transactional
	void debeGuardarElTipoIdentificacion() {
		
		try {
			
		TipoIdentificacionDTO tipoIdentifcacionDTO = new TipoIdentificacionDTO();
		
		tipoIdentifcacionDTO.setCodigo("LC");
		tipoIdentifcacionDTO.setNombre("LICENCIA CONDUCCION");
		tipoIdentifcacionDTO.setFechaCreacion(new Date());
		tipoIdentifcacionDTO.setUsuCreador("CLOPEZ");
		tipoIdentifcacionDTO.setEstado(Constantes.ACTIVO);
				
		tipoIdentificacionService.guardarTipoIdentificacion(tipoIdentifcacionDTO);
		
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	@Transactional
	void debeActualizarElTipoIdentificacion() {
		
		try {
			
		TipoIdentificacionDTO tipoIdentifcacionDTO = new TipoIdentificacionDTO();
		
		tipoIdentifcacionDTO.setIdTiid(1L);
		tipoIdentifcacionDTO.setCodigo("CC");
		tipoIdentifcacionDTO.setNombre("CEDULA CIUDADANIAF");
		tipoIdentifcacionDTO.setFechaCreacion(new Date());
		tipoIdentifcacionDTO.setUsuCreador("CLOPEZ");
		tipoIdentifcacionDTO.setEstado(Constantes.ACTIVO);
				
		tipoIdentificacionService.guardarTipoIdentificacion(tipoIdentifcacionDTO);
		
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	@Transactional
	void debeEliminarElTipoIdentificacion() {

		try {

			TipoIdentificacionDTO tipoIdentifcacionDTO = new TipoIdentificacionDTO();
			tipoIdentifcacionDTO.setIdTiid(1L);
			tipoIdentificacionService.eliminarTipoIdentificacion(tipoIdentifcacionDTO.getIdTiid());
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
