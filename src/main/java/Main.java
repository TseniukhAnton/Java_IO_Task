import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.Skill;
import repository.SkillRepository;

public class Main {
    public static void main(String[] args) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        SkillRepository skillRepository = new SkillRepository();
        Skill skill4 = new Skill(4,"PlayChess");
        Skill skill5 = new Skill(5,"PlayGolf");
        System.out.println(skillRepository.save(skill5));
        //System.out.println(skillRepository.getById(2));
        //System.out.println(skillRepository.getAll());
        Skill skill3 = new Skill(3,"Python");
        Skill skill1 = new Skill(1,"C++");
        //System.out.println(skillRepository.save(skill3));
        //skillRepository.deleteById(2);
        //skillRepository.update(skill1);
        //System.out.println(skillRepository.getAll());

    }
}
