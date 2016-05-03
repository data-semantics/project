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

public class CustomQuery {

	static final String inputFileName = "http://bibfram.es/fuseki/derrida/query";
	ArrayList<Resource> localArray = new ArrayList<Resource>();
	ArrayList<Resource> localArray1 = new ArrayList<Resource>();
	ArrayList<Resource> noCreatorArray = new ArrayList<Resource>();
	ArrayList<Literal> literalArray = new ArrayList<Literal>();
	ArrayList<Literal> literalArray1 = new ArrayList<Literal>();
	ArrayList<Literal> bookTitleArray = new ArrayList<Literal>();
	ArrayList<Resource> bookUrlArray = new ArrayList<Resource>();
	ArrayList<Literal> evaTextArray = new ArrayList<Literal>();
	ArrayList<Literal> creatorArray = new ArrayList<Literal>();
	ArrayList<Resource> evaNameArray = new ArrayList<Resource>();
	ArrayList<Literal> creatorTextArray = new ArrayList<Literal>();
	ArrayList<Resource> creatorUrlArray = new ArrayList<Resource>();
	ArrayList<Resource> imageArray = new ArrayList<Resource>();

	public ArrayList<Resource> showSearchSub(String sub) {

		ArrayList<Resource> localArray2 = new ArrayList<Resource>();

		String queryString = "PREFIX dcterms: <http://purl.org/dc/terms/>"
				+ "PREFIX skos: <http://www.w3.org/2004/02/skos/core#>"
				+ "PREFIX oa: <http://www.w3.org/ns/oa#>"
				+ "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>"
				+ "PREFIX dc: <http://purl.org/dc/elements/1.1/>" +

				"SELECT * " + "WHERE { " + "?s ?p ?o .?s oa:text ?o. FILTER(regex(?o, \""
				+ sub + "\", \"i\"))" + "}" + "ORDER BY ?label" + " LIMIT 100";

		Query query = QueryFactory.create(queryString);
		QueryExecution q = QueryExecutionFactory.sparqlService(inputFileName,
				query);
		ResultSet results = q.execSelect();

		while (results.hasNext()) {

			QuerySolution binding = results.nextSolution();
			Resource subj1 = binding.getResource("s");
			localArray2.add(subj1);

		}

		// Important - free up resources used running the query
		q.close();
		return localArray2;

	}

	public ArrayList<Literal> showSearchObj(String sub) {

		String queryString = "PREFIX dcterms: <http://purl.org/dc/terms/>"
				+ "PREFIX skos: <http://www.w3.org/2004/02/skos/core#>"
				+ "PREFIX oa: <http://www.w3.org/ns/oa#>"
				+ "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>"
				+ "PREFIX dc: <http://purl.org/dc/elements/1.1/>" +

				"SELECT * " + "WHERE { " + "?s ?p ?o .?s oa:text ?o. FILTER(regex(?o, \""
				+ sub + "\", \"i\"))" + "}" + "ORDER BY ?label" + " LIMIT 100";

		Query query = QueryFactory.create(queryString);
		QueryExecution q = QueryExecutionFactory.sparqlService(inputFileName,
				query);
		ResultSet results = q.execSelect();

		while (results.hasNext()) {

			QuerySolution binding = results.nextSolution();
			Literal subj1 = binding.getLiteral("o");
			literalArray1.add(subj1);

		}

		// Important - free up resources used running the query
		q.close();
		return literalArray1;

	}

	public ArrayList<Resource> showSearchProp(String sub) {

		String queryString = "PREFIX dcterms: <http://purl.org/dc/terms/>"
				+ "PREFIX skos: <http://www.w3.org/2004/02/skos/core#>"
				+ "PREFIX oa: <http://www.w3.org/ns/oa#>"
				+ "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>"
				+ "PREFIX dc: <http://purl.org/dc/elements/1.1/>" +

				"SELECT * " + "WHERE { " + "?s ?p ?o .?s oa:text ?o. FILTER(regex(?o, \""
				+ sub + "\", \"i\"))" + "}" + "ORDER BY ?label" + " LIMIT 100";

		Query query = QueryFactory.create(queryString);
		QueryExecution q = QueryExecutionFactory.sparqlService(inputFileName,
				query);
		ResultSet results = q.execSelect();

		while (results.hasNext()) {

			QuerySolution binding = results.nextSolution();
			Resource subj1 = binding.getResource("p");
			localArray1.add(subj1);

		}

		// Important - free up resources used running the query
		q.close();
		return localArray1;

	}

