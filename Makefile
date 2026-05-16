.PHONY: help test run build run-jar clean

LIB_NAME := seq-learn
VERSION := 0.1.0-SNAPSHOT
UBER_FILE := target/$(LIB_NAME)-$(VERSION)-standalone.jar

help:
	@echo "Clojure Sequence Learning Project Makefile"
	@echo ""
	@echo "Available targets:"
	@echo "  make help    - Show this help message"
	@echo "  make test    - Run the Clojure unit tests"
	@echo "  make run     - Run the main program from source"
	@echo "  make build   - Build a standalone Uberjar"
	@echo "  make run-jar - Run the application from the Uberjar"
	@echo "  make clean   - Remove build artifacts"

test:
	clojure -X:test

run:
	clojure -M -m seq-learn.main

# Define source and test files as dependencies
SOURCES := $(shell find src test -type f)

$(UBER_FILE): $(SOURCES) deps.edn build.clj
	clojure -T:build uber

build: $(UBER_FILE)

run-jar: $(UBER_FILE)
	java -jar $(UBER_FILE)

clean:
	clojure -T:build clean
