/**  
 * @Title:  DestinoMapper.java   
 * @Package co.edu.usbcali.viajesusb.mapper   
 * @Description: description   
 * @author: Emery Estupiñan     
 * @date:   18/10/2021 5:08:33 p. m.   
 * @version V1.0 
 * @Copyright: Universidad San de Buenaventura
 */
package co.edu.usbcali.viajesusb.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import co.edu.usbcali.viajesusb.domain.Destino;
import co.edu.usbcali.viajesusb.domain.TipoDestino;
import co.edu.usbcali.viajesusb.dto.DestinoDTO;
import co.edu.usbcali.viajesusb.dto.TipoDestinoDTO;

/**   
 * @ClassName:  DestinoMapper   
  * @Description: TODO   
 * @author: Emery Estupiñan     
 * @date:   18/10/2021 5:08:33 p. m.      
 * @Copyright:  USB
 */
@Mapper(componentModel = "spring")
public interface DestinoMapper {
	
	@Mapping(source = "tipoDestino.nombre", target = "nombreTipoDestino")
	@Mapping(source = "tipoDestino.codigo", target = "codigoTipoDestino")
	@Mapping(source = "tipoDestino.idTide", target = "idTide")
	public DestinoDTO destinoToDestinoDTO(Destino destino);
	
	public List<DestinoDTO> listDestinoToDestinoDTO(List<Destino> lstDestino);

}
