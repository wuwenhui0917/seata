/*
 *  Copyright 1999-2019 Seata.io Group.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package io.seata.integration.dubbo;

import org.apache.dubbo.common.Constants;
import org.apache.dubbo.common.extension.Activate;
import org.apache.dubbo.rpc.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Copyright asiainfo.com
 *
 * @author wuwh6
 */
@Activate(group = {Constants.PROVIDER},order =100 )
public class AccessLogFilter implements Filter {

    private Logger logger= LoggerFactory.getLogger(AccessLogFilter.class);

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {

        if(logger.isInfoEnabled()){
            String address = RpcContext.getContext().getRemoteAddress().getHostString();
            logger.info("处理ip为："+address);
        }

        return invoker.invoke(invocation);
    }
}
