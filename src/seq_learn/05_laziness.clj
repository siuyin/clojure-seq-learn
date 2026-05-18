(ns seq-learn.05-laziness
  "Illustrating laziness and infinite sequences in Clojure.")

;; 1. The lazy-seq macro
;; lazy-seq delays execution of its body until the sequence is consumed.
(defn custom-range [n]
  (lazy-seq
    (when (pos? n)
      (cons n (custom-range (dec n))))))

;; 2. Infinite Sequences
;; A classic example: the Fibonacci sequence.
(defn fibs
  ([] (fibs 0N 1N))
  ([a b] 
   (lazy-seq
     (cons a (fibs b (+ a b))))))

;; 3. Realization tracking
;; We can use 'realized?' to check if the head of a lazy sequence is calculated.
;; Note: Many core seqs are chunked, which affects realization.
(defn track-realization []
  (let [s (map #(do (Thread/sleep 10) %) (range 10))]
    {:initial (realized? s)
     :after-first (do (first s) (realized? s))}))

;; 4. Side Effects and doall
;; Laziness can hide side effects. 'doall' forces realization.
(defn side-effects-example []
  (let [counter (atom 0)
        s (map (fn [_] (swap! counter inc)) (range 10))]
    {:before (deref counter)
     :after-doall (do (doall s) (deref counter))}))

(comment
  (take 5 (custom-range 10))
  (take 10 (fibs))
  (track-realization)
  (side-effects-example))
