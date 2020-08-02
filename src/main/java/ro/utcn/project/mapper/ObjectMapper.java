package ro.utcn.project.mapper;

import ro.utcn.project.dto.ObjectDto;
import ro.utcn.project.entities.Object;

import java.util.ArrayList;
import java.util.List;

public class ObjectMapper {
    public List<ObjectDto> getObjects(List<Object> objects)
    {
        List<ObjectDto> objectsDto=new ArrayList<>();
        for(Object o:objects)
        {
            objectsDto.add(new ObjectDto(o));
        }
        return objectsDto;
    }
}
