(ns advent-of-code.day1
  (:require [advent-of-code.core :as c]))

(def data (c/parse-file "day1.txt"))

(def grouped-data
  ;; partition the data by an empty line (grouping each elf), then filter out the empty lines that
  (filter
    #(not= "" (first %))
    (partition-by #(= "" %) data)))

(def parsed-data
  ;; map the outer grouping (each elf)
  (map
    ;; map each item the elf is carrying to a number
    #(map (fn [num] (Integer/parseInt num)) %) grouped-data))

(def reduced-data
  ;; map over each elf, reducing (summing up) all the items they have
  (map (fn [nums] (reduce + nums)) parsed-data))

(def elves-by-calories-desc
  (let [indexed-elves (map-indexed (fn [idx itm] {:idx idx :itm itm}) reduced-data)]
    (reverse (sort-by :itm indexed-elves))))

(println "Part 1 total answer is:" (first elves-by-calories-desc))
(println "Part 2 total answer is:"
         ;; get the item count from each of the top three elves, then add them
         (let [first-elf (:itm (first elves-by-calories-desc))
               second-elf (:itm (nth elves-by-calories-desc 1))
               third-elf (:itm (nth elves-by-calories-desc 2))]
           (+ first-elf second-elf third-elf)))
