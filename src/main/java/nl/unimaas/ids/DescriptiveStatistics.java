package nl.unimaas.ids;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Map;

import org.apache.jena.query.ParameterizedSparqlString;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.riot.RDFDataMgr;
import org.apache.jena.riot.RDFFormat;
import org.yaml.snakeyaml.Yaml;

public class DescriptiveStatistics {
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception {
		// TODO: print usage if problems come up
		
		if(args.length<2)
			throw new IllegalArgumentException("You must provide two arguments.\n  1. a valid sparql-endpoint-url\n  2. an output-file location");
		
		String sparqlEndpoint = args[0];
		String outputFilePath = args[1];
		
		Model statistics = null;
		
		Yaml yaml = new Yaml();
		Map<String, Object> yamlFile = (Map<String, Object>)yaml.load(DescriptiveStatistics.class.getResourceAsStream("/queries.yaml"));
		List<Map<String, String>> prefixes = (List<Map<String, String>>)yamlFile.get("prefixes");
		List<String> queries = (List<String>)yamlFile.get("queries");
		
		ParameterizedSparqlString query = new ParameterizedSparqlString();
		for(Map<String, String> prefix : prefixes) {
			String key = prefix.keySet().iterator().next();
			query.setNsPrefix(key, prefix.get(key));
		}
			
		
		for(String sparql : queries) {
			query.setCommandText(sparql);
			QueryExecution queryExecution = QueryExecutionFactory.sparqlService(sparqlEndpoint, query.toString());
			Model model = queryExecution.execConstruct();
			statistics = (statistics==null)?model:ModelFactory.createUnion(statistics, model);
		}
		
		RDFDataMgr.write(new FileOutputStream(new File(outputFilePath)), statistics, RDFFormat.RDFXML_PRETTY);

	}

}
