package com.bean;

import java.util.ArrayList;
import java.util.List;

import com.hp.hpl.jena.rdf.model.Literal;
import com.hp.hpl.jena.rdf.model.Resource;
import com.rdf.CustomQuery;
import com.rdf.QueryClass;


public class TestBean extends Object{
	
		QueryClass queryInstance= new QueryClass();
		CustomQuery customQuery = new CustomQuery();
	
		
	    public List<String> getItems1() {
	        List<String> list = new ArrayList<String>();
	        list.add("Sample Annotation List");
	        list.add("Creators who mention Marguerite Derrida");
	        list.add("All English Annotations");
	        return list;
	    }

	    public ArrayList<String> getAnnoName(){
	    	ArrayList<String> list = new ArrayList<String>();
	    	ArrayList<Literal> arr= new ArrayList<Literal>();
	    	arr.addAll(queryInstance.showAnnoName());
	    	for(int i=0;i<arr.size();i++){
	    	list.add(arr.get(i).getValue().toString());
	    	}

	    	return list;
	    }
	    
	    public ArrayList<String> getAnnoURI(){
	    	ArrayList<String> listAnnoURI = new ArrayList<String>();
	    	ArrayList<Resource> arr= new ArrayList<Resource>();
	    	arr.addAll(queryInstance.showAnnotation());
	    	for(int i=0;i<arr.size();i++){
	    		listAnnoURI.add(arr.get(i).getURI());
	    	}

	    	return listAnnoURI;
	    }
	    
	    
	    public ArrayList<String> getAnnoText(){
	    	ArrayList<String> list = new ArrayList<String>();
	    	ArrayList<Literal> arr= new ArrayList<Literal>();
	    	arr.addAll(queryInstance.showAnnoText());
	    	for(int i=0;i<arr.size();i++){
	    	list.add(arr.get(i).getValue().toString());
	    	}

	    	return list;
	    }
	    
	    public ArrayList<String> getCreatorAnno(){
	    	ArrayList<String> list = new ArrayList<String>();
	    	ArrayList<Resource> arr= new ArrayList<Resource>();
	    	arr.addAll(customQuery.showCreatorAnno());
	    	for(int i=0;i<arr.size();i++){
	    	list.add(arr.get(i).getURI());
	    	}

	    	return list;
	    }
	    
	    public ArrayList<String> getCreatorName(){
	    	ArrayList<String> list = new ArrayList<String>();
	    	ArrayList<Literal> arr= new ArrayList<Literal>();
	    	arr.addAll(customQuery.showCreatorNames());
	    	for(int i=0;i<arr.size();i++){
	    	list.add(arr.get(i).getValue().toString());
	    	}

	    	return list;
	    }
	    
	    
	    public ArrayList<String> getAnnoBody(){
	    	ArrayList<String> list = new ArrayList<String>();
	    	ArrayList<Resource> arr= new ArrayList<Resource>();
	    	arr.addAll(customQuery.showAnnoBodyEng());
	    	for(int i=0;i<arr.size();i++){
	    	list.add(arr.get(i).getURI());
	    	}

	    	return list;
	    }
	    
	    public ArrayList<String> getAnnoBodyText(){
	    	ArrayList<String> list = new ArrayList<String>();
	    	ArrayList<Literal> arr= new ArrayList<Literal>();
	    	arr.addAll(customQuery.showAnnoTextEng());
	    	for(int i=0;i<arr.size();i++){
	    	list.add(arr.get(i).getValue().toString());
	    	}

	    	return list;
	    }
	    
	    public ArrayList<String> getSearchSub(){
	    	ArrayList<String> list = new ArrayList<String>();
	    	ArrayList<Resource> arr= new ArrayList<Resource>();
	    	arr.addAll(customQuery.showSearchSub());
	    	for(int i=0;i<arr.size();i++){
	    	
		    	if(arr.get(i).getNode().isURI())
		    		list.add(arr.get(i).getURI());
		    	else if(arr.get(i).getNode().isBlank())
		    		list.add(arr.get(i).getId().toString());
	    	}

	    	return list;
	    }
	    
	    public ArrayList<String> getSearchObj(){
	    	ArrayList<String> list = new ArrayList<String>();
	    	ArrayList<Literal> arr= new ArrayList<Literal>();
	    	arr.addAll(customQuery.showSearchObj());
	    	for(int i=0;i<arr.size();i++){
	    	list.add(arr.get(i).getValue().toString());
	    	}

	    	return list;
	    }
	    public ArrayList<String> getSearchProp(){
	    	ArrayList<String> list = new ArrayList<String>();
	    	ArrayList<Resource> arr= new ArrayList<Resource>();
	    	arr.addAll(customQuery.showSearchProp());
	    	for(int i=0;i<arr.size();i++){
	    	list.add(arr.get(i).getURI());
	    	}

	    	return list;
	    }
	    

	  
}
