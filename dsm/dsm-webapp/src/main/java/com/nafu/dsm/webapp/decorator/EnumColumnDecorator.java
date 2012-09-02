package com.nafu.dsm.webapp.decorator;

import java.util.Locale;

import javax.servlet.jsp.PageContext;

import org.displaytag.decorator.DisplaytagColumnDecorator;
import org.displaytag.exception.DecoratorException;
import org.displaytag.properties.MediaTypeEnum;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.LocaleProvider;
import com.opensymphony.xwork2.TextProvider;
import com.opensymphony.xwork2.TextProviderFactory;

public class EnumColumnDecorator implements DisplaytagColumnDecorator, LocaleProvider {

	@Override
	public Object decorate(Object columnValue, PageContext pageContext, MediaTypeEnum media) throws DecoratorException {
		return getTextProvider().getText(columnValue.toString());
	}

	private TextProvider getTextProvider() {
        return new TextProviderFactory().createInstance(getClass(), this);
    }

	@Override
	public Locale getLocale() {
		return ActionContext.getContext().getLocale();
	}
}
