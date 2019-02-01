package com.geospace.exception.handlers;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * GeoErrorController
 * This class is used to provide support for error pages.
 * @author Prasad Ramalingam
 *
 */
@RestController
public class GeoErrorController implements ErrorController {

	private static final String PATH = "/error";

	@RequestMapping(value = PATH)
	public String error() {
		return "Please check your Data";
	}

	@Override
	public String getErrorPath() {
		return PATH;
	}

}
