package repository;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import model.Team;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class TeamRepository implements TeamRepo {
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    private static final String LOCATION = ".\\src\\main\\resources\\teams.json";

    private List<Team> getTeams() {
        try {
            String teamJson = Files.readString(Path.of(LOCATION));
            Type type = new TypeToken<ArrayList<Team>>() {
            }.getType();
            return gson.fromJson(teamJson, type);
        } catch (IOException | NullPointerException e) {
            System.out.println("Exception " + e);
        }
        return null;
    }

    private void writeToFile(List<Team> teams) {
        try (Writer writer = new FileWriter(LOCATION)) {
            gson.toJson(teams, writer);
        } catch (Exception e) {
            System.out.println("Exception " + e);
        }
    }

    @Override
    public Team getById(Integer id) {
        return getTeams().stream()
                .filter(team -> team.getId()
                        .equals(id))
                .findFirst().get();
    }

    @Override
    public void deleteById(Integer id) {
        List<Team> list = getTeams();
        list.removeIf(team -> team.getId().equals(id));
        writeToFile(list);
    }

    @Override
    public Team update(Team team) {
        List<Team> list = getTeams();
        list.stream()
                .filter(currentteam -> currentteam.getId().equals(team.getId()))
                .findFirst()
                .get()
                .setName("AnotherName");
        writeToFile(list);
        return team;
    }

    @Override
    public Team save(Team team) {
        List<Team> list = getTeams();
        if (list.isEmpty()) {
            list.add(team);
        } else if (list.get(list.size() - 1).getId() < team.getId()) {
            list.add(team);
        }
        writeToFile(list);
        return team;
    }

    @Override
    public List<Team> getAll() {
        return getTeams();
    }
}
