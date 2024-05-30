/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author user
 */
public class Model_PlayerProfile {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public ImageIcon getIcon() {
        return icon;
    }

    public void setIcon(ImageIcon icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
    
    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
    
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
    
    public double getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Model_PlayerProfile( String name, double weight, double height, String position, double salary,int id) {
        
        this.name = name;
        this.weight = weight;
        this.height = height;
        this.position = position;
        this.salary = salary;
        this.id=id;
    }

    public Model_PlayerProfile() {
    }
    
    private ImageIcon icon;
    private String name;
    private double weight;
    private double height;
    private String position;
    private double salary;
    private int id;
}
