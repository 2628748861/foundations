package com.plugin.foundation.library.db;

import android.content.ContentValues;

import org.litepal.LitePal;
import org.litepal.crud.LitePalSupport;

import java.util.Arrays;
import java.util.List;

public class LitePalApi implements IDbAPI<LitePalSupport>
{
    @Override
    public void save(LitePalSupport litePalSupport) {
        litePalSupport.save();
    }

    @Override
    public void save(LitePalSupport... t) {
        LitePal.saveAll(Arrays.asList(t));
    }

    @Override
    public void delete(Class<LitePalSupport> claz, long id) {
        LitePal.delete(claz,id);
    }

    @Override
    public void delete(Class<LitePalSupport> claz,String... condition) {
        LitePal.deleteAll(claz,condition);
    }

    @Override
    public void update(Class<LitePalSupport> claz, ContentValues contentValues, long id) {
        LitePal.update(claz,contentValues,id);
    }

    @Override
    public void update(Class<LitePalSupport> claz, ContentValues contentValues, String... condition) {
        LitePal.updateAll(claz,contentValues,condition);
    }

    @Override
    public LitePalSupport find(Class<LitePalSupport> claz, long id) {
        return LitePal.find(claz,id);
    }

    @Override
    public List<LitePalSupport> find(Class<LitePalSupport> claz) {
        return LitePal.findAll(claz);
    }

    @Override
    public List<LitePalSupport> find(Class<LitePalSupport> claz, String[] columns, String... condition) {
        return LitePal.select(columns).where(condition).find(claz);
    }
}
