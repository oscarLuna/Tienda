package com.mpersd.techshop.configuracion;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

public class SecurityWebApplicationInitializer extends AbstractSecurityWebApplicationInitializer{

	public SecurityWebApplicationInitializer() {
		System.out.println("security iniciado");
	}

}
