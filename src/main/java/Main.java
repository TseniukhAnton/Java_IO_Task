import entity.Skill;
import entity.SkillRepository;
import parser.GsonParser;

public class Main {
    public static void main(String[] args) {
        //GsonParser.parseJson("C:\\Users\\Anton\\Documents\\GitHub\\CRUD\\src\\main\\resources\\skills.json");
        SkillRepository parser = new SkillRepository();
        Skill skill = parser.getAll();
        System.out.println("Skill " + skill.toString());
    }
}
