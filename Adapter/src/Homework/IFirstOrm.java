package Homework;

/**
 * Created by veron on 07.11.2016.
 */
public interface IFirstOrm<TDbEntity extends IDbEntity> {

    void create(TDbEntity entity);
    TDbEntity read(int id);
    void update(TDbEntity entity);
    void  delete(TDbEntity entity);
}
