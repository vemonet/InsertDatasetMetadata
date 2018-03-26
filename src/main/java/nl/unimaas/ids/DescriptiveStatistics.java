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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.yaml.snakeyaml.Yaml;

public class DescriptiveStatistics {
	private static final Logger logger = LoggerFactory.getLogger(DescriptiveStatistics.class.getName());
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception {
		
		if(args.length<2)
			throw new IllegalArgumentException("You must provide two arguments.\n"
					+ "  1. a valid sparql-endpoint-url\n"
					+ "  2. an output-file location\n");
		
		String sparqlEndpoint = args[0];
		String outputFilePath = args[1];
		
		Model statistics = null;
		
		
		Yaml yaml = new Yaml();
		Map<String, Object> yamlFile = (Map<String, Object>)yaml.load(
				DescriptiveStatistics.class.getResourceAsStream("/queries.yaml"));
		
		ParameterizedSparqlString query = new ParameterizedSparqlString();
		
		List<Map<String, String>> prefixes = (List<Map<String, String>>)yamlFile.get("prefixes");
		for(Map<String, String> prefix : prefixes) {
			String key = prefix.keySet().iterator().next();
			query.setNsPrefix(key, prefix.get(key));
		}
		
		List<String> queries = (List<String>)yamlFile.get("queries");
		for(String sparql : queries) {
			query.setCommandText(sparql);
			QueryExecution queryExecution = QueryExecutionFactory.sparqlService(sparqlEndpoint, query.toString());
			queryExecution.setTimeout(0, 0);
			
			logger.info("executing:\n\t" + queryExecution.getQuery().toString().replaceAll("\n", "\n\t") + "\n");
			long start = System.currentTimeMillis();
			Model model = queryExecution.execConstruct();
			
			logger.info("took: " + (System.currentTimeMillis() - start) + " ms\n" + model + "\n");
			statistics = (statistics==null) ? model : ModelFactory.createUnion(statistics, model);
		}
		
		File outputFile = new File(outputFilePath);
		if(outputFile.getParentFile()!=null) outputFile.getParentFile().mkdirs();
		RDFDataMgr.write(new FileOutputStream(outputFile), statistics, RDFFormat.NTRIPLES);
		logger.info("Succesfully written results to \"" + outputFile.getAbsolutePath() + "\"");

	}

}
