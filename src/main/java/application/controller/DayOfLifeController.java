package application.controller;

import java.time.LocalDate;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tools.DateUtils;
import application.entities.DayOfLife;
import application.repository.IDayOfLifeRepository;

@RestController
public class DayOfLifeController {

  @Autowired
  private IDayOfLifeRepository dayOfLifeRepository;

  @RequestMapping(value = "/", method = RequestMethod.GET,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public Object getDaysOfLife() {
    List<DayOfLife> dof = dayOfLifeRepository.findAll();
    return dof;
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public Object getDaysOfLife(@PathVariable(value = "id") Long id) {
    DayOfLife dof = dayOfLifeRepository.findById(id);
    return dof;
  }


  @RequestMapping(value = "/save", method = RequestMethod.GET,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public Object save(@PathParam(value = "sensations") String sensations) {
    DayOfLife dof = new DayOfLife();
    dof.setDayOfLife(DateUtils.asDate(LocalDate.now()));
    dof.setSensations(sensations);
    dayOfLifeRepository.saveAndFlush(dof);
    return "data inserted with id " + dof.getId();
  }

  @RequestMapping(value = "/delete", method = RequestMethod.GET,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public Object delete() {
    dayOfLifeRepository.deleteAll();
    return "all data has been deleted";
  }
}
