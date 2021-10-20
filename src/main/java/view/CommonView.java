package view;


import java.io.InputStreamReader;
import java.util.Scanner;

public class CommonView {
    Scanner scanner = new Scanner(new InputStreamReader(System.in));

    private final SkillView sv = new SkillView();
    private final DeveloperView dv = new DeveloperView();
    private final TeamView tv = new TeamView();

    public void start() {
        System.out.println("What would you like to do? Create, Read, Update or Delete?");
        String sc = scanner.next();
        if (sc.equals("Create")) {
            System.out.println("What would you like to create? Skill, Developer or Team?");
            String create = scanner.next();
            if (create.equals("Skill")) {
                sv.createSkillFromController();
                System.out.println("New Skill was created");
                sv.getSkillFromController();
            } else if (create.equals("Developer")) {
                dv.createDeveloperFromController();
                System.out.println("New Developer was created");
                dv.getDeveloperFromController();
            } else if (create.equals("Team")) {
                tv.createTeamFromController();
                System.out.println("New Team was created");
                tv.getTeamFromController();
            } else {
                System.out.println("Wrong command!");
            }
        } else if (sc.equals("Read")) {
            System.out.println("What would you like to read? Skill, Developer or Team?");
            String read = scanner.next();
            if (read.equals("Skill")) {
                sv.getSkillFromController();
            } else if (read.equals("Developer")) {
                dv.getDeveloperFromController();
            } else if (read.equals("Team")) {
                tv.getTeamFromController();
            } else {
                System.out.println("Wrong command!");
            }
        } else if (sc.equals("Update")) {
            System.out.println("What would you like to update? Skill, Developer or Team?");
            String update = scanner.next();
            if (update.equals("Skill")) {
                sv.updateSkillFromController();
                System.out.println("Skill was updated");
                sv.getSkillFromController();
            } else if (update.equals("Developer")) {
                dv.updateDeveloperFromController();
                System.out.println("Developer was updated");
                dv.getDeveloperFromController();
            } else if (update.equals("Team")) {
                tv.updateTeamFromController();
                System.out.println("Team was updated");
                tv.getTeamFromController();
            } else {
                System.out.println("Wrong command!");
            }
        } else if (sc.equals("Delete")) {
            System.out.println("What would you like to delete? Skill, Developer or Team?");
            String delete = scanner.next();
            if (delete.equals("Skill")) {
                sv.getAllSkillsFromController();
                sv.deleteSkillFromController();
                System.out.println("Skill was deleted");
                sv.getAllSkillsFromController();
            } else if (delete.equals("Developer")) {
                dv.getAllDevelopersFromController();
                dv.deleteDeveloperFromController();
                System.out.println("Developer was deleted");
                dv.getAllDevelopersFromController();
            } else if (delete.equals("Team")) {
                tv.getAllTeamsFromController();
                tv.deleteTeamFromController();
                System.out.println("Team was deleted");
                tv.getAllTeamsFromController();
            } else {
                System.out.println("Wrong command!");
            }
        } else {
            System.out.println("Wrong command!");
        }
    }
}
