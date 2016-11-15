package com.company;

import Homework.*;

/**
 * Created by veron on 15.11.2016.
 */
public class SecondOrmAdapter implements ITarget {

    private final ISecondOrmContext context;

    public SecondOrmAdapter(ISecondOrm orm) {
        this.context = orm.getContext();
    }

    @Override
    public void createUserEntity(DbUserEntity entity) {
        context.getUsers().add(entity);
    }

    @Override
    public void createUserInfoEntity(DbUserInfoEntity entity) {
        context.getUserInfos().add(entity);
    }

    @Override
    public DbUserEntity readUserEntity(int id) {
        return (DbUserEntity) context.getUsers().stream().filter((s) -> s.getId() == id);
    }

    @Override
    public DbUserInfoEntity readUserInfoEntity(int id) {
        return (DbUserInfoEntity) context.getUsers().stream().filter((s) -> s.getId() == id);
    }

    @Override
    public void updateUserEntity(DbUserEntity entity) {
        DbUserEntity copy = (DbUserEntity) context.getUsers().stream().filter((s) -> s.getId() == entity.getId());
        deleteUserEntity(copy);
        context.getUsers().add(entity);
    }

    @Override
    public void updateUserInfoEntity(DbUserInfoEntity entity) {
        DbUserInfoEntity copy = (DbUserInfoEntity) context.getUsers().stream().filter((s) -> s.getId() == entity.getId());
        deleteUserInfoEntity(copy);
        context.getUserInfos().add(entity);
    }

    @Override
    public void deleteUserEntity(DbUserEntity entity) {
        context.getUsers().remove(entity);
    }

    @Override
    public void deleteUserInfoEntity(DbUserInfoEntity entity) {
        context.getUsers().remove(entity);
    }
}
