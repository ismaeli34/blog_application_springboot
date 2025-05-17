package com.example.BlogApplicationSpringboot.exceptions;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * You don’t return null or let the app crash.
 * You return a meaningful error to the client.
 */

@Getter
@Setter
@NoArgsConstructor
public class ResourceNotFoundException  extends RuntimeException{
    String resourceName;
    String fieldName;
    Integer fieldValue;

    public ResourceNotFoundException( String resourceName, String fieldName, Integer fieldValue) {
        super(String.format("%s not found with %s : %d", resourceName,fieldName,fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
}
