package com.ifarm.order.controller;

import com.ifarm.common.pojo.IfarmResult;
import com.ifarm.common.utils.ExceptionUtil;
import com.ifarm.order.pojo.Order;
import com.ifarm.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 订单Controller
 *
 */
@Controller
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@RequestMapping(value="/create", method=RequestMethod.POST)
	@ResponseBody
	public IfarmResult createOrder(@RequestBody Order order) {
		try {
            IfarmResult result = orderService.createOrder(order, order.getOrderItems(), order.getOrderShipping());
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return IfarmResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}
}
