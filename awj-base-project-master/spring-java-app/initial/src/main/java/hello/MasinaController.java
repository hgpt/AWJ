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
public class MasinaController {
  private List<Masina> masini = new ArrayList<Masina>();


  MasinaController() {
    Masina s1 = new Masina(1, "Tesla", "X", 0);
    Masina s2 = new Masina(2, "LandRover","Evoque", 3.2);
    Masina s3 = new Masina(3, "Audi","A4", 2.5);

    masini.add(s1);
    masini.add(s2);
    masini.add(s3);
  }

  @RequestMapping(value="/Masina", method = RequestMethod.GET)
  public List<Masina> index() {
    return this.masini;
  }

  @RequestMapping(value="/Masina/{producator},{model},{putere}", method = RequestMethod.POST)
  public ResponseEntity add(@PathVariable("producator") String producator,
                            @PathVariable("model") String model,
                            @PathVariable("putere") double putere) {
    int counter = masini.size() + 1;
    Masina aux = new Masina(counter,producator,model,putere);
    masini.add(aux);
    return new ResponseEntity<Masina>(aux, new HttpHeaders(), HttpStatus.OK);
  }

  @RequestMapping(value="/Masina/{id},{putere}", method = RequestMethod.PUT)
  public ResponseEntity remove(@PathVariable("id") int id, 
                               @PathVariable("putere") double putere) {
    for(Masina p : this.masini) {
      if(p.getId() == id) {
          p.setPutere(putere);
          return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NO_CONTENT);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }

  @RequestMapping(value="/Masina/{id}", method = RequestMethod.GET)
  public ResponseEntity show(@PathVariable("id") int id) {
    for(Masina p : this.masini) {
      if(p.getId() == id) {
        return new ResponseEntity<Masina>(p, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }

  @RequestMapping(value="/Masina/{id}", method = RequestMethod.DELETE)
  public ResponseEntity remove(@PathVariable("id") int id) {
    for(Masina p : this.masini) {
      if(p.getId() == id) {
        this.masini.remove(p);
        return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NO_CONTENT);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }
}
