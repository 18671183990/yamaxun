package com.alan.yamaxun;

import android.app.Application;
import android.test.ApplicationTestCase;

import com.alan.yamaxun.db.DiscoverDao;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {

    private DiscoverDao dao;

    public ApplicationTest() {
        super(Application.class);

    }

    public void test1() {
        dao = new DiscoverDao(getContext());
        long result = dao.insertOneData("商品1", R.mipmap.xiezi1, "描述1", 168.00);
        assertEquals(true, result > 0);
    }

    public void testDeleteOneData(){
        dao = new DiscoverDao(getContext());
        long delete = dao.deleteOneData("商品3");
        assertEquals(1,delete);
    }

    public void testUpdateOneData(){
        dao = new DiscoverDao(getContext());
        int update = dao.updateProPrice("商品1", 500.00);
        assertEquals(1,update);
    }

    public void testQueryAll(){
        dao = new DiscoverDao(getContext());
        int columCount = dao.queryAll();
        assertEquals(10,columCount);
    }

public void test3(){
    dao = new DiscoverDao(getContext());
    int i = dao.insert10Datas();
    assertEquals(10,i);
}
}