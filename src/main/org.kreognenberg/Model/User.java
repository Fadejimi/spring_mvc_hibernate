package Model;

import java.util.Arrays;
import java.util.List;

public class User {
    private Integer id;
    private String username;
    private String email;
    private String password;
    private String beerKind;
    private String gender;
    private List<String> complicatedInterests;
    private String confirmPassword;
    private String interests;

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public User(String username, String email, String password, String beerKind, String gender, String interests) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.beerKind = beerKind;
        this.gender = gender;
        this.interests = interests;
    }

    public User() {

    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return this.id;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBeerKind() {
        return beerKind;
    }

    public void setBeerKind(String beerKind) {
        this.beerKind = beerKind;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<String> getComplicatedInterests() {
        return computeInterests(this.interests);
    }

    public void setComplicatedInterests(List<String> interests) {
        this.complicatedInterests = interests;
        this.interests = delimitInterests(interests);
    }

    private List<String> computeInterests(String st) {
        List<String> items = Arrays.asList(st.split("\\s*,\\s*"));
        return items;
    }

    private String delimitInterests(List<String> list) {
        StringBuilder stBuilder = new StringBuilder();

        for(String st : list){
            stBuilder.append(st);
            stBuilder.append(",");
        }

        String output = stBuilder.toString();

        //Remove last comma
        output = output.substring(0, output.length() - 1);

        //System.out.println(csv);
        return output;
    }

    public String getInterests() {
        return this.interests;
    }

    public void setInterests(String interests) {
        this.interests = interests;
        this.complicatedInterests = computeInterests(interests);
    }

    public boolean isNew() {
        if (this.id == null) {
            return true;
        }
        return false;
    }
}
