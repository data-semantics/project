xquery version "3.1";

module namespace cwb-annotate   = "http://bibfram.es/cwb/annotate";

import module namespace functx  = "http://www.functx.com";
declare namespace cwb		   = "http://bibfram.es/cwb/";
declare namespace marcxml       = "http://www.loc.gov/MARC21/slim";
declare namespace rdf           = "http://www.w3.org/1999/02/22-rdf-syntax-ns#";
declare namespace rdfs          = "http://www.w3.org/2000/01/rdf-schema#";

declare namespace oa			= "http://www.w3.org/ns/oa#";
declare namespace ex            = "http://example.org/";
declare namespace foaf		  = "http://xmlns.com/foaf/0.1/";
declare namespace skos		  = "http://www.w3.org/2004/02/skos/core#";
declare namespace dcterms       = "http://purl.org/dc/terms/";
declare namespace schema        = "http://schema.org/";
declare namespace bf            = "http://bibframe.org/vocab/";
declare namespace madsrdf       = "http://www.loc.gov/mads/rdf/v1#";
declare namespace relators      = "http://id.loc.gov/vocabulary/relators/";
declare namespace identifiers   = "http://id.loc.gov/vocabulary/identifiers/";
declare namespace notes         = "http://id.loc.gov/vocabulary/notes/";
declare namespace mods          = "http://www.loc.gov/mods/v3";

declare
    %rest:path("/resource/{$id}")
    %rest:GET             
function cwb-annotate:get-annotation(
    $id as xs:string*
) as item()* {
    <rest:response>
      <http:response status="303">
        <http:header name="location" value="/view/{$id}/instance1"/>
      </http:response>
    </rest:response>
};

declare
    %rest:path("/resource/{$x}/{$y}")
    %rest:GET             
function cwb-annotate:get-instance(
    $x as xs:string*,
    $y as xs:string*
) 
as item()* {
    <rest:response>
        <http:response status="303">
            <http:header name="location" value="/view/{$x}/{$y}"/>
        </http:response>
    </rest:response>
};

declare
    %rest:path("/view/{$x}/{$y}")    
    %rest:GET                   
