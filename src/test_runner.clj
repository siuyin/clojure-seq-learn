(ns test-runner
  (:require [clojure.test :as t]
            [clojure.java.io :as io]))

(defn- test-namespaces []
  (->> (io/file "test")
       file-seq
       (filter #(.isFile %))
       (map #(.getPath %))
       (filter #(.endsWith % "_test.clj"))
       (map #(-> %
                 (subs 5 (- (count %) 4)) ; remove "test/" and ".clj"
                 (clojure.string/replace "_" "-")
                 (clojure.string/replace "/" ".")
                 symbol))))

(defn run [{:keys [ns]}]
  (let [target-ns (if (seq ns)
                    (map symbol ns)
                    (test-namespaces))]
    (doseq [n target-ns]
      (require n))
    (let [test-results (apply t/run-tests target-ns)]
      (when (pos? (+ (:fail test-results) (:error test-results)))
        (throw (ex-info "Tests failed" test-results))))))
