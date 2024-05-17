/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import javax.swing.Icon;

/**
 *
 * @author user
 */
public class Model_PlayerProfile {
    
    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }
    
    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }
    
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
    
    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public Model_PlayerProfile(Icon icon, String name, String weight, String height, String position, String salary) {
        this.icon = icon;
        this.name = name;
        this.weight = weight;
        this.height = height;
        this.position = position;
        this.salary = salary;
    }

    public Model_PlayerProfile() {
    }
    
    private Icon icon;
    private String name;
    private String weight;
    private String height;
    private String position;
    private String salary;
}
