package entity;

import com.google.gson.Gson;

import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.List;

public class SkillRepository{
    private List<Skill> skills;

    @Override
    public String toString() {
        return "SkillRepository{" +
                "skills=" + skills +
                '}';
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }



}
