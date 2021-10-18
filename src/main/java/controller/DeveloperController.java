package controller;

import model.Developer;
import model.Skill;
import repository.DeveloperRepository;
import repository.GsonDeveloperRepositoryImpl;

import java.util.List;

public class DeveloperController {

    private final DeveloperRepository repo = new GsonDeveloperRepositoryImpl();

    public Developer getDeveloper(Integer id){
        return repo.getById(id);
    }

    public void deleteDeveloper(Integer id) {
        repo.deleteById(id);
    }

    public Developer updateDeveloper(Integer id, String firstName, String lastName, List<Skill> skills){
        Developer developer = new Developer(id, firstName, lastName,skills);
        return repo.update(developer);
    }

    public Developer createDeveloper(Integer id, String firstName, String lastName, List<Skill> skills){
        Developer developer = new Developer(id, firstName, lastName,skills);
        return repo.save(developer);
    }

    public List<Developer> getAllDevelopers() {
        return repo.getAll();
    }


}
