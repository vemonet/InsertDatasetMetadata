# About
This project executes a series of SPARQL construct statements which result in a RDF XML file containing the results of those statements.
# Docker
## Build
docker build -t dqa_descriptive_stats .
## Run
### Linux / OSX
docker run -it -v /data/dqa:/data --rm dqa_descriptive_stats "http://dbpedia.org/sparql" "/data/dbpedia.xml"
### Windows
docker run -it -v /c/data/dqa:/data --rm dqa_descriptive_stats "http://dbpedia.org/sparql" "/data/dbpedia.xml"
