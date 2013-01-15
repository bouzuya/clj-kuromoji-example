(ns kuromoji-example.core
  (:require [kuromoji-example.reading :as r])
  (:import [org.atilika.kuromoji Token Tokenizer]))

(defn -main
  [& args]
  (r/with-tokenizer
    (r/reading "困る")))

(-main)
