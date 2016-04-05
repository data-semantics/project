package com.rdf;

import java.util.ArrayList;

import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.rdf.model.Literal;
import com.hp.hpl.jena.rdf.model.Resource;

public class CustomQuery {


	static final String inputFileName = "http://bibfram.es/fuseki/derrida/query";
	ArrayList<Resource> localArray = new ArrayList<Resource>();
	ArrayList<Resource> localArray1 = new ArrayList<Resource>();
	 ArrayList<Literal> literalArray = new ArrayList<Literal>();
	 ArrayList<Literal> literalArray1 = new ArrayList<Literal>();
	 
    public  ArrayList<Resource>  showCreatorAnno() {
	       
	     
    	String queryString = 
    		"PREFIX dcterms: <http://purl.org/dc/terms/>"+
        	"PREFIX skos: <http://www.w3.org/2004/02/skos/core#>"+
        	"PREFIX oa: <http://www.w3.org/ns/oa#>"+
        	"PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>"+
        	"PREFIX dc: <http://purl.org/dc/elements/1.1/>"+

        	"SELECT DISTINCT ?anno ?name "+
        	"WHERE { "+      
        	  "  ?anno dcterms:creator ?creator ."+
        	  "	 ?anno oa:hasBody ?body ."+
        		"?meta oa:hasBody ?bn2 ."+
        		"?bn2 oa:hasSource <http://viaf.org/viaf/163091629> ."+
        	  	"?meta oa:hasTarget ?bn1 ."+
        	  	"?bn1 oa:hasSource ?body ."+  	
        	    "?creator skos:prefLabel ?name ."+  
        	"}"+
        	"ORDER BY ?label"+
        	" LIMIT 50";
		

    	Query query = QueryFactory.create(queryString);
    	QueryExecution q = QueryExecutionFactory.sparqlService(inputFileName,query);
    	ResultSet results = q.execSelect();
    

        	while(results.hasNext()){
    			
    			QuerySolution binding = results.nextSolution();
    			Resource subj1 = binding.getResource("anno");
    			localArray.add(subj1);
    			
    			
    			
    		}
        
		// Important - free up resources used running the query
		q.close();
		return localArray;
	       
	    }
    
    public  ArrayList<Literal>  showCreatorNames() {
	       
	     
    	String queryString = 
    		"PREFIX dcterms: <http://purl.org/dc/terms/>"+
        	"PREFIX skos: <http://www.w3.org/2004/02/skos/core#>"+
        	"PREFIX oa: <http://www.w3.org/ns/oa#>"+
        	"PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>"+
        	"PREFIX dc: <http://purl.org/dc/elements/1.1/>"+

        	"SELECT DISTINCT ?anno ?name "+
        	"WHERE { "+      
        	  "  ?anno dcterms:creator ?creator ."+
        	  "	 ?anno oa:hasBody ?body ."+
        		"?meta oa:hasBody ?bn2 ."+
        		"?bn2 oa:hasSource <http://viaf.org/viaf/163091629> ."+
        	  	"?meta oa:hasTarget ?bn1 ."+
        	  	"?bn1 oa:hasSource ?body ."+  	
        	    "?creator skos:prefLabel ?name ."+  
        	"}"+
        	"ORDER BY ?label"+
        	" LIMIT 50";
		

    	Query query = QueryFactory.create(queryString);
    	QueryExecution q = QueryExecutionFactory.sparqlService(inputFileName,query);
    	ResultSet results = q.execSelect();
    
        	while(results.hasNext()){
    			
    			QuerySolution binding = results.nextSolution();
    			Literal subj = binding.getLiteral("name");
    			literalArray.add(subj);
    			
    			
    			
    		}

		// Important - free up resources used running the query
		q.close();
		return literalArray;
	       
	    }
    
    
    public  ArrayList<Literal>  showAnnoTextEng() {
	       

        String queryString= 
        	"PREFIX dcterms: <http://purl.org/dc/terms/>"+
    			"PREFIX skos: <http://www.w3.org/2004/02/skos/core#>"+
    			"PREFIX oa: <http://www.w3.org/ns/oa#>"+
    			"PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>"+
    			"PREFIX dc: <http://purl.org/dc/elements/1.1/>"+
    			
    			"SELECT ?body ?text "+
    			"WHERE { "+      
    				"?body dc:language \"en\" ."+
    			  	"?body oa:text ?text . "+
    			"}"+
    			"ORDER BY ?label"+
    			" LIMIT 100";
		

    	Query query = QueryFactory.create(queryString);
    	QueryExecution q = QueryExecutionFactory.sparqlService(inputFileName,query);
    	ResultSet results = q.execSelect();
    
        	while(results.hasNext()){
    			
    			QuerySolution binding = results.nextSolution();
    			Literal subj = binding.getLiteral("text");
    			literalArray.add(subj);
    			
    			
    			
    		}

		// Important - free up resources used running the query
		q.close();
		return literalArray;
	       
	    }
    
