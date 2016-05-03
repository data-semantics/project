package com.tutorial;

import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import com.hp.hpl.jena.rdf.model.Literal;
import com.hp.hpl.jena.rdf.model.Resource;

public class LoginBean{
	 /**
	 * 
	 */

		private String locale = "en"; 
	    private String message = ""; 

		private String name;
	    private String password;
	    private String query;
	    private String customQ;
	    private String customQ1;
	    private String selectedCreator;
	    CustomQuery customQuery = new CustomQuery();
	    private  ArrayList<ResultStructure> resultFullList= new ArrayList<ResultStructure>();
	    private  ArrayList<ResultStructure> allEngAnnoList= new ArrayList<ResultStructure>();
	    private  ArrayList<ResultStructure> allFrAnnoList= new ArrayList<ResultStructure>();
	    private  ArrayList<ResultStructure> creatorFList= new ArrayList<ResultStructure>();
	    private  ArrayList<ResultStructure> annoEvaList= new ArrayList<ResultStructure>();
	    private  ArrayList<ResultStructure> creatorFullList= new ArrayList<ResultStructure>();
	    private  ArrayList<String> noCreatorList= new ArrayList<String>();
		private ResultStructure result = new ResultStructure();
		private ResultStructure engResult = new ResultStructure();
		private ResultStructure frResult = new ResultStructure();
		private ResultStructure creatorResult = new ResultStructure();
		private ResultStructure evaResult = new ResultStructure();
		ResultStructure rs1 = new ResultStructure();
	    private  ArrayList<String> subList= new ArrayList<String>();
	    private  ArrayList<String> objList= new ArrayList<String>();
	    private  ArrayList<String> propList= new ArrayList<String>();
	    private  ArrayList<String> creatorList= new ArrayList<String>();
	    private  ArrayList<String> creatorUrlList= new ArrayList<String>();
	    private  ArrayList<String> creatorTextList= new ArrayList<String>();
	    private  ArrayList<String> imageList= new ArrayList<String>();
	    private boolean showCreators = false;

	   
		
		   public void searchSub(String input){
		    	ArrayList<String> list = new ArrayList<String>();
		    	ArrayList<Resource> arr= new ArrayList<Resource>();
		    	arr.addAll(customQuery.showSearchSub(input));
		    	for(int i=0;i<arr.size();i++){
		    	
			    	if(arr.get(i).getNode().isURI())
			    		list.add(arr.get(i).getURI());
			    	else if(arr.get(i).getNode().isBlank())
			    		list.add(arr.get(i).getId().toString());
		    	}

		    	this.setSubList(list);
		    }
		    
		    public void searchObj(String input){
		    	ArrayList<String> list = new ArrayList<String>();
		    	ArrayList<Literal> arr= new ArrayList<Literal>();
		    	arr.addAll(customQuery.showSearchObj(input));
		    	for(int i=0;i<arr.size();i++){
		    	list.add(arr.get(i).getValue().toString());
		    	}

		    	this.setObjList(list);
		    }
		 
		    public void searchProp(String input){
		    	ArrayList<String> list = new ArrayList<String>();
		    	ArrayList<Resource> arr= new ArrayList<Resource>();
		    	arr.addAll(customQuery.showSearchProp(input));
		    	for(int i=0;i<arr.size();i++){
		    	list.add(arr.get(i).getURI());
		    	}

		    	this.setPropList(list);
		    }
		    
		    
		    
		    
		    public ArrayList<String> annoEngBody(){
		    	ArrayList<String> list = new ArrayList<String>();
		    	ArrayList<Resource> arr= new ArrayList<Resource>();
		    	arr.addAll(customQuery.showAnnoBodyEng("en"));
		    	for(int i=0;i<arr.size();i++){
		    	list.add(arr.get(i).getURI());
		    	}

		    	return list;
		    }
		    
