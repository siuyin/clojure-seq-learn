(ns seq-learn.04-subsequences-test
  (:require [clojure.test :refer [deftest is testing]]
            [seq-learn.04-subsequences :as sub]))

(deftest take-drop-test
  (testing "take and drop operations"
    (let [res (sub/take-drop-examples)]
      (is (= '(1 2 3) (:take res)))
      (is (= '(4 5) (:drop res))))))

(deftest split-at-test
  (testing "split-at operation"
    (is (= ['(10 20) '(30 40)] (sub/split-at-example)))))

(deftest while-test
  (testing "take-while and drop-while operations"
    (let [res (sub/while-examples)]
      (is (= '(-3 -2 -1) (:take-while res)))
      (is (= '(0 1 2) (:drop-while res))))))

(deftest partition-test
  (testing "partition operations with various arities"
    (let [res (sub/partition-examples)]
      (is (= '((1 2) (3 4) (5 6)) (:basic res)))
      (is (= '((1 2) (4 5)) (:with-step res))) ; Note: last one (7) is dropped because size < 2
      (is (= '((1 2 3) (4 5 0)) (:with-pad res))))))

(deftest partition-by-test
  (testing "partition-by operation"
    (is (= '((:a :b) (:gap) (:c :d :e) (:gap) (:f)) (sub/partition-by-example)))))
