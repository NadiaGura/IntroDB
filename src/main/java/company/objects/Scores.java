package company.objects;

public class Scores {

    //properties
    private int id;
    private int mathematics;
    private int english;
    private int physics;
    private int chemistry;

    // empty constructor
    public Scores() {
    }

    //getters setters
    public int getId() {
        return id;
    }

    public int getMathematics() {
        return mathematics;
    }

    public int getEnglish() {
        return english;
    }

    public int getPhysics() {
        return physics;
    }

    public int getChemistry() {
        return chemistry;
    }
    public void setId(int id) {
        this.id = id;
    }

    public void setMathematics(int mathematics) {
        this.mathematics = mathematics;
    }

    public void setEnglish(int english) {
        this.english = english;
    }

    public void setPhysics(int physics) {
        this.physics = physics;
    }

    public void setChemistry(int chemistry) {
        this.chemistry = chemistry;
    }


}
