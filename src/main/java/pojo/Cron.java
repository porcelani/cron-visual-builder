package pojo;

public class Cron {

    private String name;
    private String cronExpression;
    private int duration;

    public String getCronExpression() {
        return cronExpression;
    }

    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ClassPojo [cronExpression = " + cronExpression + ", duration = " + duration + ", name = " + name + "]";
    }
}