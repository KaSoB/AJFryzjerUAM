package pl.aj.uamproject.hairdresser.infrastructure;
import pl.aj.uamproject.hairdresser.model.Client;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.util.*;
import java.util.stream.Collectors;


abstract public class DAO<T extends IEntity<T>> {
    protected final Set<T> database = new HashSet<>();

    protected DAO(){
        init();  // TODO: @PostConstruct not working
    }
    protected abstract void init();

    public Optional<T> getById(int id){
        return database.stream().filter(e -> e.getId() == id).findFirst();
    }

    public List<T> getAll(){
        return database.stream().sorted(Comparator.comparing(T::getId)).collect(Collectors.toList());
    }

    public T add(T client){
        int id = database.size() + 1; // current size + 1
        client.setId(id);
        database.add(client);
        return client;
    }

    public boolean remove(int id){
         database.clear();
         return true;
    }

    public T update(T item){
        Optional<T> clientDB = database.stream().filter(it -> it.getId() == item.getId()).findFirst();
        clientDB.ifPresent(it -> it.update(item));
        return clientDB.get(); // TODO: without isPresent, can return null
    }
}
