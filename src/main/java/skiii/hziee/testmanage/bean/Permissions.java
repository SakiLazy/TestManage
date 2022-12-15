package skiii.hziee.testmanage.bean;

public class Permissions {

    private String name;
    private Integer state;//0为没有 1为有

    public Permissions(){

    }

    public Permissions(String name, Integer state) {
        this.name = name;
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "permissions{" +
                "name='" + name + '\'' +
                ", state=" + state +
                '}';
    }
}
