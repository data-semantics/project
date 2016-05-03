package com.tutorial;

import java.util.ArrayList;

import com.hp.hpl.jena.rdf.model.Literal;
import com.hp.hpl.jena.rdf.model.Resource;
import com.sun.org.apache.xml.internal.security.Init;

public class OpenSearchBean {
	
		
    	private String openquery;
	    CustomQuery customQuery = new CustomQuery();
	    private  ArrayList<ResultStructure> resultFullList= new ArrayList<ResultStructure>();
		ResultStructure rs1 = new ResultStructure();
		private ResultStructure openResult = new ResultStructure();
	    private  ArrayList<String> subList= new ArrayList<String>();
	    private  ArrayList<String> objList= new ArrayList<String>();
	    private  ArrayList<String> propList= new ArrayList<String>();
		
	
	    
	    
	
	   public OpenSearchBean() {
			super();
		}

	public void searchSub(){
	    	ArrayList<String> list = new ArrayList<String>();
	    	ArrayList<Resource> arr= new ArrayList<Resource>();
	    	arr.addAll(customQuery.showSearchSub(openquery));
	    	for(int i=0;i<arr.size();i++){
	    	
		    	if(arr.get(i).getNode().isURI())
		    		list.add(arr.get(i).getURI());
		    	else if(arr.get(i).getNode().isBlank())
		    		list.add(arr.get(i).getId().toString());
	    	}

	    	this.setSubList(list);
	    }
	    
	    public void searchObj(){
	    	ArrayList<String> list = new ArrayList<String>();
	    	ArrayList<Literal> arr= new ArrayList<Literal>();
	    	arr.addAll(customQuery.showSearchObj(openquery));
	    	for(int i=0;i<arr.size();i++){
	    	list.add(arr.get(i).getValue().toString());
	    	}

	    	this.setObjList(list);
	    }
	 
	    public void searchProp(){
	    	ArrayList<String> list = new ArrayList<String>();
	    	ArrayList<Resource> arr= new ArrayList<Resource>();
	    	arr.addAll(customQuery.showSearchProp(openquery));
	    	for(int i=0;i<arr.size();i++){
	    	list.add(arr.get(i).getURI());
	    	}

	    	this.setPropList(list);
	    }
	    
	
	
	  // Search Tool Results
  

	public ArrayList<ResultStructure> getResultFullList() {	
	this.searchSub();
	this.searchObj();
	this.searchProp();
	
	 
	  for(int i=0;i<this.subList.size();i++){
		
		  ResultStructure temp = new ResultStructure();
		  temp.setSubject(this.subList.get(i));
		  temp.setObject(this.objList.get(i));
		  temp.setProperty(this.propList.get(i));
		  this.setOpenResult(temp);
		  resultFullList.add(this.getOpenResult());
		 
	  }
	
	
	
	return resultFullList;
	}

	public void setResultFullList(ArrayList<ResultStructure> resultFullList) {
		this.resultFullList = resultFullList;
	}

	public ArrayList<String> getSubList() {
		return subList;
	}

	public void setSubList(ArrayList<String> subList) {
		this.subList = subList;
	}

	public ArrayList<String> getObjList() {
		return objList;
	}

	public void setObjList(ArrayList<String> objList) {
		this.objList = objList;
	}

	public ArrayList<String> getPropList() {
		return propList;
	}

	public void setPropList(ArrayList<String> propList) {
		this.propList = propList;
	}

	public String getOpenquery() {
		return openquery;
	}

	public void setOpenquery(String openquery) {
		this.openquery = openquery;
	}

	public ResultStructure getOpenResult() {
		return openResult;
	}

	public void setOpenResult(ResultStructure openResult) {
		this.openResult = openResult;
	}
    
    
    
    

}
