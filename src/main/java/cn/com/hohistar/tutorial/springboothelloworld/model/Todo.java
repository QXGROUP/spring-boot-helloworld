package cn.com.hohistar.tutorial.springboothelloworld.model;

public class Todo {

    private Long id;

    private String title;
    private String desc;

    public Todo() {
    }

    public Todo(Long id, String title, String desc) {
        this.id = id;
        this.title = title;
        this.desc = desc;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
