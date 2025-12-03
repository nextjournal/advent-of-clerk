;; # 🎄 Advent of Clerk

;; [Advent of Code](https://adventofcode.com) with
;; [Clerk](https://clerk.vision).
(ns advent-of-clerk.index
  {:nextjournal.clerk/visibility {:code :hide :result :hide}}
  (:require [babashka.fs :as fs]
            [clojure.string :as str]
            [nextjournal.clerk :as clerk]))

#_(days-with-contents)

(defn build-paths
  "Computes the paths to build by looking for files in
  `src/advent_of_clerk` and filtering out unmodified templates (files
  with less than four lines)."
  []
  (into []
        (keep (fn [day]
                (let [f (fs/file "src" "advent_of_clerk" (format "day_%s.clj" (cond->> day
                                                                                (< day 10) (str "0"))))]
                  (when (and (.exists f)
                             (< 3 (count (str/split-lines (slurp f)))))
                    (str f)))))
        (range 1 26)))


#_(build-paths)

{:nextjournal.clerk/visibility {:result :show}}

^::clerk/no-cache
(clerk/html (into [:ul] (mapv (fn [path]
                                (when-let [day (second (re-matches #".*day_(\d+).clj" path))]
                                  [:li [:a {:href (clerk/doc-url (str/replace path #"\.clj" ""))} "Day " day]]))
                              (build-paths))))

