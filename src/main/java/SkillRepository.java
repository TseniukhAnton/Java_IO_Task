import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class SkillRepository {
    private final Gson gson = new Gson();

    private final String location = "";

    File file = new File("C:\\Users\\Anton\\Documents\\GitHub\\CRUD\\src\\main\\resources\\skills.json");

    public List<Skill> getAll() {
        try (FileReader reader = new FileReader(file)) {
            List<Skill> skill = gson.fromJson(reader, new TypeToken<ArrayList<Skill>>() { }.getType());
            return skill;
        } catch (Exception e) {
            System.out.println("Exception " + e.toString());
        }
        return null;
    }

    public Skill save(Skill skill){

        try (FileReader reader = new FileReader(file)) {
            String record  = gson.toJson(skill, new TypeToken<Skill>() {}.getType());
            return skill;
        } catch (Exception e) {
            System.out.println("Exception " + e.toString());
        }
        return null;
    }


}
