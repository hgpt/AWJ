package hello;

import java.util.List;
import java.util.ArrayList;

public class PC {
  private String producator;
  private String model;
  private int id;
  private String procesor;
  

  public PC() {}

  public PC(int id, String producator, String model, String procesor) {
      this.producator = producator;
      this.id = id;
      this.procesor = procesor;
      this.model = model;
  }

  void setProcesor(String procesor){
    this.procesor = procesor;
  }

  public String getProducator() {
      return this.producator;
  }

  public int getId() {
    return this.id;
  }

  public String getProcesor(){
    return this.procesor;
  }

  public String getModel(){
    return this.model;
  }

}