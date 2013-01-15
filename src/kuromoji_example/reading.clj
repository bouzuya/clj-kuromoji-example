(ns kuromoji-example.reading
  (:import [org.atilika.kuromoji Token Tokenizer]))

(def ^:dynamic ^Tokenizer *tokenizer*)

(defmacro with-tokenizer
  [& body]
  `(binding [*tokenizer* (.build (Tokenizer/builder))]
     ~@body))

(defn tokenize
  [s]
  (seq (.tokenize *tokenizer* s)))

(defn reading
  [s]
  (apply str
         (map #(or (.getReading %)
                   (.getSurfaceForm %))
              (tokenize s))))

