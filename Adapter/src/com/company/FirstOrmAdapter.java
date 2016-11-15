package com.company;

import Homework.DbUserEntity;
import Homework.DbUserInfoEntity;
import Homework.IDbEntity;
import Homework.IFirstOrm;

/**
 * Created by veron on 15.11.2016.
 */
public class FirstOrmAdapter implements ITarget{

    private final IFirstOrm<IDbEntity> orm;

    public FirstOrmAdapter(IFirstOrm orm) {
        this.orm = orm;
    }

    @Override
    public void createUserEntity(DbUserEntity entity) {
        orm.create(entity);
    }

    @Override
    public void createUserInfoEntity(DbUserInfoEntity entity) {
        orm.create(entity);
    }

    @Override
    public DbUserEntity readUserEntity(int id) {
        return (DbUserEntity) orm.read(id);
    }

    @Override
    public DbUserInfoEntity readUserInfoEntity(int id) {
        return (DbUserInfoEntity) orm.read(id);
    }

    @Override
    public void updateUserEntity(DbUserEntity entity) {
        orm.update(entity);
    }

    @Override
    public void updateUserInfoEntity(DbUserInfoEntity entity) {
        orm.update(entity);
    }

    @Override
    public void deleteUserEntity(DbUserEntity entity) {
        orm.delete(entity);
    }

    @Override
    public void deleteUserInfoEntity(DbUserInfoEntity entity) {
        orm.delete(entity);
    }
}
