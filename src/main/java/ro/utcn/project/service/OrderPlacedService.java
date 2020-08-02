package ro.utcn.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.utcn.project.entities.OrderPlaced;
import ro.utcn.project.repo.OrderPlacedRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class OrderPlacedService {
    @Autowired
    private OrderPlacedRepository orderPlacedRepository;

    public void insertOrder(OrderPlaced orderPlaced){orderPlacedRepository.save(orderPlaced);}

    public List<OrderPlaced> getAllOrdersPlaced(){return orderPlacedRepository.findAll();}

    public OrderPlaced findById(int id){return orderPlacedRepository.findById(id);}

    public boolean updateStatus(int id,String status)
    {
        OrderPlaced orderPlaced=findById(id);
        if(orderPlaced.setStatus(status)==true) {
            insertOrder(orderPlaced);
            return true;
        }
        return false;
    }
}