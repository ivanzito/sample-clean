package br.com.ivan;

import java.util.List;

public interface GenericCrud<In extends AdapterInput,Out extends AdapterOutput> {

    Out insert(In input);
    Out update(In input);
    void delete(In input);
    Out find(Long id);
    List<Out> findAll();

}
