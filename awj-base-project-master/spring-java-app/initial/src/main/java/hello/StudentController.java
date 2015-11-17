package hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.ArrayList;


@RestController
public class StudentController {
  private List<Student> studenti = new ArrayList<Student>();


  StudentController() {
    Student s1 = new Student(1, "Alex", 8.8, "A&C");
    Student s2 = new Student(2, "Andrei", 9.8, "A&C");
    Student s3 = new Student(3, "Alin", 9.5, "A&C");

    studenti.add(s1);
    studenti.add(s2);
    studenti.add(s3);
  }

  @RequestMapping(value="/Student", method = RequestMethod.GET)
  public List<Student> index() {
    return this.studenti;
  }

  @RequestMapping(value="/Student/{name},{medie},{facultate}", method = RequestMethod.POST)
  public ResponseEntity add(@PathVariable("name") String name,
                            @PathVariable("medie") double medie,
                            @PathVariable("facultate") String facultate) {
    int counter = studenti.size() + 1;
    Student aux = new Student(counter,name,medie,facultate);
    studenti.add(aux);
    return new ResponseEntity<Student>(aux, new HttpHeaders(), HttpStatus.OK);
  }

  @RequestMapping(value="/Student/{id},{medie}", method = RequestMethod.PUT)
  public ResponseEntity remove(@PathVariable("id") int id, 
                               @PathVariable("medie") double medie) {
    for(Student p : this.studenti) {
      if(p.getId() == id) {
          p.setMedie(medie);
          return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NO_CONTENT);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }

  @RequestMapping(value="/Student/{id}", method = RequestMethod.GET)
  public ResponseEntity show(@PathVariable("id") int id) {
    for(Student p : this.studenti) {
      if(p.getId() == id) {
        return new ResponseEntity<Student>(p, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }

  @RequestMapping(value="/Student/{id}", method = RequestMethod.DELETE)
  public ResponseEntity remove(@PathVariable("id") int id) {
    for(Student p : this.studenti) {
      if(p.getId() == id) {
        this.studenti.remove(p);
        return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NO_CONTENT);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }
}
