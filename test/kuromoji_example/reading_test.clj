(ns kuromoji-example.reading-test
  (:require [kuromoji-example.reading :as r])
  (:use clojure.test))

(deftest reading-test
  (r/with-tokenizer
    (is (= (r/reading "Clojureは速い。") "Clojureハハヤイ。"))
    (is (= (r/reading "多摩川のたまちゃん") "タマガワノタマチャン"))
    (is (= (r/reading "写真とビデオのインポート") "シャシントビデオノインポート")))
    (is (= (r/reading "南太平洋のブロードウェイミュージカル") "ミナミタイヘイヨウノブロードウェイミュージカル")))


