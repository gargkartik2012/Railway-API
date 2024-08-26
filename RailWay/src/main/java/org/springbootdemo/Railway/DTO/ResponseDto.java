package org.springbootdemo.Railway.DTO;

public record ResponseDto(Integer id,String name,Integer ticketNumber,String startLocation,String destinationLocation) {
}
