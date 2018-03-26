[![License](https://img.shields.io/badge/FAIR-metrics-orange.svg)](http://fairmetrics.org/)
[![License](https://img.shields.io/badge/license-MIT-blue.svg)](https://opensource.org/licenses/MIT)
# About
This project executes a series of SPARQL construct statements which result in a RDF file containing the results of those statements.
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
