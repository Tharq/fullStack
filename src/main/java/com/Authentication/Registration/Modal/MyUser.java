package com.Authentication.Registration.Modal;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("User")
public class MyUser {
    @org.springframework.data.annotation.Id
    private String Id;

    @NonNull
    private String name;

    @NonNull
    private String password;
}
