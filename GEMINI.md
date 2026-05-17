# Software Development Guidelines

When planning and implementing software development tasks in this project, adhere to the following principles:

1. **Test Driven Development (TDD):** Always write tests before implementing the corresponding functionality. Ensure that all new features and bug fixes are verified by automated tests.
2. **Naming Conventions:** Select clear, descriptive, but concise function names that accurately reflect their purpose.
3. **Function Length:** Keep functions focused and manageable. Aim for a length between 5 and 15 lines of code.
4. **Modularity:** Break up complex logic into independent, coherent modules.
5. **Library Design & Stuttering:**
    - Organise modules into logical libraries.
    - Avoid "stuttering" in function names. When a function is part of a library, its name should not repeat the library's name as a prefix.
    - **Example:** Prefer `csv.read()` over `csv.read_csv()`.

---

# Clojure Sequence Learning Project

This project is dedicated to exploring and mastering Clojure's sequence abstraction.

## Technical Reference: Clojure Sequences

### The Sequence Abstraction (`ISeq`)
A sequence is a logical list that is:
- **Immutable**: Elements cannot be changed.
- **Persistent**: Efficiently produces new versions.
- **Lazy**: Elements are only calculated as needed.

Core functions:
- `(seq coll)`: Returns a sequence from a collection, or `nil` if empty. Use this for emptiness checks: `(if-let [s (seq coll)] ...)`
- `(first s)`: Returns the first item in the sequence.
- `(rest s)`: Returns a sequence of the remaining items (never nil, maybe empty).
- `(cons item s)`: Returns a new sequence with `item` added to the front.

### Key Characteristics
1. **Laziness**: Most sequence functions return a "lazy sequence" which doesn't compute its values until they are requested.
2. **Chunking**: For performance, some lazy sequences (like those produced by `range` or `map`) compute elements in chunks (typically 32) to reduce overhead.

## Project Conventions

### Namespace Naming
- Examples should be in `src/` under appropriate names (e.g., `src/seq_learn/01_basics.clj`).
- Use the namespace pattern `seq-learn.<topic>` (e.g., `seq-learn.01-basics`).

### Verification
- Each example should be accompanied by tests in `test/` or include `(comment ...)` blocks with verifiable results.
- Prefer using `clojure.test` for formal verification.

## Instructions for Gemini CLI
When asked to add a new example:
1. Refer to `learning_plan.txt` for the current phase.
2. Create a new file in `src/` following the naming convention.
3. Implement illustrative examples with clear comments explaining the behavior.
4. Add a corresponding test file in `test/` to verify the examples.
5. Update `learning_plan.txt` if the plan changes.
6. Verify changes using `clojure -X:test`.