	public ArrayList<Resource> showAnnoBodyEng(String lang) {

		String queryString = "PREFIX dcterms: <http://purl.org/dc/terms/>"
				+ "PREFIX skos: <http://www.w3.org/2004/02/skos/core#>"
				+ "PREFIX oa: <http://www.w3.org/ns/oa#>"
				+ "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>"
				+ "PREFIX dc: <http://purl.org/dc/elements/1.1/>" +

				"SELECT ?body ?text " + "WHERE { "
				+ "?body dc:language \""+ lang + "\" ." + 
				"?body oa:text ?text . " + "}"
				+ "ORDER BY ?label" + " LIMIT 100";

		Query query = QueryFactory.create(queryString);
		QueryExecution q = QueryExecutionFactory.sparqlService(inputFileName,
				query);
		ResultSet results = q.execSelect();

		while (results.hasNext()) {

			QuerySolution binding = results.nextSolution();
			Resource subj1 = binding.getResource("body");
			localArray.add(subj1);

		}

		// Important - free up resources used running the query
		q.close();
		return localArray;

	}

	public ArrayList<Literal> showAnnoTextEng(String lang) {

		String queryString = "PREFIX dcterms: <http://purl.org/dc/terms/>"
				+ "PREFIX skos: <http://www.w3.org/2004/02/skos/core#>"
				+ "PREFIX oa: <http://www.w3.org/ns/oa#>"
				+ "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>"
				+ "PREFIX dc: <http://purl.org/dc/elements/1.1/>" +

				"SELECT ?body ?text " + "WHERE { "
				+ "?body dc:language \""+ lang + "\" ." + 
				"?body oa:text ?text . " + "}"
				+ "ORDER BY ?label" + " LIMIT 100";

		Query query = QueryFactory.create(queryString);
		QueryExecution q = QueryExecutionFactory.sparqlService(inputFileName,
				query);
		ResultSet results = q.execSelect();

		while (results.hasNext()) {

			QuerySolution binding = results.nextSolution();
			Literal subj = binding.getLiteral("text");
			literalArray.add(subj);

		}

		// Important - free up resources used running the query
		q.close();
		return literalArray;

	}

	public ArrayList<Resource> showCreatorAnno() {

		String queryString = "PREFIX dcterms: <http://purl.org/dc/terms/>"
				+ "PREFIX skos: <http://www.w3.org/2004/02/skos/core#>"
				+ "PREFIX oa: <http://www.w3.org/ns/oa#>"
				+ "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>"
				+ "PREFIX dc: <http://purl.org/dc/elements/1.1/>" +

				"SELECT DISTINCT ?anno ?name " + "WHERE { "
				+ "  ?anno dcterms:creator ?creator ."
				+ "	 ?anno oa:hasBody ?body ." + "?meta oa:hasBody ?bn2 ."
				+ "?bn2 oa:hasSource <http://viaf.org/viaf/163091629> ."
				+ "?meta oa:hasTarget ?bn1 ." + "?bn1 oa:hasSource ?body ."
				+ "?creator skos:prefLabel ?name ." + "}" + "ORDER BY ?label"
				+ " LIMIT 50";

		Query query = QueryFactory.create(queryString);
		QueryExecution q = QueryExecutionFactory.sparqlService(inputFileName,
				query);
		ResultSet results = q.execSelect();

		while (results.hasNext()) {

			QuerySolution binding = results.nextSolution();
			Resource subj1 = binding.getResource("anno");
			localArray.add(subj1);

		}

		// Important - free up resources used running the query
		q.close();
		return localArray;

	}

