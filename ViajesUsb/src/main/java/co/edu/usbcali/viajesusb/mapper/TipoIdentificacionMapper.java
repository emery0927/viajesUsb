/**  
 * @Title:  TipoIdentificacionMapper.java   
 * @Package co.edu.usbcali.viajesusb.mapper   
 * @Description: description   
 * @author: Emery Estupiñan     
 * @date:   18/10/2021 11:03:39 p. m.   
 * @version V1.0 
 * @Copyright: Universidad San de Buenaventura
 */
package co.edu.usbcali.viajesusb.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import co.edu.usbcali.viajesusb.domain.TipoIdentificacion;
import co.edu.usbcali.viajesusb.dto.TipoIdentificacionDTO;


/**
 * @ClassName: TipoIdentificacionMapper
 * @Description: TODO
 * @author: Emery Estupiñan
 * @date: 18/10/2021 11:03:39 p. m.
 * @Copyright: USB
 */
@Mapper(componentModel = "spring")
public interface TipoIdentificacionMapper {

	public TipoIdentificacionDTO tipoidentificacionToTipoIdentificacionDTO(TipoIdentificacion tipoIdentificacion);

	public TipoIdentificacion tipoIdentifcacionDTOToTipoIdentificacion(TipoIdentificacionDTO tipoIdentifcacionDTO);

	public List<TipoIdentificacionDTO> listTipoIdentificacionToTipoIdentificacionDTO(List<TipoIdentificacion> lstTipoIdentificacion);

	public List<TipoIdentificacion> listTipoDestinoDTOToTipoDestino(List<TipoIdentificacionDTO> lstTipoIdentificacionDTO);

}
