package myproject2.src.domain;

public class PC  implements Equipment{
    private String model;//机器型号
    private String desplay;//机器名称

    public PC() {
        super();
    }

    public PC(String model, String desplay) {
        super();
        this.model = model;
        this.desplay = desplay;
    }




    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDesplay() {
        return desplay;
    }

    public void setDesplay(String desplay) {
        this.desplay = desplay;
    }
    @Override
    public String getDescription() {
        return model + "(" + desplay +")";
    }
}