	public ArrayList<Literal> showCreatorNames() {

		String queryString = "PREFIX dcterms: <http://purl.org/dc/terms/>"
				+ "PREFIX skos: <http://www.w3.org/2004/02/skos/core#>"
				+ "PREFIX oa: <http://www.w3.org/ns/oa#>"
				+ "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>"
				+ "PREFIX dc: <http://purl.org/dc/elements/1.1/>" +

				"SELECT DISTINCT ?anno ?name " + "WHERE { "
				+ "  ?anno dcterms:creator ?creator ."
				+ "	 ?anno oa:hasBody ?body ." + "?meta oa:hasBody ?bn2 ."
				+ "?bn2 oa:hasSource <http://viaf.org/viaf/163091629> ."
				+ "?meta oa:hasTarget ?bn1 ." + "?bn1 oa:hasSource ?body ."
				+ "?creator skos:prefLabel ?name ." + "}" + "ORDER BY ?label"
				+ " LIMIT 50";

		Query query = QueryFactory.create(queryString);
		QueryExecution q = QueryExecutionFactory.sparqlService(inputFileName,
				query);
		ResultSet results = q.execSelect();

		while (results.hasNext()) {

			QuerySolution binding = results.nextSolution();
			Literal subj = binding.getLiteral("name");
			literalArray.add(subj);

		}

		// Important - free up resources used running the query
		q.close();
		return literalArray;

	}

	public ArrayList<Resource> showNotCreators() {

		String queryString = "PREFIX dcterms: <http://purl.org/dc/terms/>"
				+ "PREFIX skos: <http://www.w3.org/2004/02/skos/core#>"
				+ "PREFIX oa: <http://www.w3.org/ns/oa#>"
				+ "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>"
				+ "PREFIX dc: <http://purl.org/dc/elements/1.1/>" +

				"SELECT DISTINCT ?anno ?name " + "WHERE { "
				+ "  ?anno dcterms:creator ?creator ."
				+ "	 ?anno oa:hasBody ?body ." + "?meta oa:hasBody ?bn2 ."
				+ "?bn2 oa:hasSource <http://viaf.org/viaf/163091629> ."
				+ "?meta oa:hasTarget ?bn1 ." + "?bn1 oa:hasSource ?body ."
				+ "?creator skos:prefLabel ?name ." + "}" + "ORDER BY ?label"
				+ " LIMIT 50";

		Query query = QueryFactory.create(queryString);
		QueryExecution q = QueryExecutionFactory.sparqlService(inputFileName,
				query);
		ResultSet results = q.execSelect();

		while (results.hasNext()) {

			QuerySolution binding = results.nextSolution();
			Resource subj1 = binding.getResource("anno");
			noCreatorArray.add(subj1);

		}

		// Important - free up resources used running the query
		q.close();
		return noCreatorArray;

	}

	public ArrayList<Literal> showBookList(String limit) {

		String queryString = "PREFIX dc: <http://purl.org/dc/elements/1.1/>"
				+ "PREFIX schema: <http://schema.org/>" +

				"SELECT ?book ?title " + "WHERE { "
				+ "  ?book schema:sameAs ?oclc ." + "	 ?oclc dc:title ?title ."
				+ "}" + "ORDER BY ?title" + " LIMIT "+limit;

		Query query = QueryFactory.create(queryString);
		QueryExecution q = QueryExecutionFactory.sparqlService(inputFileName,
				query);
		ResultSet results = q.execSelect();

		while (results.hasNext()) {

			QuerySolution binding = results.nextSolution();
			Literal subj = binding.getLiteral("title");
			bookTitleArray.add(subj);

		}

		// Important - free up resources used running the query
		q.close();
		return bookTitleArray;

	}

