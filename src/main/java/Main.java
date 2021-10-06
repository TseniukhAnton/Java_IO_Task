public class Main {
    public static void main(String[] args) {
        //GsonParser parser = new GsonParser();
        SkillRepository skillRepository = new SkillRepository();

        skillRepository.getAll();
        //skillRepository.save(new Skill(1,"SQL"));
    }
}
