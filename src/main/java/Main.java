import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.Developer;
import model.Skill;
import model.Team;
import repository.GsonDeveloperRepositoryImpl;
import repository.GsonSkillRepositoryImpl;
import repository.GsonTeamRepositoryImpl;
import view.SkillView;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        GsonSkillRepositoryImpl skillRepository = new GsonSkillRepositoryImpl();

//        Skill skill4 = new Skill(4,"Ruby");
//        Skill skill5 = new Skill(5,"PlayGolf");
//        Skill skill6 = new Skill(6,"SQL");
//        Skill skill7 = new Skill(7,"Maven");
//        //skillRepository.save(skill5);
//        //System.out.println(skillRepository.getById(3));
//        Skill skill3 = new Skill(3,"Python");
//        Skill skill2 = new Skill(2,"Java");
//        Skill skill1 = new Skill(1,"C++");
//        System.out.println(skillRepository.save(skill7));
//        //skillRepository.deleteById(2);
//        skillRepository.update(skill2);
//        //System.out.println(skillRepository.getAll());
//
//        List<Skill> javaDev = new ArrayList<>();
//        javaDev.add(skill2);
//        javaDev.add(skill6);
//        List<Skill> cplusDev = new ArrayList<>();
//        cplusDev.add(skill1);
//        cplusDev.add(skill6);
//        List<Skill> pythonDev = new ArrayList<>();
//        pythonDev.add(skill3);
//        pythonDev.add(skill6);
//        List<Skill> rubyDev = new ArrayList<>();
//        rubyDev.add(skill4);
//        rubyDev.add(skill6);
//        GsonDeveloperRepositoryImpl developerRepository = new GsonDeveloperRepositoryImpl();
//        Developer javaDeveloper = new Developer(1,"Oleg", "Ivanov",javaDev);
//        Developer cplusDeveloper = new Developer(2,"Zhora", "Petrov",cplusDev);
//        Developer pythonDeveloper = new Developer(3,"Petr", "Kulich",pythonDev);
//        Developer rubyDeveloper = new Developer(4,"Ivan", "Bondar",rubyDev);
//        developerRepository.save(javaDeveloper);
//        developerRepository.save(cplusDeveloper);
//        developerRepository.save(pythonDeveloper);
//        developerRepository.save(rubyDeveloper);
//        developerRepository.update(javaDeveloper);
//
//        List<Developer> developers = new ArrayList<>();
//        developers.add(javaDeveloper);
//        developers.add(cplusDeveloper);
//
//        GsonTeamRepositoryImpl teamRepository = new GsonTeamRepositoryImpl();
//        Team devTeam = new Team(1,"FirstTeam",developers);
//        teamRepository.save(devTeam);

        SkillView skillView = new SkillView();
        skillView.createSkillFromController();
        skillView.getAllSkillsFromController();

    }
}
