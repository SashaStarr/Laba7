package ua.lviv.iot.string.controller;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ua.lviv.iot.string.model.Lion;

@RequestMapping("/lions")
@RestController
public class LionsController {
	private Map<Integer, Lion> lions = new HashMap<>();
	  private AtomicInteger idAccount = new AtomicInteger();

	  @GetMapping
	  public List<Lion> getAllLions() {
	    return new LinkedList<Lion>(lions.values());
	  }

	  @GetMapping(path = "/{id}")
	  public Lion getLion(@PathVariable("id") Integer lionId) {
	    System.out.println(lionId);
	    return lions.get(lionId);
	  }

	  @PostMapping
	  public Lion createDress(final @RequestBody Lion lion) {
	    lion.setId(idAccount.incrementAndGet());
	    lions.put(lion.getId(), lion);
	    return lion;
	  }

	  @DeleteMapping(path = "/{id}")
	  public ResponseEntity<Lion> deleteLion(@PathVariable("id") Integer lionId) {
	   HttpStatus status = lions.remove(lionId)==null?HttpStatus.NOT_FOUND:HttpStatus.OK;
	   return ResponseEntity.status(status).build();
	 
	  }
	  @PutMapping(path= "/{id}")
	  public Lion updateLion(final @PathVariable ("id") Integer lionId, 
	      final @RequestBody Lion lion) {
	    lion.setId(lionId);
	    return lions.put(lionId, lion);
	  }
	  }