function cwb-annotate:show(
    $x as xs:string*,
    $y as xs:string*    
) 
as item()* {   
    let $anno :=
	   db:attribute(
           "derrida", 
           "http://bibfram.es/derrida/resource/" || $x
       )/..
    let $instance :=
	   db:attribute(
           "derrida", 
           "http://bibfram.es/derrida/resource/" || $x || "/instance1"
       )/..
    let $oclc := $instance/*[@rel eq "schema:sameAs"]/@resource[starts-with(., "http://www.worldcat.org/oclc/")]/string()
    let $oclc-req := 
	    <http:request 
		    href="{$oclc}"
		    method="GET">
		    <http:header
			    name="Accept"
			    value="application/rdf+xml"/>
	    </http:request>
    let $oclc-resp := 
	    try {
		    http:send-request($oclc-req)
	    } catch * {
		    <cwb:message>Sorry, no data could be retrieved for this URI.</cwb:message>
	    }        
	    
    (: Instance data :)
    let $oclc-instance :=
	    if ($oclc-resp[2]) then
		    let $oclc-resp-head := $oclc-resp[1]
		    let $oclc-resp-body := $oclc-resp[2]        
		    return $oclc-resp-body
	    else $oclc-resp   
    let $oclc-instance-creator := 
        $oclc-instance//rdf:Description[@rdf:about eq $oclc]/schema:creator/@rdf:resource/string()
    let $oclc-instance-creator-name :=
        $oclc-instance//rdf:Description[@rdf:about eq $oclc-instance-creator]/schema:name/string()
    let $oclc-instance-title := 
	    $oclc-instance//rdf:Description[@rdf:about eq $oclc]/schema:name/string()
    let $oclc-publication-date :=
        $oclc-instance//rdf:Description[@rdf:about eq $oclc]/schema:datePublished/string()
    let $oclc-publisher-id :=
        $oclc-instance//rdf:Description[@rdf:about eq $oclc]/schema:publisher[1]/@rdf:resource/string()
    let $oclc-publisher :=
        $oclc-instance//rdf:Description[@rdf:about eq $oclc-publisher-id]/schema:name/string()
    
    (: Work data :)
    let $oclc-req-2 :=
	    if ($oclc-instance/name() eq "cwb:message") then
    	    $oclc-instance
        else 
    	    let $oclc-2 := $oclc-instance//rdf:Description/schema:exampleOfWork/@rdf:resource/string()    	
            let $oclc-req := 
        	    <http:request 
        		    href="{$oclc-2}"
        		    method="GET"
        		    follow-redirect="true">
        		    <http:header
        			    name="Accept"
        			    value="application/rdf+xml"/>
       		    </http:request>
            let $oclc-resp-2 := 
        	    try {
        		    http:send-request($oclc-req)
        	    } catch * {
        		    <cwb:message>Sorry, no data could be retrieved for this URI.</cwb:message>
        	    }        
            let $oclc-work := 
        	    if ($oclc-resp-2[2]) then
        		    let $oclc-resp-2-head := $oclc-resp-2[1]
        		    let $oclc-resp-2-body := $oclc-resp-2[2]        
        		    return $oclc-resp-2-body
        	    else $oclc-resp-2
            return 
        	    <cwb:oclc-work id="{$oclc-2}">
				    <cwb:oclc-work-title>{                
					    $oclc-work//rdf:Description[@rdf:about eq $oclc-2]/schema:name/string()
                    }</cwb:oclc-work-title>            	
                </cwb:oclc-work>        
    return
	    <html>  
            <head>
            <meta charset="utf-8"/>
            <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
            <!-- Bootstrap core CSS 
            <link href="/derrida/static/css/bootstrap.min.css" rel="stylesheet"/>
            -->
            <!-- Optional theme
            <link rel="stylesheet" href="/derrida/static/css/bootstrap-theme.min.css"/>
            -->
            <!-- Custom styles for this template -->
            <link href="/derrida/static/css/CSS_Derrida.css" rel="stylesheet"/>
            <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
            <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
            <![endif]-->
            
            <style type="text/css">
                <![CDATA[            
                    body{
                        background-image: url("/derrida/static/img/BlueBackground.jpg")
                    }                    
                    
                    #header{
                        position: relative;
                        background-image: url("/derrida/static/img/LogoPattern.jpg");
                        height: 103px;     
                        text-align: center;                   
                    }
                    #subheader{
                        background-color: rgb(245, 176, 65);
                        width: 100%;
                        font-size: 20px;
                        height: 25px;
                        background-color: rgb(245, 176, 65);
                        color: rgb(0, 51, 153);
                        text-align: center;
                        
                    }
                    #footer #course {
                        position: relative;
                        background-image: url("/derrida/static/img/LogoPattern.jpg");
                        line-height: 35px;     
                        text-align: center;                   
                        font-weight: bold;
                        color: white;
                        font-size: 18px;
                    }
                    #footer #credits {
                        position: relative;
                        background-image: url("/derrida/static/img/LogoPattern.jpg");
                        line-height: 35px;     
                        text-align: center;                   
                        color: white;
                        font-size: 18px;
                    }
                    #item{
                        margin-left: 1%;
                    }
                    #annotable{
                        width: 100%;
                        margin-bottom: 2%;
                    }
                    #anno{
                        width: 10%;
                        padding: 10px;
                        
                    }
                    #book{
                        width: 10%;
                        padding: 10px;
                    }
                    #item-img img{
                        width: 60%;
                        
                    }
                    #back{
                        background: rgb(245, 176, 65) none repeat scroll 0% 0%;
                        padding: 5px 10px;
                        border-radius: 9px;
                        font-size: 13px;
                        font-family: Georgia,serif;
                        cursor: pointer;                  
                        margin: 5px 10px;      
                    }
                ]]>
            </style>
            
            <title>
            	Annotation {$x}
            </title>    
            <!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script> -->
            <!-- <script src="/derrida/static/js/bootstrap.min.js"></script> -->
        </head>
        <body prefix="rdf: http://www.w3.org/1999/02/22-rdf-syntax-ns# owl: http://www.w3.org/2002/07/owl# bf: http://bibframe.org/vocab/ madsrdf: http://www.loc.gov/mads/rdf/v1# relators: http://id.loc.gov/vocabulary/relators/ m21rdf00X: http://marc21rdf.info/elements/00X/ skos: http://www.w3.org/2004/02/skos/core# dcterms: http://purl.org/dc/terms/ oa: http://www.w3.org/ns/oa# dc: http://purl.org/dc/elements/1.1/ ex: http://example.org/ schema: http://schema.org/ foaf: http://xmlns.com/foaf/0.1/ xsd: http://www.w3.org/2001/XMLSchema#" xml:base="http://bibfram.es/">
            <div id="wrapper" class="container">
                <div id="header">
                    <img src="/derrida/static/img/Background.jpg" alt="De-Framing Derrida header title"/>
                </div>
                <div id="subheader">
                    Manuscript Annotations in Jacques Derrida's Library
                </div>
                <!-- <input id="back" type="submit" value="Back"/> -->
                <h1>Annotation {$x}</h1>
		        <table id="annotable" rev="oa:hasBody" resource="{'http://bibfram.es/derrida/resource/' || $x}">      
                    <thead class="table-header">
                        <tr>                           
                            <td>Annotated item</td>                                                        
                            <td>Annotation</td>                                                    
                        </tr>
                    </thead>          
                    <tbody>
                        <tr class="table-odd-row">
                            {
                                for $img in db:open("derrida")/*/*[@typeof eq "foaf:Image"]
                                for $depicts in $img/*[@rel = "foaf:depicts"]/@resource
                                where $depicts[starts-with(., "http://bibfram.es/derrida/resource/" || $x || "/item")]
                                
                                return
                                <td id="item-img" about="{$depicts}" rel="foaf:depiction">
                                    <img src="{$img/@about}" alt="Item image for item {$depicts}"/>
                                </td>
                                
                            }
                            <td id="item-img">
                            {
                                for $img in db:open("derrida")/*/*[@typeof eq "foaf:Image"]
                                for $depicts in $img/*[@rel = "foaf:depicts"]/@resource
                                where $depicts[starts-with(., "http://bibfram.es/derrida/resource/" || $x || "/page")]
                                
                                return
                                
                                    <img src="{$img/@about}" rel="foaf:depicts" resource="{$depicts}" alt="Item image for page {$depicts}"/>                                                                
                            }
                            </td>    
                        </tr>
                        <tr class="table-even-row">
                            <td id="book" about="{'http://bibfram.es/derrida/resource/' || $x}" rel="oa:hasTarget" resource="{'http://bibfram.es/derrida/resource/' || $x || '/pageX'}">                    
                                <span rel="dcterms:isPartOf" resource="http://bibfram.es/derrida/resource/{$x}/item1"/>
                                <span about="http://bibfram.es/derrida/resource/{$x}/item1" rel="bf:itemOf" resource="http://bibfram.es/derrida/resource/{$x}/instance1"/>
                                <span id="work" about="{$oclc-req-2/@id/string()}" typeof="bf:Work schema:CreativeWork">
                                    <span id="instance" about="http://bibfram.es/derrida/resource/{$x}/instance1" typeof="bf:Instance" rel="bf:instanceOf" resource="{$oclc-req-2/@id/string()}">                                        
                                        <dl>
                                            <dt about="http://bibfram.es/derrida/resource/{$x}/instance1" rel="schema:sameAs" resource="{$oclc}">Title: </dt>
                                            <dd>
                                                <a href="{$oclc}" property="dcterms:title">{
                                                    $oclc-instance-title    
                                                }</a>            		
                                            </dd>
                                        </dl>
                                        <dl about="{$oclc}">
                                            <dt rel="dcterms:creator" resource="{$oclc-instance-creator}">Creator: </dt>
                                            <dd><a href="{$oclc-instance-creator}">{$oclc-instance-creator-name}</a></dd>
                                        </dl>
                                        <dl>
                                            <dt about="{$oclc}" rel="schema:publisher" resource="{$oclc-publisher-id}">Publisher: </dt>
                                            <dd>{$oclc-publisher}</dd>
                                        </dl>
                                        <dl>
                                            <dt about="{$oclc}" rel="schema:datePublished" resource="{$oclc-publication-date}">Date published: </dt>
                                            <dd>{$oclc-publication-date}</dd>
                                        </dl> 
                                    </span>
                                </span>            
                            </td>                                   
                            <td id="anno">
                                <dl rel="dcterms:creator">
                                    <dt>Annotation author: </dt>
                                    <dd resource="{
                                        if ($anno/*[@rel eq "dcterms:creator"]/@resource) then
                                            $anno/*[@rel eq "dcterms:creator"]/@resource
                                        else ()
                                    }" typeof="foaf:Person">
                                        <a href="{
                                            if ($anno/*[@rel eq "dcterms:creator"]/@resource) then
                                                $anno/*[@rel eq "dcterms:creator"]/@resource
                                            else ()
                                        }">{
                                            db:attribute(
                                                "derrida",
                                                $anno/*[@rel eq "dcterms:creator"]/@resource/string(),                               
                                                "about"
                                            )/../string()		                
                                        }</a>
                                    </dd>
                                </dl>		            
                                <dl>{
                                    for $body at $p in $anno/*[@rel eq "oa:hasBody"]/@resource
                                        let $b :=
                                            db:attribute(
                                                "derrida", 
                                                $body/string(), 
                                                "about"
                                            )/..
                                        return (                       	
                                            <dt>Annotation text: </dt>,
                                            <dd property="oa:text" datatype="xsd:string">&#8220;{$b/*[@property eq "oa:text"]/string()}&#8221;</dd>
                                        )
                                }</dl>
                                <dl>{                                        
                                    <dt rel="dc:subject">Names and places: </dt>,		            
                                    for $meta in db:open("derrida")/*/*[@about => contains("/meta")]
                                    where $meta/@about => starts-with("http://bibfram.es/derrida/resource/" || $x || "/meta")
                                    let $b := $meta/*[@rel eq "oa:hasBody"]                    
                                    let $tag := $b/*[@rel eq "oa:hasSource"]
                                    let $source := $tag/@resource/string()
                                    return
                                        <dd resource="{$source}" typeof="{
                                            db:attribute(
                                                "derrida",
                                                $source,
                                                "about"
                                            )/../@typeof/string()
                                        }">
                                            <a href="{$source}">{
                                                db:attribute(
                                                    "derrida",
                                                    $source,
                                                    "about"         		                        
                                                )/../*[@property eq "skos:prefLabel"]/string()
                                            }</a>		                
                                        </dd>   
                                }</dl>                              
                            </td>                          
                        </tr>		                		                          
                    </tbody>                                              
                </table>		        
                <div id="footer">
                    <div id="course">Data Semantics 2016</div>
                    <div id="credits">Timothy Thompson, Sushmita Ray, Al Armstrong</div>
                </div>
		    </div>  
        </body>
    </html> => functx:change-element-ns-deep("http://www.w3.org/1999/xhtml", "")
};



declare
    %rest:path("/data/{$x}/{$y}")
    %rest:GET               
    %rest:produces("text/turtle")
    %output:media-type("text/turtle")    
function cwb-annotate:rdf-xml(
    $x as xs:string*,
    $y as xs:string*
) 
as item()* {
    let $query :=
                   ``[
DESCRIBE <http://bibfram.es/derrida/resource/`{$x}`/`{$y}`> 
WHERE {
  ?s ?p ?o .
} 
                   ]``
               let $request := 
                   <http:request 
                       href="http://bibfram.es/fuseki/sparql?query={encode-for-uri($query)}"
                       method="GET">
                       <http:header
                           name="Accept"
                           value="text/turtle"/>
                   </http:request>
               let $response := http:send-request($request)
               let $head := $response[1]
               let $body := $response[2]     
               return $body          
};

declare
    %rest:path("/data/data.rdf")
    %rest:GET
    %rest:produces("application/rdf+xml")
    %output:media-type("application/rdf+xml")
function cwb-annotate:dump-turtle()
as item()* {
    let $query :=
                   ``[
DESCRIBE *
WHERE {
  ?s ?p ?o .
}
                   ]``
               let $request :=
                   <http:request
                       href="http://bibfram.es/fuseki/sparql?query={encode-for-uri($query)}"
                       method="GET">
                       <http:header
                           name="Accept"
                           value="application/rdf+xml"/>
                   </http:request>
               let $response := http:send-request($request)
               let $head := $response[1]
               let $body := $response[2]
               return $body
};