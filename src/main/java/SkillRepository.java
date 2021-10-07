import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.File;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class SkillRepository {
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    private static final String LOCATION = "skills.json";

    private URL resourseUrl = getClass().getClassLoader().getResource(LOCATION);

    public Skill getSkillById(Integer id) {
        try{
            String skillJson = Files.readString(Path.of(resourseUrl.toURI()));
            Type type = new TypeToken<ArrayList<Skill>>() {}.getType();
            List<Skill> skills = gson.fromJson(skillJson,type);
            for (Skill skill : skills){
                if (skill.getId().equals(id)){
                    return skill;
                }
            }
        }catch (IOException | URISyntaxException e){
            System.out.println("Exception " + e.toString());
        }
        return null;
    }

    public List<Skill> getAll() {
        try {
            String skillsJson = Files.readString(Path.of(resourseUrl.toURI()));
            Type type = new TypeToken<ArrayList<Skill>>() {
            }.getType();
            List<Skill> skills = gson.fromJson(skillsJson, type);
            for (Skill skill : skills) {
                return skills;
            }
        } catch (Exception e) {
            System.out.println("Exception " + e.toString());
        }
        return null;
    }

    public Skill save(Skill skill) {

        try {
            String record = gson.toJson(skill, new TypeToken<Skill>() {
            }.getType());
            return skill;
        } catch (Exception e) {
            System.out.println("Exception " + e.toString());
        }
        return null;
    }

}
