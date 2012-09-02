package com.nafu.dsm.webapp.action.admin.dictionary;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.nafu.dsm.domain.Dictionary;
import com.nafu.dsm.webapp.action.EditBasicAction;

/**
 * @author xmfang
 *
 */
public class DictionaryEditAction extends EditBasicAction {

	private static final long serialVersionUID = -2961873565900673137L;
		
	private Dictionary dictionary;
	
	public String execute() {
		if (dictionary.getId() != null) {
			dictionary = Dictionary.get(Dictionary.class, dictionary.getId());
		}
		return SUCCESS;
	}

	@Action(value = "/admin/dictionary/dictionary-save",
			results = {@Result(name = "success", type = "redirect",
					location = "/admin/dictionary/dictionary-list.action", params = {"category", "%{dictionary.category}"})}
	)
	public String saveDictionary() {
		application.saveEntity(dictionary);
		return SUCCESS;
	}
	
	@Action(value = "/admin/dictionary/dictionary-remove",
		results = {@Result(name = "success", type = "redirect",
				location = "/admin/dictionary/dictionary-list.action", params = {"category", "%{dictionary.category}"})}
	)
	public String removeDictionary() {
		if (dictionary.getId() > 0) {
			dictionary = Dictionary.get(Dictionary.class, dictionary.getId());
			application.removeEntity(dictionary);
		}
		return SUCCESS;
	}
	
	//getters and setters

	public Dictionary getDictionary() {
		return dictionary;
	}

	public void setDictionary(Dictionary dictionary) {
		this.dictionary = dictionary;
	}

}
