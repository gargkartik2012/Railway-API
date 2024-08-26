package org.springbootdemo.Railway.DTO;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data              //@Data is a Lombok annotation that generates boilerplate code for you,
//i.e., getters, setters, equals(), hashCode and toString() methods.
@NoArgsConstructor
@AllArgsConstructor
public class RailwayDto {

        private Integer id;
        private String name;
        private Integer ticketNumber;
        private String startLocation;
        private String destinationLocation;
        private Integer price;






}
