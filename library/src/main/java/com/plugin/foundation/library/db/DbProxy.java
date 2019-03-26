package com.plugin.foundation.library.db;
import java.util.List;

/**
 * Created by cample on 2018/6/26.
 */

public final class DbProxy implements IDbAPI {
    private static IDbAPI iDbAPI;
    private DbProxy(){
    }
    public static void init(IDbAPI apiClass)
    {
        DbProxy.iDbAPI=apiClass;
    }
    public static DbProxy getInstance()
    {
       return IDBProxyHolder.instance;
    }

    @Override
    public String getDbName() {
        return iDbAPI.getDbName();
    }


    @Override
    public long insert(Object t) {
        return iDbAPI.insert(t);
    }

    @Override
    public long insertOrUpdate(Object t) {
        return iDbAPI.insertOrUpdate(t);
    }

    @Override
    public void insertOrReplaceTx(Object[] s) {
        iDbAPI.insertOrReplaceTx(s);
    }

    @Override
    public void delete(Object t) {
        iDbAPI.delete(t);
    }

    @Override
    public void deleteAll(Class<?> t) {
        iDbAPI.deleteAll(t);
    }

    @Override
    public void update(Object t) {
        iDbAPI.update(t);
    }


    @Override
    public <T> T loadById(Class<T> claz, Long id) {
        return iDbAPI.loadById(claz,id);
    }

    @Override
    public <T> List<T> loadAll(Class<T> t) {
        return iDbAPI.loadAll(t);
    }

    @Override
    public <T> T loadFirst(Class<T> t) {
        return iDbAPI.loadFirst(t);
    }

    @Override
    public long size(Class<Object> t) {
        return iDbAPI.size(t);
    }


    @Override
    public <T> List<T> customQuery(Class<T> t, String where, String... selectionArg) {
        return iDbAPI.customQuery(t, where, selectionArg);
    }

    private static class IDBProxyHolder
    {
        private static DbProxy instance = new DbProxy();
    }


}
