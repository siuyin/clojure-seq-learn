(ns seq-learn.generation-test
  (:require [clojure.test :refer [deftest is testing]]
            [seq-learn.generation :as gen]))

(deftest range-test
  (testing "range generation with various arities"
    (let [res (gen/range-examples)]
      (is (= '(0 1 2 3 4) (:basic res)))
      (is (= '(5 6 7 8 9) (:start-end res)))
      (is (= 5 (count (:with-step res))))
      (is (= '(0 1 2 3 4) (:infinite res))))))

(deftest repeat-test
  (testing "repeat generation"
    (let [res (gen/repeat-examples)]
      (is (= '("ha" "ha" "ha") (:finite res)))
      (is (= '(7 7 7) (:infinite res))))))

(deftest cycle-test
  (testing "cycle generation"
    (let [res (gen/cycle-examples)]
      (is (= '(1 2 1 2 1 2) (:basic res))))))

(deftest iterate-test
  (testing "iterate generation"
    (let [res (gen/iterate-examples)]
      (is (= '(1 2 4 8 16) (:powers-of-2 res))))))
