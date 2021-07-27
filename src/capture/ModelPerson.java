package capture;

public class ModelPerson {

    // class to hold the person data and then send it to the DB
    private int id;
    private String first_name, last_name;

    public ModelPerson() {
    }

    public ModelPerson(String first_name, String office, String image) { 
        //LastPerson
        this.first_name = first_name;
        
    }

    public ModelPerson(int id, String first_name, String last_name) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

   
}
