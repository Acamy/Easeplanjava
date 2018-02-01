package com.hebaohua.part5_DB.day3;

/**
 * @author Hebh
 * @date 2018/2/1
 * @description:
 */
public interface UserMapper {
    public void insertUser(User user);

    public User getUser(String name);

    public void deleteUser(String name);

    public void updateUser(User user);
}
