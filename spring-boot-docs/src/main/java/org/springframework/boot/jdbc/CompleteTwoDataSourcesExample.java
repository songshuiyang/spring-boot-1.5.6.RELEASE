/*
 * Copyright 2012-2017 the original author or authors.
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

package org.springframework.boot.jdbc;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * Example configuration for configuring two data sources with what Spring Boot does in
 * auto-configuration.
 *
 * @author Stephane Nicoll
 */
public class CompleteTwoDataSourcesExample {

	/**
	 * A complete configuration that exposes two data sources.
	 */
	@Configuration
	static class CompleteDataSourcesConfiguration {

		// tag::configuration[]
		@Bean
		@Primary
		@ConfigurationProperties("app.datasource.foo")
		public DataSourceProperties fooDataSourceProperties() {
			return new DataSourceProperties();
		}

		@Bean
		@Primary
		@ConfigurationProperties("app.datasource.foo")
		public DataSource fooDataSource() {
			return fooDataSourceProperties().initializeDataSourceBuilder().build();
		}

		@Bean
		@ConfigurationProperties("app.datasource.bar")
		public DataSourceProperties barDataSourceProperties() {
			return new DataSourceProperties();
		}

		@Bean
		@ConfigurationProperties("app.datasource.bar")
		public DataSource barDataSource() {
			return barDataSourceProperties().initializeDataSourceBuilder().build();
		}
		// end::configuration[]

	}

}
