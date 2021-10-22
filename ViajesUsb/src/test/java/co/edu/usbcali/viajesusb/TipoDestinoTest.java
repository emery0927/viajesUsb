/**  
 * @Title:  TipoDestinoTest.java   
 * @Package co.edu.usbcali.viajesusb   
 * @Description: description   
 * @author: Emery Estupiñan     
 * @date:   6/09/2021 11:05:45 a. m.   
 * @version V1.0 
 * @Copyright: Universidad San de Buenaventura
 */
package co.edu.usbcali.viajesusb;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import co.edu.usbcali.viajesusb.domain.TipoDestino;
import co.edu.usbcali.viajesusb.dto.DestinoDTO;
import co.edu.usbcali.viajesusb.dto.TipoDestinoDTO;
import co.edu.usbcali.viajesusb.service.TipoDestinoService;
import co.edu.usbcali.viajesusb.utils.Constantes;

/**   
 * @ClassName:  TipoDestinoTest   
  * @Description: TODO   
 * @author: Emery Estupiñan     
 * @date:   4/09/2021 11:05:45 a. m.      
 * @Copyright:  USB
 */
@SpringBootTest
@Rollback(false)
class TipoDestinoTest {
	
	@Autowired
	private TipoDestinoService tipoDestinoService;

	@Test
	@Transactional
	void debeConsultarUnTipoDeDestinoPorCodigo() throws Exception {
		
		TipoDestino tipoDestino = null;
		
		try {
			tipoDestino = tipoDestinoService.findByCodigo(null);
			System.out.println(tipoDestino.toString());
		} catch (SQLException e) {
			e.printStackTrace();
			}
	}
	
	@Test
	@Transactional
	void debeConsultarUnTipoDeDestinoPorCodigoEstado() throws Exception {
		
		TipoDestino tipoDestino = null;
		
		try {
			tipoDestino = tipoDestinoService.findByCodigoAndEstado("PLAYA","E");
			System.out.println(tipoDestino.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	@Transactional
	void debeConsultarUnTipoDeDestinoPorEstadoOrdenadosAlfabeticamente() throws Exception {
		
		List<TipoDestino> lstTipoDestino = null;
		
		try {
			lstTipoDestino = tipoDestinoService.findByEstadoOrderByNombre("A");
			for(TipoDestino tipoDestino : lstTipoDestino) {
				System.out.println(tipoDestino.getNombre());
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	@Transactional
	void debeGuardarElTipoDestino() {
		
		try {
			
		TipoDestinoDTO tipoDestinoDTO = new TipoDestinoDTO();
		
		tipoDestinoDTO.setCodigo("PALU");
		tipoDestinoDTO.setNombre("PAISAJES LUNARES");
		tipoDestinoDTO.setDescripcion("ÁREAS DE LOMAS ESCARPADAS Y ÁRIDAS QUE HACEN QUE EN EL ENTORNO SE DÉ UN PAISAJE PARECIDO AL DE LA LUNA.");
		tipoDestinoDTO.setFechaCreacion(new Date());
		tipoDestinoDTO.setUsuCreador("CLOPEZ");
		tipoDestinoDTO.setEstado(Constantes.ACTIVO);
		
		tipoDestinoService.guardarTipoDestino(tipoDestinoDTO);
		
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	@Transactional
	void debeActualizarElTipoDestino() {
		
		try {
			
		TipoDestinoDTO tipoDestinoDTO = new TipoDestinoDTO();
		
		tipoDestinoDTO.setIdTide(2L);
		tipoDestinoDTO.setCodigo("PLAYA");
		tipoDestinoDTO.setNombre("PLAYA Y MARr");
		tipoDestinoDTO.setDescripcion("DESTINO QUE CUENTA CON MAR, BRISA Y ARENA.");
		tipoDestinoDTO.setFechaCreacion(new Date());
		tipoDestinoDTO.setUsuCreador("CLOPEZ");
		tipoDestinoDTO.setEstado(Constantes.ACTIVO);
		
		tipoDestinoService.actualizarTipoDestino(tipoDestinoDTO);
		
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	@Transactional
	void debeEliminarElDestino() {

		try {

			TipoDestinoDTO tipoDestinoDTO = new TipoDestinoDTO();
			tipoDestinoDTO.setIdTide(1L);
			tipoDestinoService.eliminarTipoDestino(tipoDestinoDTO.getIdTide());
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}


}
