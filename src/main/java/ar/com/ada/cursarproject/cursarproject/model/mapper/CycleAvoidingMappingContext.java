package ar.com.ada.cursarproject.cursarproject.model.mapper;

import org.mapstruct.BeforeMapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.TargetType;
import org.springframework.stereotype.Component;

import java.util.IdentityHashMap;
import java.util.Map;

@Component("cycleAvoidingMappingContext")
public class CycleAvoidingMappingContext {

    private Map<Object, Object> knownInstances = new IdentityHashMap<>();
    private static CycleAvoidingMappingContext INSTANCE = null;

    @BeforeMapping
    public <T> T getMappedInstance (Object source, @TargetType Class<T> targetType){
        return (T) knownInstances.get(source);
    }

    @BeforeMapping
    public void storeMappedinstance(Object source, @MappingTarget Object targetType){
        knownInstances.put(source, targetType);
    }

    public static CycleAvoidingMappingContext getInstance() {
        if(INSTANCE == null)
            INSTANCE = new CycleAvoidingMappingContext();

        return INSTANCE;
    }

      
}
