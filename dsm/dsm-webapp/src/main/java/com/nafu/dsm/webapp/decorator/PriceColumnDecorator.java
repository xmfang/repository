package com.nafu.dsm.webapp.decorator;

import javax.servlet.jsp.PageContext;

import org.displaytag.decorator.DisplaytagColumnDecorator;
import org.displaytag.exception.DecoratorException;
import org.displaytag.properties.MediaTypeEnum;

public class PriceColumnDecorator implements DisplaytagColumnDecorator {

	@Override
	public Object decorate(Object columnValue, PageContext pageContext, MediaTypeEnum media) throws DecoratorException {
		return (float)((Integer)columnValue)/100;
	}

}
