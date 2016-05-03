package com.tutorial;

import java.util.ArrayList;

import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.rdf.model.Literal;
import com.hp.hpl.jena.rdf.model.Resource;

public class MainQuery {

	 
	static final String inputFileName1 = "http://bibfram.es/fuseki/derrida/query";
    ArrayList<Literal> arrTitle = new ArrayList<Literal>();
    ArrayList<Literal> arrAP = new ArrayList<Literal>();
    static ArrayList<Resource> arr1 = new ArrayList<Resource>();
    
    
  
    
    public  ArrayList<Literal>  showAnnoText() {
	       
	     
    	String queryString = 
        	"PREFIX dcterms: <http://purl.org/dc/terms/>"+
        		"PREFIX skos: <http://www.w3.org/2004/02/skos/core#>"+
        		"PREFIX oa: <http://www.w3.org/ns/oa#>"+
        		"PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>"+
        		"PREFIX dc: <http://purl.org/dc/elements/1.1/>"+

        		"SELECT DISTINCT ?anno ?name ?text "+
        		"WHERE {"+       
        		 "   ?anno dcterms:creator ?creator ."+
        		 "	?anno oa:hasBody ?body ."+
        		 	"?meta oa:hasBody ?bn2 ."+
        			"?bn2 oa:hasSource <http://viaf.org/viaf/88958529> ."+
        		  	"?meta oa:hasTarget ?bn1 ."+
        		  	"?bn1 oa:hasSource ?body ."+ 
        		  	"?creator skos:prefLabel ?name ."+
        		    "?body oa:text ?text ."+
        		 "}"+
        		 "ORDER BY ?label"+
        				" LIMIT 50";
		

    	Query query = QueryFactory.create(queryString);
    	QueryExecution q = QueryExecutionFactory.sparqlService(inputFileName1,query);
    	ResultSet results = q.execSelect();

    	while(results.hasNext()){
			
			QuerySolution binding = results.nextSolution();
			Literal subj = binding.getLiteral("text");
			arrTitle.add(subj);
			
		}
		// Important - free up resources used running the query
		q.close();
		return arrTitle;
	       
	    }
    
    
    public  ArrayList<Resource>  showAnnotation() {
	       
	     
    	String queryString = 
        	"PREFIX dcterms: <http://purl.org/dc/terms/>"+
        		"PREFIX skos: <http://www.w3.org/2004/02/skos/core#>"+
        		"PREFIX oa: <http://www.w3.org/ns/oa#>"+
        		"PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>"+
        		"PREFIX dc: <http://purl.org/dc/elements/1.1/>"+

        		"SELECT DISTINCT ?anno ?name ?text "+
        		"WHERE {"+       
        		 "   ?anno dcterms:creator ?creator ."+
        		 "	?anno oa:hasBody ?body ."+
        		 	"?meta oa:hasBody ?bn2 ."+
        			"?bn2 oa:hasSource <http://viaf.org/viaf/88958529> ."+
        		  	"?meta oa:hasTarget ?bn1 ."+
        		  	"?bn1 oa:hasSource ?body ."+ 
        		  	"?creator skos:prefLabel ?name ."+
        		    "?body oa:text ?text ."+
        		 "}"+
        		 "ORDER BY ?label"+
        				" LIMIT 50";
		

    	Query query = QueryFactory.create(queryString);
    	QueryExecution q = QueryExecutionFactory.sparqlService(inputFileName1,query);
    	ResultSet results = q.execSelect();
    	
    	if(arr1.isEmpty()){

    	while(results.hasNext()){
			
			QuerySolution binding = results.nextSolution();
			Resource subj1 = binding.getResource("anno");
			arr1.add(subj1);
			
			
			
		}
    	}
		// Important - free up resources used running the query
		q.close();
		return arr1;
	       
	    }
    
    
    public  ArrayList<Literal>  showAnnoName() {
	       
	     
    	String queryString = 
        	"PREFIX dcterms: <http://purl.org/dc/terms/>"+
        		"PREFIX skos: <http://www.w3.org/2004/02/skos/core#>"+
        		"PREFIX oa: <http://www.w3.org/ns/oa#>"+
        		"PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>"+
        		"PREFIX dc: <http://purl.org/dc/elements/1.1/>"+

        		"SELECT DISTINCT ?anno ?name ?text "+
        		"WHERE {"+       
        		 "   ?anno dcterms:creator ?creator ."+
        		 "	?anno oa:hasBody ?body ."+
        		 	"?meta oa:hasBody ?bn2 ."+
        			"?bn2 oa:hasSource <http://viaf.org/viaf/88958529> ."+
        		  	"?meta oa:hasTarget ?bn1 ."+
        		  	"?bn1 oa:hasSource ?body ."+ 
        		  	"?creator skos:prefLabel ?name ."+
        		    "?body oa:text ?text ."+
        		 "}"+
        		 "ORDER BY ?label"+
        				" LIMIT 50";
		

    	Query query = QueryFactory.create(queryString);
    	QueryExecution q = QueryExecutionFactory.sparqlService(inputFileName1,query);
    	ResultSet results = q.execSelect();
    	
    	if(arrAP.isEmpty()){

    	while(results.hasNext()){
			
    		QuerySolution binding = results.nextSolution();
			Literal subj = binding.getLiteral("name");
			arrAP.add(subj);
			
			
		}
    	}
		// Important - free up resources used running the query
		q.close();
		return arrAP;
	       
	    }




}
