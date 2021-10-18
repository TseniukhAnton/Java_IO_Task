package controller;

import model.Skill;
import repository.GsonSkillRepositoryImpl;
import repository.SkillRepository;

import java.util.List;

public class SkillController {

    private final SkillRepository repo = new GsonSkillRepositoryImpl();

    public Skill getSkill(Integer id){
        return repo.getById(id);
    }

    public void deleteSkill(Integer id) {
        repo.deleteById(id);
    }

    public Skill updateSkill(Integer id, String name) {
        Skill skill = new Skill(id, name);
        return repo.update(skill);
    }

    public Skill createSkill(Integer id, String name) {
        Skill skill = new Skill(id, name);
        return repo.save(skill);
    }

    public List<Skill> getAllSkills() {
        return repo.getAll();
    }

}
