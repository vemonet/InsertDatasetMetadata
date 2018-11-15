package nl.unimaas.ids.metadata;

import java.util.List;

public class MetadataProperties {
		
    public MetadataProperties() {}
	
	private List<MetadataProperty> properties;

	public void setProperties(List<MetadataProperty> properties) {
		this.properties = properties;
	}

	public List<MetadataProperty> getProperties() {
		return properties;
	}
}
