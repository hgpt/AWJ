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
public class PCController {
  private List<PC> pcuri = new ArrayList<PC>();


  PCController() {
    PC s1 = new PC(1, "HP", "EliteBook", "i5");
    PC s2 = new PC(2, "Apple","MacBook Pro 15", "i7");
    PC s3 = new PC(3, "Lenovo","Yoga", "i5");

    pcuri.add(s1);
    pcuri.add(s2);
    pcuri.add(s3);
  }

  @RequestMapping(value="/PC", method = RequestMethod.GET)
  public List<PC> index() {
    return this.pcuri;
  }

  @RequestMapping(value="/PC/{producator},{model},{procesor}", method = RequestMethod.POST)
  public ResponseEntity add(@PathVariable("producator") String producator,
                            @PathVariable("model") String model,
                            @PathVariable("procesor") String procesor) {
    int counter = pcuri.size() + 1;
    PC aux = new PC(counter,producator,model,procesor);
    pcuri.add(aux);
    return new ResponseEntity<PC>(aux, new HttpHeaders(), HttpStatus.OK);
  }

  @RequestMapping(value="/PC/{id},{procesor}", method = RequestMethod.PUT)
  public ResponseEntity remove(@PathVariable("id") int id, 
                               @PathVariable("procesor") String procesor) {
    for(PC p : this.pcuri) {
      if(p.getId() == id) {
          p.setProcesor(procesor);
          return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NO_CONTENT);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }

  @RequestMapping(value="/PC/{id}", method = RequestMethod.GET)
  public ResponseEntity show(@PathVariable("id") int id) {
    for(PC p : this.pcuri) {
      if(p.getId() == id) {
        return new ResponseEntity<PC>(p, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }

  @RequestMapping(value="/PC/{id}", method = RequestMethod.DELETE)
  public ResponseEntity remove(@PathVariable("id") int id) {
    for(PC p : this.pcuri) {
      if(p.getId() == id) {
        this.pcuri.remove(p);
        return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NO_CONTENT);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }
}
