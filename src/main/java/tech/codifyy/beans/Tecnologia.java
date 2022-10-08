package tech.codifyy.beans;

public class Tecnologia {
    private Integer _id;
    private String name, color, icon;

    public Tecnologia() {
    }

    public Tecnologia(Integer _id, String name, String color, String icon) {
        this._id = _id;
        this.name = name;
        this.color = color;
        this.icon = icon;
    }

    public Integer get_id() {
        return _id;
    }

    public void set_id(Integer _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
