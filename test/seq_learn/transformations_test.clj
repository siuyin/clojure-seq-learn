(ns seq-learn.transformations-test
  (:require [clojure.test :refer [deftest is testing]]
            [seq-learn.transformations :as trans]))

(deftest map-test
  (testing "map transformations"
    (let [res (trans/map-examples)]
      (is (= '(2 3 4) (:basic res)))
      (is (= '(11 22 33) (:multi-coll res)))
      (is (= '("Alice" "Bob") (:keyword res))))))

(deftest filter-remove-test
  (testing "filter and remove transformations"
    (let [res (trans/filter-remove-examples)]
      (is (= '(0 2 4 6 8) (:filter res)))
      (is (= '(1 3 5 7 9) (:remove res))))))

(deftest mapcat-test
  (testing "mapcat transformation"
    (let [res (trans/mapcat-examples)]
      (is (= '(2 1 4 3 6 5) (:basic res))))))

(deftest keep-test
  (testing "keep transformation"
    (let [res (trans/keep-examples)]
      (is (= '(0 1 2 3 4) (:basic res))))))
