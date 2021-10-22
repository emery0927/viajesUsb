/**  
 * @Title:  DestinoTest.java   
 * @Package co.edu.usbcali.viajesusb   
 * @Description: description   
 * @author: Emery Estupiñan     
 * @date:   6/09/2021 11:20:50 a. m.   
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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import co.edu.usbcali.viajesusb.domain.Destino;
import co.edu.usbcali.viajesusb.dto.DestinoDTO;
import co.edu.usbcali.viajesusb.service.DestinoService;
import co.edu.usbcali.viajesusb.utils.Constantes;

/**
 * @ClassName: DestinoTest
 * @Description: TODO
 * @author: Emery Estupiñan
 * @date: 6/09/2021 11:20:50 a. m.
 * @Copyright: USB
 */
@SpringBootTest
@Rollback(false)
class DestinoTest {

	@Autowired
	private DestinoService destinoService;

	@Test
	@Transactional
	void debeConsultarDestinoPorTipoDestino() throws Exception {

		List<Destino> lstDestino = null;

		try {
			lstDestino = destinoService.findByTipoDestinoCodigo("123");
			for (Destino destino : lstDestino) {
				System.out.println(destino.getCodigo() + "-" + destino.getNombre());
				// H1:M18
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	@Transactional
	void debeConsultarDestinoSPorEstadosPaginado() throws Exception {

		Page<Destino> pageDestino = null;

		try {
			Pageable pageable = PageRequest.of(0, 2);
			pageDestino = destinoService.findByEstado("G", pageable);

			for (Destino destino : pageDestino.getContent()) {
				System.out.println(destino.getCodigo() + "-" + destino.getNombre());

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	@Transactional
	void debeGuardarElDestinoSanAndres() {

		try {

			DestinoDTO destinoDTO = new DestinoDTO();
			
			destinoDTO.setAire(Constantes.SI);
			destinoDTO.setTierra(Constantes.NO);
			destinoDTO.setMar(Constantes.SI);
			
			
			destinoDTO.setNombre("San Andrés");
			destinoDTO.setCodigo("SAND");
			destinoDTO.setDescripcion("San andrés islas");
			destinoDTO.setEstado(Constantes.ACTIVO);
			destinoDTO.setFechaCreacion(new Date());
			destinoDTO.setUsuCreador("CLOPEZ");

			destinoDTO.setCodigoTipoDestino("PLAYA");
			destinoDTO.setNombreTipoDestino("PLAYA Y MAR");

			destinoService.guardarDestino(destinoDTO);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
	
	@Test
	@Transactional
	void debeActualizarElDestinoSanAndres() {

		try {

			DestinoDTO destinoDTO = new DestinoDTO();
			
			destinoDTO.setIdDest(1L);
			destinoDTO.setAire(Constantes.SI);
			destinoDTO.setTierra(Constantes.NO);
			destinoDTO.setMar(Constantes.SI);
			
			
			destinoDTO.setNombre("San Andrés");
			destinoDTO.setCodigo("SAND");
			destinoDTO.setDescripcion("San andrés islas");
			destinoDTO.setEstado(Constantes.ACTIVO);
			destinoDTO.setFechaCreacion(new Date());
			destinoDTO.setUsuCreador("CLOPEZ");

			destinoDTO.setCodigoTipoDestino("PLAYA");
			destinoDTO.setNombreTipoDestino("PLAYA Y MAR");

			destinoService.actualizarDestino(destinoDTO);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
	
	@Test
	@Transactional
	void debeEliminarElDestinoSanAndres() {

		try {

			DestinoDTO destinoDTO = new DestinoDTO();
			destinoDTO.setIdDest(1L);
			destinoService.eliminarDestino(destinoDTO.getIdDest());
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
