(ns seq-learn.subsequences
  "Illustrating subsequence and partitioning functions in Clojure.")

;; 1. take & drop
;; (take n coll) -> first n items
;; (drop n coll) -> everything after the first n items
(defn take-drop-examples []
  {:take (take 3 [1 2 3 4 5])
   :drop (drop 3 [1 2 3 4 5])})

;; 2. split-at
;; (split-at n coll) -> [(take n coll) (drop n coll)]
(defn split-at-example []
  (split-at 2 [10 20 30 40]))

;; 3. take-while & drop-while
;; (take-while pred coll) -> items from the beginning while pred is true
;; (drop-while pred coll) -> items starting from the first item where pred is false
(defn while-examples []
  {:take-while (take-while neg? [-3 -2 -1 0 1 2])
   :drop-while (drop-while neg? [-3 -2 -1 0 1 2])})

;; 4. partition
;; (partition n coll) -> groups of size n
;; (partition n step coll) -> groups of size n, moving by step
;; (partition n step pad coll) -> groups of size n, with padding if needed
(defn partition-examples []
  {:basic       (partition 2 [1 2 3 4 5 6])
   :with-step   (partition 2 3 [1 2 3 4 5 6 7])
   :with-pad    (partition 3 3 [0] [1 2 3 4 5])})

;; 5. partition-by
;; (partition-by f coll) -> groups items where (f x) returns the same value
(defn partition-by-example []
  (partition-by #(= % :gap) [:a :b :gap :c :d :e :gap :f]))

(comment
  (take-drop-examples)
  (split-at-example)
  (while-examples)
  (partition-examples)
  (partition-by-example))
