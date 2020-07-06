package thuy.codegym.models;

import org.springframework.web.multipart.MultipartFile;

public class StudentForm {
      private int id;
      private String name;
      private String address;
      private MultipartFile avatar;
      private Classes classes;

    public StudentForm() {
    }

    public StudentForm(int id, String name, String address, MultipartFile avatar, Classes classes) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.avatar = avatar;
        this.classes = classes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public MultipartFile getAvatar() {
        return avatar;
    }

    public void setAvatar(MultipartFile avatar) {
        this.avatar = avatar;
    }

    public Classes getClasses() {
        return classes;
    }

    public void setClasses(Classes classes) {
        this.classes = classes;
    }
}