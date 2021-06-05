package br.com.ivan;

public interface AdapterOutput<In, Out> {
    Out toPresenter(In input);
}
