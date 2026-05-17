(ns seq-learn.performance-test
  (:require [clojure.test :refer [deftest is testing]]
            [seq-learn.performance :as perf]))

(deftest chunking-test
  (testing "chunking behavior: realizing one item realizes a chunk of 32"
    (let [res (perf/demonstrate-chunking)]
      (is (= 0 (:before res)))
      ;; 32 is the standard chunk size in Clojure
      (is (= 32 (:after-first res))))))

(deftest transducer-test
  (testing "transducer output matches sequence output"
    (let [data (range 10)
          res (perf/transducer-example data)]
      (is (= '(0 4 16 36 64) (:sequence res)))
      (is (= [0 4 16 36 64] (:transducer res))))))
