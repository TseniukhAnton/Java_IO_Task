import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.Developer;
import model.Skill;
import model.Team;
import repository.DeveloperRepository;
import repository.SkillRepository;
import repository.TeamRepository;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        SkillRepository skillRepository = new SkillRepository();

        Skill skill4 = new Skill(4,"PlayChess");
        Skill skill5 = new Skill(5,"PlayGolf");
        Skill skill6 = new Skill(6,"SQL");
        //skillRepository.save(skill5);
        //System.out.println(skillRepository.getById(3));
        Skill skill3 = new Skill(3,"Python");
        Skill skill2 = new Skill(2,"Java");
        Skill skill1 = new Skill(1,"C++");
        //System.out.println(skillRepository.save(skill4));
        //skillRepository.deleteById(2);
        //skillRepository.update(skill1);
        //System.out.println(skillRepository.getAll());

        List<Skill> javaDev = new ArrayList<>();
        javaDev.add(skill2);
        javaDev.add(skill6);
        List<Skill> cplusDev = new ArrayList<>();
        cplusDev.add(skill1);
        cplusDev.add(skill6);
        DeveloperRepository developerRepository = new DeveloperRepository();
        Developer javaDeveloper = new Developer(1,"Oleg", "Ivanov",javaDev);
        Developer cplusDeveloper = new Developer(2,"Zhora", "Petrov",cplusDev);
        developerRepository.save(javaDeveloper);
        developerRepository.save(cplusDeveloper);

        List<Developer> developers = new ArrayList<>();
        developers.add(javaDeveloper);
        developers.add(cplusDeveloper);

        TeamRepository teamRepository = new TeamRepository();
        Team devTeam = new Team(1,"FirstTeam",developers);
        teamRepository.save(devTeam);

    }
}
