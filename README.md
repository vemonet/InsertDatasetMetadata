[![License](https://img.shields.io/badge/FAIR-metrics-orange.svg)](http://fairmetrics.org/)
[![License](https://img.shields.io/badge/license-MIT-blue.svg)](https://opensource.org/licenses/MIT)
# About
This project executes eight SPARQL queries defined by the Health Care and the Life Sciences [HCLS](https://www.w3.org/TR/hcls-dataset/#s6_6) group on the description of datasets using the Resource Description Framework. That is, the number of triples, entities, subjects, properties, objects and graphs of the dataset are reported.

This Docker container is part of the LODQuA pipeline (https://github.com/MaastrichtU-IDS/dqa_pipeline/).



## Todo

Check prov-o (we want a generic description)



The program takes arguments. All arguments are loaded to a HashMap and this hashmap is used to construct the SPARQL query to add metadata.

2 types of SPARQL query: 

* creating a new dataset
* adding a new version to a dataset

Some metadata are mandatory (title and description when creating a new dataset for example). Other will be directly retrieved using SPARQL queries (title when new version...)



# Docker

## Build
```
docker build -t dqa_descriptive_stats .
```
## Run
### Linux / OSX
```
docker run -it --rm \
  -v /data/dqa:/data \
  dqa_descriptive_stats \
  "http://dbpedia.org/sparql" "/data/dbpedia-descriptive.nq"
```
### Windows
```
docker run -it --rm ^
  -v /c/data/dqa:/data ^
  dqa_descriptive_stats ^
  "http://dbpedia.org/sparql" "/data/dbpedia-descriptive.nq"
```
