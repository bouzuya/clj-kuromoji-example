(ns kuromoji-example.core
  (:import [org.atilika.kuromoji Token Tokenizer]))

(defn -main
  [& args]
  (let [^Tokenizer tokenizer (.build (Tokenizer/builder))]
    (doseq [^Token token (.tokenize tokenizer "寿司が食べたい。")]
      (println (str (.getSurfaceForm token) "\t" (.getAllFeatures token))))))

