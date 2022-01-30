package ehospital.model;

public class Gender {
    private long ID;
    private String genderName;

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getGenderName() {
        return genderName;
    }

    public void setGenderName(String genderName) {
        this.genderName = genderName;
    }

    public static void showGenders(Gender gender){
        System.out.println(gender.getID()+"--"+gender.getGenderName());
    }
}