	public ArrayList<Resource> showBookUrlList(String limit) {

		String queryString = "PREFIX dc: <http://purl.org/dc/elements/1.1/>"
				+ "PREFIX schema: <http://schema.org/>" +

				"SELECT ?book ?title " + "WHERE { "
				+ "  ?book schema:sameAs ?oclc ." + "	 ?oclc dc:title ?title ."
				+ "}" + "ORDER BY ?title" + " LIMIT "+limit;

		Query query = QueryFactory.create(queryString);
		QueryExecution q = QueryExecutionFactory.sparqlService(inputFileName,
				query);
		ResultSet results = q.execSelect();

		while (results.hasNext()) {

			QuerySolution binding = results.nextSolution();
			Resource subj1 = binding.getResource("book");
			bookUrlArray.add(subj1);

		}

		// Important - free up resources used running the query
		q.close();
		return bookUrlArray;

	}

	//List the text of annotations created by Eva Rosenblum
	public ArrayList<Resource> showEvaNames() {

		String queryString = 
		"PREFIX dcterms: <http://purl.org/dc/terms/>"+
		"PREFIX skos: <http://www.w3.org/2004/02/skos/core#>"+
		"PREFIX oa: <http://www.w3.org/ns/oa#>"+
		"PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>"+
		"PREFIX dc: <http://purl.org/dc/elements/1.1/>"+
		
			"SELECT DISTINCT ?anno ?text "+
			"WHERE {"+      
			    "?anno dcterms:creator <http://viaf.org/viaf/54153607> ."+
			    "?anno oa:hasBody ?body ."+
			    "<http://viaf.org/viaf/54153607> skos:prefLabel ?name . "+
			    "?body oa:text ?text ."+
			"}"+
			" ORDER BY ?text"+
			" LIMIT 100";

		Query query = QueryFactory.create(queryString);
		QueryExecution q = QueryExecutionFactory.sparqlService(inputFileName,
				query);
		ResultSet results = q.execSelect();

		while (results.hasNext()) {
			QuerySolution binding = results.nextSolution();
			Resource subj1 = binding.getResource("anno");
			evaNameArray.add(subj1);
		}

		// Important - free up resources used running the query
		q.close();
		return evaNameArray;

	}
	
