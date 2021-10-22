/**  
 * @Title:  TipoIdentificacionDTO.java   
 * @Package co.edu.usbcali.viajesusb.dto   
 * @Description: description   
 * @author: Emery Estupiñan     
 * @date:   4/10/2021 2:00:27 p. m.   
 * @version V1.0 
 * @Copyright: Universidad San de Buenaventura
 */
package co.edu.usbcali.viajesusb.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.ToString;

/**   
 * @ClassName:  TipoIdentificacionDTO   
  * @Description: TODO   
 * @author: Emery Estupiñan     
 * @date:   4/10/2021 2:00:27 p. m.      
 * @Copyright:  USB
 */
@Data
public class TipoIdentificacionDTO implements Serializable {

	private static final long serialVersionUID = -5998412841994393121L;

	private Long idTiid;	
	private String codigo;	
	private String nombre;	
	private Date fechaCreacion;	
	private Date fechaModificacion;
	private String usuCreador;
	private String usuModificador;
	private String estado;
}
