package ro.utcn.project.mapper;

import ro.utcn.project.dto.ObjectForOrderDto;
import ro.utcn.project.entities.Object;

import java.util.ArrayList;
import java.util.List;

public class ObjectForOrderMapper {
    public List<ObjectForOrderDto> getObjects(List<Object> objects)
    {
        List<ObjectForOrderDto> objectsDto=new ArrayList<>();
        for(Object o:objects)
        {
            objectsDto.add(new ObjectForOrderDto(o));
        }
        return objectsDto;
    }
}
