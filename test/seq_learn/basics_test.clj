(ns seq-learn.basics-test
  (:require [clojure.test :refer [deftest is testing]]
            [seq-learn.basics :as basics]))

(deftest seq-function-test
  (testing "seq returns sequence views of various collections"
    (let [res (basics/explain-seq)]
      (is (seq? (:vector res)))
      (is (seq? (:list res)))
      (is (seq? (:map res)))
      (is (seq? (:set res)))
      (is (nil? (:empty res))))))

(deftest core-ops-test
  (testing "core sequence operations on vectors"
    (let [res (basics/core-ops [1 2 3])]
      (is (= 1 (:first res)))
      (is (= '(2 3) (:rest res)))
      (is (= '(2 3) (:next res)))))
  
  (testing "core sequence operations on single-item collections"
    (let [res (basics/core-ops [1])]
      (is (= 1 (:first res)))
      (is (empty? (:rest res)))
      (is (nil? (:next res))))))

(deftest prepend-test
  (testing "cons prepends to various collections"
    (is (= '(0 1 2 3) (basics/prepend 0 [1 2 3])))
    (is (= '(0) (basics/prepend 0 [])))))

(deftest emptiness-check-test
  (testing "idiomatic emptiness check with seq"
    (is (= "Processing: 1" (basics/process-if-not-empty [1 2 3])))
    (is (= "Collection is empty" (basics/process-if-not-empty [])))))
