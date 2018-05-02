package com.spring.version.model;

import java.io.Serializable;

/**
 * Created by lamendoza on 05/05/2017.
 * Clase del modelo de datos es decir clase que me permite ver todo los datos
 */
public class ExampleM implements Serializable {
    private Long Id;
    private String Name;
    private String MiddleName;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getMiddleName() {
        return MiddleName;
    }

    public void setMiddleName(String middleName) {
        MiddleName = middleName;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + Id +
                ", firstName='" + Name + '\'' +
                ", lastName='" + MiddleName + '\'' +
                '}';
    }

}
