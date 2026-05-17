(ns seq-learn.01-basics
  "Illustrating the core Clojure sequence abstraction.")

;; 1. The 'seq' function
;; 'seq' is the entry point to the sequence abstraction.
;; It returns a sequence view of a collection, or nil if the collection is empty.
(defn explain-seq []
  {:vector (seq [1 2 3])
   :list   (seq '(1 2 3))
   :map    (seq {:a 1 :b 2}) ; returns a sequence of map entries
   :set    (seq #{1 2 3})
   :empty  (seq [])})        ; returns nil

;; 2. Core functions: first, rest, next
;; 'first' returns the first item.
;; 'rest' returns the rest of the sequence (always a sequence, maybe empty).
;; 'next' returns the rest of the sequence, or nil if there are no more items.
(defn core-ops [coll]
  (let [s (seq coll)]
    {:first (first s)
     :rest  (rest s)
     :next  (next s)}))

;; 3. Prepending with 'cons'
;; 'cons' prepends an item to the front of a sequence.
(defn prepend [item coll]
  (cons item (seq coll)))

;; 4. Idiomatic Emptiness Check
;; In Clojure, it's idiomatic to use (seq coll) as a boolean test.
(defn process-if-not-empty [coll]
  (if-let [s (seq coll)]
    (str "Processing: " (first s))
    "Collection is empty"))

(comment
  (explain-seq)
  (core-ops [10 20 30])
  (prepend 0 [1 2 3])
  (process-if-not-empty [1])
  (process-if-not-empty []))
