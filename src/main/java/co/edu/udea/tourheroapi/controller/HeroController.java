package co.edu.udea.tourheroapi.controller;

import co.edu.udea.tourheroapi.model.Hero;
import co.edu.udea.tourheroapi.service.HeroService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/heroes")
public class HeroController {

    HeroService heroService;
    public HeroController(HeroService heroService){
        this.heroService=heroService;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Busca un heroe por su id", response = Hero.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Hero encontrado exitosamente"),
            @ApiResponse(code= 400, message = "La peticion es inválida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")
    })
    public ResponseEntity<Hero> getHero(@PathVariable Integer id){
        return ResponseEntity.ok(heroService.getHero(id));
    }

    @GetMapping("/")
    @ApiOperation(value = "Buscar la lista de heroe", response = Hero.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Hero encontrado exitosamente"),
            @ApiResponse(code= 400, message = "La peticion es inválida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")
    })
    public ResponseEntity<List<Hero>> getHeros(){
        return ResponseEntity.ok(heroService.getHeroes());
    }

    @PutMapping("/update")
    @ApiOperation(value = "Actualiza un heroe")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Hero encontrado exitosamente"),
            @ApiResponse(code= 400, message = "La peticion es inválida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")
    })
    public void updateHero(@RequestBody Hero hero){
        heroService.updateHero(hero);
    }

    @PostMapping("/create")
    @ApiOperation(value = "Crea un heroe")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Hero encontrado exitosamente"),
            @ApiResponse(code= 400, message = "La peticion es inválida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")
    })
    public void createHero(@RequestBody Hero hero){
        heroService.createHero(hero);
    }

    @DeleteMapping("/delete")
    @ApiOperation(value = "Elimina un heroe")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Hero encontrado exitosamente"),
            @ApiResponse(code= 400, message = "La peticion es inválida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")
    })
    public void deleteHero(@RequestBody Hero hero){
        heroService.deleteHero(hero);
    }
    @GetMapping("/buscar/{name}")
    @ApiOperation(value = "Busca un heroe por el nombre")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Hero encontrado exitosamente"),
            @ApiResponse(code= 400, message = "La peticion es inválida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")
    })
    public ResponseEntity<List<Hero>> searchHeroes(@ApiParam("Nombre del heroe que desea buscar")
                                                              @PathVariable("name") String name) {
        return ResponseEntity.ok(heroService.searchHeroes(name));
    }

    @GetMapping("/delete/{id}")
    @ApiOperation(value = "Elimina  un heroe por su id", response = Hero.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Hero eliminado exitosamente"),
            @ApiResponse(code= 400, message = "La peticion es inválida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")
    })
    public void deleteHero(@PathVariable Integer id){
        heroService.deleteHero(id);
    }



}
