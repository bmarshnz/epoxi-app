package io.epoxi.app.repository.validation;

import java.util.Optional;

import io.epoxi.app.util.validation.ValidationCondition;
import io.epoxi.app.repository.modelbase.EngineMember;

public class NameNotNullCondition<T> implements ValidationCondition {
    
    final EngineMember<T> member;

    public NameNotNullCondition(EngineMember<T> member) {  
        this.member = member;      
    }
 
    public Optional<String> validate() {

        if (member.getName()!=null) 
            return Optional.empty();
        else
        {
            return Optional.of(String.format("Name cannot be null for object '%s'", member.toString()));
        }
            
    }
}