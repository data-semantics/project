package com.tutorial;

import java.awt.Desktop;
import java.io.ByteArrayOutputStream;
import java.net.URI;
import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.QueryParseException;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.query.ResultSetFormatter;
import com.hp.hpl.jena.rdf.model.Literal;
import com.hp.hpl.jena.rdf.model.Resource;

public class EditorBean {

	private String xmlResult = "";
	private String format = "";
	private boolean showRdfPrefix = false;
	private boolean showXsdPrefix = false;
	private boolean showResultGrid = false;
	private ResultStructure result = new ResultStructure();
	private  ArrayList<String> bookTitleList= new ArrayList<String>();
    private  ArrayList<String> bookUrlList= new ArrayList<String>();
	private ArrayList<ResultStructure> fullBookList = new ArrayList<ResultStructure>();
	private  ArrayList<String> completeTitleList= new ArrayList<String>();
    private  ArrayList<String> completeUrlList= new ArrayList<String>();
	private ArrayList<ResultStructure> completeBookList = new ArrayList<ResultStructure>();

	private String inputFileName = "http://bibfram.es/fuseki/derrida/query";
	private String rdfsPrefix = "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>";
	private String xsdPrefix = "PREFIX xsd:	<http://www.w3.org/2001/XMLSchema#>";
	CustomQuery customQuery = new CustomQuery();

	private String query = "PREFIX dcterms: <http://purl.org/dc/terms/>" + "\n"
			+ "PREFIX skos: <http://www.w3.org/2004/02/skos/core#>" + "\n"
			+ "PREFIX oa: <http://www.w3.org/ns/oa#>" + "\n"
			+ "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>"
			+ "\n" + "PREFIX foaf: <http://xmlns.com/foaf/0.1/>"
			+ "\n" + "PREFIX dc: <http://purl.org/dc/elements/1.1/>";
	
