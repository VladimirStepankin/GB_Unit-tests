package seminar.third.hw.tdd;

public class User {

    String name;
    String password;
    private boolean isAdmin;
    boolean isAuthenticate = false;

    public User(String name, String password, boolean isAdmin) {
        this.name = name;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public boolean isAuthenticated() {
        return isAuthenticate;
    }

    public void setAuthenticated(boolean isAuthenticated) {
        this.isAuthenticate = isAuthenticated;
    }

    //3.6.
    public boolean authenticate(String name, String password) {
        return false;
    }

}