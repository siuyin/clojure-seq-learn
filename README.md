# Clojure Sequence Learning Project

This project is a comprehensive guide to mastering Clojure's sequence abstraction. It covers everything from basic operations to advanced performance optimizations like chunking and transducers.

## Project Structure

The project is organized into six phases, each with its own example file in `src/seq_learn/` and a corresponding test file in `test/seq_learn/`.

| Phase | Topic | Concepts Covered | Files |
|-------|-------|-------------------|-------|
| 1 | **Basics** | `seq`, `first`, `rest`, `cons`, emptiness checks | `01_basics.clj`, `01_basics_test.clj` |
| 2 | **Generation** | `range`, `repeat`, `cycle`, `iterate` | `02_generation.clj`, `02_generation_test.clj` |
| 3 | **Transformations** | `map`, `filter`, `remove`, `mapcat`, `keep` | `03_transformations.clj`, `03_transformations_test.clj` |
| 4 | **Subsequences** | `take`, `drop`, `split-at`, `take-while`, `partition` | `04_subsequences.clj`, `04_subsequences_test.clj` |
| 5 | **Laziness** | `lazy-seq`, infinite sequences, realization, `doall` | `05_laziness.clj`, `05_laziness_test.clj` |
| 6 | **Performance** | Chunking (size 32), Transducers introduction | `06_performance.clj`, `06_performance_test.clj` |

## Prerequisites

- [Clojure CLI](https://clojure.org/guides/install_clojure) (v1.12.0 or later)
- `make` (optional, for convenience)

## Running the Project

To see the current active phase, run:
```bash
clojure -M -m seq-learn.main
```

## Running Tests

### Run All Tests
To run the full suite of tests across all phases:
```bash
make test
# OR
clojure -X:test
```

### Run Verbose Tests for Specific Phases
To run tests for a specific phase and see detailed output, use the following commands:

#### Phase 1: Basics
```bash
clojure -X:test :ns '["seq-learn.01-basics-test"]'
```

#### Phase 2: Generation
```bash
clojure -X:test :ns '["seq-learn.02-generation-test"]'
```

#### Phase 3: Transformations
```bash
clojure -X:test :ns '["seq-learn.03-transformations-test"]'
```

#### Phase 4: Subsequences & Partitioning
```bash
clojure -X:test :ns '["seq-learn.04-subsequences-test"]'
```

#### Phase 5: Laziness & Infinite Sequences
```bash
clojure -X:test :ns '["seq-learn.05-laziness-test"]'
```

#### Phase 6: Performance & Chunking
```bash
clojure -X:test :ns '["seq-learn.06-performance-test"]'
```

## Exploration
Each source file in `src/seq_learn/` contains `(comment ...)` blocks. You can load these into a REPL to experiment with the examples interactively.
