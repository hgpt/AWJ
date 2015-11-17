package hello;

import java.util.List;
import java.util.ArrayList;

public class Masina {
  private String producator;
  private String model;
  private int id;
  private double putere;
  

  public Masina() {}

  public Masina(int id, String producator, String model, double putere) {
      this.producator = producator;
      this.id = id;
      this.putere = putere;
      this.model = model;
  }

  void setPutere(double putere){
    this.putere = putere;
  }

  public String getProducator() {
      return this.producator;
  }

  public int getId() {
    return this.id;
  }

  public double getPutere(){
    return this.putere;
  }

  public String getModel(){
    return this.model;
  }

}