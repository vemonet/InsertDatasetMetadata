# Docker
## Build
docker build -t dqa_descriptive_stats .
## Run
docker run -it -v /c/data/dqa:/data --rm dqa_descriptive_stats "http://dbpedia.org/sparql" "/data/dbpedia.xml"
