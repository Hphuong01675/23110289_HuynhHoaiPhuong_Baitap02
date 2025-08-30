package Model;

public class Category {
    private int id;
    private String name;
    private String description;
    private String username; // dùng username thống nhất

    public Category() {}

    public Category(int id, String name, String description, String username) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.username = username;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getUsername() { return username; } // thống nhất
    public void setUsername(String username) { this.username = username; }
}
