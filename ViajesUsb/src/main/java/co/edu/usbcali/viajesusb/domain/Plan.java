/**  
 * @Title:  Plan.java   
 * @Package co.edu.usbcali.viajesusb.domain   
 * @Description: description   
 * @author: Emery Estupiñan     
 * @date:   17/10/2021 9:20:12 p. m.   
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
 * @ClassName:  Plan   
  * @Description: TODO   
 * @author: Emery Estupiñan     
 * @date:   17/10/2021 9:20:12 p. m.      
 * @Copyright:  USB
 */
@Data
@Entity
@Table(name="plan")
public class Plan {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_plan")
	public Long idPlan;
	
	@Column(name="codigo", unique=true, nullable=false, length=5)
	public String codigo;
	
	@Column(name="nombre", nullable=false, length=100)
	public String nombre;
	
	@Column(name="descripcion_solicitud", nullable=true, length=5)
	public Long descripcionSolicitud;
	
	@Column(name="cantidad_personas", nullable=false, length=5)
	public Long cantidadPersonas;
	
	@Column(name="fecha_solicitud", nullable=false)
	public Date fechaSolicitud;
	
	@Column(name="fecha_inicio_viaje", nullable=true)
	public Date fechaInicioViaje;
	
	@Column(name="fecha_fin_viaje", nullable=true)
	public Date fechaFinViaje;
	
	@Column(name="valor_total", nullable=false, length=19)
	public Long valorTotal;
	
	@Column(name="fecha_creacion", nullable=false)
	public Date fechaCreacion;
	
	@Column(name="fecha_modificacion", nullable=true)
	public Date fechaModificacion;
	
	@Column(name="usu_creador", nullable=false, length=10)
	public String usuCreador;
	
	@Column(name="usu_modificador", nullable=true, length=10)
	public String usuModificador;
	
	@Column(name="estado", nullable=false, length=1)
	public String estado;

}
