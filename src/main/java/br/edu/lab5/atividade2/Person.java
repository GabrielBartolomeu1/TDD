package br.edu.lab5.atividade2;

public class Person {
    private int id;
    private String name;
    private int age;
    private Email email;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    public Email getEmail() { return email; }
    public void setEmail(Email email) { this.email = email; }
}