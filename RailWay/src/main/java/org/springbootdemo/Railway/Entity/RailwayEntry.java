package org.springbootdemo.Railway.Entity;


import jakarta.persistence.*;
import lombok.*;


@Data              //@Data is a Lombok annotation that generates boilerplate code for you,
                    //i.e., getters, setters, equals(), hashCode and toString() methods.
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name="Railway_Enquiry")
public class RailwayEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private Integer ticketNumber;
    private String startLocation;
    private String destinationLocation;
    private Integer price;




}
