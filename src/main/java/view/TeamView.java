package view;

import controller.TeamController;
import model.Developer;
import model.Team;
import repository.GsonDeveloperRepositoryImpl;
import repository.GsonTeamRepositoryImpl;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TeamView {
    private final Scanner scanner = new Scanner(new InputStreamReader(System.in));

    private final TeamController teamController = new TeamController();

    public Team getTeamFromController() {
        System.out.println("Please enter Team id to find it");
        Integer id = scanner.nextInt();
        System.out.println(teamController.getTeam(id));
        return teamController.getTeam(id);
    }

    public void deleteTeamFromController() {
        System.out.println("Please enter Team id");
        Integer id = scanner.nextInt();
        System.out.println(teamController.getAllTeams());
        teamController.deleteTeam(id);
        System.out.println(teamController.getAllTeams());
    }

    public Team updateTeamFromController() {
        System.out.println("Please enter Team id, new name, new developerId");
        Integer id = scanner.nextInt();
        String name = scanner.next();
        Integer developerId = scanner.nextInt();
        List<Developer> list = new GsonTeamRepositoryImpl().getById(id).getDevelopers();
        list.add(new GsonDeveloperRepositoryImpl().getById(developerId));
        return teamController.updateTeam(id, name, list);
    }

    public Team createTeamFromController() {
        System.out.println("Please enter Team id, name, developerId, developerId2");
        Integer id = scanner.nextInt();
        String name = scanner.next();
        Integer developerId = scanner.nextInt();
        Integer developerId2 = scanner.nextInt();
        List<Developer> list = new ArrayList<>();
        list.add(new GsonDeveloperRepositoryImpl().getById(developerId));
        list.add(new GsonDeveloperRepositoryImpl().getById(developerId2));
        return teamController.createTeam(id, name, list);
    }

    public List<Team> getAllTeamsFromController() {
        System.out.println(teamController.getAllTeams());
        return teamController.getAllTeams();
    }
}
