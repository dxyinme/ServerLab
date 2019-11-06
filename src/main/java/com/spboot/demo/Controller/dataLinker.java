package com.spboot.demo.Controller;

import com.spboot.demo.Comment.OperatorComment;
import com.spboot.demo.Comment.OperatorCommentImpl;
import com.spboot.demo.House_service.HouseService;
import com.spboot.demo.House_service.HouseServiceImp;
import com.spboot.demo.User.OperatorUser;
import com.spboot.demo.User.OperatorUserImpl;
import com.spboot.demo.Const.baiduAPI;

public class dataLinker {
    static protected OperatorUser opUser = new OperatorUserImpl();
    static protected HouseService opHouse = new HouseServiceImp();
    static protected OperatorComment opComment = new OperatorCommentImpl();

    static protected baiduAPI baiduapi = new baiduAPI();
}
