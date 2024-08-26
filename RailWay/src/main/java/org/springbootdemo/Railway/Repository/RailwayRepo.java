package org.springbootdemo.Railway.Repository;

import org.springbootdemo.Railway.Entity.RailwayEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RailwayRepo extends JpaRepository<RailwayEntry,Integer> {
    List<RailwayEntry> findAllByStartLocation(String startLocation);
    RailwayEntry findByName(String name);

    List<RailwayEntry> findAllByDestinationLocation(String DestinationLocation);

    void deleteRailwayEntryById(int id);

    RailwayEntry findByTicketNumber(int ticketNumber);
}
