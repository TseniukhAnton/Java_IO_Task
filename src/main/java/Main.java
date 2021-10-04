import entity.Skill;
import entity.SkillRepository;
import parser.GsonParser;

public class Main {
    public static void main(String[] args) {
        //GsonParser.parseJson("C:\\Users\\Anton\\Documents\\GitHub\\CRUD\\src\\main\\resources\\skills.json");
        GsonParser parser = new GsonParser();
        SkillRepository skillRepository = parser.getAll();
        System.out.println("SkillRepository " + skillRepository.toString());
    }
}
