(ns kuromoji-example.core
  (:require [clojure.java.io :as jio]
            [clojure.pprint :as pp]
            [kuromoji-example.tokenizer :as tokenizer])
  (:import [org.atilika.kuromoji Token Tokenizer]))

(def ^:dynamic ^Tokenizer *tokenizer*)

(defn tokenize
  [s]
  (seq (.tokenize *tokenizer* s)))

(defn word-count
  [s]
  (->>
    s
    (tokenize)
    (map #(.getSurfaceForm %))
    (reduce (fn [m k] (update-in m [k] (fnil inc 0))) {})))

(defn files
  [dir]
  (->
    dir
    (jio/file)
    (.listFiles)
    (seq)))

(defn word-counts-in-dir
  [dir]
  (reduce (fn [r m] (merge-with + r m))
          {}
          (map #(word-count (slurp %)) (files dir))))

(defn word-counts-all-entries
  []
  (binding [*tokenizer* (.build (Tokenizer/builder))]
    (word-counts-in-dir (System/getenv "ENTRYDIR"))))

(defn -main
  [& args]
  (->>
    (word-counts-all-entries)
    (seq)
    (sort-by val >)
    (pp/pprint)))

