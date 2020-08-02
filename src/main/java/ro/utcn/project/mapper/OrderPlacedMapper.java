package ro.utcn.project.mapper;

import ro.utcn.project.dto.OrderPlacedDto;
import ro.utcn.project.entities.OrderPlaced;

import java.util.ArrayList;
import java.util.List;

public class OrderPlacedMapper {
    public List<OrderPlacedDto> getOrders(List<OrderPlaced> orders)
    {
        List<OrderPlacedDto> orderDtos=new ArrayList<>();
        for(OrderPlaced o:orders)
        {
            orderDtos.add(new OrderPlacedDto(o));
        }
        return orderDtos;
    }
}
