(ns seq-learn.06-performance
  "Illustrating performance optimizations: chunking and transducers.")

;; 1. Chunking Behavior
;; Many sequences (like those from range, map, filter) are chunked.
;; Accessing the first element of a chunked sequence realizes the entire chunk (usually 32).
(defn demonstrate-chunking []
  (let [counter (atom 0)
        s (map (fn [x] (swap! counter inc) x) (range 100))]
    {:before (deref counter)
     :after-first (do (first s) (deref counter))}))

;; 2. Transducers
;; Transducers are a way to compose transformations without creating intermediate sequences.
(defn transducer-example [coll]
  (let [xf (comp (filter even?)
                 (map #(* % %)))]
    {:sequence (->> coll (filter even?) (map #(* % %)))
     :transducer (into [] xf coll)}))

(comment
  (demonstrate-chunking)
  (transducer-example (range 10)))
