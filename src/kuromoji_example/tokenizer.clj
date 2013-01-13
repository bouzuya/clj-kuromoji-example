(ns kuromoji-example.tokenizer
  (:import [org.atilika.kuromoji Token Tokenizer]))

; http://www.atilika.com/products/kuromoji.html#code-example
(defn example
  []
  (let [^Tokenizer tokenizer (.build (Tokenizer/builder))]
    (doseq [^Token token (.tokenize tokenizer "寿司が食べたい。")]
      (println (str (.getSurfaceForm token) "\t" (.getAllFeatures token))))))

