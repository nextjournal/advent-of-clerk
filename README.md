# 🎄 Advent of Clerk

A template repo for folks wanting to do [Advent of
 Code](https://adventofcode.com) with [Clerk](https://clerk.vision).

## Usage

Fork & clone this repo, make sure you have [Clojure
installed](https://clojure.org/guides/install_clojure), then run:

``` shell
clj -M:nextjournal/clerk nextjournal.clerk/serve! --watch-paths src --port 7878 --browse
```

This will start the Clerk webserver on port 7878 and watch the `src/`
directory for changes and open Clerk in your browser.

Open one of the files there, e.g. `day_01.clj`, make a change and save
it. You should then see these changes reflected in the browser.
