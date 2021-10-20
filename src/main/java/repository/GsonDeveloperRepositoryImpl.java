package repository;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import model.Developer;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class GsonDeveloperRepositoryImpl implements DeveloperRepository {
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    private static final String LOCATION = ".\\src\\main\\resources\\developers.json";

    private List<Developer> getDevelopers() {
        try {
            String developerJson = Files.readString(Path.of(LOCATION));
            Type type = new TypeToken<ArrayList<Developer>>() {
            }.getType();
            return gson.fromJson(developerJson, type);
        } catch (IOException | NullPointerException e) {
            System.out.println("Exception " + e);
        }
        return null;
    }

    private void writeToFile(List<Developer> developers) {
        try (Writer writer = new FileWriter(LOCATION)) {
            gson.toJson(developers, writer);
        } catch (Exception e) {
            System.out.println("Exception " + e);
        }
    }

    private Integer getMaxId(List<Developer> list) {
        int maxId = 0;
        for (Developer currentdeveloper : list) {
            if (currentdeveloper.getId() > maxId) {
                maxId = currentdeveloper.getId();
            }
        }
        return maxId;
    }

    @Override
    public Developer getById(Integer id) {
        return getDevelopers().stream().filter(developer -> developer.getId().equals(id)).findFirst().get();
    }

    @Override
    public void deleteById(Integer id) {
        List<Developer> list = getDevelopers();
        list.removeIf(developer -> developer.getId().equals(id));
        writeToFile(list);
    }

    @Override
    public Developer update(Developer developer) {
        List<Developer> list = getDevelopers();
        for (Developer currentdeveloper : list) {
            if (currentdeveloper.getId().equals(developer.getId())) {
                currentdeveloper.setFirstName(developer.getFirstName());
                currentdeveloper.setLastName(developer.getLastName());
                currentdeveloper.setSkills(developer.getSkills());
            }
        }
        writeToFile(list);
        return developer;
    }

    @Override
    public Developer save(Developer developer) {
        List<Developer> list = getDevelopers();
        if (list.isEmpty()) {
            list.add(developer);
        } else if (getMaxId(list) < developer.getId()) {
            list.add(developer);
        } else {
            System.out.println("id exists or was deleted previously");
        }
        writeToFile(list);
        return developer;
    }

    @Override
    public List<Developer> getAll() {
        return getDevelopers();
    }
}
