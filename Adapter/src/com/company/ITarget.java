package com.company;

import Homework.DbUserEntity;
import Homework.DbUserInfoEntity;
import Homework.IDbEntity;

/**
 * Created by veron on 15.11.2016.
 */
public interface ITarget {

    void createUserEntity(DbUserEntity entity);
    void createUserInfoEntity(DbUserInfoEntity entity);

    DbUserEntity readUserEntity(int id);
    DbUserInfoEntity readUserInfoEntity(int id);

    void updateUserEntity(DbUserEntity entity);
    void updateUserInfoEntity(DbUserInfoEntity entity);

    void deleteUserEntity(DbUserEntity entity);
    void deleteUserInfoEntity(DbUserInfoEntity entity);
}
