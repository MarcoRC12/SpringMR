/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.upeu.Spring.service;

import java.util.List;
import pe.edu.upeu.Spring.entity.PersonaTaller;
import pe.edu.upeu.Spring.entity.Taller;

/**
 *
 * @author marco
 */
public interface PersonaTallerService {
    public List<PersonaTaller> findAll();

    public PersonaTaller findById(Long id);

    public List<PersonaTaller> findByTaller(Taller taller);

    public PersonaTaller save(PersonaTaller personaTaller);

    public void delete(PersonaTaller personaTaller);

    public void deleteById(Long id);
}
