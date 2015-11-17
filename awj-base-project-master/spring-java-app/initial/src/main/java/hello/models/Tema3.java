package hello;

import java.util.List;
import java.util.ArrayList;

public class Tema3{

    class Persoana {
      private String name;
      private int id;

      public Persoana() {}

      public Persoana(int id, String name) {
          this.name = name;
          this.id = id;
      }

      void setName(String name){
        this.name = name;
      }

      public String getName() {
          return this.name;
      }

      public int getId() {
        return this.id;
      }
    }

    class Student {
      private String name;
      private int id;
      private float medie;

      public Student() {}

      public Student(int id, String name, float medie) {
          this.name = name;
          this.id = id;
          this.medie = medie;
      }

      void setName(String name){
        this.name = name;
      }

      void setMedie(float m){
        this.medie = m;
      }

      public String getName() {
          return this.name;
      }

      public int getId() {
        return this.id;
      }
    }

}