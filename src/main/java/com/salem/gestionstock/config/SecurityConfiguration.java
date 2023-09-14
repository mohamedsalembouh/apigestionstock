package com.salem.gestionstock.config;

import jakarta.servlet.Filter;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfiguration {

}
