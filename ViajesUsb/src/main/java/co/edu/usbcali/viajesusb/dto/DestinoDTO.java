/**  
 * @Title:  DestinoDTO.java   
 * @Package co.edu.usbcali.viajesusb.dto   
 * @Description: description   
 * @author: Emery Estupiñan     
 * @date:   28/09/2021 11:14:44 a. m.   
 * @version V1.0 
 * @Copyright: Universidad San de Buenaventura
 */
package co.edu.usbcali.viajesusb.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import co.edu.usbcali.viajesusb.domain.TipoDestino;
import lombok.Data;
import lombok.ToString;

/**   
 * @ClassName:  DestinoDTO   
  * @Description: TODO   
 * @author: Emery Estupiñan     
 * @date:   28/09/2021 11:14:44 a. m.      
 * @Copyright:  USB
 */
@Data
public class DestinoDTO implements Serializable{

	private static final long serialVersionUID = 1788451459550469775L;
	
	private Long idDest;
	private String codigo;	
	private String nombre;	
	private String descripcion;	
	private String tierra;	
	private String aire;	
	private String mar;	
	private Date fechaCreacion;	
	private Date fechaModificacion;	
	private String usuCreador;	
	private String usuModificador;	
	private String estado;
	
	private Long idTide;
	private String codigoTipoDestino;
	private String nombreTipoDestino;


}
