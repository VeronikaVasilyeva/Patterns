package com.company;

import Homework.DbUserEntity;
import Homework.DbUserInfoEntity;
import Homework.IDbEntity;
import Homework.IFirstOrm;

/**
 * Created by veron on 15.11.2016.
 */
public class FirstOrmAdapter implements ITarget{

    private final IFirstOrm<DbUserEntity> orm1;
    private final IFirstOrm<DbUserInfoEntity> orm2;

    public FirstOrmAdapter(IFirstOrm<DbUserEntity> orm1, IFirstOrm<DbUserInfoEntity> orm2) {
        this.orm1 = orm1; this.orm2= orm2;
    }

    @Override
    public void createUserEntity(DbUserEntity entity) {
        orm1.create(entity);
    }

    @Override
    public void createUserInfoEntity(DbUserInfoEntity entity) {
        orm2.create(entity);
    }

    @Override
    public DbUserEntity readUserEntity(int id) {
        return (DbUserEntity) orm1.read(id);
    }

    @Override
    public DbUserInfoEntity readUserInfoEntity(int id) {
        return (DbUserInfoEntity) orm2.read(id);
    }

    @Override
    public void updateUserEntity(DbUserEntity entity) {
        orm1.update(entity);
    }

    @Override
    public void updateUserInfoEntity(DbUserInfoEntity entity) {
        orm2.update(entity);
    }

    @Override
    public void deleteUserEntity(DbUserEntity entity) {
        orm1.delete(entity);
    }

    @Override
    public void deleteUserInfoEntity(DbUserInfoEntity entity) {
        orm2.delete(entity);
    }
}
