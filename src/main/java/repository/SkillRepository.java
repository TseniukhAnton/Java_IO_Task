package repository;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import model.Skill;

import java.io.*;

import java.lang.reflect.Type;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SkillRepository implements SkillRepo {


    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    private static final String LOCATION = "src\\main\\resources\\skills.json";

    private URL resourseUrl = getClass().getClassLoader().getResource(LOCATION);

    public List<Skill> getSkills() {
        try {
            String skillJson = Files.readString(Path.of(resourseUrl.toURI()));
            Type type = new TypeToken<ArrayList<Skill>>() {
            }.getType();
            List<Skill> skills = gson.fromJson(skillJson, type);
            return skills;
        } catch (IOException | URISyntaxException e) {
            System.out.println("Exception " + e.toString());
        }
        return null;
    }

    @Override
    public Skill getById(Integer id) {
        try {
            Stream.of(getSkills()).filter(id).
        } catch (Exception e) {
            System.out.println("Exception " + e.toString());
        }
        return null;
    }

    @Override
    public void deleteById(Integer id) {
        try {
            String skillJson = Files.readString(Path.of(resourseUrl.toURI()));
            Type type = new TypeToken<ArrayList<Skill>>() {
            }.getType();
            List<Skill> skills = gson.fromJson(skillJson, type);
            skills.removeIf(skill -> skill.getId().equals(id));
            for (Skill skill : skills) {
                System.out.println(skill);
            }
        } catch (IOException | URISyntaxException e) {
            System.out.println("Exception " + e.toString());
        }
    }

    @Override
    public Skill update(Skill skill) {
        try {
            String skillJson = Files.readString(Path.of(resourseUrl.toURI()));
            Type type = new TypeToken<ArrayList<Skill>>() {
            }.getType();
            List<Skill> skills = gson.fromJson(skillJson, type);
            for (Skill skillArr : skills) {
                if (skillArr.getId().equals(skill.getId())) {
                    skillArr.setName("NewSkill");
                }
            }
            String newRecord = gson.toJson(skills);
            ObjectOutputStream obj = new ObjectOutputStream(new FileOutputStream(LOCATION));
            obj.writeObject(newRecord);
            System.out.println(skills);
        } catch (IOException | URISyntaxException e) {
            System.out.println("Exception " + e.toString());
        }
        return null;
    }

    @Override
    public Skill save(Skill skill) {
        try {
            String skillJson = Files.readString(Path.of(resourseUrl.toURI()));
            Type type = new TypeToken<ArrayList<Skill>>() {
            }.getType();
            List<Skill> skills = gson.fromJson(skillJson, type);
            skills.add(skill);
            String newRecord = gson.toJson(skills);
            ObjectOutputStream obj = new ObjectOutputStream(new FileOutputStream(LOCATION));
            obj.writeObject(newRecord);
            System.out.println(skills);
            return skill;
        } catch (Exception e) {
            System.out.println("Exception " + e.toString());
        }
        return null;
    }

    @Override
    public List<Skill> getAll() {
        try {
            String skillsJson = Files.readString(Path.of(resourseUrl.toURI()));
            Type type = new TypeToken<ArrayList<Skill>>() {
            }.getType();
            List<Skill> skills = gson.fromJson(skillsJson, type);
            return skills;
        } catch (Exception e) {
            System.out.println("Exception " + e.toString());
        }
        return null;
    }


}
