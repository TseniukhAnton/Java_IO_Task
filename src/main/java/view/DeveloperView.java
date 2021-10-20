package view;

import controller.DeveloperController;
import model.Developer;
import model.Skill;
import repository.GsonDeveloperRepositoryImpl;
import repository.GsonSkillRepositoryImpl;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeveloperView {
    private final Scanner scanner = new Scanner(new InputStreamReader(System.in));

    private final DeveloperController developerController = new DeveloperController();

    public Developer getDeveloperFromController() {
        System.out.println("Please enter Developer id to find it");
        Integer id = scanner.nextInt();
        System.out.println(developerController.getDeveloper(id));
        return developerController.getDeveloper(id);
    }

    public void deleteDeveloperFromController() {
        System.out.println("Please enter Developer id");
        Integer id = scanner.nextInt();
        System.out.println(developerController.getAllDevelopers());
        developerController.deleteDeveloper(id);
        System.out.println(developerController.getAllDevelopers());
    }

    public Developer updateDeveloperFromController() {
        System.out.println("Please enter Developer id, new firstName, new lastName, new skillId, skillId2");
        Integer id = scanner.nextInt();
        String firstName = scanner.next();
        String lastName = scanner.next();
        Integer skillId = scanner.nextInt();
        Integer skillId2 = scanner.nextInt();
        List<Skill> list = new GsonDeveloperRepositoryImpl().getById(id).getSkills();
        list.add(new GsonSkillRepositoryImpl().getById(skillId));
        list.add(new GsonSkillRepositoryImpl().getById(skillId2));
        return developerController.updateDeveloper(id, firstName, lastName, list);
    }

    public Developer createDeveloperFromController() {
        System.out.println("Please enter Developer id, firstName, lastName, skillId, skillId2");
        Integer id = scanner.nextInt();
        String firstName = scanner.next();
        String lastName = scanner.next();
        Integer skillId = scanner.nextInt();
        Integer skillId2 = scanner.nextInt();
        List<Skill> list = new ArrayList<>();
        list.add(new GsonSkillRepositoryImpl().getById(skillId));
        list.add(new GsonSkillRepositoryImpl().getById(skillId2));
        return developerController.createDeveloper(id, firstName, lastName, list);
    }

    public List<Developer> getAllDevelopersFromController() {
        System.out.println(developerController.getAllDevelopers());
        return developerController.getAllDevelopers();
    }
}
