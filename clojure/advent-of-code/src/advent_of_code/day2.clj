(ns advent-of-code.day2
  (:require [advent-of-code.core :as c]))

(def data (c/parse-file "day2.txt"))

;; A and X are Rock = 1 Point
;; B and Y are Paper = 2 Points
;; C and Z are Scissors = 3 Points
;; 0 Points for a loss
;; 3 Points for a draw
;; 6 Points for a win
(def game-values {"A X" 4 "A Y" 8 "A Z" 3 "B X" 1 "B Y" 5 "B Z" 9 "C X" 7 "C Y" 2 "C Z" 6})

;; A is Rock
;; B is Paper
;; C is Scissors
;; X is lose
;; Y is draw
;; Z is win
(def updated-game-values {"A X" 3 "A Y" 4 "A Z" 8 "B X" 1 "B Y" 5 "B Z" 9 "C X" 2 "C Y" 6 "C Z" 7})

(defn mapped-and-summed-data [game-values]
  (reduce + (map #(get game-values %) data)))

(println "The first answer is:" (mapped-and-summed-data game-values))
(println "The second answer is:" (mapped-and-summed-data updated-game-values))
