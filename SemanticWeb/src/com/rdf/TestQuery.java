package com.rdf;

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
	static final String inputFileName = "http://bibfram.es/fuseki/derrida/query";
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
					"?s ?p ?o . FILTER(regex(?o, \"ami.*\", \"i\"))"+
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
					"?body dc:language \"en\" ."+
				  	"?body oa:text ?text . "+
				"}"+
				"ORDER BY ?label"+
				" LIMIT 100";
        

    	Query query = QueryFactory.create(queryString2);
    	QueryExecution q = QueryExecutionFactory.sparqlService(inputFileName,query);
    	ResultSet results = q.execSelect();
    	ArrayList<String> list = new ArrayList<String>();

    	while(results.hasNext()){
			
			QuerySolution binding = results.nextSolution();
			//System.out.println(binding);
			Resource subj1 = binding.getResource("p");
			Resource subj2 = binding.getResource("s");
			Literal subj = binding.getLiteral("o");
	
			arr1.add(subj1);
			arr.add(subj);
			arr3.add(subj2);
		}
    	
    	for(int i=0;i<arr3.size();i++){
	    	if(arr3.get(i).getNode().isURI())
	    		System.out.println(arr3.get(i).getURI());
	    	else if(arr3.get(i).getNode().isBlank())
	    		System.out.println(arr3.get(i).getId());
	    	}
	
    	/*System.out.println("-" + arr3); 
		System.out.println("-" + arr1);
		System.out.println("-" + arr);
*/
	/*	// Execute the query and obtain results
		QueryExecution qe = QueryExecutionFactory.create(query, model);
		ResultSet results = qe.execSelect();*/
		/*
		while(results.hasNext()){
			
			QuerySolution binding = results.nextSolution();
			Literal subj = binding.getLiteral("name");
			Literal subj2 = binding.getLiteral("text");
			Resource subj1 = binding.getResource("anno");
			arr.add(subj);
			arr1.add(subj1);
			arr2.add(subj2);
		
			
			
		}
		System.out.println("-" + arr); 
		System.out.println("-" + arr1); 
		System.out.println("-" + arr2); */
		
		// Output query results	
    
	 //ResultSetFormatter.out(System.out, results, query);

		
		
		

		q.close();
        
        
  

        
       
    }


    
 /*   <%

    String selected = request.getParameter("id");
      String radio = (String)session.getAttribute("radioSelect");
           if (radio == null) {
           	radio = new String("");
           } else {
           	radio = new String(selected);
           }

           session.setAttribute("radioSelect", radio);

           %>
    
    
*/
}