	public EditorBean(){
		this.fetchBookTitle();
		this.fetchBookUrl();
		this.fetchFullBookTitle();
		this.fetchFullBookUrl();
		 for(int i=0;i<this.bookTitleList.size();i++){
				
			  ResultStructure temp = new ResultStructure();
			  temp.setBookTitle(this.bookTitleList.get(i));
			  temp.setBookUrl(this.bookUrlList.get(i));
			  this.setResult(temp);
			  fullBookList.add(this.getResult());
			 
		  }
		 for(int i=0;i<this.completeTitleList.size();i++){
				
			  ResultStructure temp = new ResultStructure();
			  temp.setBookTitle(this.completeTitleList.get(i));
			  temp.setBookUrl(this.completeUrlList.get(i));
			  this.setResult(temp);
			  completeBookList.add(this.getResult());
			 
		  }
	}
	
	
	public String openUrl(String url){
		try {
			  Desktop desktop = java.awt.Desktop.getDesktop();
			  URI oURL = new URI(url);
			  desktop.browse(oURL);
			} catch (Exception e) {
			  e.printStackTrace();
			}
			return "";
		
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public String getXmlResult() {
		return xmlResult;
	}

	public void setXmlResult(String xmlResult) {
		this.xmlResult = xmlResult;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public boolean isShowRdfPrefix() {
		return showRdfPrefix;
	}

	public void setShowRdfPrefix(boolean showRdfPrefix) {
		this.showRdfPrefix = showRdfPrefix;
	}

	public String getRdfsPrefix() {
		return rdfsPrefix;
	}

	public void setRdfsPrefix(String rdfsPrefix) {
		this.rdfsPrefix = rdfsPrefix;
	}

	public ArrayList<ResultStructure> getFullBookList() {
		return fullBookList;
	}

	public void setFullBookList(ArrayList<ResultStructure> fullBookList) {
		this.fullBookList = fullBookList;
	}

	public String getInputFileName() {
		return inputFileName;
	}

	public void setInputFileName(String inputFileName) {
		this.inputFileName = inputFileName;
	}

	public boolean isShowXsdPrefix() {
		return showXsdPrefix;
	}

	public void setShowXsdPrefix(boolean showXsdPrefix) {
		this.showXsdPrefix = showXsdPrefix;
	}

	public String getXsdPrefix() {
		return xsdPrefix;
	}

	public void setXsdPrefix(String xsdPrefix) {
		this.xsdPrefix = xsdPrefix;
	}

	public boolean isShowResultGrid() {
		return showResultGrid;
	}

	public void setShowResultGrid(boolean showResultGrid) {
		this.showResultGrid = showResultGrid;
	}

	
	/*
	 * public List<String> getBookList() { List<String> list = new
	 * ArrayList<String>(); list.add(
	 * "Traité sur la liberté et la volonté de l'Un : Ennéade VI, 8 (39)");
	 * list.add("Margins of Philosophy");
	 * list.add("Spurs: Nietzsche's Styles/Eperons: Les Styles de Nietzsche");
	 * list
	 * .add("Speech and Phenomena and Other Essays on Husserl's Theory of Signs"
	 * ); return list; }
	 */

	public ResultStructure getResult() {
		return result;
	}

	public void setResult(ResultStructure result) {
		this.result = result;
	}

	public ArrayList<String> getBookTitleList() {
		return bookTitleList;
	}

	public void setBookTitleList(ArrayList<String> bookTitleList) {
		this.bookTitleList = bookTitleList;
	}

	public ArrayList<String> getBookUrlList() {
		return bookUrlList;
	}

	public void setBookUrlList(ArrayList<String> bookUrlList) {
		this.bookUrlList = bookUrlList;
	}

	
	
	public ArrayList<String> getCompleteTitleList() {
		return completeTitleList;
	}


	public void setCompleteTitleList(ArrayList<String> completeTitleList) {
		this.completeTitleList = completeTitleList;
	}


	public ArrayList<String> getCompleteUrlList() {
		return completeUrlList;
	}


	public void setCompleteUrlList(ArrayList<String> completeUrlList) {
		this.completeUrlList = completeUrlList;
	}


	public ArrayList<ResultStructure> getCompleteBookList() {
		return completeBookList;
	}


	public void setCompleteBookList(ArrayList<ResultStructure> completeBookList) {
		this.completeBookList = completeBookList;
	}


	public void fetchBookTitle() {
		ArrayList<String> list = new ArrayList<String>();
		ArrayList<Literal> arr = new ArrayList<Literal>();
		arr.addAll(customQuery.showBookList("15"));
		for (int i = 0; i < arr.size(); i++) {
			list.add(arr.get(i).getValue().toString());
		}
		this.setBookTitleList(list);
	}
	
	
	public void fetchBookUrl() {
		ArrayList<String> list = new ArrayList<String>();
		ArrayList<Resource> arr = new ArrayList<Resource>();
		arr.addAll(customQuery.showBookUrlList("15"));
		for (int i = 0; i < arr.size(); i++) {
			list.add(arr.get(i).getURI());
		}
		this.setBookUrlList(list);
	}
	
	
	public void fetchFullBookTitle() {
		ArrayList<String> list = new ArrayList<String>();
		ArrayList<Literal> arr = new ArrayList<Literal>();
		arr.addAll(customQuery.showBookList("60"));
		for (int i = 0; i < arr.size(); i++) {
			list.add(arr.get(i).getValue().toString());
		}
		this.setCompleteTitleList(list);
	}
	
	
	public void fetchFullBookUrl() {
		ArrayList<String> list = new ArrayList<String>();
		ArrayList<Resource> arr = new ArrayList<Resource>();
		arr.addAll(customQuery.showBookUrlList("60"));
		for (int i = 0; i < arr.size(); i++) {
			list.add(arr.get(i).getURI());
		}
		this.setCompleteUrlList(list);
	}
	
	public ArrayList<ResultStructure> getBookList() {
		this.fetchBookTitle();
		this.fetchBookUrl();
		
		 for(int i=0;i<this.bookTitleList.size();i++){
				
			  ResultStructure temp = new ResultStructure();
			  temp.setBookTitle(this.bookTitleList.get(i));
			  temp.setBookUrl(this.bookUrlList.get(i));
			  this.setResult(temp);
			  fullBookList.add(this.getResult());
			 
		  }
		return fullBookList;
	}

	public String showResults() {
		executeQuery(this.query, this.format);
		return "";
	}

	public void executeQuery(String queryString, String format) {
		try{
		Query query = QueryFactory.create(queryString);
		QueryExecution q = QueryExecutionFactory.sparqlService(inputFileName,
				query);
		ResultSet results = q.execSelect();

		// ResultSetFormatter.outputAsXML(results);
		if (this.format.equals("xml")) {
			setXmlResult(ResultSetFormatter.asXMLString(results));
		} else if (this.format.equals("json")) {
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			ResultSetFormatter.outputAsJSON(outputStream, results);
			setXmlResult(new String(outputStream.toByteArray()));
		} else if (this.format.equals("text")) {
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			ResultSetFormatter.out(outputStream, results);
			setXmlResult(new String(outputStream.toByteArray()));
		}
		setShowResultGrid(true);
		q.close();
		}
		catch (QueryParseException e) {
		    String message = "Failed to retrieve data from endpoint: Please revisit the query ";
		    FacesContext.getCurrentInstance().addMessage("derrida:message", 
		        new FacesMessage(FacesMessage.SEVERITY_INFO, message, null));
		    setShowResultGrid(false);
		}
	}

	public String displayRdfs() {
		this.setShowRdfPrefix(true);
		this.setShowXsdPrefix(false);
		return "";

	}

	public String displayXsd() {
		this.setShowXsdPrefix(true);
		this.setShowRdfPrefix(false);
		return "";

	}

	public String returnEditor() {

		return "backSparql";
	}
	

}
