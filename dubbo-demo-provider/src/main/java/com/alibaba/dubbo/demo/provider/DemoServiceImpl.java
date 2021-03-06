/*
 * Copyright 1999-2011 Alibaba Group.
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *  
 *      http://www.apache.org/licenses/LICENSE-2.0
 *  
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alibaba.dubbo.demo.provider;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.alibaba.dubbo.demo.api.DemoService;
import com.alibaba.dubbo.demo.api.bean.Fruit;
import com.alibaba.dubbo.rpc.RpcContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DemoServiceImpl implements DemoService {
    private static Log LOG = LogFactory.getLog(DemoServiceImpl.class);

    @Override
    public String sayHello(String name) {
//        int i = 2/0;
//        try {
//            Thread.sleep(7000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        LOG.info("[" + new SimpleDateFormat("HH:mm:ss").format(new Date()) + "] Hello " + name
                + ", request from consumer: " + RpcContext.getContext().getRemoteAddress());
        return "Hello " + name + ", response form provider: " + RpcContext.getContext().getLocalAddress();
    }

    @Override
    public Fruit getColor(Fruit fruit) {
        if ("Apple".equals(fruit.getName())) {
            fruit.setColor("red");
        } else {
            fruit.setColor("oops");
        }
        return fruit;
    }

}