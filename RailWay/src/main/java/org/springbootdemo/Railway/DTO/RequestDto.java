package org.springbootdemo.Railway.DTO;

public record RequestDto(Integer id,String name,Integer ticketNumber,String startLocation,String destinationLocation) {
}
