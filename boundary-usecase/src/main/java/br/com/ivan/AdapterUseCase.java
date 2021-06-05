package br.com.ivan;

public interface AdapterUseCase<T, E> {

    UserOutput toOutput(T out);
    E toEntity(UserInput input);

}
