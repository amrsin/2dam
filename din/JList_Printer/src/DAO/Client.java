
package DAO;

/**
 *
 * @author amrsin
 */
public class Client {

    private String id;
    private String notes;

    public Client() {
        this.id = "";

        this.notes = "";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
