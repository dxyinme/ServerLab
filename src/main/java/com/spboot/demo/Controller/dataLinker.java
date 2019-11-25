package com.spboot.demo.Controller;

import com.spboot.demo.Comment.OperatorComment;
import com.spboot.demo.Comment.OperatorCommentImpl;
import com.spboot.demo.House_service.HouseService;
import com.spboot.demo.House_service.HouseServiceImp;
import com.spboot.demo.LogicAPI.Urlcov.Urlcov;
import com.spboot.demo.User.OperatorUser;
import com.spboot.demo.User.OperatorUserImpl;
import com.spboot.demo.Const.baiduAPI;

public class dataLinker {
    static public OperatorUser opUser = new OperatorUserImpl();
    static public HouseService opHouse = new HouseServiceImp();
    static public OperatorComment opComment = new OperatorCommentImpl();

    static public Urlcov urlcov = new Urlcov();
    static public baiduAPI baiduapi = new baiduAPI();
}
