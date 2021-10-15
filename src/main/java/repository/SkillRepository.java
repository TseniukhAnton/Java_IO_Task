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

    private static final String LOCATION = "./skills.json";

    private final URL resourseUrl = getClass().getClassLoader().getResource(LOCATION);

    private List<Skill> getSkills() {
        try {
            //String skillJson = Files.readString(Path.of(resourseUrl.toURI()));
            String skillJson = Files.readString(Path.of(LOCATION));
            Type type = new TypeToken<ArrayList<Skill>>() {
            }.getType();
            return gson.fromJson(skillJson, type);
        } catch (IOException | NullPointerException e) {
            System.out.println("Exception " + e);
        }
        return null;
    }

    @Override
    public Skill getById(Integer id) {
        try {
            return getSkills().stream()
                    .filter(skill -> skill.getId()
                            .equals(id))
                            .findAny()
                            .get();
        } catch (Exception e) {
            System.out.println("Exception " + e);
        }
        return null;
    }

    @Override
    public void deleteById(Integer id) {
        try (Writer writer = new FileWriter("skills.json")) {
            getSkills().removeIf(skill -> skill.getId().equals(id));
            gson.toJson(getSkills(), writer);
        } catch (Exception e) {
            System.out.println("Exception " + e);
        }
    }

    @Override
    public Skill update(Skill skill) {
        try (Writer writer = new FileWriter("skills.json")) {
            getSkills().stream()
                    .filter(skill1 -> skill1.getId()
                            .equals(skill.getId()))
                            .findAny()
                            .get()
                            .setName("NewSkill");
            gson.toJson(getSkills(), writer);
            return skill;
        } catch (Exception e) {
            System.out.println("Exception " + e);
        }
        return null;
    }

    @Override
    public Skill save(Skill skill) {
        try (Writer writer = new FileWriter("skills.json")) {
            getSkills().add(skill);
            gson.toJson(getSkills(), writer);
            return skill;
        } catch (Exception e) {
            System.out.println("Exception " + e);
        }
        return null;
    }

    @Override
    public List<Skill> getAll() {
        try {
            return getSkills();
        } catch (Exception e) {
            System.out.println("Exception " + e);
        }
        return null;
    }


}
