/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.upeu.Spring.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Data;

/**
 *
 * @author marco
 */
@Entity
@Data
@Table(name = "persona_taller")
public class PersonaTaller implements Serializable {
     
    @Id
    @Column(name = "peta_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long petaId;

    @ManyToOne
    @JoinColumn(name = "tall_id")
    private Taller taller;

    @ManyToOne
    @JoinColumn(name = "pers_id")
    private Persona persona;

    @ManyToOne
    @JoinColumn(name = "tipe_id")
    private TipoPersona tipoPersona;

    @Column(name = "peta_carrera")
    private String petaCarrera;

    @Column(name = "peta_ciclo")
    private String petaCiclo;

    @Column(name = "peta_asistencia")
    private String petaAsistencia;

}
