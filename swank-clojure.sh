#!/bin/sh
# swank-clojure easy wrapper
# This requires lein deps or mvn deps.

DEST=$1
if [ -z ${DEST} ]; then
    DEST=.
fi
cd ${DEST}
if [ -f project.clj ]; then
    exec env \
	JAVA_OPTS="-Dswank.encoding=utf-8-unix -Dfile.encoding=UTF-8" \
	lein swank 4005 127.0.0.1 ':encoding' '"UTF-8"'
elif [ -f pom.xml ]; then
    exec env \
	MAVEN_OPTS="${MAVEN_OPTS} -Dclojure.swank.encoding=utf-8-unix -Dfile.encoding=UTF-8" \
	mvn clojure:swank
else
    echo "You can specify only a project directory including \"project.clj\" or \"pom.xml\"."
fi
