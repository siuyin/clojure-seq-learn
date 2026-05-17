(ns seq-learn.02-generation
  "Illustrating programmatic sequence generation in Clojure.")

;; 1. range
;; (range) -> infinite sequence [0 1 2 ...]
;; (range end) -> [0 1 ... end-1]
;; (range start end) -> [start ... end-1]
;; (range start end step) -> [start start+step ... <end]
(defn range-examples []
  {:basic       (range 5)           ; (0 1 2 3 4)
   :start-end   (range 5 10)        ; (5 6 7 8 9)
   :with-step   (range 0 1 0.2)     ; (0 0.2 0.4 0.6000000000000001 0.8)
   :infinite    (take 5 (range))})  ; (0 1 2 3 4)

;; 2. repeat
;; (repeat x) -> infinite sequence of x
;; (repeat n x) -> sequence of x repeated n times
(defn repeat-examples []
  {:finite   (repeat 3 "ha")     ; ("ha" "ha" "ha")
   :infinite (take 3 (repeat 7))}) ; (7 7 7)

;; 3. cycle
;; (cycle coll) -> infinite repetition of the items in coll
(defn cycle-examples []
  {:basic (take 6 (cycle [1 2]))}) ; (1 2 1 2 1 2)

;; 4. iterate
;; (iterate f x) -> infinite sequence [x (f x) (f (f x)) ...]
(defn iterate-examples []
  {:powers-of-2 (take 5 (iterate #(* 2 %) 1))}) ; (1 2 4 8 16)

(comment
  (range-examples)
  (repeat-examples)
  (cycle-examples)
  (iterate-examples))
