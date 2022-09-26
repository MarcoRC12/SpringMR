/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.upeu.Spring.PController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upeu.Spring.entity.Persona;
import pe.edu.upeu.Spring.entity.PersonaTaller;
import pe.edu.upeu.Spring.entity.Taller;
import pe.edu.upeu.Spring.service.PersonaService;
import pe.edu.upeu.Spring.service.PersonaTallerService;

/**
 *
 * @author marco
 */
@RestController
@RequestMapping("/persona-taller")
@Api(value = "Microservicio de Gestio de personas en talleres", description = "Microservicio de Gestion de Personas en talleres")
public class PersonaTallerController {

    @Autowired
    PersonaTallerService personaTallerService;

    @Autowired
    PersonaService personaService;
    
    @ApiOperation(value = "Lista de personas en talleres")
    @GetMapping("/all")
    public List<PersonaTaller> findAll() {
        return personaTallerService.findAll();
    }
    
    @ApiOperation(value = "Obtiene datos de los talleres de la persona")
    @GetMapping("/taller/{id}")
    public List<PersonaTaller> findByTaller(@PathVariable Long id) {
        Taller taller = new Taller();
        taller.setTallId(id);
        return personaTallerService.findByTaller(taller);
    }

    @ApiOperation(value = "Obtiene datos de Persona Taller")
    @GetMapping("/{id}")
    public ResponseEntity<PersonaTaller> findById(@PathVariable Long id) {
        PersonaTaller personaTaller = personaTallerService.findById(id);
        return ResponseEntity.ok(personaTaller);
    }

    @ApiOperation(value = "Elimina datos de una persona registrada en taller")
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        personaTallerService.deleteById(id);
    }

    //Falta Añadir Tipo documento
    @ApiOperation(value = "Crea una Persona en Taller")
    @PostMapping("/save")
    public PersonaTaller save(@RequestBody PersonaTaller personaTaller) {
        Persona persona = personaService.findByPersDni(personaTaller.getPersona().getPersDni());
        if (persona == null) {
            return null;
        } else {
            personaTaller.setPersona(persona);
            return personaTallerService.save(personaTaller);
        }
    }

    @PutMapping("/update")
    public PersonaTaller update(@RequestBody PersonaTaller personaTaller) {
        return personaTallerService.save(personaTaller);
    }
}
