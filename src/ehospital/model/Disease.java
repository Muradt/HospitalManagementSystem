package ehospital.model;

public class Disease {
    private long ID;
    private String name;
    private String treatment;
    private String symptoms;

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public static void showDiseases(Disease disease){
        System.out.println(disease.getID()+"--"+disease.getName()+"--"+disease.getTreatment()+"--"+disease.getSymptoms());
    }

    @Override
    public String toString() {
        return name;
    }
    
    
}
