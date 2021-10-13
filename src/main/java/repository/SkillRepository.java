package repository;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import model.Skill;

import java.io.*;

import java.lang.reflect.Type;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class SkillRepository implements SkillRepo {


    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    private static final String LOCATION = "C:\\Users\\Anton\\Documents\\GitHub\\CRUD\\src\\main\\resources\\skills.json";

    private final URL resourseUrl = getClass().getClassLoader().getResource(LOCATION);

    public List<Skill> getSkills() {
        try {
            //String skillJson = Files.readString(Path.of(resourseUrl.toURI()));
            String skillJson = Files.readString(Path.of(LOCATION));
            Type type = new TypeToken<ArrayList<Skill>>() {
            }.getType();
            List<Skill> skills = gson.fromJson(skillJson, type);
            return skills;
        } catch (IOException | NullPointerException e) {
            System.out.println("Exception " + e.toString());
        }
        return null;
    }

    @Override
    public Skill getById(Integer id) {
        try {
            return getSkills().stream().filter(skill -> skill.getId().equals(id)).findAny().get();
        } catch (Exception e) {
            System.out.println("Exception " + e.toString());
        }
        return null;
    }

    @Override
    public void deleteById(Integer id) {
        try {
            getSkills().removeIf(skill -> skill.getId().equals(id));
            System.out.println(getSkills());
        } catch (Exception e) {
            System.out.println("Exception " + e.toString());
        }
    }

    @Override
    public Skill update(Skill skill) {
        try {
            getSkills().stream().filter(skill1 -> skill1.getId().equals(skill.getId())).findAny().get().setName("NewSkill");
            String newRecord = gson.toJson(getSkills());
            return skill;
        } catch (Exception e) {
            System.out.println("Exception " + e.toString());
        }
        return null;
    }

    @Override
    public Skill save(Skill skill) {
        try {
            getSkills().add(skill);
            String newRecord = gson.toJson(getSkills());
            return skill;
        } catch (Exception e) {
            System.out.println("Exception " + e.toString());
        }
        return null;
    }

    @Override
    public List<Skill> getAll() {
        try {
            return getSkills();
        } catch (Exception e) {
            System.out.println("Exception " + e.toString());
        }
        return null;
    }


}
