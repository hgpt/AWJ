package hello;

import java.util.List;
import java.util.ArrayList;

public class Student {
  private String name;
  private int id;
  private double medie;
  private String facultate;

  public Student() {}

  public Student(int id, String name, double medie, String facultate) {
      this.name = name;
      this.id = id;
      this.medie = medie;
      this.facultate = facultate;
  }

  void setMedie(double medie){
    this.medie = medie;
  }

  public String getName() {
      return this.name;
  }

  public int getId() {
    return this.id;
  }

  public double getMedie(){
    return this.medie;
  }

  public String getFacultate(){
    return this.facultate;
  }

}