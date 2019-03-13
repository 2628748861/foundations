package com.plugin.foundation.library.db;

import android.content.ContentValues;

import java.util.List;

public class DbProxy implements IDbAPI {

    private static IDbAPI iDbAPI;
    private DbProxy(){}
    public static void init(IDbAPI iDbAPI)
    {
        DbProxy.iDbAPI=iDbAPI;
    }
    public static DbProxy getInstance()
    {
        return IDbAPIHolder.instance;
    }

    @Override
    public void save(Object o) {
        iDbAPI.save(o);
    }

    @Override
    public void save(Object[] t) {
        iDbAPI.save(t);
    }

    @Override
    public void delete(Class claz, long id) {
        iDbAPI.delete(claz, id);
    }

    @Override
    public void delete(Class claz, String... condition) {
        iDbAPI.delete(claz, condition);
    }

    @Override
    public void update(Class claz, ContentValues contentValues, long id) {
        iDbAPI.update(claz, contentValues, id);
    }

    @Override
    public void update(Class claz, ContentValues contentValues, String... condition) {
        iDbAPI.update(claz, contentValues, condition);
    }

    @Override
    public Object find(Class claz, long id) {
        return iDbAPI.find(claz, id);
    }

    @Override
    public List find(Class claz) {
        return iDbAPI.find(claz);
    }

    @Override
    public List find(Class claz, String[] columns, String... condition) {
        return iDbAPI.find(claz, columns, condition);
    }

    static class IDbAPIHolder
    {
        private static DbProxy instance = new DbProxy();
    }


}