		    public ArrayList<String> annoEngBodyText(){
		    	ArrayList<String> list = new ArrayList<String>();
		    	ArrayList<Literal> arr= new ArrayList<Literal>();
		    	arr.addAll(customQuery.showAnnoTextEng("en"));
		    	for(int i=0;i<arr.size();i++){
		    	list.add(arr.get(i).getValue().toString());
		    	}

		    	return list;
		    }
		    
		    
		    public ArrayList<String> annoFrBody(){
		    	ArrayList<String> list = new ArrayList<String>();
		    	ArrayList<Resource> arr= new ArrayList<Resource>();
		    	arr.addAll(customQuery.showAnnoBodyEng("fr"));
		    	for(int i=0;i<arr.size();i++){
		    	list.add(arr.get(i).getURI());
		    	}

		    	return list;
		    }
		    
		    public ArrayList<String> annoFrBodyText(){
		    	ArrayList<String> list = new ArrayList<String>();
		    	ArrayList<Literal> arr= new ArrayList<Literal>();
		    	arr.addAll(customQuery.showAnnoTextEng("fr"));
		    	for(int i=0;i<arr.size();i++){
		    	list.add(arr.get(i).getValue().toString());
		    	}

		    	return list;
		    }
		    
		    
		    public ArrayList<String> creatorAnno(){
		    	ArrayList<String> list = new ArrayList<String>();
		    	ArrayList<Resource> arr= new ArrayList<Resource>();
		    	arr.addAll(customQuery.showCreatorAnno());
		    	for(int i=0;i<arr.size();i++){
		    	list.add(arr.get(i).getURI());
		    	}

		    	return list;
		    }
		    
		    public ArrayList<String> creatorName(){
		    	ArrayList<String> list = new ArrayList<String>();
		    	ArrayList<Literal> arr= new ArrayList<Literal>();
		    	arr.addAll(customQuery.showCreatorNames());
		    	for(int i=0;i<arr.size();i++){
		    	list.add(arr.get(i).getValue().toString());
		    	}

		    	return list;
		    }
		    
		    
		    public ArrayList<String> createEvaAnno(){
		    	ArrayList<String> list = new ArrayList<String>();
		    	ArrayList<Resource> arr= new ArrayList<Resource>();
		    	arr.addAll(customQuery.showEvaNames());
		    	for(int i=0;i<arr.size();i++){
		    		list.add(arr.get(i).getURI());
		    	
		    	}

		    	return list;
		    }
		    
		    public ArrayList<String> createEvaText(){
		    	ArrayList<String> list = new ArrayList<String>();
		    	ArrayList<Literal> arr= new ArrayList<Literal>();
		    	arr.addAll(customQuery.showEvaText());
		    	for(int i=0;i<arr.size();i++){
		    		list.add(arr.get(i).getValue().toString());
		    	}

		    	return list;
		    }
		    
		    public void searchCreatorAnno(String input){
		    	ArrayList<String> list = new ArrayList<String>();
		    	ArrayList<Resource> arr= new ArrayList<Resource>();
		    	arr.addAll(customQuery.getCreatorAnnoList(input));
		    	for(int i=0;i<arr.size();i++){
		    	
			    	if(arr.get(i).getNode().isURI())
			    		list.add(arr.get(i).getURI());
			    	else if(arr.get(i).getNode().isBlank())
			    		list.add(arr.get(i).getId().toString());
		    	}

		    	this.setCreatorUrlList(list);
		    }
		    
		   
		 
		    public void searchCreatorText(String input){
		    	ArrayList<String> list = new ArrayList<String>();
		    	ArrayList<Literal> arr= new ArrayList<Literal>();
		    	arr.addAll(customQuery.getCreatorText(input));
		    	for(int i=0;i<arr.size();i++){
		    		list.add(arr.get(i).getValue().toString());
		    	}

		    	this.setCreatorTextList(list);
		    }
		    
		    public ArrayList<String> showImages(){
		    	ArrayList<String> list = new ArrayList<String>();
		    	ArrayList<Resource> arr= new ArrayList<Resource>();
		    	arr.addAll(customQuery.getAnnotationGallery());
		    	for(int i=0;i<arr.size();i++){
		    		list.add(arr.get(i).getURI());
		    	}

		    	return list;
		    }
		    
