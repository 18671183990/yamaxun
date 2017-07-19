package com.alan.yamaxun.config;

import com.alan.yamaxun.R;

/**
 * projectName: yamaxun
 * packageName: com.alan.yamaxun.config
 * className:   Constans
 * author:  Alan
 * time:    2016/7/31	21:33
 * desc:    TODO
 */
public interface Constans {
    //首页轮播图数据
    int[] bannerPics = {R.mipmap.banner1, R.mipmap.banner2, R.mipmap.banner3};

    /*鞋子图标*/
    int[] shoesIcons = {
            R.mipmap.xiezi1, R.mipmap.xiezi2, R.mipmap.xiezi3, R.mipmap.xiezi4,
            R.mipmap.xiezi5, R.mipmap.xiezi6, R.mipmap.xiezi7, R.mipmap.xiezi8,
            R.mipmap.xiezi9, R.mipmap.xiezi10, R.mipmap.xiezi11, R.mipmap.xiezi12};

    /*鞋子描述*/
    String[] shoesDescs = {
            "年轻时尚,运动首选", "年轻时尚,简单轻便", "高贵奢华,充满活力信息", "时尚保暖,上档次",
            "实用耐穿,高性价比", "运动时尚,透气性好", "高贵奢华,品质保证", "外国进口品牌",
            "低调奢华,有内涵", "年轻时尚,新鲜活力", "贵族气息,欧美风尚", "简约时尚,色彩搭配协调"};

    /*鞋子价格*/
    double[] shoesPrices = {65.00, 78.00, 700.00, 300.00, 120.00, 70.00, 2000.00, 398.00, 266.00, 5998.00, 29980.00, 1888.00};

    String[] categoryLeftData = {
            "为你推荐",
            "Kindle商店",
            "海外购",
            "图书",
            "手机通讯",
            "电脑产品",
            "服饰箱包",
            "母婴用品",
            "运动户外",
            "鞋靴",
            "个护健康",
            "食品酒饮",
            "小家电",
            "家居生活",
            "美容化妆",
            "数码影音",
            "钟表",
            "玩具"};

    String[] fenlei = {"热门分类", "手机", "腕表", "笔记本电脑", "白酒", "平板电视", "儿童文学", "空调", "科普百科", "少儿英语", "礼品卡"};

    //Z秒杀鞋子图片ID
    int[] zMiaoSha = {R.mipmap.xiezi3, R.mipmap.xiezi9, R.mipmap.xiezi10, R.mipmap.xiezi12};

    //推荐页面的第一个GradView的数据
    int[] gradImageData1 = {R.mipmap.xiezi3, R.mipmap.xiezi4};
    String[] gradDescData1 = {"款款惊爆价", "超低惊喜价"};

    //推荐页面的第二个GradView的数据
    int[] gradImageData2 = {R.mipmap.xiezi5, R.mipmap.xiezi9, R.mipmap.xiezi11, R.mipmap.xiezi3, R.mipmap.xiezi10, R.mipmap.xiezi12};
    String[] gradDescData2 = {"平底单鞋", "时尚高跟", "复古风格", "夏季凉鞋", "单鞋", "增高鞋"};

    int[] gradPicData1 = {R.mipmap.pro1, R.mipmap.pro2, R.mipmap.pro3, R.mipmap.pro4, R.mipmap.pro5, R.mipmap.pro6, R.mipmap.pro7, R.mipmap.pro8, R.mipmap.pro9, R.mipmap.pro10};

}
