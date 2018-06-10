#!/bin/sh
cd $TRAVIS_BUILD_DIR/common-utils
mvn clean package
mvn cobertura:cobertura