package Homework;

import java.util.HashSet;

/**
 * Created by veron on 07.11.2016.
 */
public interface ISecondOrmContext {
    HashSet<DbUserEntity> getUsers();
    HashSet<DbUserInfoEntity> getUserInfos();
}
