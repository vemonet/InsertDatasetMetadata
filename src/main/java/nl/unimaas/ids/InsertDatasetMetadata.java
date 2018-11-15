package nl.unimaas.ids;

import java.io.InputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.yaml.snakeyaml.Yaml;

import nl.unimaas.ids.metadata.MetadataProperties;
import nl.unimaas.ids.metadata.MetadataProperty;

public class InsertDatasetMetadata {
	//private static final Logger logger = LoggerFactory.getLogger(InsertDatasetMetadata.class.getName());
	
	// TODO: should we use Java X validation (annotation to validate) 
	
	public static void main(String[] args) throws Exception {

		Yaml yaml = new Yaml();
		
		try (InputStream in = InsertDatasetMetadata.class.getResourceAsStream("/dataset-properties.yaml")) {
	          MetadataProperties properties = yaml.loadAs(in, MetadataProperties.class);
	          for (MetadataProperty prop : properties.getProperties()) {
	              System.out.println(prop.getName());
	          }
	      }
		
		
		/*
		Map<String, Object> yamlPropertiesFile = (Map<String, Object>)yaml.load(
				InsertDatasetMetadata.class.getResourceAsStream("/dataset-properties.yaml"));
		
		Map<String, String> prefixes = (Map<String, String>)yamlPropertiesFile.get("prefixes");
		
		System.out.println(Arrays.toString(prefixes.entrySet().toArray()));

		Map<String, String> properties = (Map<String, String>)yamlPropertiesFile.get("properties");
		
		System.out.println(Arrays.toString(properties.entrySet().toArray()));

		
		
		
		if(args.length<2)
			throw new IllegalArgumentException("You must provide two arguments.\n"
					+ "  1. a valid sparql-endpoint-url\n"
					+ "  2. an output-file location\n");
		
		String sparqlEndpoint = args[0];
		String outputFilePath = args[1];
		
		Model statistics = null;
		
		ParameterizedSparqlString query = new ParameterizedSparqlString();
		
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
		*/

	}

}
