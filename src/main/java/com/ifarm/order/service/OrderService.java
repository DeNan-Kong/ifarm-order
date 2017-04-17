package com.ifarm.order.service;

import com.ifarm.common.pojo.IfarmResult;
import com.ifarm.domin.TbOrder;
import com.ifarm.domin.TbOrderItem;
import com.ifarm.domin.TbOrderShipping;

import java.util.List;

public interface OrderService {

	IfarmResult createOrder(TbOrder order, List<TbOrderItem> itemList, TbOrderShipping orderShipping);
}
