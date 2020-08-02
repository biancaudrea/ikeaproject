package ro.utcn.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.utcn.project.entities.Object;
import ro.utcn.project.entities.OrderPlaced;
import ro.utcn.project.repo.ObjectRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ObjectService {
    @Autowired
    private ObjectRepository objectRepository;
    public List<Object> getAllObjects() {
        return objectRepository.findAll();
    }
    public void insertObject(Object object)
    {
        objectRepository.save(object);
    }
    public Object findById(int id){return objectRepository.findById(id);}
    public void updatePrice(int id,double newPrice){
        Object object=objectRepository.findById(id);
        object.setPrice(newPrice);
        insertObject(object);
    }
    public boolean updateOrder(Object object, OrderPlaced orderPlaced)
    {
        if(object.setOrderPlaced(orderPlaced)==true) {
            insertObject(object);
            return true;
        }
        return false;
    }
    public void deleteById(int id)
    {
        objectRepository.delete(findById(id));
    }
    public List<Object> sortByPrice(){return objectRepository.sortByPrice();}
}