/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.upeu.Spring.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upeu.Spring.entity.PersonaTaller;
import pe.edu.upeu.Spring.entity.Taller;

/**
 *
 * @author marco
 */
@Repository
public interface PersonaTallerRepository extends CrudRepository<PersonaTaller, Long>{
        List<PersonaTaller> findByTaller(Taller taller);
}
