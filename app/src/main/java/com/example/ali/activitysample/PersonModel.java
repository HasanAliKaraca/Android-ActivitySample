package com.example.ali.activitysample;

import java.io.Serializable;

/**
 * Created by ali on 29.07.2015.
 */
public class PersonModel implements Serializable {

    private String _name;
    private String _age;

    public String getAge() {
        return _age;
    }

    public PersonModel setAge(String _age) {
        this._age = _age;
        return this;
    }

    public String getName() {
        return _name;
    }

    public PersonModel setName(String _name) {
        this._name = _name;
        return this;
    }

    public void setModel(String name, String age) {
        this.setName(name);
        this.setAge(age);
    }
}
