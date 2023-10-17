package  co.edu.udea.tourheroapi.service;

import co.edu.udea.tourheroapi.model.Hero;
import co.edu.udea.tourheroapi.repository.HeroRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class HeroService {

    private HeroRepository heroRepository;

    public HeroService(HeroRepository heroRepository){
        this.heroRepository=heroRepository;
    }


    public Hero getHero(Integer id){
        Optional<Hero> optionalHero = heroRepository.findById(id);
        if(!optionalHero.isPresent()){
            System.out.println("Error en el servicio de getHero");
        }
        return optionalHero.get();
    }


    public List<Hero> getHeroes(){
        List<Hero> heroesList = heroRepository.findAll();
        return heroesList;
    }

    public void updateHero(Hero hero){
        heroRepository.save(hero);
    }

    public void createHero(Hero hero){
        heroRepository.save(hero);
    }

    public void deleteHero(Hero hero){
        heroRepository.delete(hero);
    }

    public List<Hero> searchHeroes(String name){
         List<Hero> heroesList = heroRepository.findByNameLike("%"+name+"%");
        return heroesList;
    }

    public void deleteHero(Integer id){
        heroRepository.deleteById(id);
    }
}
