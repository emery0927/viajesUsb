/**  
 * @Title:  DetallePlan.java   
 * @Package co.edu.usbcali.viajesusb.domain   
 * @Description: description   
 * @author: Emery Estupiñan     
 * @date:   17/10/2021 9:20:27 p. m.   
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
 * @ClassName:  DetallePlan   
  * @Description: TODO   
 * @author: Emery Estupiñan     
 * @date:   17/10/2021 9:20:27 p. m.      
 * @Copyright:  USB
 */
@Data
@Entity
@Table(name="detalle_plan")
public class DetallePlan {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_depl")
	public Long idDepl;
	
	@Column(name="alimentacion", unique=true, nullable=false, length=1)
	public String alimentacion;
	
	@Column(name="hospedaje", nullable=false, length=1)
	public String hospedaje;
	
	@Column(name="transporte", nullable=true, length=1)
	public String transporte;
	
	@Column(name="traslados", nullable=false, length=1)
	public String traslados;
	
	@Column(name="valor", nullable=false, length=1)
	public Long valor;
	
	@Column(name="cantidad_noches", nullable=true)
	public Long cantidadNoches;
	
	@Column(name="cantidad_dias", nullable=true)
	public Long cantidadDias;
	
	@Column(name="fecha_creacion", nullable=false, length=19)
	public Date fechaCreacion;
	
	@Column(name="fecha_modificacion", nullable=false)
	public Date fechaModificacion;
	
	@Column(name="usu_creador", nullable=true, length=10)
	public String usuCreador;
	
	@Column(name="usu_modificador", nullable=false, length=10)
	public String usuModificador;
	
	@Column(name="estado", nullable=true, length=1)
	public String estado;


}
