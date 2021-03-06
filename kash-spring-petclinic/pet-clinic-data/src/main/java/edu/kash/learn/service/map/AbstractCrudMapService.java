package edu.kash.learn.service.map;

import edu.kash.learn.model.base.BaseEntity;
import edu.kash.learn.service.CrudService;
import edu.kash.learn.service.support.ServiceHelper;

public abstract class AbstractCrudMapService<T extends BaseEntity, ID extends String> implements CrudService<T, ID> {
    protected Map<ID, T> map = new HashMap<>();

    public T findById(ID o) {
        return map.get(o);
    }

    public T save(T object) {
        System.out.println("Called  to save from : " + this.getClass());
        if (object != null) {
            long nextId = getMaxValue();
            System.out.println("New nextid init");
            object.setId(nextId);
            map.put((ID) String.valueOf(nextId), object);
            return object;
        }
        throw new RuntimeException();
    }

    public Set<T> findAll() {
        return new HashSet(map.values());
    }

    public void deleteById(ID o) {
        map.remove(o);
    }

    public void deleteAll() {
        map.clear();
    }

    public void delete(T object) {
        map.entrySet().removeIf(idtEntry -> idtEntry.getValue().equals(object));
    }

    private long getMaxValue() {
        if (map.isEmpty()) {
            return 1;
        }
        return ServiceHelper.getaLong(Collections.max(map.keySet())) + 1;
    }

}
