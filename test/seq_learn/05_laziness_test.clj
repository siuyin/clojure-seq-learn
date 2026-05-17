(ns seq-learn.05-laziness-test
  (:require [clojure.test :refer [deftest is testing]]
            [seq-learn.05-laziness :as lazy]))

(deftest custom-range-test
  (testing "custom lazy range using lazy-seq"
    (is (= '(5 4 3 2 1) (lazy/custom-range 5)))
    (is (empty? (lazy/custom-range 0)))))

(deftest fibs-test
  (testing "infinite fibonacci sequence"
    (is (= '(0 1 1 2 3 5 8 13 21 34) (take 10 (lazy/fibs))))))

(deftest realization-test
  (testing "sequence realization behavior"
    (let [res (lazy/track-realization)]
      (is (false? (:initial res)))
      ;; Note: map is chunked, so first element might realize the whole chunk (32)
      (is (true? (:after-first res))))))

(deftest side-effects-test
  (testing "doall forces realization of side effects"
    (let [res (lazy/side-effects-example)]
      (is (= 0 (:before res)))
      (is (= 10 (:after-doall res))))))
