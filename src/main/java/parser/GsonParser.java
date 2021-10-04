package parser;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import entity.Skill;
import entity.SkillRepository;

import java.io.FileReader;
import java.util.List;

public class GsonParser {
    public SkillRepository getAll(){
        Gson gson = new Gson();
        try(FileReader reader = new FileReader("skills.json"))
        {
            SkillRepository skillRepository  = gson.fromJson(reader, SkillRepository.class);
            return skillRepository;
        }catch (Exception e){
            System.out.println("Exception " + e.toString());
        }
        return null;
    }
}
