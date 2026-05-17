(ns seq-learn.03-transformations
  "Illustrating core sequence transformation functions in Clojure.")

;; 1. map
;; (map f coll) -> sequence of (f x) for each x in coll
;; (map f c1 c2) -> sequence of (f x1 x2) for corresponding items
(defn map-examples []
  {:basic       (map inc [1 2 3])
   :multi-coll  (map + [1 2 3] [10 20 30])
   :keyword     (map :name [{:name "Alice"} {:name "Bob"}])})

;; 2. filter & remove
;; (filter pred coll) -> sequence of items where (pred x) is true
;; (remove pred coll) -> sequence of items where (pred x) is false
(defn filter-remove-examples []
  {:filter (filter even? (range 10))
   :remove (remove even? (range 10))})

;; 3. mapcat
;; (mapcat f coll) -> (apply concat (map f coll))
;; Useful when f returns a collection and you want a flat result.
(defn mapcat-examples []
  {:basic (mapcat reverse [[1 2] [3 4] [5 6]])}) ; (2 1 4 3 6 5)

;; 4. keep
;; (keep f coll) -> sequence of non-nil (f x)
(defn keep-examples []
  {:basic (keep #(if (even? %) (/ % 2)) (range 10))}) ; (0 1 2 3 4)

(comment
  (map-examples)
  (filter-remove-examples)
  (mapcat-examples)
  (keep-examples))
