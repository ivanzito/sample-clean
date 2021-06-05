package br.com.ivan;

public interface AdapterInput<In, Out> {

    Out toInput(In input);
}