		 // Search Tool Results
		    public String openSearch(){
		    	
		    	if(query.equals("")){
		    		// Bring the error message using the Faces Context
					String errorMessage = "Please enter input for Search Annotation";
					// Add View Faces Message
					FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					errorMessage, errorMessage);
					// Add the message into context for a specific component
					FacesContext.getCurrentInstance().addMessage("derrida:message", message);
					return "";
		    	}
		    	else
		    	{
		    	this.searchSub(query);
		    	this.searchObj(query);
		    	this.searchProp(query);
		    	

				  for(int i=0;i<this.subList.size();i++){
					
					  ResultStructure temp = new ResultStructure();
					  temp.setSubject(this.subList.get(i));
					  temp.setObject(this.objList.get(i));
					  temp.setProperty(this.propList.get(i));
					  this.setResult(temp);
					  resultFullList.add(this.getResult());
					 
				  }
		    
		    	if(resultFullList.size()==0){
		    		String errorMessage = "No Results found for "+ query;
					// Add View Faces Message
					FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					errorMessage, errorMessage);
					// Add the message into context for a specific component
					FacesContext.getCurrentInstance().addMessage("derrida:message", message);
		    	}
		    	return "login";
		    	}
		    }
		    
		    
		   public String creatorSearch(){
				    	
			   /*String str = selectedCreator;
			   			String[] tokens = str.split(",");
			   			setSelectedCreator((tokens[1].concat(" ")).concat(tokens[0]));*/
				    	this.searchCreatorAnno(selectedCreator);
				    	this.searchCreatorText(selectedCreator);
				    	this.setShowCreators(true);
		
						  for(int i=0;i<this.creatorUrlList.size();i++){
							
							  ResultStructure temp = new ResultStructure();
							  temp.setSubject(this.creatorUrlList.get(i));
							  temp.setObject(this.creatorTextList.get(i));
							  this.setResult(temp);
							 creatorFullList.add(this.getResult());
							 
						  }
						  if(creatorFullList.size()==0){
					    		String errorMessage = "No Results found for "+ selectedCreator;
								// Add View Faces Message
								FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
								errorMessage, errorMessage);
								// Add the message into context for a specific component
								FacesContext.getCurrentInstance().addMessage("derrida:message", message);
					    	}
				    	return "login";
				    }
		    
		    public String customSearch(){
		    	
		    	if (getCustomQ().equals("first")){
		    		

				    // All English Annotations
		    		ArrayList<String> textList = new ArrayList<String>();
			    	ArrayList<String> bodyList = new ArrayList<String>();
			    	textList.addAll(this.annoEngBodyText());
			    	bodyList.addAll(this.annoEngBody());
			    	 
					  for(int i=0;i<textList.size();i++){
						
						  ResultStructure temp = new ResultStructure();
						  temp.setBody(bodyList.get(i));
						  temp.setText(textList.get(i));
						  this.setEngResult(temp);
						  allEngAnnoList.add(this.getEngResult());
						 
					  }
		    		
		    	}
		    	else if(getCustomQ().equals("second")){
		    		
		    		 // Creators who mention Marguerite Derrida
		    		ArrayList<String> creatorList = new ArrayList<String>();
			    	ArrayList<String> annoList = new ArrayList<String>();
			    	annoList.addAll(this.creatorAnno());
			    	creatorList.addAll(this.creatorName());
			    	 
					  for(int i=0;i<creatorList.size();i++){
						
						  ResultStructure temp = new ResultStructure();
						  temp.setCreatorAnno(annoList.get(i));
						  temp.setCreatorName(creatorList.get(i));
						  this.setCreatorResult(temp);
						  creatorFList.add(this.getCreatorResult());
						 
					  }
		    		
		    	}
		    	else if(getCustomQ().equals("third")){
		    		
		    		//Non Creators
			    	ArrayList<Resource> arr= new ArrayList<Resource>();
			    	arr.addAll(customQuery.showNotCreators());
			    	for(int i=0;i<arr.size();i++){
			    	noCreatorList.add(arr.get(i).getURI());
			    	}
		    		
		    	}
		    	else if(getCustomQ().equals("fourth")){
		    		
		    		 // List the text of annotations created by Eva Rosenblum
 
		    		ArrayList<String> evaAnnoList = new ArrayList<String>();
			    	ArrayList<String> evaTextList = new ArrayList<String>();
			    	evaTextList.addAll(this.createEvaText());
			    	evaAnnoList.addAll(this.createEvaAnno());
			    	 
					  for(int i=0;i<evaAnnoList.size();i++){
						
						  ResultStructure temp = new ResultStructure();
						  temp.setCreatorAnno(evaAnnoList.get(i));
						  temp.setCreatorName(evaTextList.get(i));
						  this.setEvaResult(temp);
						  annoEvaList.add(this.getEvaResult());
						 
					  }
			    	}
		    	else if (getCustomQ().equals("fifth")){
		    		

				    // All English Annotations
		    		ArrayList<String> textList = new ArrayList<String>();
			    	ArrayList<String> bodyList = new ArrayList<String>();
			    	textList.addAll(this.annoFrBodyText());
			    	bodyList.addAll(this.annoFrBody());
			    	 
					  for(int i=0;i<textList.size();i++){
						
						  ResultStructure temp = new ResultStructure();
						  temp.setBody(bodyList.get(i));
						  temp.setText(textList.get(i));
						  this.setFrResult(temp);
						  allFrAnnoList.add(this.getFrResult());
						 
					  }
		    	}  
		    		
		    	
		    	return "result";
		    }
		    
		    
		    public String goToGallery(){
		    	setImageList(showImages());
		    	return "gallery";
		    }
		    
		    private static final ResultStructure[] queryList = new ResultStructure[] {
				
				new ResultStructure("first","All English Annotations"),
				new ResultStructure("second","Creators who mention Marguerite Derrida"),
				new ResultStructure("third","All entities tagged in annotations, who are not creators"),
				new ResultStructure("fourth","List of annotations text created by Eva Rosenblum"),
				new ResultStructure("fifth","All French Annotations")
			};
		    
		    public ResultStructure[] getQueryList() {
		    	 
				return queryList;
		 
			}
		

			public String submit(){
		    	
		    	
		    	return "result";
		    }
		    
			public String reset(){
					    	this.setQuery("");
					    	this.setCustomQ("");
					    	
					    	return " ";
					    }
			
			public String gotoEditor() {

				return "sparql";
			}
			
			
			

			public ArrayList<String> getCreatorList() {
		    	ArrayList<Literal> arr= new ArrayList<Literal>();
		    	arr.addAll(customQuery.getCreatorList());
		    	for(int i=0;i<arr.size();i++){
		    		creatorList.add(arr.get(i).getValue().toString());
		    	}

				return creatorList;
			}

			
			public void setCreatorList(ArrayList<String> creatorList) {
				this.creatorList = creatorList;
			}

			public ArrayList<String> getObjList() {
				return objList;
			}


			public void setObjList(ArrayList<String> objList) {
				this.objList = objList;
			}


			public ArrayList<ResultStructure> getResultFullList() {
				return resultFullList;
			}


			public void setResultFullList(ArrayList<ResultStructure> resultFullList) {
				this.resultFullList = resultFullList;
			}


			public ResultStructure getResult() {
				return result;
			}


			public void setResult(ResultStructure result) {
				this.result = result;
			}
		 
			 public String getName ()
			    {
			        return name;
			    }


			    public void setName (final String name)
			    {
			        this.name = name;
			    }


			    public String getPassword ()
			    {
			        return password;
			    }


			    public void setPassword (final String password)
			    {
			        this.password = password;
			    }


				public String getQuery() {
					return query;
				}


				public void setQuery(String query) {
					this.query = query;
				}

			


				public ArrayList<String> getSubList() {
					return subList;
				}


				public void setSubList(ArrayList<String> subList) {
					this.subList = subList;
				}

				public ArrayList<String> getPropList() {
					return propList;
				}

				public void setPropList(ArrayList<String> propList) {
					this.propList = propList;
				}

				public String getCustomQ() {
					return customQ;
				}

				public void setCustomQ(String customQ) {
					this.customQ = customQ;
				}

				public String getCustomQ1() {
					return customQ1;
				}

				public void setCustomQ1(String customQ1) {
					this.customQ1 = customQ1;
				}

				public ResultStructure getEngResult() {
					return engResult;
				}

				public void setEngResult(ResultStructure engResult) {
					this.engResult = engResult;
				}

				public ArrayList<ResultStructure> getCreatorFList() {
					return creatorFList;
				}

				public void setCreatorFList(ArrayList<ResultStructure> creatorFList) {
					this.creatorFList = creatorFList;
				}

				public ResultStructure getCreatorResult() {
					return creatorResult;
				}

				public void setCreatorResult(ResultStructure creatorResult) {
					this.creatorResult = creatorResult;
				}

				public ArrayList<String> getNoCreatorList() {
					return noCreatorList;
				}

				public void setNoCreatorList(ArrayList<String> noCreatorList) {
					this.noCreatorList = noCreatorList;
				}

				public ArrayList<ResultStructure> getAllEngAnnoList() {
					return allEngAnnoList;
				}

				public void setAllEngAnnoList(ArrayList<ResultStructure> allEngAnnoList) {
					this.allEngAnnoList = allEngAnnoList;
				}

				public ResultStructure getEvaResult() {
					return evaResult;
				}

				public void setEvaResult(ResultStructure evaResult) {
					this.evaResult = evaResult;
				}

				public ArrayList<ResultStructure> getAnnoEvaList() {
					return annoEvaList;
				}

				public void setAnnoEvaList(ArrayList<ResultStructure> annoEvaList) {
					this.annoEvaList = annoEvaList;
				}

				public ArrayList<ResultStructure> getAllFrAnnoList() {
					return allFrAnnoList;
				}

				public void setAllFrAnnoList(ArrayList<ResultStructure> allFrAnnoList) {
					this.allFrAnnoList = allFrAnnoList;
				}

				public ResultStructure getFrResult() {
					return frResult;
				}

				public void setFrResult(ResultStructure frResult) {
					this.frResult = frResult;
				}

				public String getSelectedCreator() {
					return selectedCreator;
				}

				public void setSelectedCreator(String selectedCreator) {
					this.selectedCreator = selectedCreator;
				}

				public String getLocale() {
					return locale;
				}

				public void setLocale(String locale) {
					this.locale = locale;
				}

				public String getMessage() {
					return message;
				}

				public void setMessage(String message) {
					this.message = message;
				}

				public ArrayList<ResultStructure> getCreatorFullList() {
					return creatorFullList;
				}

				public void setCreatorFullList(ArrayList<ResultStructure> creatorFullList) {
					this.creatorFullList = creatorFullList;
				}

				public ArrayList<String> getCreatorUrlList() {
					return creatorUrlList;
				}

				public void setCreatorUrlList(ArrayList<String> creatorUrlList) {
					this.creatorUrlList = creatorUrlList;
				}

				public boolean isShowCreators() {
					return showCreators;
				}

				public void setShowCreators(boolean showCreators) {
					this.showCreators = showCreators;
				}

				public ArrayList<String> getCreatorTextList() {
					return creatorTextList;
				}

				public void setCreatorTextList(ArrayList<String> creatorTextList) {
					this.creatorTextList = creatorTextList;
				}

				public ArrayList<String> getImageList() {
					return imageList;
				}

				public void setImageList(ArrayList<String> imageList) {
					this.imageList = imageList;
				}

				
				
				
		    
	    
}
