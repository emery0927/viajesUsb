/**  
 * @Title:  ClienteDTO.java   
 * @Package co.edu.usbcali.viajesusb.dto   
 * @Description: description   
 * @author: Emery Estupiñan     
 * @date:   6/09/2021 6:36:57 p. m.   
 * @version V1.0 
 * @Copyright: Universidad San de Buenaventura
 */
package co.edu.usbcali.viajesusb.dto;

import java.io.Serializable;
import java.util.Date;

import co.edu.usbcali.viajesusb.domain.TipoIdentificacion;
import lombok.Data;

/**   
 * @ClassName:  ClienteDTO   
  * @Description: TODO   
 * @author: Emery Estupiñan     
 * @date:   4/09/2021 6:36:57 p. m.      
 * @Copyright:  USB
 */
@Data
public class ClienteDTO implements Serializable{

	private static final long serialVersionUID = 8650084404524240764L;
	
	private Long idClie;
	private String numeroIdentificacion;
	private String primerApellido;
    private String segundoApellido;
    private String nombre;
    private String telefono1;
    private String telefono2;
    private String correo;
    private String sexo;
    private Date fechaNacimiento;
    private Date fechaCreacion;
    private Date fechaModificacion;
    private String usuCreador;
    private String usuModificador;
    private String estado;
    
    private Long idTiid;
    private String codigoTipoIdentificacion;
    private String nombreTipoIdentificacion;
 

    

    
    

}
