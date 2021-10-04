package entity;

import com.google.gson.Gson;

import java.io.FileReader;
import java.util.List;

public class SkillRepository{
    private List<Skill> skills;

    public Skill getAll(){
        Gson gson = new Gson();
        try(FileReader reader = new FileReader("skills.json"))
        {
            Skill skill = gson.fromJson(reader,Skill.class);
            return skill;
        }catch (Exception e){
            System.out.println("Exception " + e.toString());
        }
        return null;
    }

}
