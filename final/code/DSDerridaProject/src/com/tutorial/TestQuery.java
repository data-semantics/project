package com.tutorial;

import java.util.ArrayList;

import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.query.ResultSetFormatter;
import com.hp.hpl.jena.rdf.model.Literal;
import com.hp.hpl.jena.rdf.model.Resource;

public class TestQuery {

	//static final String inputFileName = "C:\\Sushmita\\MS DataScience\\Data Semantics\\Project\\bibframe1.rdf";
	static final String inputFileName = "http://bibfram.es/fuseki/derrida/";
	 static ArrayList<Literal> arr = new ArrayList<Literal>();
	 static ArrayList<Resource> arr1 = new ArrayList<Resource>();
	 static ArrayList<Resource> arr3 = new ArrayList<Resource>();
	 static ArrayList<Literal> arr2 = new ArrayList<Literal>();
    public static void main (String args[]) {
 
        
     // Create a new query
	
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
        				" LIMIT 2";
     //Find annotation creators who mention Marguerite Derrida 
       // (http://viaf.org/viaf/163091629) in their annotations   
        
        String queryString1= 
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
        	" LIMIT 100";
        
        
        //Find annotation texts that include words starting with "ami".
        String queryString2= 
        	"PREFIX dcterms: <http://purl.org/dc/terms/>"+
				"PREFIX skos: <http://www.w3.org/2004/02/skos/core#>"+
				"PREFIX oa: <http://www.w3.org/ns/oa#>"+
				"PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>"+
				"PREFIX dc: <http://purl.org/dc/elements/1.1/>"+
				
				"SELECT * "+
				"WHERE { "+      
					"?s ?p ?o . FILTER(regex(?o, \"Marguerite Derrida\", \"i\"))"+
				"}"+
				"ORDER BY ?label"+
				" LIMIT 100";
        
        //Find all annotations in English (or French, etc.)
        String queryString3= 
        	"PREFIX dcterms: <http://purl.org/dc/terms/>"+
				"PREFIX skos: <http://www.w3.org/2004/02/skos/core#>"+
				"PREFIX oa: <http://www.w3.org/ns/oa#>"+
				"PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>"+
				"PREFIX dc: <http://purl.org/dc/elements/1.1/>"+
				
				"SELECT ?body ?text "+
				"WHERE { "+      
					"?body dc:language \"fr\" ."+
				  	"?body oa:text ?text . "+
				"}"+
				"ORDER BY ?label"+
				" LIMIT 100";
        
        
        
        String queryString4=
        	"PREFIX dcterms: <http://purl.org/dc/terms/>"+
        		"PREFIX skos: <http://www.w3.org/2004/02/skos/core#>"+
        		"PREFIX oa: <http://www.w3.org/ns/oa#>"+
        		"PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>"+
        		"PREFIX dc: <http://purl.org/dc/elements/1.1/>"+

        		"SELECT DISTINCT ?anno ?label "+
        		"WHERE { "+      
        		    "?tag skos:prefLabel ?label"+
        		    "MINUS"+
        		    "{ ?anno dcterms:creator ?tag  }"+
        		"}"+
        		" LIMIT 100";
        
        
        String queryString5=
        	"PREFIX dcterms: <http://purl.org/dc/terms/>"+
    		"PREFIX skos: <http://www.w3.org/2004/02/skos/core#>"+
    		"PREFIX oa: <http://www.w3.org/ns/oa#>"+
    		"PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>"+
    		"PREFIX dc: <http://purl.org/dc/elements/1.1/>"+
    		
				"SELECT DISTINCT ?anno ?name ?text "+
				"WHERE {"+      
				    "?anno dcterms:creator <http://viaf.org/viaf/54153607> ."+
				    "?anno oa:hasBody ?body ."+
				    "<http://viaf.org/viaf/54153607> skos:prefLabel ?name . "+
				    "?body oa:text ?text ."+
				"}"+
				" ORDER BY ?text"+
				" LIMIT 100";
        
        
        String queryString6=
        	"PREFIX schema: <http://schema.org/>"+
			"PREFIX skos: <http://www.w3.org/2004/02/skos/core#>"+
			"PREFIX oa: <http://www.w3.org/ns/oa#>"+
			
			"SELECT ?clean (COUNT(?clean) AS ?tag)"+
			" WHERE "+
			"{"+
				"{"+
			    	"?subject oa:exact ?text "+	
			  		"BIND(\"^\\s+(.*?)\\s*$|^(.*?)\\s+$\" AS ?regexp)"+
			  		"FILTER(REGEX(?text, ?regexp)) "+ 
			    	"BIND(REPLACE(?text, ?regexp, \"$1$2\") AS ?clean)"+    
			  	"}"+
			    " UNION"+
			    "{"+
			        "?subject oa:exact ?text"+
			        "BIND(?text AS ?clean)"+
			        "BIND(\"^\\s+(.*?)\\s*$|^(.*?)\\s+$\" AS ?regexp)"+  		    	
			    	"FILTER(!REGEX(?clean, ?regexp))"+   	
			    "}"+
			"}"+
			" GROUP BY ?clean"+
			" ORDER BY DESC(?tag)";

    	Query query = QueryFactory.create(queryString3);
    	QueryExecution q = QueryExecutionFactory.sparqlService(inputFileName,query);
    	ResultSet results = q.execSelect();
    	

	 ResultSetFormatter.out(System.out, results, query);
		q.close();
        
    }


}
