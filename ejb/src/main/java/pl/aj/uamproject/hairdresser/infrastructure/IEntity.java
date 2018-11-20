package pl.aj.uamproject.hairdresser.infrastructure;


public interface IEntity<T> {
    Integer getId();

    void setId(Integer var1);

    void update(T var1);
}
