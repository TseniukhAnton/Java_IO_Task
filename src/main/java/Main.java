import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Skill skill = new Skill();
        skill.setId(1);
        skill.setName("Maven");
        Skill skill2 = new Skill();
        skill2.setId(2);
        skill2.setName("MongoDB");
        String json = gson.toJson(skill);
        String json2 = gson.toJson(skill2);

        System.out.println(json);



        SkillRepository skillRepository = new SkillRepository();
        skillRepository.getAll();
    }
}
