public class User {
    private String username;
    private String password;
    private String name;

    public User(String username, String password, String name) {
        this.username = username;
        this.password = password;
        this.name = name;
    }

    public boolean authenticate(String u, String p) {
        return username.equals(u) && password.equals(p);
    }

    public void updateProfile(String newName) {
        this.name = newName;
    }

    public void updatePassword(String newPass) {
        this.password = newPass;
    }

    public String getName() {
        return name;
    }
}