    public  ArrayList<Resource>  showAnnoBodyEng() {
	       

        String queryString= 
        	"PREFIX dcterms: <http://purl.org/dc/terms/>"+
    			"PREFIX skos: <http://www.w3.org/2004/02/skos/core#>"+
    			"PREFIX oa: <http://www.w3.org/ns/oa#>"+
    			"PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>"+
    			"PREFIX dc: <http://purl.org/dc/elements/1.1/>"+
    			
    			"SELECT ?body ?text "+
    			"WHERE { "+      
    				"?body dc:language \"en\" ."+
    			  	"?body oa:text ?text . "+
    			"}"+
    			"ORDER BY ?label"+
    			" LIMIT 100";
		

    	Query query = QueryFactory.create(queryString);
    	QueryExecution q = QueryExecutionFactory.sparqlService(inputFileName,query);
    	ResultSet results = q.execSelect();
    
        	while(results.hasNext()){
    			
    			QuerySolution binding = results.nextSolution();
    			Resource subj1 = binding.getResource("body");
    			localArray.add(subj1);
    			
    			
    			
    		}

		// Important - free up resources used running the query
		q.close();
		return localArray;
	       
	    }
    
    
    public  ArrayList<Resource>  showSearchSub() {
	       
    	ArrayList<Resource> localArray2 = new ArrayList<Resource>();

        String queryString= 
        	"PREFIX dcterms: <http://purl.org/dc/terms/>"+
			"PREFIX skos: <http://www.w3.org/2004/02/skos/core#>"+
			"PREFIX oa: <http://www.w3.org/ns/oa#>"+
			"PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>"+
			"PREFIX dc: <http://purl.org/dc/elements/1.1/>"+
			
			"SELECT * "+
			"WHERE { "+      
				"?s ?p ?o . FILTER(regex(?o, \"ami.*\", \"i\"))"+
			"}"+
			"ORDER BY ?label"+
			" LIMIT 100";
		

    	Query query = QueryFactory.create(queryString);
    	QueryExecution q = QueryExecutionFactory.sparqlService(inputFileName,query);
    	ResultSet results = q.execSelect();
    
        	while(results.hasNext()){
    			
    			QuerySolution binding = results.nextSolution();
    			Resource subj1 = binding.getResource("s");
    			localArray2.add(subj1);
    			
    			
    			
    		}
        

		// Important - free up resources used running the query
		q.close();
		return localArray2;
	       
	    }
    
    
    public  ArrayList<Resource>  showSearchProp() {
	       

        String queryString= 
        	"PREFIX dcterms: <http://purl.org/dc/terms/>"+
			"PREFIX skos: <http://www.w3.org/2004/02/skos/core#>"+
			"PREFIX oa: <http://www.w3.org/ns/oa#>"+
			"PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>"+
			"PREFIX dc: <http://purl.org/dc/elements/1.1/>"+
			
			"SELECT * "+
			"WHERE { "+      
				"?s ?p ?o . FILTER(regex(?o, \"ami.*\", \"i\"))"+
			"}"+
			"ORDER BY ?label"+
			" LIMIT 100";
		

    	Query query = QueryFactory.create(queryString);
    	QueryExecution q = QueryExecutionFactory.sparqlService(inputFileName,query);
    	ResultSet results = q.execSelect();
    
        	while(results.hasNext()){
    			
    			QuerySolution binding = results.nextSolution();
    			Resource subj1 = binding.getResource("p");
    			localArray1.add(subj1);
    			
    			
    			
    		}

		// Important - free up resources used running the query
		q.close();
		return localArray1;
	       
	    }
    
    
    public  ArrayList<Literal>  showSearchObj() {
	       

        String queryString= 
        	"PREFIX dcterms: <http://purl.org/dc/terms/>"+
			"PREFIX skos: <http://www.w3.org/2004/02/skos/core#>"+
			"PREFIX oa: <http://www.w3.org/ns/oa#>"+
			"PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>"+
			"PREFIX dc: <http://purl.org/dc/elements/1.1/>"+
			
			"SELECT * "+
			"WHERE { "+      
				"?s ?p ?o . FILTER(regex(?o, \"ami.*\", \"i\"))"+
			"}"+
			"ORDER BY ?label"+
			" LIMIT 100";
		

    	Query query = QueryFactory.create(queryString);
    	QueryExecution q = QueryExecutionFactory.sparqlService(inputFileName,query);
    	ResultSet results = q.execSelect();
    
        	while(results.hasNext()){
    			
    			QuerySolution binding = results.nextSolution();
    			Literal subj1 = binding.getLiteral("o");
    			literalArray1.add(subj1);
    			
    			
    			
    		}

		// Important - free up resources used running the query
		q.close();
		return literalArray1;
	       
	    }



}
