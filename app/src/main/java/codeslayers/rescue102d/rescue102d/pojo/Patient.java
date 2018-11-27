package codeslayers.rescue102d.rescue102d.pojo;

public class Patient {

    String id,name,desc,mcase;


    public Patient() {
    }

    public Patient(String id, String name, String desc, String mcase) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.mcase = mcase;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getMcase() {
        return mcase;
    }

    public void setMcase(String mcase) {
        this.mcase = mcase;
    }
}