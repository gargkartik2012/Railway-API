package org.springbootdemo.Railway.Controller;


import org.springbootdemo.Railway.Entity.RailwayEntry;
import org.springbootdemo.Railway.Service.RailwayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/Railway")
public class railwayController {

    private final RailwayService service;

    @Autowired
    public railwayController(RailwayService service) {
        this.service = service;
    }

    @GetMapping("/hello")
    public String welcome(){
        return "welcome to the page";
    }
    @PostMapping("/AddEntry")
    public RailwayEntry addEntry(@RequestBody RailwayEntry Railwayentry){
        return service.saveRailway(Railwayentry);
    }

    @PostMapping("/AddAllEntries")
    public List<RailwayEntry> addEntries(@RequestBody List<RailwayEntry> RailwayEntries){
        return service.saveAllRailway(RailwayEntries);
    }

    @GetMapping("/Entries")
    public ResponseEntity<List<RailwayEntry>> findAllRailwayEntries(){
        List<RailwayEntry> railwayEntryList = service.getRailwayEntry();
        if(railwayEntryList.size()<=0){

            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(railwayEntryList));

    }
        /* public List<RailwayEntry> findAllRailwayEntries(){
        return service.getRailwayEntry();
    }*/

    // this ResponseEntity is used when we send the Status code with the data to the server or fetch the details
    @GetMapping("/RailwayEntryById/{id}")
    public ResponseEntity<RailwayEntry> findRailwayEntryById(@PathVariable("id") int id){
        RailwayEntry railwayEntry = service.getRailwayEntryById(id);
        if(railwayEntry == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(railwayEntry));
    }
    /*public RailwayEntry findRailwayEntryById(@PathVariable int id){
        return service.getRailwayEntryById(id);
    }*/

    @GetMapping("/RailwayEntryByTicketNumber/{ticketNumber}")
    public RailwayEntry findByTicketNumber(@PathVariable int ticketNumber){
        return service.getRailwayEntryByTicketNumber(ticketNumber);
    }

    @GetMapping("/RailwayEntryByName/{name}")
    public RailwayEntry findRailwayEntryName(@PathVariable String name){
        return service.getRailwayEntryByName(name);
    }

    @GetMapping("/RailwayEntryByStartLocation/{startLocation}")
    public List<RailwayEntry> findAllByStartLocation(@PathVariable String startLocation){
        return service.getRailwayEntryByStartLocation(startLocation);
    }

    @GetMapping("/RailwayEntryByDestinationLocation/{destinationLocation}")
    public List<RailwayEntry> findAllByDestinationLocation(@PathVariable String destinationLocation){
        return service.getRailwayEntryByDestinationLocation(destinationLocation);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteRailwayEntry(@PathVariable int id){
        return service.deleteRailwayEntry(id);
    }




}
