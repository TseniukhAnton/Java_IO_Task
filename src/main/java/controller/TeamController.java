package controller;

import model.Developer;
import model.Team;
import repository.GsonTeamRepositoryImpl;
import repository.TeamRepository;

import java.util.List;

public class TeamController {
    private final TeamRepository repo = new GsonTeamRepositoryImpl();

    public Team getTeam(Integer id){
        return repo.getById(id);
    }

    public void deleteTeam(Integer id) {
        repo.deleteById(id);
    }

    public Team updateTeam(Integer id, String name, List<Developer> developers){
        Team team = new Team(id, name,developers);
        return repo.update(team);
    }

    public Team createTeam(Integer id, String name, List<Developer> developers){
        Team team = new Team(id, name,developers);
        return repo.save(team);
    }

    public List<Team> getAllTeams() {
        return repo.getAll();
    }
}