	public ArrayList<Literal> showEvaText() {

		String queryString = 
		"PREFIX dcterms: <http://purl.org/dc/terms/>"+
		"PREFIX skos: <http://www.w3.org/2004/02/skos/core#>"+
		"PREFIX oa: <http://www.w3.org/ns/oa#>"+
		"PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>"+
		"PREFIX dc: <http://purl.org/dc/elements/1.1/>"+
		
			"SELECT DISTINCT ?anno ?text "+
			"WHERE {"+      
			    "?anno dcterms:creator <http://viaf.org/viaf/54153607> ."+
			    "?anno oa:hasBody ?body ."+
			    "<http://viaf.org/viaf/54153607> skos:prefLabel ?name . "+
			    "?body oa:text ?text ."+
			"}"+
			" ORDER BY ?text"+
			" LIMIT 100";

		Query query = QueryFactory.create(queryString);
		QueryExecution q = QueryExecutionFactory.sparqlService(inputFileName,
				query);
		ResultSet results = q.execSelect();

		while (results.hasNext()) {
			QuerySolution binding = results.nextSolution();
			Literal subj = binding.getLiteral("text");
			evaTextArray.add(subj);
		}

		// Important - free up resources used running the query
		q.close();
		return evaTextArray;

	}
	
	
	public ArrayList<Literal> getCreatorList(){
		String queryString=
			"PREFIX dcterms: <http://purl.org/dc/terms/>"+
			"PREFIX skos: <http://www.w3.org/2004/02/skos/core#>"+
			"PREFIX oa: <http://www.w3.org/ns/oa#>"+
			"PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>"+
			"PREFIX dc: <http://purl.org/dc/elements/1.1/>"+
			
				"SELECT DISTINCT ?label "+
				"WHERE {"+      
				    "?anno dcterms:creator ?creator ."+
				    "?creator skos:prefLabel ?label  ."+
				    "FILTER(?creator != <http://library.princeton.edu>)."+
				"}"+
				" ORDER BY ?label"+
				" LIMIT 100";
		
		
		Query query = QueryFactory.create(queryString);
		QueryExecution q = QueryExecutionFactory.sparqlService(inputFileName,
				query);
		ResultSet results = q.execSelect();

		while (results.hasNext()) {
			QuerySolution binding = results.nextSolution();
			Literal subj = binding.getLiteral("label");
			creatorArray.add(subj);
		}

		// Important - free up resources used running the query
		q.close();
		return creatorArray;
	}
	
	
	public ArrayList<Resource> getCreatorAnnoList(String sub){
		String queryString=
			"PREFIX dcterms: <http://purl.org/dc/terms/>"+
			"PREFIX skos: <http://www.w3.org/2004/02/skos/core#>"+
			"PREFIX oa: <http://www.w3.org/ns/oa#>"+
			"PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>"+
			"PREFIX dc: <http://purl.org/dc/elements/1.1/>"+
			
				"SELECT DISTINCT ?anno  ?text "+
				"WHERE {"+      
				    " ?anno dcterms:creator ?creator ."+
				    " ?anno oa:hasBody ?body. "+
				    " ?creator skos:prefLabel \""
					+ sub + "\"  ."+
				    " ?body oa:text ?text . "+
				"}"+
				" LIMIT 100";
		
		
		Query query = QueryFactory.create(queryString);
		QueryExecution q = QueryExecutionFactory.sparqlService(inputFileName,
				query);
		ResultSet results = q.execSelect();

		while (results.hasNext()) {
			QuerySolution binding = results.nextSolution();
			Resource subj = binding.getResource("anno");
			creatorUrlArray.add(subj);
		}

		// Important - free up resources used running the query
		q.close();
		return creatorUrlArray;
	}
	
	
	public ArrayList<Literal> getCreatorText(String sub){
		String queryString=
			"PREFIX dcterms: <http://purl.org/dc/terms/>"+
			"PREFIX skos: <http://www.w3.org/2004/02/skos/core#>"+
			"PREFIX oa: <http://www.w3.org/ns/oa#>"+
			"PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>"+
			"PREFIX dc: <http://purl.org/dc/elements/1.1/>"+
			
				"SELECT DISTINCT ?anno ?text "+
				"WHERE {"+      
				    " ?anno dcterms:creator ?creator ."+
				    " ?anno oa:hasBody ?body. "+
				    " ?creator skos:prefLabel \""
				+ sub + "\"  ."+
				    " ?body oa:text ?text . "+
				"}"+
				" LIMIT 100";
		
		
		Query query = QueryFactory.create(queryString);
		QueryExecution q = QueryExecutionFactory.sparqlService(inputFileName,
				query);
		ResultSet results = q.execSelect();

		while (results.hasNext()) {
			QuerySolution binding = results.nextSolution();
			Literal subj = binding.getLiteral("text");
			creatorTextArray.add(subj);
		}

		// Important - free up resources used running the query
		q.close();
		return creatorTextArray;
}
	
	
	public ArrayList<Resource> getAnnotationGallery(){
		String queryString=
			"PREFIX dcterms: <http://purl.org/dc/terms/>"+
			"PREFIX skos: <http://www.w3.org/2004/02/skos/core#>"+
			"PREFIX oa: <http://www.w3.org/ns/oa#>"+
			"PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>"+
			"PREFIX dc: <http://purl.org/dc/elements/1.1/>"+
			"PREFIX foaf: <http://xmlns.com/foaf/0.1/>"+
			
				"SELECT DISTINCT ?image where {?image a foaf:Image}";
		
		
		Query query = QueryFactory.create(queryString);
		QueryExecution q = QueryExecutionFactory.sparqlService(inputFileName,
				query);
		ResultSet results = q.execSelect();

		while (results.hasNext()) {
			QuerySolution binding = results.nextSolution();
			Resource subj = binding.getResource("image");
			imageArray.add(subj);
		}

		// Important - free up resources used running the query
		q.close();
		return imageArray;
}
	
}
