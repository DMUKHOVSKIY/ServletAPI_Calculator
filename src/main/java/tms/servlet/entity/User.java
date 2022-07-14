package tms.servlet.entity;

public class User {
    private String name;
    private String username;
    private String password;

    public static class Builder{
        private final User user;

        public Builder(){
            user = new User();
        }

        public Builder name(String name){
            user.name = name;
            return this;
        }

        public Builder username(String username){
            user.username= username;
            return this;
        }

        public Builder password(String password){
            user.password = password;
            return this;
        }

        public User build(){
            return user;
        }

    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        if (username != null ? !username.equals(user.username) : user.username != null) return false;
        return password != null ? password.equals(user.password) : user.password == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
