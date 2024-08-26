package org.springbootdemo.Railway.Service;


import org.springbootdemo.Railway.Entity.RailwayEntry;
import org.springbootdemo.Railway.Repository.RailwayRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class RailwayService {



    private final RailwayRepo repository;

    @Autowired
    public RailwayService(RailwayRepo repository) {
        this.repository = repository;
    }

    public RailwayEntry saveRailway(RailwayEntry Railwayentry){
        return repository.save(Railwayentry);
    }

    public List<RailwayEntry> saveAllRailway(List<RailwayEntry> RailwayEntries){
        return repository.saveAll(RailwayEntries);
    }

    public List<RailwayEntry> getRailwayEntry(){
        return repository.findAll();
    }

    public RailwayEntry getRailwayEntryById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public RailwayEntry getRailwayEntryByTicketNumber(int ticketNumber){
        return repository.findByTicketNumber(ticketNumber);
    }


    public RailwayEntry getRailwayEntryByName(String name){
        return repository.findByName(name);

    }
    public List<RailwayEntry> getRailwayEntryByStartLocation(String startLocation){
        return repository.findAllByStartLocation(startLocation);
    }


    public List<RailwayEntry> getRailwayEntryByDestinationLocation(String destinationLocation){
        return repository.findAllByDestinationLocation(destinationLocation);
    }

    public String deleteRailwayEntry(int id){
        repository.deleteById(id);
        return "Entry removed !!" +id;
    }

    public RailwayEntry updateRailwayEntry(RailwayEntry railwayEntry){
        RailwayEntry existingEntry = repository.findByTicketNumber(railwayEntry.getTicketNumber());
        assert existingEntry !=null;
        existingEntry.setId(railwayEntry.getId());
        existingEntry.setName(railwayEntry.getName());
        existingEntry.setDestinationLocation(railwayEntry.getDestinationLocation());
        existingEntry.setTicketNumber(railwayEntry.getTicketNumber());
        existingEntry.setPrice(railwayEntry.getPrice());
        existingEntry.setStartLocation(railwayEntry.getStartLocation());
        return repository.save(existingEntry);


    }
}


