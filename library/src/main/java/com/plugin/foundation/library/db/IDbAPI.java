package com.plugin.foundation.library.db;

import android.content.ContentValues;

import java.util.List;

/**
 * Created by cample on 2018/3/21.
 */

public interface IDbAPI<T>
{

    /**添加单条数据
     * @param t
     */
    void save(T t);
    /**添加数据
     * @param t
     * @return
     */
    void save(T... t);

    /**删除指定id数据
     * @param claz
     */
    void delete(Class<T> claz, long id);

    /**条件删除 举例：condition====>"duration > ?"
     * @param claz
     */
    void delete(Class<T> claz, String... condition);

    /**修改单条数据
     * @param
     */
    void update(Class<T> claz, ContentValues contentValues, long id);

    /**按条件修改指定类型数据
     * @param
     */
    void update(Class<T> claz, ContentValues contentValues, String... condition);


    /**查询指定id数据
     * @param claz
     * @param id
     */
    T find(Class<T> claz, long id);

    /**查询指定类型全部数据
     * @param claz
     */
    List<T> find(Class<T> claz);

    /**按指定条件查询指定类型全部数据
     * @param claz
     * @param condition
     */
    List<T> find(Class<T> claz, String[] columns, String... condition);
}