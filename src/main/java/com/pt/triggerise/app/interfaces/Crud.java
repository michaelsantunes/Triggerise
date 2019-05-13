package com.pt.triggerise.app.interfaces;

import java.util.List;
import java.util.Optional;

public interface Crud {

    void save();
    void remove();
    Optional<?> getByName(String parameter);
    List<?> listAll();

}
