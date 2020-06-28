package com.szkhb.accenture.reboarding;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.cloud.config.server.EnableConfigServer;

import ch.sbb.esta.openshift.gracefullshutdown.GracefulshutdownSpringApplication;

@SpringBootApplication
@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class })
@EnableConfigServer
public class ConfigServerApplication {
	public static void main(String[] args) {
		GracefulshutdownSpringApplication.run(ConfigServerApplication.class, args);
	}
}