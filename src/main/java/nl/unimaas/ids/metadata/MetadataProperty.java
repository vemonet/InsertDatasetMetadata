package nl.unimaas.ids.metadata;

public class MetadataProperty {
	
	public MetadataProperty() {}
	
	private String name;

	private String description;

	private MetadataRange range;
	private MetadataRequirement summaryLevel;
	private MetadataRequirement versionLevel;
	private MetadataRequirement rdfDistributionLevel;
	private MetadataRequirement sourceDistributionLevel;

	
	// Getter and setter
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
	public MetadataRange getRange() {
		return range;
	}
	public void setRange(MetadataRange range) {
		this.range = range;
	}
	public MetadataRequirement getSummaryLevel() {
		return summaryLevel;
	}
	public void setSummaryLevel(MetadataRequirement summaryLevel) {
		this.summaryLevel = summaryLevel;
	}
	public MetadataRequirement getVersionLevel() {
		return versionLevel;
	}
	public void setVersionLevel(MetadataRequirement versionLevel) {
		this.versionLevel = versionLevel;
	}
	public MetadataRequirement getRdfDistributionLevel() {
		return rdfDistributionLevel;
	}
	public void setRdfDistributionLevel(MetadataRequirement rdfDistributionLevel) {
		this.rdfDistributionLevel = rdfDistributionLevel;
	}
	public MetadataRequirement getSourceDistributionLevel() {
		return sourceDistributionLevel;
	}
	public void setSourceDistributionLevel(MetadataRequirement sourceDistributionLevel) {
		this.sourceDistributionLevel = sourceDistributionLevel;
	}
}
