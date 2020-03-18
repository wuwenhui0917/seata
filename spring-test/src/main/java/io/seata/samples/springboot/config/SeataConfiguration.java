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
package io.seata.samples.springboot.config;

import io.seata.spring.annotation.GlobalTransactionScanner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * The type Seata configuration.
 */
@Configuration
public class SeataConfiguration {

	@Value("${spring.application.name}")
	private String applicationId;

	/**
	 * 注册一个StatViewServlet
	 *
	 * @return global transaction scanner
	 */
	@Bean
	public GlobalTransactionScanner globalTransactionScanner() {
        GlobalTransactionScanner globalTransactionScanner = new GlobalTransactionScanner(applicationId,
            "my_test_tx_group");
		return globalTransactionScanner;
	}
}
