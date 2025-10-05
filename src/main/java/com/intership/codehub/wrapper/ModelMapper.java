package com.intership.codehub.wrapper;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ModelMapper<T> {
    private String status;  // "success" or "error"
    private String message; // description
    private T data;         // payload (any object)
}

