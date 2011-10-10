(ns wolfskin.core
  (:use [clojure.string :only (trim join)]
        [cljcr.core]
        [clojure.contrib.zip-filter.xml :only (xml-> attr text)])
  (:require [clojure.xml :as xml]
            [clojure.zip :as zip]
            [nzz.news-nt :as nt])
  (:import (org.apache.jackrabbit.core RepositoryFactoryImpl)))

(def repo-conf
     { RepositoryFactoryImpl/REPOSITORY_HOME "repository/repository"
      RepositoryFactoryImpl/REPOSITORY_CONF "repository/repository.xml"})

(def session-conf {:username "username" :password "password" :save-changes true})

(defn store-article [xml-art]
  (with-repository repo-conf
    (with-session session-conf
      (do
        (let [repo-article (add-node (root-node) "article")
              properties (nt/get-property-map xml-art)]
          (set-properties repo-article properties)
          repo-article)))))

(defn get-article-properties [article]
  (with-repository repo-conf
    (with-session session-conf
      (do
        (properties article)))))


(defn path-and-string [v] {(. v getPath) (. v getString)})
                                        ; all nodes with paths and values as strings:
                                        ; (map #(map path-and-string %) (map cljcr/properties (cljcr/children (. session getRootNode))))