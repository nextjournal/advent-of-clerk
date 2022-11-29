(ns user
  (:require [advent-of-clerk.index :as index]
            [nextjournal.clerk :as clerk]
            [clojure.string :as str]
            [babashka.fs :as fs]))


(comment
  (clerk/build! {:index "src/advent_of_clerk/index.clj"
                 :paths (index/build-paths)
                 :browse true}))


