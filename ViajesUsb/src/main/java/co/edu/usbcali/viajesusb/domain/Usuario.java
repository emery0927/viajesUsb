/**  
 * @Title:  Usuario.java   
 * @Package co.edu.usbcali.viajesusb.domain   
 * @Description: description   
 * @author: Emery Estupiñan     
 * @date:   17/10/2021 9:20:41 p. m.   
 * @version V1.0 
 * @Copyright: Universidad San de Buenaventura
 */
package co.edu.usbcali.viajesusb.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**   
 * @ClassName:  Usuario   
  * @Description: TODO   
 * @author: Emery Estupiñan     
 * @date:   17/10/2021 9:20:41 p. m.      
 * @Copyright:  USB
 */
@Data
@Entity
@Table(name="usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_usua")
	public Long idUsua;
	
	@Column(name="login", unique=true, nullable=false, length=1)
	public String login;
	
	@Column(name="password", nullable=false, length=1)
	public String password;
	
	@Column(name="nombre", nullable=true, length=1)
	public String nombre;
	
	@Column(name="identificacion", nullable=false, length=1)
	public String identificacion;
	
	@Column(name="fecha_creacion", nullable=false, length=1)
	public Long fechaCreacion;
	
	@Column(name="fecha_modificacion", nullable=true)
	public Long fechaModificacion;
	
	@Column(name="usu_creador", nullable=false)
	public Long usuCreador;
	
	@Column(name="usu_modificador", nullable=false, length=19)
	public Date usu_modificador;
	
	@Column(name="estado", nullable=false)
	public Date estado;

}
