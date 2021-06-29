package com.example.boot.JDBC.controller;

/**
 * @author xjm
 * @version 1.0
 * @date 2021-06-29 22:51
 */

import com.example.boot.JDBC.mapper.mysqldb.TbOrderMapper;
import com.example.boot.JDBC.model.mysqldb.TbOrder;
import com.example.boot.JDBC.model.mysqldb.TbOrderExample;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class OrderController {
    protected static final Logger logger = LoggerFactory
            .getLogger(OrderController.class);



    @Resource
    private TbOrderMapper tbOrderMapper ;

    /**
     * 数据插入测试
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/dataInsert",method = RequestMethod.GET)
    @ResponseBody
    public JSONObject dataInsert(HttpServletRequest request, HttpServletResponse response ) throws Exception{
        try {
            TbOrder order = new TbOrder();
            order.setPayment("111");
            tbOrderMapper.insert(order);
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("return_code", "0");
            jsonObject.put("operation","2");
            return jsonObject;
        } catch (Exception e) {
            logger.error("OrderController.dataInsert error", e);
            return getBusinessJson("参数异常，请联系管理员");
        }
    }


    /**
     * 分页查询+数据删除
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/dataDelete",method = RequestMethod.GET)
    @ResponseBody
    public JSONObject dataDelete(HttpServletRequest request, HttpServletResponse response ) throws Exception{
        try {
            TbOrder queryBean = new TbOrder();
            PageHelper.startPage(1, 10);
            TbOrderExample tbOrderExample =new TbOrderExample();
            List<TbOrder> tabUsers = tbOrderMapper.selectByExample(tbOrderExample);

            for (TbOrder record : tabUsers){
                tbOrderMapper.deleteByPrimaryKey(record.getOrderId());
            }
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("return_code", "0");
            jsonObject.put("operation","2");
            jsonObject.put("data",tabUsers);
            return jsonObject;
        } catch (Exception e) {
            logger.error("UserController.dataDelete error", e);
            return getBusinessJson("参数异常，请联系管理员");
        }
    }

    /**
     * 数据全删
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/dataDestory",method = RequestMethod.GET)
    @ResponseBody
    public JSONObject dataDestory(HttpServletRequest request, HttpServletResponse response ) throws Exception{
        try {
            TbOrderExample tbOrderExample=new TbOrderExample();
            tbOrderMapper.deleteByExample(tbOrderExample);

            JSONObject jsonObject = new JSONObject();
            jsonObject.put("return_code", "0");
            jsonObject.put("operation","2");

            return jsonObject;
        } catch (Exception e) {
            logger.error("OrderController.dataDestory error", e);
            return getBusinessJson("参数异常，请联系管理员");
        }
    }

    public JSONObject getBusinessJson(String msg) throws JSONException {
        if(Strings.isNullOrEmpty(msg)) {
            msg="数据不合法，请重试！";
        }
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("return_code", "-1002");
        jsonObject.put("return_msg", msg);
        return jsonObject;
    }
}