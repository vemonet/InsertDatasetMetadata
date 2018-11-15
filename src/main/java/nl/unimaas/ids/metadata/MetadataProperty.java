package nl.unimaas.ids.metadata;

public class MetadataProperty {
	
	public MetadataProperty() {}
	
	private String name;

	private String description;
	private String range;
	private String summaryLevel;
	private String versionLevel;
	private String rdfDistributionLevel;
	private String sourceDistributionLevel;
	/*private MetadataRange range;
	private MetadataRequirement summaryLevel;
	private MetadataRequirement versionLevel;
	private MetadataRequirement rdfDistributionLevel;
	private MetadataRequirement sourceDistributionLevel;*/

	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getRange() {
		return range;
	}
	public void setRange(String range) {
		this.range = range;
	}
	public String getSummaryLevel() {
		return summaryLevel;
	}
	public void setSummaryLevel(String summaryLevel) {
		this.summaryLevel = summaryLevel;
	}
	public String getVersionLevel() {
		return versionLevel;
	}
	public void setVersionLevel(String versionLevel) {
		this.versionLevel = versionLevel;
	}
	public String getRdfDistributionLevel() {
		return rdfDistributionLevel;
	}
	public void setRdfDistributionLevel(String rdfDistributionLevel) {
		this.rdfDistributionLevel = rdfDistributionLevel;
	}
	public String getSourceDistributionLevel() {
		return sourceDistributionLevel;
	}
	public void setSourceDistributionLevel(String sourceDistributionLevel) {
		this.sourceDistributionLevel = sourceDistributionLevel;
	}
	
}
