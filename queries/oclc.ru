PREFIX dcterms: <http://purl.org/dc/terms/> 
PREFIX skos: <http://www.w3.org/2004/02/skos/core#>
PREFIX oa: <http://www.w3.org/ns/oa#>
PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>
PREFIX dc: <http://purl.org/dc/elements/1.1/>
PREFIX ex: <http://example.org/>
PREFIX bf: <http://bibframe.org/vocab/>
PREFIX schema: <http://schema.org/>

INSERT DATA
{
<http://bibfram.es/annotations/derrida/1.4.11.37/pageX> rdf:type ex:Page .
<http://bibfram.es/annotations/derrida/1.4.11.37/pageX> dcterms:isPartOf <http://bibfram.es/annotations/derrida/1.4.11.37/item1> .
<http://bibfram.es/annotations/derrida/1.4.11.37/item1> rdf:type bf:Item .
<http://bibfram.es/annotations/derrida/1.4.11.37/item1> bf:itemOf <http://bibfram.es/annotations/derrida/1.4.11.37/instance1> .
<http://bibfram.es/annotations/derrida/1.4.11.37/instance1> rdf:type bf:Instance .
<http://bibfram.es/annotations/derrida/1.4.11.37/instance1> schema:sameAs <http://www.worldcat.org/oclc/24251579> .
}

