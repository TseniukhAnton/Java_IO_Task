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

    private static final String LOCATION = ".\\src\\main\\resources\\skills.json";

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

    private void writeToFile(List<Skill> skills) {
        try (Writer writer = new FileWriter(LOCATION)) {
            gson.toJson(skills, writer);
        } catch (Exception e) {
            System.out.println("Exception " + e);
        }
    }

    @Override
    public Skill getById(Integer id) {
        return getSkills().stream()
                .filter(skill -> skill.getId()
                        .equals(id))
                .findFirst()
                .get();
    }

    @Override
    public void deleteById(Integer id) {
        List<Skill> list = getSkills();
        list.removeIf(skill -> skill.getId().equals(id));
        writeToFile(list);
    }

    @Override
    public Skill update(Skill skill) {
        List<Skill> list = getSkills();
        list.stream()
                .filter(currentskill -> currentskill.getId()
                        .equals(skill.getId()))
                .findFirst()
                .get()
                .setName("NewSkill");
        writeToFile(list);
        return skill;
    }

    @Override
    public Skill save(Skill skill) {
        List<Skill> list = getSkills();
        if (list.size() < skill.getId()){
            list.add(skill);
        }
        writeToFile(list);
        return skill;
    }

    @Override
    public List<Skill> getAll() {
        return getSkills();
    }


}
